package com.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * From client to server
 */
public class ClientIn {
    public static void main(String... args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        String userInput;

        System.out.println("Enter your input port (Integer)");
        Scanner inputClientPortScanner = new Scanner(System.in);
        int inputClientPort = Integer.parseInt(inputClientPortScanner.nextLine());

        while (true) {
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            if (!(userInput = stdIn.readLine()).equalsIgnoreCase("exit")) {
//toDo good system exit
                break;
            }
            try (
                    Socket echoSocket = new Socket(hostName, portNumber);
                    PrintWriter out =
                            new PrintWriter(echoSocket.getOutputStream(), true);
            ) {
                out.println(userInput);
                echoSocket.close();
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " +
                        hostName);
                System.exit(1);
            }

        }
    }
}
