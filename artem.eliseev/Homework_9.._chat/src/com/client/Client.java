package com.client;

import java.util.Scanner;

/**
 * Created by Anry on 22.08.2015.
 */
public class Client {
    String hostName;
    int portNumber;
    int inputClientPort;

    public Client() {
//        toDo Illegal Argument Exception
            System.out.println("Enter host name (ip or www):");
            hostName = Client.varGetter();

            System.out.println("portNumber:");
            portNumber = Integer.parseInt(Client.varGetter());

            System.out.println("Enter your input port (Integer):");
            inputClientPort = Integer.parseInt(Client.varGetter());

            ClientIn clientIn = new ClientIn(hostName, portNumber, inputClientPort);
            new Thread(clientIn).start();

            ClientOut clientOut = new ClientOut(inputClientPort);
            new Thread(clientOut).start();
    }

    public static String varGetter() {
        Scanner inputClientPortScanner = new Scanner(System.in);
        return inputClientPortScanner.nextLine().toString();
    }
}
