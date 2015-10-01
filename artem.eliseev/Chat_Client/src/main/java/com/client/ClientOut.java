package com.client;

import oldNotInWork.EchoServer;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * From server to client.
 */
@Component
public class ClientOut implements Runnable {
    int inputClientPort;

    public ClientOut(int inputClientPort) {
        this.inputClientPort = inputClientPort;
    }

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
                e.printStackTrace();
            }
        }
    }
}
Chat - stable version. Working on TODOes; Client-jar, server-war; Tombcat, rest - not finished