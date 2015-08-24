package Server;

import Client.ClientID;
import Client.Message;
import Client.Sender;

import java.io.*;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
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
    //TODO: encapsulate connections storage in separate class
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
                        //TODO: throw this exception
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
                    //TODO: implement strategy pattern (https://ru.wikipedia.org/wiki/%D0%A1%D1%82%D1%80%D0%B0%D1%82%D0%B5%D0%B3%D0%B8%D1%8F_%28%D1%88%D0%B0%D0%B1%D0%BB%D0%BE%D0%BD_%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F%29)
                    //TODO: create factory which will provide strategy for each operation and each strategy will encapsulate logic of it's processing
                    // определенному пользователю
                    String str = message.getText();
                    if (str.indexOf("@") == 0) {

                        String[] strings = str.split(" ");
                        String receiverNick = strings[0];
                        receiverNick = receiverNick.substring(1);
                        ClientID privateReceiver = null;

                        for (Map.Entry<ClientID, String> entry : connectionDB.entrySet()) {
                            if (entry.getKey().getNick().equals(receiverNick)) {
                                privateReceiver = entry.getKey();
                            }
                        }

                        Sender.send(message, privateReceiver);
                        System.out.println("Личное сообщение " + message.getText() + " отправлено " + privateReceiver);
                    } else if ("save".equals(str)) {
                        // отправвить сообщение тому, кто его прислал
                        Sender.send(message, message.getClientID());
                        System.out.println("Клиент " + message.getClientID() + " сохранил свою историю переписки");
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
                        System.out.println("Клиент " + message.getClientID() + " запросилл список вссех подключенных пользователей");
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
                //TODO: use e.printStackTrace()
                System.out.println("Сервер. Ошибка прерывания");
            } catch (IOException e) {
                //TODO: use e.printStackTrace()
                System.out.println("Сервер. Ошибка ввода/ввывода");
            }
        }).start();


    }
}
