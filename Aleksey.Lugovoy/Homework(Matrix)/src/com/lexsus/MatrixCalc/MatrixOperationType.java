package com.lexsus.MatrixCalc;

import java.util.Scanner;

/**
 * Created by LugovoyAV on 22.07.2015.
 */
public enum MatrixOperationType {
    CONCAT{
        @Override
        public double [][] Calculate() {
            System.out.println("Enter first matrix.");
            double[][] matrix1 = GetMatrix();

            System.out.println("Enter second matrix.");
            double[][] matrix2 = GetMatrix();

            if ((matrix1.length!=matrix2.length) || (matrix1[0].length!=matrix2[0].length)){
                System.out.println("The size of array must be equal ");
                return null;
            }
            newmatrix = new double[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    newmatrix[i][j] = matrix1[i][j]+matrix2[i][j];
                }
            }
            return newmatrix;
        }
    },
    MUL{
        @Override
        public double[][] Calculate() {
            System.out.println("Enter first matrix.");
            double[][] matrix1 = GetMatrix();

            System.out.println("Enter second matrix.");
            double[][] matrix2 = GetMatrix();

            if (matrix2.length!=matrix1[0].length){
                System.out.println("The size of array must be equal ");
                return null;
            }
            newmatrix = new double[matrix1.length][matrix2[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    double sum =0;
                    for (int k = 0; k < matrix1[0].length; k++) {
                        sum+=matrix1[i][k]*matrix2[k][j];
                    }
                    newmatrix[i][j] = sum;
                }
            }
            return newmatrix;
        }
    },
    TRASPARENT{
        @Override
        public double [][] Calculate() {
            System.out.println("Enter first matrix.");
            double[][] matrix1 = GetMatrix();

            newmatrix = new double[matrix1.length][matrix1[0].length];
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    newmatrix[i][j] = matrix1[j][i];
                    newmatrix[j][i] = matrix1[i][j];
                }
            }
            return newmatrix;
        }
    };


    public double[][] Calculate() {
        return null;
    }
    protected double[][] GetMatrix(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row count matrix:");
        int m = scanner.nextInt();

        System.out.println("Enter column count matrix:");
        int n = scanner.nextInt();

        System.out.println("Enter   matrix elements (from whitespace):");
        double mas[][] = new double[m][n];
        int i=0;
        while (i<m && scanner.hasNext()){
            int j=0;
            while (j<n && scanner.hasNext()) {
                mas[i][j++] = scanner.nextDouble();
            }
            i++;
        }
        return mas;
    }
    double newmatrix[][]=null;

    @Override
    public String toString() {

        if (newmatrix==null)
            return super.toString();
        String str = new String();
        for (int i = 0; i < newmatrix.length; i++) {
            for (int j = 0; j < newmatrix[0].length; j++) {
                str+=newmatrix[i][j];
                str+="\t";
            }
            str+="\n";
        }
        return str;
    }
}
