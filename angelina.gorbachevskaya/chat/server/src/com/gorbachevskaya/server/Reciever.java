package com.gorbachevskaya.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Ангелина on 16.08.2015.
 */
public class Reciever implements Runnable{
    BlockingQueue<String> queue;
    private boolean flag = false;
    Socket socket;

    public Reciever(Socket ss, BlockingQueue<String> queue) {
        this.socket = ss;
        this.queue = queue;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        ) {
            while (!flag) {
                String str = in.readLine();
                queue.put(str);
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port or listening for a connection");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}