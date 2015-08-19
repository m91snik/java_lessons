package com.vega.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Вася-Вега on 17.08.2015.
 */
public class InputMessage implements Runnable{

    private Socket socket;

    public InputMessage(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String fserver;

            while (true){
                fserver = in.readLine();
                System.out.println(fserver);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
