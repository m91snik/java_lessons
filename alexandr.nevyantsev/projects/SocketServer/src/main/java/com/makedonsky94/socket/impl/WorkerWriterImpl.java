package com.makedonsky94.socket.impl;

import com.makedonsky94.socket.Client;
import com.makedonsky94.socket.Message;
import com.makedonsky94.socket.ProjectLogger;
import com.makedonsky94.socket.interfaces.WorkerReader;
import com.makedonsky94.socket.interfaces.WorkerWriter;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerWriterImpl implements WorkerWriter {
    private final BlockingQueue<Message> messageBlockingQueue;
    private final ConcurrentHashMap<String, Client> clients;

    public WorkerWriterImpl(BlockingQueue<Message> messageBlockingQueue, ConcurrentHashMap<String, Client> clients) throws IOException {
        this.clients = clients;
        this.messageBlockingQueue = messageBlockingQueue;
    }

    @Override
    public Message getMessage() throws InterruptedException {
        return messageBlockingQueue.take();
    }

    @Override
    public void runWriter() {
        while (true) {
            try {
                Message msg = this.getMessage();

                clients.forEach((nick, client) -> {
                    try {
                        client.write(msg);
                    } catch (ConnectException ex) {
                        clients.remove(nick);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                //TODO: use logger
                ProjectLogger.log(msg.getMessageString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
