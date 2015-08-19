package com.gorbachevskaya.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ангелина on 15.08.2015.
 */
public class Reciever implements Runnable {
    private int port;
    private boolean flag = false;

    Reciever(int port) {
        this.port = port;
    }

    public void setFlag() {
        this.flag = true;
    }

    @Override
    public void run() {
        while (!flag) {

            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
            ) {
                String msg = in.readLine();
                System.out.println(msg);
            } catch (IOException e) {
                System.out.println("Couldn't get I/O for the connection");
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
}
