package com.gorbachevskaya.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Angelina on 14.08.2015.
 */

public class Server {
    private int port = 1234;
    BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    boolean flag = false;

    public void setFlag() {
        this.flag = true;
    }

    Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            ServerSocket serverSocket1 = new ServerSocket(8283);
            Socket socket1 = serverSocket1.accept();
            new Thread(new Sender(socket1, queue)).start();

            while (!flag) {
                Socket socket = serverSocket.accept();
                new Thread(new Reciever(socket, queue)).start();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}