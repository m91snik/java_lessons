package com.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by Anry on 22.08.2015.
 */
public class Server {
    static int counter = 0;
    static List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());


    Server() {
    }

    public static void main(String... args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);

        class ServerIn implements Runnable {
            private final BlockingQueue blockingQueue;

            ServerIn(BlockingQueue mainBlockingQueue) {
                blockingQueue = mainBlockingQueue;
            }

            @Override
            public synchronized void run() {
                while (true) {
                    try (
                            ServerSocket serverSocket =
                                    new ServerSocket(Integer.parseInt(args[0]));
                            Socket clientSocket = serverSocket.accept();

                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(clientSocket.getInputStream()));
                    ) {
                        String inputLine;
                        String clientIp;
                        clientIp = clientSocket.getInetAddress().toString();
                        Connection con = new Connection(clientSocket, clientIp);
                        if (con.newUserCheck(con)) {
                            connections.add(con);
                        }
                        inputLine = in.readLine();
                        try {
                            blockingQueue.put(inputLine);
                        } catch (InterruptedException ex) {
                            System.out.println("BlockingQueue Server input Exception");
                        }
                        clientSocket.close();
                    } catch (IOException e) {
                        System.out.println("Exception caught when trying to listen on port "
                                + portNumber + " or listening for a connection");
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        BlockingQueue mainBlockingQueue = new LinkedBlockingQueue();
        ServerIn serverIn = new ServerIn(mainBlockingQueue);
        new Thread(serverIn).start();
//        Thread threadIn = new Thread(runnableIn);
//        threadIn.start();


// Server Output


        class ServerOut implements Runnable {
            private final BlockingQueue blockingQueue;

            ServerOut(BlockingQueue mainBlockingQueue) {
                blockingQueue = mainBlockingQueue;
            }

            //toDO client socket timeout defence;
            @Override
            public synchronized void run() {
                Socket clientSocket;


                Iterator<Connection> iter = connections.iterator();
                while (iter.hasNext()) {
                    Connection connection = new Connection(null);
                    connection = (Connection) iter.next();

                    try (PrintWriter out =
                                 new PrintWriter(connection.clientSocket.getOutputStream(), true);
                    )
                }

            }
        }


    }

    public static int counterWithSync() {
        synchronized (Server.class) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return ++counter;
        }
    }

}