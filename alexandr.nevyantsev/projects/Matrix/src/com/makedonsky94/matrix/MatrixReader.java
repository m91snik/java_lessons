package com.makedonsky94.matrix;


import java.util.Scanner;

/**
 * Created by Sasha on 27.07.2015.
 */
public class MatrixReader {
    public MatrixReader() {

    }

    static MatrixReader matrixReader;

    public static MatrixReader getInstance() {
        if(matrixReader == null) {
            matrixReader = new MatrixReader();
        }
        return matrixReader;
    }

    /**
     * This method read Matrix from System.in stream
     *
     * @return the read matrix
     */
    public Matrix readMatrix() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input size of matrix (NxN), example: 5x5");
        String size = scanner.next("^\\d+[xXı’]\\d+$");

        if(size == null || size.equals("")) {
            throw new Exception("Incorrect input");
        }

        String[] x = size.split("[xXı’]");
        int ySize = Integer.parseInt(x[0]);
        int xSize =  Integer.parseInt(x[1]);

        if(xSize * ySize == 0) {
            throw new Exception("Parameters can not be 0");
        }

        double[][] matrix = new double[ySize][xSize];
        for(int i = 0; i < ySize; i++) {
            System.out.format("Input data for row %s \n", i+1);
            for(int j = 0; j < xSize; j++) {
                System.out.format("Input data for column %s \n", j+1);
                matrix[i][j] = scanner.nextDouble();
            }
        }

        Matrix matrixObject = new Matrix();
        matrixObject.setMatrix(matrix);
        return matrixObject;
    }

}
