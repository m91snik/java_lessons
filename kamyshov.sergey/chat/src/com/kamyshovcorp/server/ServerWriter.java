package com.kamyshovcorp.server;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kamyshov.sergey on 19.08.15.
 */
public class ServerWriter implements Runnable {
    private BlockingQueue<Message> blockingQueue;

    public ServerWriter(BlockingQueue<Message> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        Message message = null;
        while (true) {
            try {
                message = blockingQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try (Socket socket = new Socket(message.getHostname(), message.getPort())) {
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
