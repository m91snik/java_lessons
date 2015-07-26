package com; /**
 * Created by Ната и Артем on 23.07.2015.
 * <p>
 * Все продолжается.
 * <p>
 * Это попытка сделать упражнение (операцию) для неограниченного числа 2 мерных матриц. Все уперлось в то, что размеры основного
 * хранящего массива нужно задавать до циклов. Это возможно, но код разрастется и на выполнение упражнения не хватит времени.
 * Было потрачено около 3х часов, чтож, теперь это опыт.
 */

import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String... args) {
        System.out.println("Hello.\nThis is matrix calculator. You can calculate 2 dimensional arrays. Max row and column number - 1000.");
        System.out.println("Enter number of arrays:");                                                          //get number of arrays
        Scanner scanner_quantity = new Scanner(System.in);
        int quantity = scanner_quantity.nextInt();
        System.out.println("Enter operation (+, -, /, *) :");                                                    //get operation
        Scanner scanner_oper = new Scanner(System.in);
        char oper = '+';
        try {
            oper = (char) System.in.read();
        } catch (IOException e) {
            System.out.println("Input Error. Enter operation (+, -, /, *, 't' for transpose) :");
        }
        int[][][] arr = new int[1000][1000][quantity];
        int kMax = 0, pMax = 0;

        for (int a = 0; a < quantity; a++) {
            System.out.println((a + 1) + " Array. Enter row length:");                                           //get array parameters
            Scanner scanner_k = new Scanner(System.in);
            int k = scanner_k.nextInt();
            if (k > kMax) {                                                                                      //return to viewer
                kMax = k;
            }
            System.out.println((a + 1) + " Array. Enter column length:");
            Scanner scanner_p = new Scanner(System.in);
            int p = scanner_p.nextInt();
            if (p > pMax) {                                                                                      //return to viewer
                pMax = p;
            }
            System.out.println("Enter integer data. Type 'enter' after every variable:");                        //get array data
//            arr = new int[kMax][pMax][quantity];
            Scanner scannerArr = new Scanner(System.in);
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < p; j++) {
                    arr[i][j][a] = scannerArr.nextInt();
                }
            }
            System.out.println();
            System.out.println("This array result:");
            for (int xEvery = 0; xEvery < k; xEvery++) {
                for (int yEvery = 0; yEvery < p; yEvery++) {
                    System.out.print(arr[xEvery][yEvery][a] + "\t");
                }
                System.out.println();
            }                                                                                                  //View every array
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Your arrays:");
        for (int z = 0; z < quantity; z++) {                                                                    //viewer
            for (int x = 0; x < kMax; x++) {
                for (int y = 0; y < pMax; y++) {
                    System.out.print(arr[x][y][z] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();

        }
        int[][] arrFin = new int[kMax][pMax];
        switch (oper) {
            case '+':
                for (int rowFin = 0; rowFin < kMax; rowFin++) {
                    for (int columnFin = 0; columnFin < pMax; columnFin++) {
                        for (int quantityFin = 0; quantityFin < quantity; quantityFin++) {
                            arrFin[rowFin][columnFin] += arr[rowFin][columnFin][quantityFin];
                        }
                    }
                }
            case '-':
                for (int rowFin = 0; rowFin < kMax; rowFin++) {
                    for (int columnFin = 0; columnFin < pMax; columnFin++) {
                        for (int quantityFin = 0; quantityFin < quantity; quantityFin++) {
                            arrFin[rowFin][columnFin] -= arr[rowFin][columnFin][quantityFin];
                        }
                    }
                }
            case '*':
                for (int rowFin = 0; rowFin < kMax; rowFin++) {
                    for (int columnFin = 0; columnFin < pMax; columnFin++) {
                        for (int quantityFin = 0; quantityFin < quantity; quantityFin++) {
                            arrFin[rowFin][columnFin] *= arr[rowFin][columnFin][quantityFin];
                        }
                    }
                }
            case '/':
                for (int rowFin = 0; rowFin < kMax; rowFin++) {
                    for (int columnFin = 0; columnFin < pMax; columnFin++) {
                        for (int quantityFin = 0; quantityFin < quantity; quantityFin++) {
                            arrFin[rowFin][columnFin] /= arr[rowFin][columnFin][quantityFin];
                        }
                    }
                }
            case 't':

        }
//Result viewer
        System.out.println("Operation result:");
        for (int iResult = 0; iResult < kMax; iResult++) {
            for (int jResult = 0; jResult < pMax; jResult++) {
                System.out.print(arrFin[iResult][jResult] + "\t");
            }
            System.out.println();
        }

    }
}
