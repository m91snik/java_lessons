package com.makedonsky94.matrix;

/**
 * Created by Sasha on 27.07.2015.
 */
public class Matrix {
    private double[][] matrix;
    public Matrix() {

    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public int getColumnCount() {
        if(matrix != null) {
            return matrix[0].length;
        }
        return 0;
    }

    public int getRowCount() {
        if(matrix != null) {
            return matrix.length;
        }
        return 0;
    }
}
