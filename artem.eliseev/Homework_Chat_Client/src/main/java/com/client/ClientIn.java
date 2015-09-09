package com.client;

import com.MessageFromClientToServer;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * From client to server
 */
@Component
public class ClientIn implements Runnable {
    String hostName;
    int portNumber;
    int inputClientPort;

    public ClientIn(String hostName, int portNumber, int inputClientPort) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.inputClientPort = inputClientPort;
    }

    @Override
    public void run() {
        while (true) {
            BufferedReader stdIn =
                    new BufferedReader(
                            new InputStreamReader(System.in));
            String userInput;
            try {
                if (Constants.EXIT.equalsIgnoreCase(userInput = stdIn.readLine())) {
//                  toDo good system exit
                  System.exit(1);
                }
            } catch (IOException e) {
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
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
