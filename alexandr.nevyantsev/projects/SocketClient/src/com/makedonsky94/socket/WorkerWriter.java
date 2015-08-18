package com.makedonsky94.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Sasha on 18.08.2015.
 */
public class WorkerWriter implements Runnable {
    private BufferedWriter bufferedWriter;
    private Socket socket;

    public WorkerWriter(Socket socket) throws IOException {
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while ( true ) {
            try {
                String msg = scanner.nextLine();
                bufferedWriter.write(msg);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }
}
