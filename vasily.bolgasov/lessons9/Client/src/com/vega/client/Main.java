package com.vega.client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Вася-Вега on 15.08.2015.
 */
public class Main {

    private static Socket server = null;
    private final static int port = 9368;
    private final static String address = "localhost";
    private static String ourAddress = "localhost";
    private static String ourName;
    private static int ourPort;
    static String fuser;
    public static Path path;
    public static boolean saveChat = false;
    private static final String CHATLOG = "chatlog.txt";
    private static final String COMMANDCHATSAVE = ".savechat";
    private static final String COMMANDCHATUNSAVE = ".stopsavechat";

    private static Runnable runnable = new Runnable() {
        private ServerSocket socket;
        private Socket server;
        String fserver;

        @Override
        public void run() {
            try {

                socket = new ServerSocket(ourPort);

                while (true){
                    server = socket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                    fserver = in.readLine();
                    System.out.println(fserver);
                    server.close();
                    if (Main.saveChat ==true){
                        Files.write(Main.path, Arrays.asList(fserver), StandardOpenOption.APPEND);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    static Runnable runnable2 = () -> {
        ServerSocket socket;
        Socket server;
        String fserver;

        try {

            socket = new ServerSocket(ourPort);

            while (true){
                server = socket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                fserver = in.readLine();
                System.out.println(fserver);
                server.close();
                if (Main.saveChat ==true){
                    Files.write(Main.path, Arrays.asList(fserver), StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static void main(String[] args) {

        ourData();

        try {
            BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
//            Thread thread = new Thread(new InputMessage(ourPort));
//            thread.start();

//            Thread thread = new Thread(runnable);
//            thread.start();

            /*
             * Create new thread for input message
             */

            Thread thread = new Thread(runnable2);
            thread.start();

            System.out.println("Write your message");

            while (true){
                fuser = inu.readLine();
                if (fuser.equals(COMMANDCHATSAVE)){

                    /*
                     * Save in file all next message
                     */

                    System.out.println("Now all next message as save");
                    saveChat = true;
                    File file = new File(CHATLOG);
                    file.createNewFile();
                    path = Paths.get(CHATLOG);
                }else if(fuser.equals(COMMANDCHATUNSAVE)){

                    /*
                     * Stop save message in file
                     */

                    System.out.println("Now all next message not save");
                    saveChat = false;
                }else {

                    /*
                     * Open socket for output message and send our data and message
                     */

                    server = new Socket(address, port);
                    PrintWriter out = new PrintWriter(server.getOutputStream(), true);
                    out.println(ourAddress + "-" + ourPort + "-" + ourName);
                    out.println(fuser);
                    if (fuser.equalsIgnoreCase("close") || fuser.equalsIgnoreCase("exit")) {
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

    /*
     * Create our data for read-write messages
     */

    private static void ourData() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ourPort = port + random.nextInt(1000);
        System.out.println("Write your name ");
        ourName = scanner.next();
    }

}
