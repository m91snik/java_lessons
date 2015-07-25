package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


/**
 * Created by HP on 23.07.2015.
 */
public class Mascalculator {
    public static void main(String[] args)throws Exception{

        Scanner in = new Scanner(System.in);

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

// Создаем массив summas для сложения наших двух массивов ( mas1 и mas2 )
        int chsummas1 = 0;
        int chsummas2 = 0;
        int [][] summas  = new int [chsummas1][chsummas2];


// первый массив
        System.out.println("Working with massiv 1");
        System.out.println("enter the string");
        String str1 = reader.readLine();
        int ch1 = Integer.parseInt(str1);

        System.out.println("enter the column");
        String str2 = reader.readLine();
        int ch2 = Integer.parseInt(str2);

        int [][] mas1 = new int [ch1][ch2];

        for (int i = 0; i < ch1; i++) {
            for (int j = 0; j < ch2; j++) {
                System.out.print("Enter the elements of array mas1 [" + i + "][" + j + "]:");
                mas1[i][j] = in.nextInt();
            }
        }



        for (int i = 0; i < ch1; i++) {
            for (int j = 0; j < ch2; j++) {
                System.out.print(mas1[i][j] + "\t");
            }
            System.out.println();
        }


// второй массив
        System.out.println("Working with massiv 2");
        System.out.println("enter the length of the string");
        String str3 = reader.readLine();
        int ch3 = Integer.parseInt(str3);

        System.out.println("enter the length of the column");
        String str4 = reader.readLine();
        int ch4 = Integer.parseInt(str4);

        int [][] mas2 = new int [ch3][ch4];

        for (int i = 0; i < ch3; i++) {
            for (int j = 0; j < ch4; j++) {
                System.out.print("Enter the elements of array mas2 [" + i + "][" + j + "]:");
                mas2[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < ch3; i++) {
            for (int j = 0; j < ch4; j++) {
                System.out.print(mas2[i][j] + "\t");
            }
            System.out.println();
        }



//        for (int i = 0; i < ch1 ; i++) {
//            for (int j = 0; j <ch2 ; j++) {
//                for (int k = 0; k <ch3 ; k++) {
//                    for (int l = 0; l <ch4 ; l++) {
//                        summas[chsummas1][chsummas2] = mas1 [i] [j] + mas2 [k] [l];
//
//                    }
//                }
//            }
//
//        }

            System.out.println(mas1 [0] [0] + mas2 [0] [0]);
    }

}




