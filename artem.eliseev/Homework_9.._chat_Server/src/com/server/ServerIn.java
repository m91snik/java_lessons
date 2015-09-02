package com.server;

import com.client.MessageFromClientToServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Anry on 25.08.2015.
 */
class ServerIn implements Runnable {
    private final BlockingQueue<String> queue;

    ServerIn(BlockingQueue<String> mainQueue) {
        queue = mainQueue;
    }

    @Override
    public synchronized void run() {
        while (true) {
            Constants constants=new Constants();
            try (
                    ServerSocket serverSocket =
                            new ServerSocket(constants.getSERVER_INPUT_PORT());
                    Socket clientSocket = serverSocket.accept();
                    ObjectInputStream in =
                            new ObjectInputStream(clientSocket.getInputStream())
            ) {
                System.out.println();
                System.out.println("Server works, connection done.");
                System.out.println("clientSocket:" + clientSocket.toString());
                MessageFromClientToServer messageFromClientToServer =
                        (MessageFromClientToServer) in.readObject();
                System.out.println("messageFromClientToServer:" + messageFromClientToServer.toString());

                String clientIp = getClientIp(clientSocket);

                Connection con = new Connection(clientIp, messageFromClientToServer.inputClientPort);
                System.out.println(con.toString());
                if (con.newUserCheck(con)) {
                    Server.connections.add(con);
                    System.out.println("Connection added");
                }
                try {
                    queue.put(messageFromClientToServer.userInput);
                } catch (InterruptedException e) {
                    System.out.println("BlockingQueue Server input InterruptedException");
                    e.printStackTrace();
                }
                System.out.println("queue in receiver " + queue.toString());
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port "
                        + constants.getSERVER_INPUT_PORT() + " or listening for a connection");
                System.out.println(e.getMessage());
                e.printStackTrace();
                break;
            } catch (ClassNotFoundException e) {
                System.out.println("ClassNotFoundException MessageFromClientToServer " +
                        "incoming message on server");
                e.printStackTrace();
            }
        }
    }
    private static String getClientIp(Socket clientSocket) {
        return clientSocket.getInetAddress().toString()
                .substring(1, clientSocket.getInetAddress().toString().length());
    }
}
