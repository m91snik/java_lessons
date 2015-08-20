package com.donriver.finance.core.qa.loadtest.data.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;

/**
 * Created by nikolay.garbuzov on 18.08.15.
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        ServerSocket serverSocket = new ServerSocket(7778);


        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                Socket socket = null;
                try {
                    socket = new Socket("localhost", 7778);
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
                PrintWriter writer = null;
                try {
                    writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                } catch (IOException e) {
                    throw new IllegalArgumentException();
                }
                writer.println(Thread.currentThread().getName());
                writer.flush();
                writer.close();
                try {
                    socket.close();
                } catch (IOException e) {
                }

            }).start();
        }

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
            socket.close();
        }

    }
}
