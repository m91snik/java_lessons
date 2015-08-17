package com.kamyshovcorp.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Server {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started with port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Server accepted new client with address: " + socket.getLocalSocketAddress());

                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
