package com.client;

import oldNotInWork.EchoServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * From server to client.
 */
public class ClientOut implements Runnable {
    int inputClientPort;

    public ClientOut(int inputClientPort) {
        this.inputClientPort = inputClientPort;
    }

    //TO DO: do not use synchronized here. it makes no sense: Done
    @Override
    public void run() {
        while (true) {
            try (
                    ServerSocket clientServerSocket =
                            new ServerSocket(inputClientPort);
                    Socket clientSocket = clientServerSocket.accept();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));
            ) {
                System.out.println(" echo: " + in.readLine());
            } catch (IOException e) {
                //TODO: do not dublicate errors in console. e.printStackTrace() is enought
                System.out.println("Exception caught when trying to listen on port "
                        + inputClientPort + " or listening for a connection");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
