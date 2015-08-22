package Server;

import Client.ClientID;
import Client.Message;
import Client.Sender;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by Ангелина on 22.08.2015.
 */
public class ServerMain {
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 1992;
    private static boolean flag = false;
    private static BlockingQueue<Message> messages = new LinkedBlockingQueue<>();
    private static ConcurrentHashMap<ClientID, String> connectionDB = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        // receive
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);) {
                while (!flag) {
                    try (Socket socket = serverSocket.accept();
                         ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

                        System.out.println("Сервер дождался подключения");
                        Message mes = (Message) in.readObject();
                        System.out.println("Принято сообщение: " + mes.getText() + " от " + mes.getClientID());
                        if (!connectionDB.containsKey(mes.getClientID())) {
                            connectionDB.put(mes.getClientID(), " ");
                            System.out.println("Клиент добавлен в базу");
                        }
                        messages.put(mes);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // send
        new Thread(() -> {
            Message message = null;
            ClientID serverID = new ClientID(SERVER_HOSTNAME, ((Integer) SERVER_PORT).toString(), "server");
            try {
                while ((message = messages.take()) != null) {

                    // определенному пользователю
                    String str = message.getText();
                    if (str.indexOf("@") == 0) {

                        String[] strings = str.split(" ");
                        String receiverNick = strings[0];
                        receiverNick = receiverNick.substring(1);
                        System.out.println(receiverNick);
                        ClientID privateReceiver = null;

                        for (Map.Entry<ClientID, String> entry : connectionDB.entrySet()) {
                            if (entry.getKey().getNick().equals(receiverNick)) {
                                privateReceiver = entry.getKey();
                            }
                        }
                        String text = "@".concat(message.getClientID().getNick()).concat(" ");
                        message.setText(text.concat(str.substring(str.indexOf(" "))));

                        Sender.send(message, privateReceiver);
                    } else if ("save".equals(str)) {
                        // отправвить сообщение тому, кто его прислал
                        Sender.send(message, message.getClientID());
                        System.out.println("Сообщение " + message.getText() + " отправлено " + message.getClientID());
                    } else if ("all".equals(str)) {

                        StringBuilder stringBuilder = new StringBuilder("Сейчас подключены пользователи: ");

                        for (Map.Entry<ClientID, String> entry : connectionDB.entrySet()) {
                            try {
                                Sender.send(new Message("", serverID), entry.getKey());
                            } catch (ConnectException e) {
                                System.out.println("Пользователь " + entry.getKey().getNick() + " отключился");
                                connectionDB.remove(entry.getKey());
                            }
                            if (connectionDB.containsKey(entry.getKey())) {
                                stringBuilder.append("\"");
                                stringBuilder.append(entry.getKey().getNick());
                                stringBuilder.append("\" ");
                            }
                        }
                        Sender.send(new Message(stringBuilder.toString(), serverID), message.getClientID());
                        System.out.println("Сообщение " + stringBuilder.toString() + " отправлено " + message.getClientID());
                    } else {
                        // всем пользователям
                        for (Map.Entry<ClientID, String> entry : connectionDB.entrySet()) {
                            try {
                                System.out.println("Сообщение " + str + " отправлено");
                                Sender.send(new Message(str, message.getClientID()), entry.getKey());
                            } catch (ConnectException e) {
                                System.out.println("Пользователь " + entry.getKey().getNick() + " отключился");
                                connectionDB.remove(entry.getKey());
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Сервер. Ошибка прерывания");
            } catch (IOException e) {
                System.out.println("Сервер. Ошибка ввода/ввывода");
            }
        }).start();


    }
}
