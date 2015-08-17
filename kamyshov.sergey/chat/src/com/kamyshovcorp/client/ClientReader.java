package com.kamyshovcorp.client;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class ClientReader implements Runnable {
    private final Socket socket;

    public ClientReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream;
        Message message;
        try {
            while (true) {
                inputStream = new ObjectInputStream(socket.getInputStream());
                message = (Message) inputStream.readObject();
                System.out.println(message.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
