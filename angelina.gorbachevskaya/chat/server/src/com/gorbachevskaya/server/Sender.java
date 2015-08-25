package com.gorbachevskaya.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Ангелина on 16.08.2015.
 */
public class Sender implements Runnable {
    String ip;
    int port;
    BlockingQueue<String> queue;
    private boolean flag = false;
    Socket socket;

    public Sender(Socket ss, BlockingQueue<String> queue) {
        this.socket = ss;
        this.queue = queue;
    }

    public Sender(String ip, int port, BlockingQueue<String> queue) {
        this.ip = ip;
        this.port = port;
        this.queue = queue;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try (
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
        ) {
            String str = null;
            while (  (str = queue.take()) != null) {
                out.println(str);
                System.out.println("Send messsage: *" + str + "*");
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + " or listening for a connection");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
