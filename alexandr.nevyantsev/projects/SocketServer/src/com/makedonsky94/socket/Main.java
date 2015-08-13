package com.makedonsky94.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    private static final String DEFAULT_PORT = "4444";
    private static BlockingQueue<Message> messageBlockingQueue;
    public static void main(String[] args) {
        String port = args.length > 0 ? args[0] : DEFAULT_PORT;
        while(true) {
            try (
                    ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port));
                    //BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            ) {
                Socket echoSocket = serverSocket.accept();
                System.out.println(echoSocket.toString());
                messageBlockingQueue = new ArrayBlockingQueue<Message>(1);
                Thread workerReader = new Thread(new WorkerReader(messageBlockingQueue, echoSocket));
                workerReader.start();
                Thread workerWriter = new Thread(new WorkerWriter(messageBlockingQueue, echoSocket));
                workerWriter.start();
                /*while (echoSocket.isConnected()) {
                    System.out.println("echo: " + in.readLine());
                }*/
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
