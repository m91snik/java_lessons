package com.gorbachevskaya.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Ангелина on 16.08.2015.
 */
public class Reciever implements Runnable {
    ConcurrentHashMap<InetAddress, Integer> connections;
    BlockingQueue<String> messages;
    private boolean flag = false;
    ServerSocket serverSocket;
    int port;

    public Reciever(int port, ConcurrentHashMap<InetAddress, Integer> connections,
                    BlockingQueue<String> messages) {
        this.connections = connections;
        this.port = port;
        this.messages = messages;
        try  {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (!flag) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));
            ) {
                String inputString = in.readLine();
                InetAddress adr = socket.getInetAddress();
                if (!connections.containsKey(adr)) {
                    connections.put(adr, Integer.valueOf(inputString));
                }
                else {
                    messages.put(inputString);
                    System.out.println(connections.toString() + "  " + inputString);
                }
                System.out.println(connections.size());
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}