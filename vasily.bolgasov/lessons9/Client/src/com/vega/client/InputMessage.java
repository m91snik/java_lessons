package com.vega.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Created by Вася-Вега on 17.08.2015.
 */
public class InputMessage implements Runnable{

    private ServerSocket socket;
    private Socket server;
    String fserver;

    public InputMessage(int port) {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true){

                /*
                 * Waiting new message and close socket
                 */

                server = socket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
                fserver = in.readLine();
                System.out.println(fserver);
                server.close();
                if (Main.saveChat ==true){
                    Files.write(Main.path, Arrays.asList(fserver), StandardOpenOption.APPEND);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
