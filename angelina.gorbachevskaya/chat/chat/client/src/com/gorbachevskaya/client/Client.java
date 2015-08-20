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

            new Thread(new Sender(ip, port)).start();
            // при первом подключении клиента требуется ввести номер сокета, который он будет слушать на прием
            // соответственнно этот порт и надо потом передать  конструктор обьекта Reciever
            int recivePort = 8283;
            new Thread(new Reciever(recivePort)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
