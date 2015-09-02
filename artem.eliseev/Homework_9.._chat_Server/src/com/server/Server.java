package com.server;

import com.client.MessageFromClientToServer;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Anry on 22.08.2015.
 */
public class Server {
    //    static int counter = 0;
    static List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());
    static BlockingQueue<String> mainQueue = new LinkedBlockingQueue<String>();


    Server() {

        ServerIn serverIn = new ServerIn(mainQueue);
        new Thread(serverIn).start();

        ServerOut serverOut = new ServerOut(mainQueue);
        new Thread(serverOut).start();

    }

//    public static void main(String... args)
////            throws IOException, ClassNotFoundException
// {
////        if (args.length != 1) {
////            System.err.println("Usage: java EchoServer <port number>");
////            System.exit(1);
////        }
////        int portNumber = Integer.parseInt(args[0]);
//
////        class ServerIn implements Runnable {
////            private final BlockingQueue<String> queue;
////
////            ServerIn(BlockingQueue<String> mainQueue) {
////                queue = mainQueue;
////            }
////
////            @Override
////            public synchronized void run() {
////                while (true) {
////                    try (
////                            ServerSocket serverSocket =
////                                    new ServerSocket(Integer.parseInt(args[0]));
////                            Socket clientSocket = serverSocket.accept();
////                            ObjectInputStream in =
////                                    new ObjectInputStream(clientSocket.getInputStream());
////                    ) {
////                        System.out.println();
////                        System.out.println("Server works, connection done.");
////                        System.out.println("clientSocket:" + clientSocket.toString());
////                        MessageFromClientToServer messageFromClientToServer =
////                                (MessageFromClientToServer) in.readObject();
////                        System.out.println("messageFromClientToServer:" + messageFromClientToServer.toString());
////
////                        String clientIp = getClientIp(clientSocket);
////
////                        Connection con = new Connection(clientIp, messageFromClientToServer.inputClientPort);
////                        System.out.println(con.toString());
////                        if (con.newUserCheck(con)) {
////                            connections.add(con);
////                            System.out.println("Connection added");
////                        }
////                        try {
////                            queue.put(messageFromClientToServer.userInput);
////                        } catch (InterruptedException e) {
////                            System.out.println("BlockingQueue Server input InterruptedException");
////                            e.printStackTrace();
////                        }
////                        System.out.println("queue in receiver " + queue.toString());
////                    } catch (IOException e) {
////                        System.out.println("Exception caught when trying to listen on port "
////                                + portNumber + " or listening for a connection");
////                        System.out.println(e.getMessage());
////                        e.printStackTrace();
////                        break;
////                    } catch (ClassNotFoundException e) {
////                        System.out.println("ClassNotFoundException MessageFromClientToServer " +
////                                "incoming message on server");
////                        e.printStackTrace();
////                    }
////                }
////            }
////        }
//        BlockingQueue<String> mainQueue = new LinkedBlockingQueue<String>();
//        ServerIn serverIn = new ServerIn(mainQueue);
//        new Thread(serverIn).start();
//
//// Server Output
//
//
////        class ServerOut implements Runnable {
////            private final BlockingQueue<String> queue;
////
////            ServerOut(BlockingQueue<String> mainQueue) {
////                queue = mainQueue;
////            }
////
////            //toDO client socket timeout defence;
////            @Override
////            public synchronized void run() {
////                while (true) {
////                    StringBuffer messageOut = new StringBuffer();
////
////                    try {
////                        messageOut = messageOut.append(queue.take());
////                        System.out.println("Message in sender " + messageOut);
////                    } catch (NullPointerException e) {
////                        System.err.print("NullPointerException in server sender");
////                        e.printStackTrace();
////                    } catch (InterruptedException e) {
////                        System.out.println("BlockingQueue Server sender InterruptedException");
////                        e.printStackTrace();
////                    }
////                    Iterator<Connection> iter = connections.iterator();
////                    while (iter.hasNext()) {
////                        Connection connection = ((Connection) iter.next());
////
////                        if (!(Server.messageSender(connection, messageOut.toString()))) {
////                            System.err.print("The message has just been lost! ");
////                            System.err.println(connection.toString() + messageOut);
////                        }
////                    }
////
////                }
////            }
////        }
//        ServerOut serverOut = new ServerOut(mainQueue);
//        new Thread(serverOut).start();
//
//    }
//
////    private static String getClientIp(Socket clientSocket) {
////        return clientSocket.getInetAddress().toString().
////                substring(1, clientSocket.getInetAddress().toString().length());
////    }
////
////    public static boolean messageSender(Connection connection, String messageOut) {
////        try (
////                Socket echoSocket = new Socket(connection.clientIp, connection.clientInputPort);
////                PrintWriter out =
////                        new PrintWriter(echoSocket.getOutputStream(), true);
////        ) {
////            out.println(messageOut);
////        } catch (UnknownHostException e) {
////            System.err.println("Don't know about client " + connection.toString() +
////                    " Message:" + messageOut.toString());
////            e.printStackTrace();
////            return false;
////        } catch (IOException e) {
////            System.err.println("Couldn't get I/O for the connection to " +
////                    connection.toString() + "Message:" + messageOut.toString());
////            e.printStackTrace();
////            return false;
////        }
////        System.out.println("The message has been sent");
////        return true;
////    }
////
////    public static int counterWithSync() {
////        synchronized (com.server.Server.class) {
//////            try {
//////                Thread.sleep(1);
//////            } catch (InterruptedException e) {
//////                throw new RuntimeException(e);
//////            }
////            return ++counter;
////        }
////    }
}
