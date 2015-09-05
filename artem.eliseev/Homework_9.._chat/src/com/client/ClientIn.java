package com.client;

import com.MessageFromClientToServer;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * From client to server
 */
//TO DO: rename file to com.client.ClientIn. it's clientIn right now: Done
public class ClientIn implements Runnable {
    String hostName;
    int portNumber;
    int inputClientPort;

    public ClientIn(String hostName, int portNumber, int inputClientPort) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.inputClientPort = inputClientPort;
    }

    //TO DO: do not use synchronized here. it makes no sense: Done
    @Override
    public void run() {
        while (true) {

            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            String userInput;
            Constants constants=new Constants();
            try {
                //TO DO: use constant.equals(variable) to prevent NPE: done
                if (constants.EXIT.equalsIgnoreCase(userInput = stdIn.readLine())){
//                  toDo good system exit
//                  System.exit(1);
                    break;
                }
            } catch (IOException e) {
                //TODO: do not dublicate errors in console. e.printStackTrace() is enought
                System.err.println("IOException in stdIn.readLine System.in");
                e.printStackTrace();
                userInput = "IO error in client";
            }
            MessageFromClientToServer messageFromClientToServer =
                    new MessageFromClientToServer(inputClientPort, userInput);
            try (
                    Socket echoSocket = new Socket(hostName, portNumber);
                    ObjectOutputStream out =
                            new ObjectOutputStream(echoSocket.getOutputStream())
            ) {
                out.writeObject(messageFromClientToServer);
            } catch (UnknownHostException e) {
                //TODO: do not dublicate errors in console. e.printStackTrace() is enought
                System.err.println("Don't know about host " + hostName);
                e.printStackTrace();
            } catch (IOException e) {
                //TODO: do not dublicate errors in console. e.printStackTrace() is enought
                System.err.println("Couldn't get I/O for the connection to " +
                        hostName);
                e.printStackTrace();
            }
        }
    }

}
