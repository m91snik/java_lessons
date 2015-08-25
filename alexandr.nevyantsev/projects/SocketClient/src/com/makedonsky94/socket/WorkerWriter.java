package com.makedonsky94.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Sasha on 18.08.2015.
 */
public class WorkerWriter implements Runnable {
    private String color;
    private String nick = "unknown";
    public static final String ANSI_RESET = "\u001B[0m";

    public WorkerWriter() {
        this.color = "\u001B[3" + (Math.abs(new Random().nextInt()) % 7 + 1) + "m";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Socket socket = null;
        BufferedWriter bufferedWriter = null;
        while ( true ) {
            try {
                String msg = scanner.nextLine();
                socket = new Socket("localhost", Main.DEFAULT_PORT);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bufferedWriter.write(this.color);
                bufferedWriter.write(this.nick);
                bufferedWriter.write(": ");
                bufferedWriter.write(ANSI_RESET);
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch ( IOException e ) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedWriter.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
