package com.makedonsky94.socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Main {

    public static final int DEFAULT_PORT = 4444;

    public static void main(String[] args) throws IOException {
        Thread workerReader = new Thread(new WorkerReader());
        workerReader.start();
        Thread workerWriter = new Thread(new WorkerWriter());
        workerWriter.start();
    }
}