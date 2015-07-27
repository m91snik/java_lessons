package com.makedonsky94.matrix;

import java.util.Arrays;

/**
 * Created by Sasha on 27.07.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Matrix matrix = MatrixReader.getInstance().readMatrix();
        System.out.println(Arrays.deepToString(matrix.getMatrix()));
        Matrix newMatrix = SimpleCalculator.TRANSPOSING.executeAction(matrix);
        System.out.println(Arrays.deepToString(newMatrix.getMatrix()));
    }
}
