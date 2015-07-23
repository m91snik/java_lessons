package com.kamyshovcorp;

import java.util.Random;

/**
 * Created by kamyshov.sergey on 22.07.15.
 */
public class MatrixInfo {

    private int min = 0;
    private int max = 9;

    private int rows = 3;
    private int cols = 4;

    private int[][] matrix;

    MatrixInfo() {
        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = randInt(min, max);
            }
        }
    }

    public MatrixInfo(int[][] matrix) {
        this.matrix = matrix;
    }

    public int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
