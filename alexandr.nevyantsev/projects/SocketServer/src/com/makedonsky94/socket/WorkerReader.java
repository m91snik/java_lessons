package com.makedonsky94.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerReader implements Runnable {
    public WorkerReader(BlockingQueue<Message> messageBlockingQueue, ConcurrentHashMap<Socket, Client> clients, int port) throws IOException {
        this.messageBlockingQueue = messageBlockingQueue;
        this.port = port;
        this.commands = new HashMap<>();
        this.clients = clients;
        this.createCommands();
    }
    BlockingQueue<Message> messageBlockingQueue;
    private int port;
    BufferedReader bufferedReader;
    ConcurrentHashMap<Socket, Client> clients;

    private HashMap<String, WorkerReaderCallback> commands;
    private void createCommands() {
//        commands.put("-nick", (string) -> {
//            Client currentClient = clients.get(socket);
//            currentClient.setNick(string);
//        });
    }

    @Override
    public void run() {
        try (
                ServerSocket serverSocket = new ServerSocket(port)
        ) {
            while (true) {
                Socket echoSocket = serverSocket.accept();
                this.bufferedReader = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

                clients.put(echoSocket, new Client(echoSocket.getInetAddress()));
                //TODO get chat history by command
                try {
                    //set nick color
                    String color = clients.get(echoSocket).getColor();
                    //read message from socket
                    String message = bufferedReader.readLine();
                    //read nick from message
                    String nick = clients.get(echoSocket).getNick();
                    messageBlockingQueue.add(new Message(message, echoSocket, color, nick));
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException();
                }
            }
        } catch (UnknownHostException e) {
            throw new UncheckedIOException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private interface WorkerReaderCallback {
        void call(String string);
    }
}
