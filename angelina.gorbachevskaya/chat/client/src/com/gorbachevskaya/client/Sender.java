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
    private Socket socket;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (PrintWriter out =
                     new PrintWriter(socket.getOutputStream(), true);

             BufferedReader stdIn =
                     new BufferedReader(
                             new InputStreamReader(System.in));
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("send message: " + "*" + userInput + "*");
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + socket.getLocalAddress());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    socket.getLocalAddress());
            System.exit(1);
        }
    }
}
