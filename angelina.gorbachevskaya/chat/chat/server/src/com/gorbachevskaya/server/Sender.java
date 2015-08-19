package com.gorbachevskaya.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ангелина on 16.08.2015.
 */
public class Sender implements Runnable {
    ConcurrentHashMap<InetAddress, Integer> connections;
    BlockingQueue<String> messages;

    public Sender(ConcurrentHashMap<InetAddress, Integer> connections,
                  BlockingQueue<String> messages) {
        this.connections = connections;
        this.messages = messages;
    }

    @Override
    public void run() {


        String str = null;
        try {
            while (  (str = messages.take()) != null) {
                for (Map.Entry<InetAddress, Integer> entry:connections.entrySet()) {

                    try ( Socket socket = new Socket(entry.getKey(),
                            entry.getValue());
                          PrintWriter out =
                                  new PrintWriter(socket.getOutputStream(), true);) {
                        out.println(str);
                        System.out.println("send message: " + "*" + str + "*");

                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

