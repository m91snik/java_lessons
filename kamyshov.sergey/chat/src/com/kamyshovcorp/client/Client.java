package com.kamyshovcorp.client;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Client {

    public static void main(String[] args) {
        try {
            new Thread(new ClientReader()).start();
            new Thread(new ClientWriter()).start();

            // Ждем завершения других потоков, чтобы поток Main не закрылся
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
