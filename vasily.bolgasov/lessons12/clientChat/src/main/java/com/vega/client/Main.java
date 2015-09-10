package com.vega.client;

import com.vega.client.connection.ConnectionData;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Вася-Вега on 01.09.2015.
 */
public class Main {

    private static Socket server = null;
    private static ConnectionData connectionData = new ConnectionData();
    static String fuser;
    public static ChatLog chatLog;

    /*
     * Create our data for read-write messages
     */

    private static void connectData(){

        Scanner scanner = new Scanner(System.in);
        connectionData.setPort(9368);
        connectionData.setAdressServer("localhost");
        Random random = new Random();
        Integer ourPort = connectionData.getPort() + random.nextInt(1000);
        connectionData.setOurPort(ourPort);
        try{
            connectionData.setOurAdress(InetAddress.getLocalHost());
        }catch (UnknownHostException e){
            throw new RuntimeException(e);
        }
        System.out.println("you wanna LOGIN or REGISTER? ");
        connectionData.setLogin(scanner.next());
        System.out.println("Write your login ");
        connectionData.setOurLogin(scanner.next());
        System.out.println("Write your password ");
        connectionData.setOurPassword(scanner.next());

    }

    static Runnable runnable2 = () -> {
        ServerSocket socket;
        String fserver;

        try {

            socket = new ServerSocket(connectionData.getOurPort());

            while (true){
                server = socket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                fserver = in.readLine();
                System.out.println(fserver);
                server.close();
                chatLog.doChatLog(fserver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {

        connectData();
        chatLog = new ChatLog(String.valueOf(Command.CHATLOG));

        try {
            BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

            /*
             * Create new thread for input message
             */

            Thread thread = new Thread(runnable2);
            thread.start();

            System.out.println("Write your message");

            while (true){
                fuser = inu.readLine();
                if (String.valueOf(Command.COMMANDCHATSAVE).equals(fuser)){

                    System.out.println("Now all next message as save");
                    chatLog.startSave(String.valueOf(Command.CHATLOG));

                }else if(String.valueOf(Command.COMMANDCHATUNSAVE).equals(fuser)){

                    System.out.println("Now all next message not save");
                    chatLog.stopSave();

                }else {

                    /*
                     * Open socket for output message and send our data and message
                     */

                    server = new Socket(connectionData.getAdressServer(), connectionData.getPort());
                    PrintWriter out = new PrintWriter(server.getOutputStream(), true);
                    out.println(connectionData.getOurAdress().getHostAddress() + " - " +
                            connectionData.getOurPort() + " - " + connectionData.getOurLogin()
                            + " - " + connectionData.getLogin() + " - " + connectionData.getOurPassword());
                    out.println(fuser);
                    if (fuser.equalsIgnoreCase(String.valueOf(Command.CLOSE)) ||
                            fuser.equalsIgnoreCase(String.valueOf(Command.EXIT))) {
                        System.out.println("End session");
                        break;
                    }
                    server.close();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.exit(0);
    }

}
