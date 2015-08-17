package com.igor2i.server.thread;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

/**
 * Created by igor2i on 16.08.2015.
 */
public class PostMes implements Runnable {

    private BlockingQueue<String> drop;
    private LinkedList<Socket> clientSocket;

    public PostMes(BlockingQueue<String> b, LinkedList<Socket> clientSocket) {
        this.drop = b;
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {

        System.out.println("Start server PostMes");
        String line = null;
        try {
            while(true) {
                try {
                    line = drop.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(Socket s : clientSocket) {

                    BufferedWriter bOut = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));

                    bOut.write(line + "\r\n");
                    bOut.flush();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}