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

    public Client() {
//        toDo Illegal Argument Exception
        System.out.println("Enter host name (ip or www)  169.254.144.144 :");
        hostName = Client.varGetter();

        System.out.println("portNumber:");
        portNumber = Integer.parseInt(Client.varGetter());

        System.out.println("Enter your input port (Integer):");
        inputClientPort = Integer.parseInt(Client.varGetter());
        System.out.println();

        System.out.println("Enter messages:");
        ClientIn clientIn = new ClientIn(hostName, portNumber, inputClientPort);
        new Thread(clientIn).start();

        ClientOut clientOut = new ClientOut(inputClientPort);
        new Thread(clientOut).start();
    }

    @NotNull
    public static String varGetter() {
        Scanner inputClientPortScanner = new Scanner(System.in);
        return inputClientPortScanner.nextLine().toString();
    }
}
