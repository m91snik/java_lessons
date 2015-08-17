package com.kamyshovcorp.server;

import com.kamyshovcorp.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class ServerThread implements Runnable {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        SocketList.addSocketToList(socket);
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
            Message message;

            while (true) {
                message = (Message) inputStream.readObject();
                sendMessageInChat(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageInChat(Message message) throws IOException {
        List<Socket> sockets = SocketList.getSockets();
        for (Socket socket : sockets) {
            if (!this.socket.equals(socket))
                sendMessageToUser(message, socket);
        }
    }

    public void sendMessageToUser(Message message, Socket socket) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(message);
        outputStream.flush();
    }
}
