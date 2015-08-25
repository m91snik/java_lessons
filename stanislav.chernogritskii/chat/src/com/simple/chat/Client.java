package com.simple.chat;

/**
 * Created by stanislav on 12.08.15.
 */

import java.net.Socket;
import java.io.*;

public class Client {
    private final Socket s;
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final BufferedReader input;

    public Client(String host, int port) throws IOException {
        s = new Socket(host, port);

        reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        input = new BufferedReader(new InputStreamReader(System.in));

        new Thread(() -> {
            while (!s.isClosed()) {
                String line = null;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    if ("Socket closed".equals(e.getMessage())) {
                        break;
                    }
                    System.out.println("Connection lost");
                    close();
                }
                if (line == null) {
                    System.out.println("Server has closed connection");
                    close();
                } else {
                    System.out.println(line);
                }
            }
        }).start();
    }

    public static void main(String[] args)  {
        try {
            new Client("127.0.0.1", 1234).run();
        } catch (IOException e) {
            System.out.println("Can't connect!");
        }
    }

    public void run() {
        System.out.println("Write something ('exit' for stop):");

        while (true) {
            String userText = null;
            try {
                userText = input.readLine();
            } catch (IOException ignored) {}

            if (s.isClosed() || "exit".equals(userText)) {
                close();
                break;
            } else {
                try {
                    writer.write(userText + "\n");
                    writer.flush();
                } catch (IOException e) {
                    close();
                    break;
                }
            }
        }
    }

    synchronized void close() {
        if (!s.isClosed()) {
            try {
                s.close();
            } catch (IOException ignored) {
                ignored.printStackTrace();
            }
        }
    }
}
