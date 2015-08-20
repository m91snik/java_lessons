package com.kamyshovcorp.server;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kamyshov.sergey on 19.08.15.
 */
public class ServerReader implements Runnable {
    private static final int PORT = 1234;
    private BlockingQueue<Message> blockingQueue;

    public ServerReader(BlockingQueue<Message> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            ObjectInputStream inputStream;
            Message message;

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    message = (Message) inputStream.readObject();
                    blockingQueue.add(message);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
