package com.igor2i.server.thread;

import java.io.*;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;

/**
 * Created by igor2i on 16.08.2015.
 */
public class ReadSocket implements Runnable {

    private BlockingQueue<String> drop;
    private Socket clientSocket;
    private LinkedHashMap nickUserSocket;


    public ReadSocket(BlockingQueue<String> b, Socket clientSocket, LinkedHashMap nickUserSocket) {
        this.drop = b;
        this.clientSocket = clientSocket;
        this.nickUserSocket = nickUserSocket;
    }



    @Override
    public void run() {

        System.out.println("Start server ReadSocket");

        try {


            try {
                String line = "";

                BufferedReader bIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));

                String nick = bIn.readLine();

                nickUserSocket.put(nick, clientSocket);

                drop.put("В чат присоединился " + nick);

                while (!(line = bIn.readLine()).equals("exit")) {

                    drop.put(nick + ":  " + line);

                }
                bIn.close();
                Connector.rm(clientSocket);
                nickUserSocket.remove(nick);
                clientSocket.close();
                drop.put(nick + " покинул чат");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
