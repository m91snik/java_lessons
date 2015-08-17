package com.igor2i.server;

import com.igor2i.server.prevetstvie.Prevetstvie;
import com.igor2i.server.scanner.Scanner;
import com.igor2i.server.thread.Connector;
import com.igor2i.server.thread.PostMes;

import java.io.IOException;

/**
 * Created by igor2i on 12.08.2015.
 */
import java.net.*;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String args[]) throws IOException {

        InetAddress addr = InetAddress.getByName("127.0.0.1");
        ServerSocket serverSocket;
        serverSocket = new ServerSocket(5055, 50, addr);

        Prevetstvie.getPrevetstvie(serverSocket.getLocalSocketAddress().toString());


        BlockingQueue<String> blockingQueue = new SynchronousQueue<String>();

        LinkedList<Socket> clientSocket = new LinkedList<Socket>();


        Thread connector = new Thread(new Connector(blockingQueue, serverSocket, clientSocket));
        connector.setDaemon(true);
        connector.start();

        Thread postMes = new Thread(new PostMes(blockingQueue, clientSocket));
        postMes.setDaemon(true);
        postMes.start();

        while (true) {
            if (Scanner.getScan().equals("shutdown")) {
                Connector.rmAll();
                Connector.setStop();
                serverSocket.close();
                break;
            }
        }
    }
}
