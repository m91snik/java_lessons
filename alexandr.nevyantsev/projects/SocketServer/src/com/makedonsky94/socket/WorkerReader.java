package com.makedonsky94.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerReader implements Runnable {
    public WorkerReader(BlockingQueue<Message> messageBlockingQueue, Socket socket) throws IOException {
        this.messageBlockingQueue = messageBlockingQueue;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.socket = socket;
    }
    BlockingQueue<Message> messageBlockingQueue;
    BufferedReader bufferedReader;
    Socket socket;
    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                messageBlockingQueue.add(new Message(bufferedReader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
