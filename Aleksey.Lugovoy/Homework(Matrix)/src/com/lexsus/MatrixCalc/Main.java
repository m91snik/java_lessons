package com.lexsus.MatrixCalc;

import java.util.Scanner;

/**
 * Created by LugovoyAV on 22.07.2015.
 */
public class Main {
    public static void main(String[] args)
    {

        System.out.println("Enter  matrix operation(+,*,T):");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        if (!command.matches("[+*T]{1}")) {
            System.out.println("Not correct operation!");
            return;
        }

        double result[][]=null;
        switch (command)
        {
            case "+":
                result = MatrixOperationType.CONCAT.Calculate();
                if (result!=null){
                    System.out.println("Result matrix:");
                    System.out.println(MatrixOperationType.CONCAT.toString());
                }
                break;
            case "*":
                result = MatrixOperationType.MUL.Calculate();
                if (result!=null){
                    System.out.println("Result matrix:");
                    System.out.println(MatrixOperationType.MUL.toString());
                }
                break;
            case "T":
                result = MatrixOperationType.TRASPARENT.Calculate();
                if (result!=null){
                    System.out.println("Result matrix:");
                    System.out.println(MatrixOperationType.TRASPARENT.toString());
                }
                break;
        }
    }
}
