package com.makedonsky94.socket;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerWriter implements Runnable {
    private final BlockingQueue<Message> messageBlockingQueue;
    private final ConcurrentHashMap<Socket, Client> bufferedWriters;

    public WorkerWriter(BlockingQueue<Message> messageBlockingQueue, ConcurrentHashMap<Socket, Client> bufferedWriters) throws IOException {
        this.bufferedWriters = bufferedWriters;
        this.messageBlockingQueue = messageBlockingQueue;
    }


    @Override
    public void run() {
        while(true) {
            try {
                Message msg = messageBlockingQueue.take();

                bufferedWriters.forEach((socket, client) -> {
                    if(socket != null &&  socket.isConnected()) {
                        try {
                            client.write(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                            bufferedWriters.remove(socket);
                        }
                    }
                });
                Logger.log(msg.getClient() + " | " + msg.getMessageString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
