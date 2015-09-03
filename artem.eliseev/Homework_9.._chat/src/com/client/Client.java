package com.client;

import com.sun.istack.internal.NotNull;

import java.util.Scanner;

/**
 * Created by Anry on 22.08.2015.
 */
public class Client {
    String hostName;
    int portNumber;
    int inputClientPort;


    public Client(String hostName, int portNumber, int inputClientPort) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        this.inputClientPort = inputClientPort;

        //TO DO: it's better to create one Scanner for System.in and use nextLine to read each line: done
        //TO DO: it makes sense to extract reading settings from System.in into Main class
        // and pass already read settings as constructor argument to Client: Done

        ClientIn clientIn = new ClientIn(hostName, portNumber, inputClientPort);
        new Thread(clientIn).start();

        ClientOut clientOut = new ClientOut(inputClientPort);
        new Thread(clientOut).start();
    }
}
