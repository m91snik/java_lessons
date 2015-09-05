package com.kamyshovcorp.client;

import com.kamyshovcorp.message.ClientInfo;
import com.kamyshovcorp.message.Message;
import com.kamyshovcorp.message.MessageType;
import org.apache.log4j.Logger;

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
    private static final Logger logger = Logger.getLogger(Client.class);
    private static String clientHostName;
    private static int clientPort;
    private static String userName;

    public void runClient() {
        try {
            clientHostName = InetAddress.getLocalHost().getHostAddress();
            logger.info("Получен адрес клиента: " + clientHostName);
        } catch (UnknownHostException e) {
            logger.error("Не удалось определить адресс клиента.");
            //TODO: throw exception because in this case it will be not possible to continue program
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите порт клиента: ");
        // TODO: Почему при использовании scanner.nextInt() проблема?
        clientPort = Integer.valueOf(scanner.nextLine());
        System.out.print("Введите имя пользователя: ");
        userName = scanner.nextLine();
        logger.info(String.format("Пользователь ввел порт %d и ник %s", clientPort, userName));

        // Thread Writer
        new Thread(() -> {
            // Формируем информацию о текущем пользователе
            ClientInfo clientInfo = new ClientInfo(userName, clientHostName, clientPort);
            // Отправляем оповещение серверу, чтобы добавиться в список пользователей
            ClientHandler.sendMessage(new Message(MessageType.ENTRANCE, null, clientInfo));
            logger.info("Пользователь " + userName + " отправил сообщение о входе в чат");
            // TODO: Добавить выход из чата
            while (true) {
                String textMessage = scanner.nextLine();
                ClientHandler.sendMessage(new Message(MessageType.MESSAGE, textMessage, clientInfo));
            }
        }).start();

        // Thread Reader
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(clientPort)) {
                logger.info("Пользователь " + userName + " создал подключение на прослушивание порта " + clientPort);
                while (true) {
                    try (Socket socket = serverSocket.accept();
                         ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {
                        Message message = (Message) inputStream.readObject();
                        System.out.println(message.getText());
                    } catch (ClassNotFoundException e) {
                        logger.error("Ошибка преобразования сообщения на клиенте пользователя " + userName, e);
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                logger.error("Ошибка при приеме сообщения на клиенте пользователя " + userName, e);
                e.printStackTrace();
            }
        }).start();
    }
}
