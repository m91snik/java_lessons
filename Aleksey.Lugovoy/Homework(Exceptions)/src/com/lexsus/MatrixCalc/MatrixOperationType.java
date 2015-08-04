package com.lexsus.MatrixCalc;

import java.util.Scanner;

/**
 * Created by LugovoyAV on 22.07.2015.
 */
public enum MatrixOperationType {
    CONCAT{
        @Override
        public double [][] Calculate(double[][]... mas) {
            try {


                double[][] matrix1 = mas[0];
                double[][] matrix2 = mas[1];
                if ((matrix1.length != matrix2.length) || (matrix1[0].length != matrix2[0].length)) {
                    System.out.println("The size of array must be equal ");
                    return null;
                }
                double[][] newmatrix = new double[matrix1.length][matrix1[0].length];
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[0].length; j++) {
                        newmatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
                return newmatrix;
            }
            catch (Exception ex){
                throw new MatrixInputException("The parameter in method toString() can be set to null", ex);
            }
        }
    },
    MUL{
        @Override
        public double[][] Calculate(double[][]... mas) {
            try {
                double[][] matrix1 = mas[0];
                double[][] matrix2 = mas[1];
                if (matrix2.length != matrix1[0].length) {
                    System.out.println("The size of array must be equal ");
                    return null;
                }
                double[][] newmatrix = new double[matrix1.length][matrix2[0].length];
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix2[0].length; j++) {
                        double sum = 0;
                        for (int k = 0; k < matrix1[0].length; k++) {
                            sum += matrix1[i][k] * matrix2[k][j];
                        }
                        newmatrix[i][j] = sum;
                    }
                }

                return newmatrix;
            }
            catch (Exception ex){
                throw new MatrixInputException("The parameter in method toString() can be set to null", ex);
            }
        }
    },
    TRASPARENT{
        @Override
        public double [][] Calculate(double[][]... mas) {
           try {
               double[][] matrix1 = mas[0];
               double[][] newmatrix = new double[matrix1.length][matrix1[0].length];
               for (int i = 0; i < matrix1.length; i++) {
                   for (int j = 0; j < matrix1[0].length; j++) {
                       newmatrix[i][j] = matrix1[j][i];
                       newmatrix[j][i] = matrix1[i][j];
                   }
               }
               return newmatrix;
           }
           catch (Exception ex){
                throw new MatrixInputException("The parameter in method toString() can be set to null", ex);
            }
        }
    };
    public double[][] Calculate(double[][]... mas) {
        return null;
    }
    static public String toString(double [][] matrix) {

       try {
           String str = new String();

           for (int i = 0; i < matrix.length; i++) {
               for (int j = 0; j < matrix[0].length; j++) {
                   str += matrix[i][j];
                   str += "\t";
               }
               str += "\n";
           }
           return str;
       }
       catch (NullPointerException ex)
       {
            throw new MatrixInputException("The parameter in method toString() can be set to null", ex);
       }
    }
}
