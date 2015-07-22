package com.stanislav.matrixcalc;

import java.util.Scanner;

/**
 * Created by stanislav on 22.07.15.
 */

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String exit;

        do {

            System.out.print("Количество столбцов в матрице: ");
            int cols = sc.nextInt();

            System.out.print("Количество строк в матрице: ");
            int rows = sc.nextInt();

            double[][] matrix1 = fillMatrix(cols, rows);
            formattedOutput(matrix1);

            System.out.println("Введите операцию: (+,-,*,Т)");
            String type = sc.next();

            if (type.equals(Operations.PLUS.type)) {
                System.out.println(Operations.PLUS.toString());

                String action = action();

                if (action.equals(Choise.MATRIX.choise)) {
                    double[][] matrix2 = fillMatrix(cols, rows);
                    formattedOutput(matrix2);

                    twoMatrixOperations(Operations.PLUS.type, matrix1, matrix2);
                } else if (action.equals(Choise.DIGIT.choise)) {
                    matrixAndDigitOperations(Operations.PLUS.type, matrix1);
                }
            } else if (type.equals(Operations.MINUS.type)) {
                System.out.println(Operations.MINUS.toString());

                String action = action();

                if (action.equals(Choise.MATRIX.choise)) {
                    double[][] matrix2 = fillMatrix(cols, rows);
                    formattedOutput(matrix2);

                    twoMatrixOperations(Operations.MINUS.type, matrix1, matrix2);
                } else if (action.equals(Choise.DIGIT.choise)) {
                    matrixAndDigitOperations(Operations.MINUS.type, matrix1);
                }
            } else if (type.equals(Operations.MULTI.type)) {
                System.out.println(Operations.MULTI.toString());

                String action = action();

                if (action.equals(Choise.MATRIX.choise)) {
                    double[][] matrix2 = fillMatrix(cols, rows);
                    formattedOutput(matrix2);

                    twoMatrixOperations(Operations.MULTI.type, matrix1, matrix2);
                } else if (action.equals(Choise.DIGIT.choise)) {
                    matrixAndDigitOperations(Operations.MULTI.type, matrix1);
                }
            } else if (type.equals(Operations.TRANSP.type)) {
                System.out.println(Operations.TRANSP.toString());

                double result[][] = new double[cols][rows];

                for (int j = 0; j < matrix1.length; j++) {
                    for (int i = 0; i < matrix1[j].length; i++) {
                        result[i][j] = matrix1[j][i];
                    }
                }

                System.out.println("Результат: ");
                formattedOutput(result);
            }

            System.out.print("Выйти из программы? [y/n] ");
            exit = sc.next();

        } while (!exit.equals("y"));
    }

    public static double[][] fillMatrix(int cols, int rows) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Заполните " + (rows * cols) + " элементов матрицы");

        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }

        return matrix;
    }

    public static void formattedOutput(double matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println(" ");
        }
    }

    public static String action() {
        Scanner sc = new Scanner(System.in);

        System.out.println("[1 - другая матрица, 2 - число]");

        return sc.next();
    }

    public static void twoMatrixOperations(String type, double[][] matrix1, double[][] matrix2) {

        double result[][] = new double[matrix1.length][matrix1[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                switch (type) {
                    case "+" : result[i][j] = matrix1[i][j] + matrix2[i][j]; break;
                    case "-" : result[i][j] = matrix1[i][j] - matrix2[i][j]; break;
                    case "*" : result[i][j] = matrix1[i][j] * matrix2[i][j]; break;
                }
            }
        }

        System.out.println("Результат: ");
        formattedOutput(result);
    }

    public static void matrixAndDigitOperations(String type, double[][] matrix) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите число: ");

        double digit = sc.nextDouble();

        double result[][] = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                switch (type) {
                    case "+" : result[i][j] = matrix[i][j] + digit; break;
                    case "-" : result[i][j] = matrix[i][j] - digit; break;
                    case "*" : result[i][j] = matrix[i][j] * digit; break;
                }
            }
        }

        System.out.println("Результат: ");
        formattedOutput(result);
    }
}
