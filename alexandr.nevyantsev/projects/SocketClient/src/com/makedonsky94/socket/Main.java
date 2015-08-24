package com.makedonsky94.socket;

import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        //TODO: in this implementation server side will not be able to work with this client once socket is closed.
        // create new socket for each message or use isConnected and create new one once it's closed
        Socket socket = new Socket("localhost", 4444);
        Thread workerReader = new Thread(new WorkerReader(socket));
        workerReader.start();
        Thread workerWriter = new Thread(new WorkerWriter(socket));
        workerWriter.start();
        //TODO: close socket appropriately
    }
}