package com.makedonsky94.socket;

import java.io.IOException;

public class Main {

    public static final int DEFAULT_PORT = 4444;

    public static void main(String[] args) throws IOException {
        //TODO: it's better to enter server host and port from console
        Thread workerReader = new Thread(new WorkerReader());
        workerReader.start();
        Thread workerWriter = new Thread(new WorkerWriter());
        workerWriter.start();
    }
}