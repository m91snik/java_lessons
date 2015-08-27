package com.vega.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Вася-Вега on 15.08.2015.
 */
public class Main {

    static ServerSocket server;
    final static int port = 9368;
    static Socket client;
    public static BlockingQueue blockingQueue = new ArrayBlockingQueue(33);
    public static List outputUsers = new ArrayList<>();
    public static int countUser = 0;
    public static int whoSend = 0;
    private static Thread outputMessage = null;

    public static void main(String[] args) {

        try {
            server = new ServerSocket(port);
            System.out.println("Server start, and we waiting connection...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * Create thread for sending message for clients
         */

        outputMessage = new Thread(new NewConnectionOutput());
        outputMessage.start();

        while(true) {
            try {

                /*
                 * Open ServerSocket and wait input message client
                 */

                client = server.accept();

                Thread inputMessage = new Thread(new NewConnectionInput(client));
                inputMessage.start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

