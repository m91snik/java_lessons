package com.makedonsky94.socket;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4444);
        Thread workerReader = new Thread(new WorkerReader(socket));
        workerReader.start();
        Thread workerWriter = new Thread(new WorkerWriter(socket));
        workerWriter.start();
    }
}