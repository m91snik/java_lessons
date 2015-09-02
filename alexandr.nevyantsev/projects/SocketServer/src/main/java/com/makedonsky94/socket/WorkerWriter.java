package com.makedonsky94.socket;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerWriter implements Runnable {
    private final BlockingQueue<Message> messageBlockingQueue;
    private final ConcurrentHashMap<String, Client> clients;

    public WorkerWriter(BlockingQueue<Message> messageBlockingQueue, ConcurrentHashMap<String, Client> clients) throws IOException {
        this.clients = clients;
        this.messageBlockingQueue = messageBlockingQueue;
    }

    public Message getMessage() throws InterruptedException {
        return messageBlockingQueue.take();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message msg = this.getMessage();

                clients.forEach((nick, client) -> {
                    try {
                        client.write(msg);
                    } catch (ConnectException ex) {
                        clients.remove(nick);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                ProjectLogger.log(msg.getMessageString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
