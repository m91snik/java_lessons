package com.gorbachevskaya.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Angelina on 14.08.2015.
 */

public class Client {
    private String ip;
    private int port = 1234;

    public Client() {
        try {
            ip = InetAddress.getLocalHost().getHostAddress();

            Socket socket = new Socket(ip, port);
            Socket socket1 = new Socket(ip, 8283);

            new Thread(new Sender(socket)).start();
            new Thread(new Reciever(socket1)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
