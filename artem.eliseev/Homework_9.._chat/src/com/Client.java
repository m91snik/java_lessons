package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Anry on 15.08.2015.
 */
public class Client {
    Client(String hostName, String portNumber) {
    }

    public static void main(String... args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java oldNotInWork.EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try (
                Socket echoSocket = new Socket(hostName, portNumber);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
                BufferedReader in =
                        new BufferedReader(
                                new InputStreamReader(echoSocket.getInputStream()));
                BufferedReader stdIn =
                        new BufferedReader(
                                new InputStreamReader(System.in))
        ) {
            String userInput;
            System.out.println("Client works!");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (true) {
                                System.out.println(/*Server.counterWithSync() + */" echo: " + in.readLine());
                            }
                        } catch (UnknownHostException e) {
                            System.err.println("Don't know about host " + hostName);
                            System.exit(1);
                        } catch (IOException e) {
                            System.err.println("Couldn't get I/O for the connection to " +
                                    hostName);
                            System.exit(1);
                        }
                    }
                };
                Thread thread = new Thread(runnable);
                thread.start();
//                System.out.println(oldNotInWork.EchoServer.counterWithSync() + " echo: " + in.readLine());
            }
        }

//        } catch (UnknownHostException e) {
//            System.err.println("Don't know about host " + hostName);
//            System.exit(1);
//        } catch (IOException e) {
//            System.err.println("Couldn't get I/O for the connection to " +
//                    hostName);
//            System.exit(1);
//        }

    }
}
