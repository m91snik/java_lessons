package com.makedonsky94.socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerReader implements Runnable {
    private static final Logger logger = LogManager.getLogger(WorkerReader.class);

    public WorkerReader(BlockingQueue<Message> messageBlockingQueue, ConcurrentHashMap<String, Client> clients, int port) throws IOException {
        this.messageBlockingQueue = messageBlockingQueue;
        this.clients = clients;
        this.port = port;
        this.commands = new HashMap<>();
        this.createCommands();
    }

    BlockingQueue<Message> messageBlockingQueue;
    private ConcurrentHashMap<String, Client> clients;
    private int port;

    private HashMap<String, WorkerReaderCallback> commands;

    private void createCommands() {
        commands.put("-nick", (nick, client) -> {
//            Client client = new Client(socketChannel.getRemoteAddress());
            if (WorkerReader.this.clients.get(nick) == null) {
                //If nick is not occupied then add this to HashMap
                clients.put(nick, client);
                WorkerReader.logger.info("Client " + client.getNick() + " change nick to " + nick);
            } else {
                client.write(new Message("Duplicate nick!"));
            }
        });

        commands.put("-exit", (nick, socketChannel) -> WorkerReader.this.clients.remove(nick));
    }

    public void addMessage(Message msg) {
        messageBlockingQueue.add(msg);
    }


    public void readMessage(SocketChannel socketChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(256);
        int conn = socketChannel.read(buffer);
        //if end of string, conn return -1
        if (conn == -1) {
            return;
        }
        String msg = new String(buffer.array());
        Pattern pattern = Pattern.compile("^[-]\\S+");
        Matcher matcher = pattern.matcher(msg);
        if(matcher.find()) {
            String command = matcher.group();
            WorkerReaderCallback callback = commands.get(command);
            if(callback != null) {
                Client client = new Client(socketChannel.getRemoteAddress());
                callback.call(msg.replaceAll(command, ""), client);
                return;
            }
        }
        WorkerReader.logger.info("Message has been added: " + new String(buffer.array()));
        this.addMessage(new Message(msg));
    }


    @Override
    public void run() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", port));
            WorkerReader.logger.info("serverSocketChannel is opened");
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            WorkerReader.logger.info("serverSocketChannel is registered");
            while (true) {
                int count = selector.select();
                //TODO: it will never return 0 because it's in blocking state till somebody connects to socket
                if (count == 0) {
                    continue;
                }
                Set selectedKeys = selector.selectedKeys();
                Iterator iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel sock = serverSocketChannel.accept();
                        if(sock != null) {
                            sock.configureBlocking(false);
                            sock.register(selector, SelectionKey.OP_READ);
                            WorkerReader.logger.info(selectionKey.toString() + " has been accepted");
                        }
                    }
                    if (selectionKey.isReadable()) {
                        WorkerReader.logger.info("Read from " + selectionKey.channel().toString());
                        SocketChannel socketChannel =
                                (SocketChannel) selectionKey.channel();
                        try {
                            this.readMessage(socketChannel);
                        } catch(IOException e) {
                            WorkerReader.logger.info("Disconnected from server " + selectionKey.channel().toString());
                        }
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private interface WorkerReaderCallback {
        void call(String string, Client client) throws IOException;
    }
}
