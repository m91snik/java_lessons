import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by HP on 25.07.2015.
 */
public class Operation {


    public void multiply (Matrix matrix1, Matrix matrix2) {     int [][] result  = new int [matrix1.stroka][matrix1.stolbec];
        if (matrix1.stolbec == matrix2.stroka ) {

            System.out.println("Multiply the two matrices");
            for (int f = 0; f < matrix2.stolbec ; f++) {
                for (int j = 0; j <matrix1.stroka ; j++) {
                    for (int i = 0; i <matrix1.stolbec ; i++) {
                        result[j][f] = result[j][f] + matrix1.mas[j][i]*matrix2.mas[i][f];

                    }

                }

            }   for (int j = 0; j <matrix1.stroka; j++) {
                    for (int f = 0; f <matrix2.stolbec ; f++) {
                        System.out.print(result[j][f] + "\t");
                    }
                    System.out.println();
            }

        } else {
            System.out.println("you cannot multiply matrices. the number of columns " +
                    "of 1st matrix is not equal to the number of rows of 2nd matrix.");
        }
    }


    public void substraction(Matrix matrix1, Matrix matrix2) {
        int[][] result = new int[matrix1.stroka][matrix1.stolbec];

        if (matrix1.stroka == matrix2.stroka && matrix1.stolbec == matrix1.stolbec) {
            System.out.println("Substract the two matrices");
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = matrix1.mas[i][j] + (-1) * matrix2.mas[i][j];

                    System.out.print(result[i][j] + "\t");
                }

                System.out.println();


            }

        } else {
            System.out.println("you cannot substract matrices of different dimensions");
        }
    }



    public void transpose(Matrix matrix1) {
        System.out.println("Transponirovanie");
        int[][] result = new int[matrix1.stolbec][matrix1.stroka];


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = matrix1.mas[j][i];
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void plus(Matrix matrix1, Matrix matrix2) {
        int[][] result = new int[matrix1.stroka][matrix1.stolbec];

        if (matrix1.stroka == matrix2.stroka && matrix1.stolbec == matrix2.stolbec) {
            System.out.println("Add the two matrices");
            for (int i = 0; i < matrix1.stroka; i++) {
                for (int j = 0; j < matrix1.stolbec; j++) {
                    result[i][j] = matrix1.mas[i][j] + matrix2.mas[i][j];

                    System.out.print(result[i][j] + "\t");
                }

                System.out.println();


            }
        } else {
            System.out.println("you cannot add matrices of different dimensions");
        }
    }
}

