package com.server;

/**
 * Created by Anry on 22.08.2015.
 */
public class Server {
    static int counter = 0;
    Server() {
    }

    public static void main(String[] args) {
    }
    static int counterWithSync() {
        synchronized (Server.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ++counter;
        }
    }

}
