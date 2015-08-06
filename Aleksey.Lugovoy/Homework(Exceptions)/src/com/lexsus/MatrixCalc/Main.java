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
        double[][] matrix1 = null;
        double[][] matrix2 = null;

        switch (command)
        {
            case "+":
                System.out.println("Enter first matrix.");
                matrix1 = MatrixInput.GetMatrix();

                System.out.println("Enter second matrix.");
                matrix2 = MatrixInput.GetMatrix();

                result = MatrixOperationType.CONCAT.Calculate(matrix1,matrix2);
                if (result!=null){
                    System.out.println("Result matrix:");
                    System.out.println(MatrixOperationType.toString(result));
                }
                break;
            case "*":
                System.out.println("Enter first matrix.");
                matrix1 = MatrixInput.GetMatrix();

                System.out.println("Enter second matrix.");
                matrix2 = MatrixInput.GetMatrix();

                result = MatrixOperationType.MUL.Calculate(matrix1,matrix2);
                if (result!=null){
                    System.out.println("Result matrix:");
                    System.out.println(MatrixOperationType.toString(result));
                }
                break;
            case "T":
                System.out.println("Enter matrix.");
                matrix1 = MatrixInput.GetMatrix();
                result = MatrixOperationType.TRASPARENT.Calculate(matrix1);
                if (result!=null){
                    System.out.println("Result matrix:");
                    System.out.println(MatrixOperationType.toString(result));
                }
                break;
        }
    }
}
