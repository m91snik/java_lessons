package com.gorbachevskaya.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ангелина on 15.08.2015.
 */
public class Sender implements Runnable {
    private int port;
    private String ipAddr;

    public Sender(String ipAddr, int port) {
        System.out.println("Enter your port, please: ");
        this.port = port;
        this.ipAddr = ipAddr;
    }

    @Override
    public void run() {
        try (
             BufferedReader stdIn =
                     new BufferedReader(
                             new InputStreamReader(System.in));
        ) {
            String userInput;
            String stringStop = "stop";

            while ( !stringStop.equals( userInput = stdIn.readLine()) ) {
                try (Socket socket = new Socket(ipAddr, port);
                        PrintWriter out =
                             new PrintWriter(socket.getOutputStream(), true);) {
                    out.println(userInput);
                    System.out.println("send message: " + "*" + userInput + "*");
                }

            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection");
            System.exit(1);
        }
    }
}
