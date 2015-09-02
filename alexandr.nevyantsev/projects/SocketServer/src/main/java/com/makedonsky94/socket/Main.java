package com.makedonsky94.socket;



import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static final int DEFAULT_PORT = 4444;
    private static BlockingQueue<Message> messageBlockingQueue;
    private static ConcurrentHashMap<String, Client> clients;

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        messageBlockingQueue = new ArrayBlockingQueue<>(500);
        clients = new ConcurrentHashMap<>();
        try {
            Thread workerWriter = new Thread(new WorkerWriter(messageBlockingQueue, clients));
            workerWriter.start();
            Thread workerReader = new Thread(new WorkerReader(messageBlockingQueue, clients, port));
            workerReader.start();
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
