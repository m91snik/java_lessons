package com.petrsulilo.matrix;

import java.util.Scanner;

/**
 * Created by Petr on 23.07.2015.
 */
public class matrix {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        int i = 0;
        int j = 0;
        double[][] matrix = new double[i][j];
        //transposeTest();
        //additionTest();
        outWhile:
        while (true) {
            switch (menu()) {
                case Multiplication:
                    System.out.println(Operations.Multiplication + " - нет реализации.");
                    break;
                case Division:
                    System.out.println(Operations.Division + " - нет реализации.");
                    break;
                case Addition:
                    additionTest();
                    break;
                case Subtraction:
                    subtractionTest();
                    break;
                case Wrong:
                    System.out.println(Operations.Wrong);
                    break outWhile;
            }
        }
    }
    public static Operations menu()
    {
        Operations[] oper = Operations.values();
        OperationsText[] operText = OperationsText.values();

        for (int i=0; i < operText.length; i++)
        {
            System.out.println(i+1 + ". " + operText[i].getName());
        }
        if (!scan.hasNextInt()) {
            return Operations.Wrong;
        }
        int comand = scan.nextInt();

        if (comand > 0 && comand < oper.length)
        {
            return oper[comand-1];
        }
        else {
            return Operations.Wrong;
        }
    }

    public static void matrix()
    {

    }
    public static double[][] transpose(double[][] matrix)
    {
        double[][] returnMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++ )
        {
            for (int j = 0; j < matrix[i].length; j++ )
            {
                returnMatrix[j][i] = matrix[i][j];
                returnMatrix[j][i] = matrix[i][j];
            }
        }
        return returnMatrix;
    }
    public static int transposeTest()
    {
        double[][] testIn = { {1 , 2},
                              {3 , 4},
                              {5 , 6} };
        System.out.println("Матрица:");
        printMatrix(testIn);
        System.out.println("Транспонированная матрица:");
        printMatrix(transpose(testIn));

        return 0;
    }
    public static double[][] addition(double[][] matrix1, double[][] matrix2)
    {
        double[][] returnMatrix = new double[maxHeigthMatrix(matrix1,matrix2)][maxWidthMatrix(matrix1,matrix2)];
            for (int i = 0; i < returnMatrix.length; i++) {
                for (int j = 0; j < returnMatrix[i].length; j++) {
                    if ((matrix1.length-1 < i) || (matrix1[0].length-1 < j))
                    {
                        returnMatrix[i][j] = 0 + matrix2[i][j];
                    }
                    else if ((matrix2.length-1 < i) || (matrix2[0].length-1 < j))
                    {
                        returnMatrix[i][j] = matrix1[i][j] + 0;
                    }
                    else
                    {
                        returnMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                    }
                }
            }
        return returnMatrix;
    }
    public static int maxWidthMatrix(double[][] matrix1, double[][] matrix2)
    {
        if (matrix1[0].length > matrix2[0].length)
        {
            return matrix1[0].length;
        }
        else
        {
            return matrix2[0].length;
        }
    }
    public static int maxHeigthMatrix(double[][] matrix1, double[][] matrix2)
    {
        if (matrix1.length > matrix2.length)
        {
            return matrix1.length;
        }
        else
        {
            return matrix2.length;
        }
    }
    public static int additionTest()
    {
        double[][] testIn1 = { {1 , 2},
                              {3 , 4},
                              {5 , 6} };
        double[][] testIn2 = {  {2 , 3},
                               {4 , 5},
                               {6 , 7} };
        double[][] testIn3 = {  {3 , 4 , 5},
                               {6 , 7 , 8},
                               {9 , 8 , 9} };
        System.out.println("Матрица 1:");
        printMatrix(testIn1);
        System.out.println("Матрица 2:");
        printMatrix(testIn2);
        System.out.println("Матрица 3:");
        printMatrix(testIn3);

        //System.out.println("Сумма 1 и 2 матриц:");
        //printMatrix(addition(testIn1, testIn2));
        System.out.println("Сумма 1 и 3 матриц:");
        printMatrix(addition(testIn1, testIn3));

        return 1;
    }
    public static double[][] subtraction(double[][] matrix1, double[][] matrix2)
    {
        double[][] returnMatrix = new double[maxHeigthMatrix(matrix1,matrix2)][maxWidthMatrix(matrix1,matrix2)];
        for (int i = 0; i < returnMatrix.length; i++) {
            for (int j = 0; j < returnMatrix[i].length; j++) {
                if ((matrix1.length-1 < i) || (matrix1[0].length-1 < j))
                {
                    returnMatrix[i][j] = 0 - matrix2[i][j];
                }
                else if ((matrix2.length-1 < i) || (matrix2[0].length-1 < j))
                {
                    returnMatrix[i][j] = matrix1[i][j] - 0;
                }
                else
                {
                    returnMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
                }
            }
        }
        return returnMatrix;
    }
    public static int subtractionTest()
    {
        double[][] testIn1 = { {1 , 2},
                {3 , 4},
                {5 , 6} };
        double[][] testIn2 = {  {2 , 3},
                {4 , 5},
                {6 , 7} };
        double[][] testIn3 = {  {3 , 4 , 5},
                {6 , 7 , 8},
                {9 , 8 , 9} };
        System.out.println("Матрица 1:");
        printMatrix(testIn1);
        System.out.println("Матрица 2:");
        printMatrix(testIn2);
        System.out.println("Матрица 3:");
        printMatrix(testIn3);

        System.out.println("Вычитание 1 из 3 матрицы:");
        printMatrix(subtraction(testIn3, testIn1));

        return 1;
    }
    public static void printMatrix(double[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++ )
        {
            for (int j = 0; j < matrix[i].length; j++ )
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

}
