package com.vega.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Вася-Вега on 17.08.2015.
 */
public class NewConnectionInput implements Runnable {

    Socket client;
    int numberUser = ++Main.countUser;
    private static BufferedReader input;

    public NewConnectionInput(Socket socket) {
        this.client = socket;
    }

    @Override
    public void run() {

        try {
            this.input = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            String inputMessage;
            while(true){
                inputMessage = this.input.readLine();
                if (inputMessage.equalsIgnoreCase("exit") || inputMessage.equalsIgnoreCase("close")){
                    break;
                }else{
                    Main.blockingQueue.put(inputMessage);
                    System.out.println("We get: " + inputMessage + " from user"+numberUser);
                    Main.whoSend = numberUser;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
