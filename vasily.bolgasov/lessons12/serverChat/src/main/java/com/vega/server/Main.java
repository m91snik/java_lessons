package com.vega.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Вася-Вега on 01.09.2015.
 */
public class Main {

    static ServerSocket server;
    final static int port = 9368;
    static Socket client;
    public static BlockingQueue blockingQueue = new ArrayBlockingQueue(33);
    public static volatile List outputUsers = new ArrayList<>();
    private static Thread outputMessage = null;



    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        Spring spring = applicationContext.getBean(Spring.class);

        System.out.println();

        try {
            server = new ServerSocket(port);
            System.out.println("Server start, and we waiting connection...");
            /*
             * Create thread for sending message for clients
             */
            outputMessage = new Thread(spring.newConnectionOutput);
            outputMessage.start();

            while(true) {
                try {

                /*
                 * Open ServerSocket and wait input message client
                 */

                    client = server.accept();

                    spring.newInput(client);
                    Thread inputMessage = new Thread(spring.newConnectionInput);

                    inputMessage.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
