package com.igor2i.server.thread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by igor2i on 16.08.2015.
 */
public class Connector implements Runnable {

    private BlockingQueue<String> drop;
    private static LinkedList<Socket> clientSocket;
    private ServerSocket serverSocket;
    private LinkedHashMap nickUserSocket;

    public Connector(BlockingQueue<String> b, ServerSocket serverSocket, LinkedList<Socket> clientSocket,LinkedHashMap nickUserSocket) {
        this.drop = b;
        this.serverSocket = serverSocket;
        Connector.clientSocket = clientSocket;
        this.nickUserSocket = nickUserSocket;
    }

    public static void rm(Socket client) {
        clientSocket.remove(client);
    }

    public static void rmAll() {
        while (clientSocket.size() > 0) {
            try {
                clientSocket.pop().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean stoped = false;

    public static void setStop() {
        stoped = true;
    }

    @Override
    public void run() {

        try {
            while (!stoped) {
                clientSocket.add((Socket) serverSocket.accept());
                Thread readSocket = new Thread(new ReadSocket(drop, clientSocket.getLast(),nickUserSocket));
                readSocket.setDaemon(true);
                readSocket.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
