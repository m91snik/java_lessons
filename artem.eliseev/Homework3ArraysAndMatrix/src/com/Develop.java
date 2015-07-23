package com; /**
 * Created by Ната и Артем on 23.07.2015.
 */

/**
 *  Это попытка сделать упражнение (операцию) для неограниченного числа 2 мерных матриц. Все уперлось в то, что размеры основного
 * хранящего массива нужно задавать до циклов. Это возможно, но код разрастется и на выполнение упражнения не хватит времени.
 * Было потрачено около 3х часов, чтож, теперь это опыт.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Develop {
    public static void main(String... args) {
        System.out.println("Hello.\nThis is matrix calculator. You can calculate 2 dimensional arrays.");
        System.out.println("Enter number of arrays:");                                                          //get number of arrays
        Scanner scanner_quantity = new Scanner(System.in);
        int quantity = scanner_quantity.nextInt();
        System.out.println("Enter operation:");                                                                  //get operation
        Scanner scanner_oper = new Scanner(System.in);
        int oper = scanner_oper.nextInt();
        int[][][] arr;
        int kMax = 0, pMax = 0;                                                                                 //initilize for return
        int arrFinal[][][] = new int[20][20][quantity];

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
            arr = new int[k][p][quantity];
            Scanner scannerArr = new Scanner(System.in);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j][a] = scannerArr.nextInt();

                }
            }
            arrFinal = arr;                                                                                      //return to viewer
        }
//        arrFinal = arr;
//            System.out.println(Arrays.deepToString(arr));
        for (int z = 0; z < quantity; z++) {                                                                    //viewer
            for (int x = 0; x < kMax; x++) {
                for (int y = 0; y < pMax; y++) {
                    System.out.print(arrFinal[x][y][z] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();

        }
    }
}
