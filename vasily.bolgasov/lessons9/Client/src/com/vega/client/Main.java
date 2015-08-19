package com.vega.client;

import sun.plugin2.message.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Вася-Вега on 15.08.2015.
 */
public class Main {

    private static Socket server = null;
    private final static int port = 9368;
    private final static String adress = "localhost";


    public static void main(String[] args) {

        try {
            server = new Socket(adress,port);

            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

            Thread thread = new Thread(new InputMessage(server));
            thread.start();

            String fuser;

            while (true){
                fuser = inu.readLine();
                out.println(fuser);
                if (fuser.equalsIgnoreCase("close") || fuser.equalsIgnoreCase("exit")){
                    System.out.println("End session");
                    server.close();
                    break;
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
