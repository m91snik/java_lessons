package com.kamyshovcorp.server;


import com.kamyshovcorp.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Server {
    private static BlockingQueue<Message> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) {
        try {
            new Thread(new ServerReader(blockingQueue)).start();
            new Thread(new ServerWriter(blockingQueue)).start();

            // Ждем завершения других потоков, чтобы поток Main не закрылся
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



