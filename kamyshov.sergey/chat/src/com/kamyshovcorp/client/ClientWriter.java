package com.kamyshovcorp.client;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kamyshov.sergey on 19.08.15.
 */
public class ClientWriter implements Runnable {
    private static final String HOSTNAME = "127.0.0.1";
    private static final int PORT_OUT = 1234;
    private static final int PORT_IN = 4321;

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Message message;

        while (true) {
            message = new Message(scanner.nextLine(), HOSTNAME, PORT_IN);

            // socket закроется автоматически, а с ним и outputStream
            try (Socket socket = new Socket(HOSTNAME, PORT_OUT)) {
                System.out.println("InetAddress: " + socket.getInetAddress());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(message);
                // можно не указывать, т.к. при закрытии socket метод flush() вызывается автоматически
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
