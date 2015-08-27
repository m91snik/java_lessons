package com.kamyshovcorp.client;

import com.kamyshovcorp.message.ClientInfo;
import com.kamyshovcorp.message.Message;
import com.kamyshovcorp.message.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Client {
    private static String clientHostName;
    private static int clientPort;
    private static String userName;

    public static void main(String[] args) {
        try {
            clientHostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("Не удалось определить адресс клиента");
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите порт клиента: ");
        // TODO: Почему при использовании scanner.nextInt() проблема?
        clientPort = Integer.valueOf(scanner.nextLine());

        System.out.print("Введите имя пользователя: ");
        userName = scanner.nextLine();

        // Writer
        new Thread(() -> {
            String textMessage;
            // Формируем информацию о текущем пользователе
            ClientInfo clientInfo = new ClientInfo(userName, clientHostName, clientPort);
            // Отправляем оповещение серверу, чтобы добавиться в список пользователей
            ClientHandler.sendMessage(new Message(MessageType.ENTRANCE, null, clientInfo));
            // TODO: Добавить выход из чата
            while (true) {
                textMessage = scanner.nextLine();
                ClientHandler.sendMessage(new Message(MessageType.MESSAGE, textMessage, clientInfo));
            }
        }).start();

        // Reader
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(clientPort)) {
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
        }).start();
    }
}
