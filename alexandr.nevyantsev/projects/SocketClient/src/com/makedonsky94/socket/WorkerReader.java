package com.makedonsky94.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Sasha on 18.08.2015.
 */
public class WorkerReader implements Runnable {

    private BufferedReader bufferedReader;
    private Socket socket;

    public WorkerReader(Socket socket) throws IOException {
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.socket = socket;
    }

    @Override
    public void run() {
        while(socket.isConnected()) {
            try {
                String message = bufferedReader.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
