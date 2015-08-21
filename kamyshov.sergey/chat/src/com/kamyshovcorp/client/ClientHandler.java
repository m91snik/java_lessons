package com.kamyshovcorp.client;

import com.kamyshovcorp.message.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by kamyshov.sergey on 21.08.15.
 */
public class ClientHandler {
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void sendMessage(Message message) {
        try (Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
