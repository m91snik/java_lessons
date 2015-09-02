package com.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * From client to server
 */
//TODO: rename file to ClientIn. it's clientIn right now
public class ClientIn implements Runnable {
    String hostName;
    int portNumber;
    int inputClientPort;

    public ClientIn(String hostName, int portNumber, int inputClientPort) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.inputClientPort = inputClientPort;
    }

    //TODO: do not use synchronized here. it makes no sense
    @Override
    public synchronized void run() {
        while (true) {
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));

            try (
                    Socket echoSocket = new Socket(hostName, portNumber);
                    ObjectOutputStream out =
                            new ObjectOutputStream(echoSocket.getOutputStream());
            ) {
                String userInput;
                //TODO: use constant.equals(variable) to prevent NPE
                if ((userInput = stdIn.readLine()).equalsIgnoreCase("exit")) {
//toDo good system exit
//                System.exit(1);
                    break;
                }
                MessageFromClientToServer messageFromClientToServer =
                        new MessageFromClientToServer(inputClientPort, userInput);
                out.writeObject(messageFromClientToServer);
                echoSocket.close();
            } catch (UnknownHostException e) {
                System.err.println("Don't know about host " + hostName);
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Couldn't get I/O for the connection to " +
                        hostName);
                e.printStackTrace();
            }

        }
    }

}
