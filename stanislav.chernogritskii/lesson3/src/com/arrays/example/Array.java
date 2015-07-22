package com.arrays.example;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by stanislav on 21.07.15.
 */
public class Array {

    public static void main(String[] args) {

        int[] array1 = new int[1];
        int[] array2 = {1,2,3};

        int a = 1;

        array1[0] = a;

        for (int i = 0; i < 10;) {
            i += 2;
        }

//        Scanner scanner;
//
//        for (scanner = new Scanner(System.in); scanner.hasNext();) {
//            scanner.next();
//        }

        int[][] mas = new int[10][5];

        mainFor:
        for (int i = 0; i < mas.length;i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = i + j;

                if ((i+j) % 2 == 0) {
                    break;
                }

                if ((i+j) == 10) {
                    break mainFor;
                }
            }
        }

        System.out.println(Arrays.deepToString(mas));

        System.out.println(CardType.DP.calculateTaxAmount(100.0));
    }
}
