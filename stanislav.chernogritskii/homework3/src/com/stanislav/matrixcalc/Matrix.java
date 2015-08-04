package com.stanislav.matrixcalc;

/**
 * Created by stanislav on 28.07.15.
 */
public class Matrix {

    Input input = new Input();

    public double[][] fillMatrix(int cols, int rows) {
        System.out.println("Заполните " + (rows * cols) + " элементов матрицы");

        double[][] filledMatrix = new double[rows][cols];

        for (int i = 0; i < filledMatrix.length; i++) {
            for (int j = 0; j < filledMatrix[i].length; j++) {
                try {
                    filledMatrix[i][j] = input.returnDouble();
                } catch(IllegalArgumentException e) {
                    e.printStackTrace();
                    filledMatrix[i][j] = 1;
                }
            }
        }

        return filledMatrix;
    }

    public void formattedOutput(double[][] resultMatrix) {

        for (int i = 0; i < resultMatrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " | ");
            }
            System.out.println(" ");
        }
    }
}
