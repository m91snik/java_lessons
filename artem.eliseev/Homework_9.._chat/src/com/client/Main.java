package com.client;

import java.util.Scanner;

/**
 * Created by Anry on 22.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        Scanner settingsScanner = new Scanner(System.in);

//        toDo Illegal Argument Exception
        System.out.println("Enter host name (ip or www)  169.254.144.144 :");
        String hostName = settingsScanner.nextLine();

        System.out.println("portNumber:");
        int portNumber = settingsScanner.nextInt();

        System.out.println("Enter your input port (Integer):");
        int inputClientPort = settingsScanner.nextInt();

        System.out.println();
        System.out.println("Enter messages:");
        Client client = new Client(hostName, portNumber, inputClientPort);
    }

}
