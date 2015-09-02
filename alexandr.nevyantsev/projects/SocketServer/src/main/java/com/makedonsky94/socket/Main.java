package com.makedonsky94.socket;



import com.makedonsky94.socket.impl.WorkerReaderImpl;
import com.makedonsky94.socket.impl.WorkerWriterImpl;
import com.makedonsky94.socket.main.MainReader;
import com.makedonsky94.socket.main.MainWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static final int DEFAULT_PORT = 4444;
    private static BlockingQueue<Message> messageBlockingQueue;
    private static ConcurrentHashMap<String, Client> clients;

    public static void main(String[] args) {
        //TODO config file with host and port
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(Config.class);
        ServerWorker serverWorker = applicationContext.getBean(ServerWorker.class);
        serverWorker.startServerWorker();
    }
}
