package com.kamyshovcorp.server;

import com.kamyshovcorp.message.Message;
import com.kamyshovcorp.message.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by kamyshov.sergey on 21.08.15.
 */
public class ServerHandler {

    public static void sendMessage(Message message, String hostName, int clientPort) {
        try (Socket socket = new Socket(hostName, clientPort)) {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(new Message(MessageType.MESSAGE, message.getText(), message.getClientInfo()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
