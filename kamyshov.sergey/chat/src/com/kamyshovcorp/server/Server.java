package com.kamyshovcorp.server;


import com.kamyshovcorp.message.ClientInfo;
import com.kamyshovcorp.message.Message;
import com.kamyshovcorp.message.MessageType;
import javafx.util.Pair;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Server {
    private static final int PORT = 1234;
    private static BlockingQueue<Message> blockingQueue = new LinkedBlockingQueue<>();
    private static Map<String, Pair<String, Integer>> users = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("The server is loaded");

        // Reader
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (ServerSocket serverSocket = new ServerSocket(PORT)) {
                    Message message;
                    ClientInfo clientInfo;
                    ObjectInputStream inputStream;
                    while (true) {
                        try (Socket socket = serverSocket.accept()) {
                            inputStream = new ObjectInputStream(socket.getInputStream());
                            message = (Message) inputStream.readObject();
                            clientInfo = message.getClientInfo();
                            if (MessageType.ENTRANCE == message.getMessageType()) {
                                // Добавляем клиента в список пользователей
                                users.put(clientInfo.getUserName(), new Pair<>(clientInfo.getHostName(), clientInfo.getClientPort()));
                                System.out.println(String.format("Пользователь [%s, %s, %d] подключился к чату.", clientInfo.getUserName(), clientInfo.getHostName(), clientInfo.getClientPort()));
                                continue;
                            } else if (MessageType.MESSAGE == message.getMessageType()) {
                                System.out.println(String.format("Принятно сообщение от [%s, %s, %d]: ", clientInfo.getUserName(), clientInfo.getHostName(), clientInfo.getClientPort()) + message.getText());
                                blockingQueue.add(message);
                            }
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Writer
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = null;
                ClientInfo clientInfo = null;
                ObjectOutputStream outputStream;
                while (true) {
                    try {
                        message = blockingQueue.take();
                        clientInfo = message.getClientInfo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (Map.Entry<String, Pair<String, Integer>> user : users.entrySet()) {
                        // Отсылаем всем кроме отправителя
                        if (!clientInfo.getUserName().equals(user.getKey())) {
                            Pair<String, Integer> userClientInfo = user.getValue();
                            try (Socket socket = new Socket(userClientInfo.getKey(), userClientInfo.getValue())) {
                                outputStream = new ObjectOutputStream(socket.getOutputStream());
                                outputStream.writeObject(message);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }
}



