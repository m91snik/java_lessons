package com.makedonsky94.socket;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by user on 13.08.2015.
 */
public class WorkerWriter implements Runnable {
    private final BlockingQueue<Message> messageBlockingQueue;
    private final BufferedWriter bufferedWriter;
    private final Socket socket;

    public WorkerWriter(BlockingQueue<Message> messageBlockingQueue, Socket socket) throws IOException {
        this.messageBlockingQueue = messageBlockingQueue;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.socket = socket;
    }

    @Override
    public void run() {
        while(socket.isConnected()) {
            try {
                Message msg = messageBlockingQueue.take();
                Logger.log(msg);
                bufferedWriter.write(msg.getMessageString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
