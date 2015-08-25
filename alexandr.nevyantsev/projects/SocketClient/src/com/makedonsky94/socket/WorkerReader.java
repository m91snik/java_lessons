package com.makedonsky94.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by Sasha on 18.08.2015.
 */
public class WorkerReader implements Runnable {

    private BufferedReader bufferedReader;
    private ServerSocket socket;

    public WorkerReader() throws IOException {
        //this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.socket = new ServerSocket(4445);
    }

    @Override
    public void run() {
        Socket inputSocket = null;
        BufferedReader bufferedReader = null;
        while(true) {
            try {
                inputSocket = socket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
                String message = bufferedReader.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                    inputSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
