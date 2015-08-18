package com.simple.chat;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by stanislav on 13.08.15.
 */
public class EchoServer implements Runnable {
    Server server;
    Socket s;
    BufferedReader br;
    BufferedWriter bw;
    BlockingQueue<EchoServer> q = server.q;

    EchoServer(Socket socketParam) throws IOException {
        s = socketParam;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()) );
    }

    public void run() {
        while (!s.isClosed()) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                close();
            }

            if (line == null) {
                close();
            } else {
                for (EchoServer sp:q) {
                    sp.send(line);
                }
            }
        }
    }

    synchronized void send(String line) {
        try {
            bw.write("Message: " + line + "\n");
            bw.flush();
        } catch (IOException e) {
            close();
        }
    }

    public synchronized void close() {
        q.remove(this);
        if (!s.isClosed()) {
            try {
                s.close();
            } catch (IOException ignored) {}
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        close();
    }
}
