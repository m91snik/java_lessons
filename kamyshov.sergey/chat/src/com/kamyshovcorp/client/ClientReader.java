package com.kamyshovcorp.client;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class ClientReader implements Runnable {
    private static final int PORT_IN = 4321;

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(PORT_IN)) {
            ObjectInputStream inputStream;
            Message message;

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    message = (Message) inputStream.readObject();
                    System.out.println(message.getText());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
