package com.kamyshovcorp.client;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class Client {

    private static final String HOSTNAME = "127.0.0.1";
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOSTNAME, PORT)) {
            new Thread(new ClientReader(socket)).start();
            new Thread(new ClientWriter(socket)).start();

            // Ждем завершения других потоков, чтобы socket не закрылся
            Thread.currentThread().join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
