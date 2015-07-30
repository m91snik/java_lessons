package com.stanislav.matrixcalc;

/**
 * Created by stanislav on 27.07.15.
 */
public class Operation {

    Input input = new Input();
    private double[][] result;

    public double[][] transparency(double[][] matrix) {

        result = new double[matrix.length][matrix[0].length];

        for (int j = 0; j < result.length; j++) {
            for (int i = 0; i < result[j].length; i++) {
                result[i][j] = matrix[j][i];
            }
        }

        return result;
    }

    public double[][] twoMatrixOperations(String type, double[][] matrix1, double[][] matrix2) {

        result = new double[matrix1.length][matrix1[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                switch (type) {
                    case "+" : result[i][j] = matrix1[i][j] + matrix2[i][j]; break;
                    case "-" : result[i][j] = matrix1[i][j] - matrix2[i][j]; break;
                    case "*" : result[i][j] = matrix1[i][j] * matrix2[i][j]; break;
                }
            }
        }

        return result;
    }

    public double[][] matrixAndDigitOperations(String type, double[][] matrix) {
        System.out.print("Введите число: ");
        double digit = input.returnDouble();

        result = new double[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {

                switch (type) {
                    case "+":
                        result[i][j] = matrix[i][j] + digit;
                        break;
                    case "-":
                        result[i][j] = matrix[i][j] - digit;
                        break;
                    case "*":
                        result[i][j] = matrix[i][j] * digit;
                        break;
                }
            }
        }

        return result;
    }
}
