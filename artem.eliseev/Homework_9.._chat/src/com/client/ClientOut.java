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
public class ClientOut {
    public static void main(String... args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        try (
                ServerSocket clientServerSocket =
                        new ServerSocket(Integer.parseInt(args[0]));
                Socket clientSocket = clientServerSocket.accept();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while (true) {
                System.out.println(" echo: " + in.readLine());
            }
        }
        catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }

    }
}
