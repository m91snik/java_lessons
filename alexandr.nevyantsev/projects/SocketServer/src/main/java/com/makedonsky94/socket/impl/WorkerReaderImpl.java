package com.makedonsky94.socket.impl;

import com.makedonsky94.socket.Client;
import com.makedonsky94.socket.Message;
import com.makedonsky94.socket.interfaces.WorkerReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
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
public class WorkerReaderImpl implements WorkerReader {

    private static final Logger logger = LogManager.getLogger(WorkerReaderImpl.class);

    public WorkerReaderImpl(BlockingQueue<Message> messageBlockingQueue, ConcurrentHashMap<String, Client> clients, int port) throws IOException {
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
            if (WorkerReaderImpl.this.clients.get(nick) == null) {
                //If nick is not occupied then add this to HashMap
                clients.put(nick, client);
                WorkerReaderImpl.logger.info("Client " + client.getNick() + " change nick to " + nick);
            } else {
                client.write(new Message("Duplicate nick!"));
            }
        });

        commands.put("-exit", (nick, socketChannel) -> WorkerReaderImpl.this.clients.remove(nick));
    }


    public int getPort() {
        return port;
    }
    @Override
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
        WorkerReaderImpl.logger.info("Message has been added: " + new String(buffer.array()));
        this.addMessage(new Message(msg));
    }

    @Override
    public void runReader() {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress("localhost", this.getPort()));
            WorkerReaderImpl.logger.info("serverSocketChannel is opened");
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            WorkerReaderImpl.logger.info("serverSocketChannel is registered");
            while (true) {
                selector.select();
                Set selectedKeys = selector.selectedKeys();
                Iterator iterator = selectedKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = (SelectionKey) iterator.next();
                    if (selectionKey.isAcceptable()) {
                        SocketChannel sock = serverSocketChannel.accept();
                        if(sock != null) {
                            sock.configureBlocking(false);
                            sock.register(selector, SelectionKey.OP_READ);
                            WorkerReaderImpl.logger.info(selectionKey.toString() + " has been accepted");
                        }
                    }
                    if (selectionKey.isReadable()) {
                        WorkerReaderImpl.logger.info("Read from " + selectionKey.channel().toString());
                        SocketChannel socketChannel =
                                (SocketChannel) selectionKey.channel();
                        try {
                            this.readMessage(socketChannel);
                        } catch(IOException e) {
                            WorkerReaderImpl.logger.info("Disconnected from server " + selectionKey.channel().toString());
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
