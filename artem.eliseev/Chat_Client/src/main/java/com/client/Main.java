package com.client;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * Created by Anry on 22.08.2015.
 */
@Component
public class Main {
    public static void main(String[] args) {
        Scanner settingsScanner = new Scanner(System.in);

//        toDo Illegal Argument Exception
        System.out.println("Enter host name (ip or www) (169.254.144.144 in default):");
        String hostName = settingsScanner.nextLine();

        System.out.println("portNumber (1025 in default):");
        int portNumber = settingsScanner.nextInt();

        System.out.println("Enter your input port (Integer):");
        int inputClientPort = settingsScanner.nextInt();

        System.out.println();
        System.out.println("Enter messages:");
        Client client = new Client(hostName, portNumber, inputClientPort);
    }

}
