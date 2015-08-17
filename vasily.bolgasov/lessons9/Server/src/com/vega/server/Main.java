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

        System.out.println("Waiting connection...");
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true) {
            try {
                client = server.accept();
                System.out.println("New client");
                outputUsers.add(client);


                Thread inputMessage = new Thread(new NewConnectionInput(client));
                inputMessage.start();

                if (outputMessage == null) {
                    outputMessage = new Thread(new NewConnectionOutput());
                    outputMessage.start();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}

