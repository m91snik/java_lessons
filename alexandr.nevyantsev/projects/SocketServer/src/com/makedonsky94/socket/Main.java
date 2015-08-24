package com.makedonsky94.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static final String DEFAULT_PORT = "4444";
    private static BlockingQueue<Message> messageBlockingQueue;
    private static ConcurrentHashMap<Socket, Client> clients;

    public static void main(String[] args) {
        //TODO: use int as port type
        String port = args.length > 0 ? args[0] : DEFAULT_PORT;
        messageBlockingQueue = new ArrayBlockingQueue<>(500);
        clients = new ConcurrentHashMap<>();
        //TODO: encapsulate serverSocket in worketReader
        try (
                ServerSocket serverSocket = new ServerSocket(Integer.parseInt(port))
        ) {
            //TODO: move workerWriter outside of this block because it doesn't work with serverSocket
            Thread workerWriter = new Thread(new WorkerWriter(messageBlockingQueue, clients));
            workerWriter.start();
            while (true) {
                Socket echoSocket = serverSocket.accept();

                System.out.println(echoSocket.toString() + "connected");

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(echoSocket.getOutputStream()));
                clients.put(echoSocket, new Client(bufferedWriter));
                //TODO: do not create new thread for each client. just use one thread to process a messages from blocking queue
                Thread workerReader = new Thread(new WorkerReader(messageBlockingQueue, echoSocket, clients));
                workerReader.start();
            }
        } catch (UnknownHostException e) {
            //TODO: throw it
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
