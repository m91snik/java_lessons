package com.makedonsky94.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerReader implements Runnable {
    public WorkerReader(BlockingQueue<Message> messageBlockingQueue, Socket socket, ConcurrentHashMap<Socket, Client> clients) throws IOException {
        this.messageBlockingQueue = messageBlockingQueue;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.socket = socket;
        this.commands = new HashMap<>();
        this.clients = clients;
        this.createCommands();
    }
    BlockingQueue<Message> messageBlockingQueue;
    BufferedReader bufferedReader;
    final Socket socket;
    ConcurrentHashMap<Socket, Client> clients;

    private HashMap<String, WorkerReaderCallback> commands;
    private void createCommands() {
        commands.put("-nick", (string) -> {
            Client currentClient = clients.get(socket);
            currentClient.setNick(string);
        });
    }

    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                String color = clients.get(socket).getColor();
                String message = bufferedReader.readLine();
                String nick = clients.get(socket).getNick();
                messageBlockingQueue.add(new Message(message, socket, color, nick));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
    private interface WorkerReaderCallback {
        void call(String string);
    }
}
