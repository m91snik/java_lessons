package com.kamyshovcorp;

/**
 * Created by kamyshov.sergey on 22.07.15.
 */
public class MatrixHandler {

    public static void print(MatrixInfo matrixInfo) {
        int[][] matrix = matrixInfo.getMatrix();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static MatrixInfo add(MatrixInfo matrixInfoOne, MatrixInfo matrixInfoTwo) {
        int[][] matrixOne = matrixInfoOne.getMatrix();
        int[][] matrixTwo = matrixInfoTwo.getMatrix();
        int[][] resultMatrix = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] + matrixTwo[i][j];
            }
        }
        return new MatrixInfo(resultMatrix);
    }

    public static MatrixInfo subtract(MatrixInfo matrixInfoOne, MatrixInfo matrixInfoTwo) {
        int[][] matrixOne = matrixInfoOne.getMatrix();
        int[][] matrixTwo = matrixInfoTwo.getMatrix();
        int[][] resultMatrix = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] - matrixTwo[i][j];
            }
        }
        return new MatrixInfo(resultMatrix);
    }

    public static MatrixInfo multiply(MatrixInfo matrixInfoOne, MatrixInfo matrixInfoTwo) {
        int[][] matrixOne = matrixInfoOne.getMatrix();
        int[][] matrixTwo = matrixInfoTwo.getMatrix();
        int[][] resultMatrix = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixOne[i].length; j++) {
                resultMatrix[i][j] = matrixOne[i][j] * matrixTwo[i][j];
            }
        }
        return new MatrixInfo(resultMatrix);
    }

    public static MatrixInfo divide(MatrixInfo matrixInfoOne, MatrixInfo matrixInfoTwo) {
        int[][] matrixOne = matrixInfoOne.getMatrix();
        int[][] matrixTwo = matrixInfoTwo.getMatrix();
        int[][] resultMatrix = new int[matrixOne.length][matrixOne[0].length];

        for (int i = 0; i < matrixOne.length; i++) {
            next:
            for (int j = 0; j < matrixOne[i].length; j++) {
                if (matrixTwo[i][j] != 0) {
                    resultMatrix[i][j] = matrixOne[i][j] / matrixTwo[i][j];
                } else {
                    continue next;
                }
            }
        }
        return new MatrixInfo(resultMatrix);
    }

}
