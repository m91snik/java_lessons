package com.jay.lesson2.homeTask;

import java.io.IOException;
import java.util.Scanner;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 * Created by Julia Lisova
 * Created on 17.07.2015.
 */
public class Calculator {

    public static void main(String[] args) throws IOException {

        Double result = 0.0;

        System.out.println("Hi! This is the best calculator ever. Please, input first argument: ");

        Scanner firstData = new Scanner(System.in);
        String firstArg = firstData.nextLine();
        //if (firstArg.matches("[0-9]+[-+*/]+[0-9]")){
        if (!firstArg.matches("[0-9.]+")) {
            System.out.println("Format is incorrect!");
            return;

        }

        System.out.println("Now input command (*,/,+,% or -): ");
        Scanner commandArg = new Scanner(System.in);
        String command = commandArg.nextLine();
        if (!command.matches("[-+*%/]{1}")) {
            System.out.println("Format is incorrect!");
            return;
        }

        System.out.println("Great! It's time for last argument: ");
        Scanner secondData = new Scanner(System.in);
        String secondArg = secondData.nextLine();
        if (!secondArg.matches("[0-9.]+")) {
            System.out.println("Format is incorrect!");
            return;
        }

        if (command.equals("/")) {
            if (secondArg.equals("0")) {
                System.out.println("You can't divide for 0!");
                return;
            }
            result = Double.parseDouble(firstArg) / Double.parseDouble(secondArg);

        }

        if (command.equals("*")) {
            result = Double.parseDouble(firstArg) * Double.parseDouble(secondArg);

        }

        if (command.equals("+")) {
            result = Double.parseDouble(firstArg) + Double.parseDouble(secondArg);

        }

        if (command.equals("-")) {
            result = Double.parseDouble(firstArg) - Double.parseDouble(secondArg);

        }

        if (command.equals("%")) {
            result = Double.parseDouble(firstArg) % Double.parseDouble(secondArg);

        }

        System.out.println("Result is: " + result);

    }
}
