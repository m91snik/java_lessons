package Client;

import ChatUtils.Sender;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Ангелина on 22.08.2015.
 * Input "save" to save client history at file "history@nick@.txt"
 * Input "all" to display all on-line users
 * To send private message to user with nickname AAA type @AAA and input message text after the space
 * F.e.: @user2 I send you private message
 */
public class ClientMain {
    private static String ipAddress;
    private static String port;
    private static String nick;
    private static final String SERVER_HOSTNAME = "localhost";
    private static final int SERVER_PORT = 1992;
    private static boolean flag = false;

    public static void main(String[] args) {
        //TODO: it make sense to ask user to enter server host ip and port instead of using constants

        try {
            ipAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            //TODO: throw an exception
            e.printStackTrace();
        }

        // проверка ввода
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свой ник");
        nick = scanner.next();
        System.out.println("Введите номер порта");
        port = scanner.next();
        if (!port.matches("[0-9]{4}")) {
            int tmp = (new Random().nextInt()) % (65535 - SERVER_PORT);
            port = ((Integer) (SERVER_PORT + Math.abs(tmp))).toString();
            System.out.println("Ошибка ввода порта. Присвоен порт номер " + port);
        }
        System.out.println("Все готово для начала общения!");


        // send
        new Thread(() -> {
            ClientID clientID = new ClientID(ipAddress, port, nick);
            ClientID serverID = new ClientID(SERVER_HOSTNAME, ((Integer) SERVER_PORT).toString(), "server");
            try (BufferedReader stdIn =
                         new BufferedReader(
                                 new InputStreamReader(System.in));) {
                String userInput;
//                while ( !"stop".equals( userInput = stdIn.readLine()) ) {
                while ((userInput = stdIn.readLine()) != null) {
                    Sender.send(new Message(userInput, clientID), serverID);
                }
                System.out.println("Сессия остановлена пользователем");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // receive
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(Integer.valueOf(port));) {
                ArrayList<String> listMessages = new ArrayList<>();
                while (!flag) {
                    try (Socket socket = serverSocket.accept();
                         ObjectInputStream in = new ObjectInputStream(socket.getInputStream());) {

                        Message mes = (Message) in.readObject();
                        //TODO: combine 2 if conditions
                        if (!"save".equals(mes.getText())) {
                            if (!"".equals(mes.getText())) {
                                String str = mes.getClientID().getNick() + " : " + mes.getText();
                                listMessages.add(str);
                                System.out.println(str);
                            }
                        } else {
                            writeToFile(listMessages);
                        }
                    } catch (ClassNotFoundException e) {
                        //TODO: throw an exception
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private static void writeToFile(ArrayList<String> lst) {
        Path path = Paths.get("history".concat(nick).concat(".txt"));
        FileChannel fileChannel = null;
        try {
            fileChannel = (FileChannel) Files.newByteChannel(path, StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE,
                    StandardOpenOption.READ);
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < lst.size(); i++) {
            String tmp = lst.get(i).concat("\n");
            ByteBuffer buffer = ByteBuffer.allocate(tmp.length());
            for (int j = 0; j < tmp.length(); j++) {
                buffer.put((byte) tmp.charAt(j));
            }
            buffer.rewind();
            try {
                fileChannel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            buffer.rewind();
        }
        System.out.println("Переписка сохранена в файл");
    }
}
