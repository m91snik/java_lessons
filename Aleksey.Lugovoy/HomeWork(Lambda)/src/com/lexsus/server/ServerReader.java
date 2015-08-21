package com.lexsus.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by LugovoyAV on 13.08.2015.
 */
public class ServerReader implements Runnable {
    private ServerSocket socket = null;
    private BlockingQueue queue = null;
    private ConcurrentHashMap<String, String> clientsMap;


    public ServerReader(BlockingQueue<Message> queue, ServerSocket socket, ConcurrentHashMap<String, String> clientsMap) throws IOException {
        this.queue = queue;
        this.socket = socket;
        this.clientsMap = clientsMap;
    }

    @Override
    public void run() {
      while (true) {
            try {
                Socket client = socket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                switch (message.type){
                    case LOGIN:
                        InetAddress address = client.getInetAddress();
                        clientsMap.put(message.Text, address.toString().substring(1));
                        break;
                    case MESSAGE:
                        queue.put(message);
                        break;
                }
                client.close();

            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                e.printStackTrace();
            }
      }
    }
}