package com.kamyshovcorp.server;


import com.kamyshovcorp.message.ClientInfo;
import com.kamyshovcorp.message.Message;
import com.kamyshovcorp.message.MessageType;
import javafx.util.Pair;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
@Component
public class Server {

	private static final Logger logger = Logger.getLogger(Server.class);
	private static final int PORT = 1234;
	private static BlockingQueue<Message> messages = new LinkedBlockingQueue<>();
	private static Map<String, Pair<String, Integer>> users = new ConcurrentHashMap<>();

    public void runServer() {
        // Thread Reader
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(PORT)) {
	            logger.info("Создан ServerSocket с портом: " + serverSocket.getLocalPort());
                Message message;
                ClientInfo clientInfo;
                ObjectInputStream inputStream;
                while (true) {
                    try (Socket socket = serverSocket.accept()) {
	                    logger.info("Создано входящее подключение для адресса: " + socket.getInetAddress());
	                    inputStream = new ObjectInputStream(socket.getInputStream());
                        message = (Message) inputStream.readObject();
                        clientInfo = message.getClientInfo();
                        Date date = new Date();
                        if (MessageType.ENTRANCE == message.getMessageType()) {
                            // Добавляем клиента в список пользователей
                            users.put(clientInfo.getUserName(), new Pair<>(clientInfo.getHostName(), clientInfo.getClientPort()));
	                        logger.info(String.format("Пользователь [%s, %s, %d] подключился к чату.", clientInfo.getUserName(), clientInfo.getHostName(), clientInfo.getClientPort()));
                        }
	                    messages.add(message);
                    } catch (ClassNotFoundException e) {
	                    logger.error("Ошибка преобразования при приеме сообщения на сервере", e);
	                    e.printStackTrace();
                    }
                }
            } catch (IOException e) {
	            logger.error(e);
	            e.printStackTrace();
            }
        }).start();

        // Thread Writer
        new Thread(() -> {
            Message message = null;
            ClientInfo clientInfo = null;
            while (true) {
                try {
                    message = messages.take();
                    clientInfo = message.getClientInfo();
                } catch (InterruptedException e) {
	                logger.error(e);
                    e.printStackTrace();
                }
                // Если пользователь только вошел, то отправляем ему историю последних сообщений
                if (MessageType.ENTRANCE == message.getMessageType()) {
                    String history = HistoryHandler.readHistory();
                    Message historyMessage = new Message(MessageType.MESSAGE, history, clientInfo);
                    ServerHandler.sendMessage(historyMessage, clientInfo.getHostName(), clientInfo.getClientPort());
	                logger.info(String.format("Пользователю [%s, %d] отправлена история последних сообщений", clientInfo.getHostName(), clientInfo.getClientPort()));
                    continue;
                } else if (MessageType.MESSAGE == message.getMessageType()) {
                    Date date = new Date();
                    String formattedText = String.format("[%td/%tm/%ty %tT %tZ, %s]: ", date, date, date, date, date,
                            message.getClientInfo().getUserName()) + message.getText();
                    // Записываем сообщение в историю перед отправкой всем пользователям
                    HistoryHandler.writeHistory(formattedText);
                    message.setText(formattedText);
                }
                for (Map.Entry<String, Pair<String, Integer>> user : users.entrySet()) {
                    // Отсылаем сообщение всем кроме отправителя
                    if (!clientInfo.getUserName().equals(user.getKey())) {
                        Pair<String, Integer> userClientInfo = user.getValue();
                        ServerHandler.sendMessage(message, userClientInfo.getKey(), userClientInfo.getValue());
                    }
                }
            }
        }).start();

	    System.out.println("Сервер запущен");
	    logger.info("Сервер запущен");
    }
}



