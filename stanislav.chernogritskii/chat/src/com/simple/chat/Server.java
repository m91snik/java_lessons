package com.simple.chat;

/**
 * Created by stanislav on 12.08.15.
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Server {

    private ServerSocket ss;
    Thread serverThread;
    int port;
    static BlockingQueue<EchoServer> q = new LinkedBlockingQueue<>();

    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
        this.port = port;
    }

    public static void main(String[] args) throws IOException {
        new Server(1234).run();
    }

    void run() {
        serverThread = Thread.currentThread();
        while (true) {
            Socket s = newConnection();
            try {
                final EchoServer processor = new EchoServer(s);
                final Thread thread = new Thread(processor);
                thread.setDaemon(true);
                thread.start();
                q.offer(processor);
            }
            catch (IOException ignored) {}
        }
    }

    private Socket newConnection() {
        Socket s = null;
        try {
            s = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                ss.close();
            } catch (IOException ignored) {}
        }
        return s;
    }
}
