package com.lexsus.MatrixCalc;

import java.util.InputMismatchException;
import java.util.Scanner;

public  class MatrixInput {
    static double [][]GetMatrix(){
        double mas[][]=null;
        try {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row count matrix:");
        int m = scanner.nextInt();

        System.out.println("Enter column count matrix:");
        int n = scanner.nextInt();

        System.out.println("Enter   matrix elements (from whitespace):");
        mas = new double[m][n];
        int i=0;

            while (i < m && scanner.hasNext()) {
                int j = 0;
                while (j < n && scanner.hasNext()) {
                    mas[i][j++] = scanner.nextDouble();
                }
                i++;
            }
        }
        catch (NumberFormatException | InputMismatchException ex)
        {
            throw new MatrixInputException("was an error while entering the number",ex);
        }
        return mas;
    }
}
