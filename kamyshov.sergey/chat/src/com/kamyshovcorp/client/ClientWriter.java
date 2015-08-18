package com.kamyshovcorp.client;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class ClientWriter implements Runnable {

    private final Socket socket;

    public ClientWriter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
            Message message;
            while (true) {
                message = new Message(scanner.nextLine());
                outputStream.writeObject(message);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
