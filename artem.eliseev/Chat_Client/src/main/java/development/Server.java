package development;/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Iterator;


public class Server {
    private List<MyConnection> connections =
            Collections.synchronizedList(new ArrayList<MyConnection>());
    static int counter = 0;
    int portNumber = Const.SERVER_IN_PORT_NUMBER;
    static Socket clientSocket;
    ServerSocket serverSocket;


    //    public void main(String... args) throws IOException {
    public Server() {

//        if (args.length != 1) {
//            System.err.println("Usage: java oldNotInWork.EchoServer <port number>");
//            System.exit(1);
//        }

//        int portNumber = Integer.parseInt(args[0]);
        int portNumber = Const.SERVER_IN_PORT_NUMBER;
        try {
            ServerSocket serverSocket =
                    new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                MyConnection con = new MyConnection(clientSocket);
                connections.add(con);
                con.thread.start();
            }
//            PrintWriter out =
//                    new PrintWriter(clientSocket.getOutputStream(), true);
//
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }


    }
//    int counterWithSync() {
//        synchronized (Server.class) {
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            return ++counter;
//        }
//    }

    private void closeAll() {
        try {
            serverSocket.close();
            synchronized (connections) {
                Iterator<MyConnection> iter = connections.iterator();
                while (iter.hasNext()) {
//                    ((MyConnection) iter.next()).close();
                }
            }
        } catch (Exception e) {
            System.err.println("Threads didn't close.");
        }
    }

//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            try (String inputLine;) {
//            } catch (IOException e) {
//                System.out.println("Exception caught when trying to listen on port "
//                        + portNumber + " or listening for a connection");
//                System.out.println(e.getMessage());
//            }
//        }
//    };

    private class MyConnection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private Socket clientSocket;

        public MyConnection(Socket clientSocket) {
            this.clientSocket = clientSocket;

            try {
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                System.out.println("Exception caught when trying to listen on port "
                        + portNumber + " or listening for a connection");
                System.out.println(e.getMessage());
            }
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        out.println(inputLine);
                        synchronized (connections) {
                            Iterator<MyConnection> iter = connections.iterator();
                            while (iter.hasNext()) {
                                ((MyConnection) iter.next()).out.println(inputLine);
                            }
                        }

                    }
                } catch (IOException e) {
                    System.out.println("Exception caught when trying to listen on port "
                            + portNumber + " or listening for a connection");
                    System.out.println(e.getMessage());
                }
            }

            public void close() {
                try {
                    in.close();
                    out.close();
                    serverSocket.close();

                    connections.remove(this);
                    if (connections.size() == 0) {
                        Server.this.closeAll();
                        System.exit(0);
                    }
                } catch (Exception e) {
                    System.err.println("Threads didn't close.");
                }
            }

        };
        Thread thread = new Thread(runnable);
    }

}