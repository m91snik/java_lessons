package com.jay.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 * Created by Julia Lisova
 * Created on 23.07.2015.
 */
public class ArrayCalculations {

    public static void main(String[] args) {

        System.out.println("Hi! We'll calculate arrays. Input data for first array. Input number of rows and columns. Divide by space: ");

        Scanner data = new Scanner(System.in);
        int rowNum1 = data.nextInt();
        int colNum1 = data.nextInt();
        int[][] arr1 = new int[rowNum1][colNum1];


        for (int i = 0; i < rowNum1; i++) {

            System.out.println("Input " + i + " array's row. Here is should be " + colNum1 + " elements, divided by spaces: ");
            data = new Scanner(System.in);
            for (int j = 0; j < colNum1; j++) {
                arr1[i][j] = data.nextInt();
            }

            System.out.println(Arrays.deepToString(arr1));

        }

        System.out.println("Great! Here is yor first array. Now chose command (ADD - add, SUB - subtract, MULT - multiply, TRANSP - )");
        data = new Scanner(System.in);
        String command = data.nextLine();

        if ((CommandTypes.ADD.toString()).equals(command) || CommandTypes.SUB.toString().equals(command)) {
            System.out.println("Input data for second array. It should have same number for row and count. In this case row count: " + rowNum1 + ", column count: " + colNum1 + ".");
            int rowNum2 = rowNum1;
            int colNum2 = colNum1;
            int[][] arr2 = new int[rowNum2][colNum2];

            for (int i = 0; i < rowNum2; i++) {

                System.out.println("Input " + i + " array's row. Here is should be " + colNum2 + " elements, divided by spaces: ");
                data = new Scanner(System.in);
                for (int j = 0; j < colNum1; j++) {
                    arr2[i][j] = data.nextInt();
                }

                System.out.println(Arrays.deepToString(arr2));

            }
            int[][] result = new int[rowNum1][colNum1];
            if (CommandTypes.ADD.toString().equals(command)) {
                for (int i = 0; i < rowNum1; i++) {
                    for (int j = 0; j < colNum1; j++) {
                        result[i][j] = arr1[i][j] + arr2[i][j];


                    }

                }

            }

            if (CommandTypes.SUB.toString().equals(command)) {
                for (int i = 0; i < rowNum1; i++) {
                    for (int j = 0; j < colNum1; j++) {
                        result[i][j] = arr1[i][j] - arr2[i][j];


                    }

                }

            }
            System.out.println("Result is: \n" + Arrays.deepToString(result));


        }
    }
}
