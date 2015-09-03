package com.makedonsky94.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by Sasha on 18.08.2015.
 */
public class WorkerReader implements Runnable {
    private ServerSocketChannel socketChannel;

    public WorkerReader() throws IOException {
        this.socketChannel = ServerSocketChannel.open();
        this.socketChannel.bind(new InetSocketAddress("localhost", 4545));
    }

    @Override
    public void run() {
        while(true) {
            try(SocketChannel inputSocketChannel =  this.socketChannel.accept())
            {
                ByteBuffer reader = ByteBuffer.allocate(256);
                inputSocketChannel.read(reader);
                System.out.println(new String(reader.array()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
