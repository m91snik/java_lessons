package com; /**
 * Created by Ната и Артем on 22.07.2015.
 */
/**
 * NOT FINISHED
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello.\nThis is matrix calculator. You can calculate 2 dimensional arrays.");
        System.out.println("(ONLY SUM NOW!!!) Enter operation:");                                                                  //get operation
        Scanner scanner_oper = new Scanner(System.in);
        char oper = scanner_oper.next().charAt(0);
        System.out.println("1st Array. Enter row length:");                                                     //get array parameters
        Scanner scanner_k1 = new Scanner(System.in);
        int k1 = scanner_k1.nextInt();
        System.out.println("1st Array. Enter column length:");
        Scanner scanner_p1 = new Scanner(System.in);
        int p1 = scanner_p1.nextInt();
        System.out.println("Enter integer data. Type 'enter' after every variable:");                           //get array data
        int[][] arr1 = new int[k1][p1];
        Scanner scannerArr1 = new Scanner(System.in);
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = scannerArr1.nextInt();
            }
        }
/**
 * 2nd array
 */
        System.out.println("2nd Array. Enter row length:");                                                     //get array parameters
        Scanner scanner_k2 = new Scanner(System.in);
        int k2 = scanner_k2.nextInt();
        System.out.println("2nd Array. Enter column length:");
        Scanner scanner_p2 = new Scanner(System.in);
        int p2 = scanner_p2.nextInt();
        System.out.println("Enter integer data. Type 'enter' after every variable:");                           //get array data
        int[][] arr2 = new int[k2][p2];
        Scanner scannerArr2 = new Scanner(System.in);
        for (int i2 = 0; i2 < arr2.length; i2++) {
            for (int j2 = 0; j2 < arr2[i2].length; j2++) {
                arr2[i2][j2] = scannerArr2.nextInt();
            }
        }

//        System.out.println(Arrays.deepToString(arr1));
        for (int x1 = 0; x1 < k1; x1++) {                                                                       //viewer
            for (int y1 = 0; y1 < p1; y1++) {
                System.out.print(arr1[x1][y1] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        for (int x2 = 0; x2 < k2; x2++) {
            for (int y2 = 0; y2 < p2; y2++) {
                System.out.print(arr2[x2][y2] + "\t");
            }
            System.out.println();
        }
        int kFin = 0, pFin = 0;
        if (k1 >= k2) {
            int kFin = k1;
        } else {
            int kFin = k2;
        }
        if (p1 >= p2) {
            int pFin = p1;
        } else {
            int pFin = p2;
        }

        int[][] arrFin = new int[kFin][pFin];


        switch (oper) {
            case '+':
                for (int iFin = 0; iFin < kFin;iFin++ ) {
                    for (int jFin = 0;jFin<pFin ;pFin++ ) {
                        arrFin [iFin][jFin]

                    }
                }

        }
    }
}