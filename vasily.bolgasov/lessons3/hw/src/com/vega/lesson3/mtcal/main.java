package com.vega.lesson3.mtcal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Вася-Вега on 22.07.2015.
 */
public class main {

    public static void main(String[] args) {

        double[][] mass3 = new double[1][1];
        Scanner vvod = new Scanner(System.in);

        /*
         * Выбор операции
         */
        System.out.println("Operation: SUM or DIF or PRO or TRA");
        String oper = vvod.next();

        /*
         * Указываем размерность первого массива
         * и заполняем его
         */

        System.out.print("mass1[i][j]\ni=");
        Integer i1 = vvod.nextInt();
        System.out.print("j=");
        Integer j1 = vvod.nextInt();
        double[][] mass1 = new double[i1][j1];

        System.out.println("element mass1:");
        for(int i=0; i<i1; i++){
            for(int j=0; j<j1; j++){
                mass1[i][j] = vvod.nextDouble();
            }
        }

        /*
         * Указываем размерность второго массива
         * и заполняем его
         */
        int i2=1,j2=1;
        if(!operation.TRA.name().equals(oper)) {
            System.out.print("mass2[i][j]\ni=");
            i2 = vvod.nextInt();
            System.out.print("j=");
            j2 = vvod.nextInt();
        }
        double[][] mass2 = new double[i2][j2];

        System.out.println("element mass2:");
        for(int i=0; i<i2; i++){
            if(operation.TRA.name().equals(oper)){
                System.out.println("not need");
                break;
            }
            for(int j=0; j<j2; j++){
                mass2[i][j] = vvod.nextDouble();
            }
        }

        /*
         * Подсчитывающие операции
         */

        if(operation.SUM.name().equals(oper)){
            if((i1==i2) && (j1==j2)){
                mass3 = new double[i1][j1];
                for(int i=0; i<j2; i++){
                    for(int j=0; j<i2; j++){
                        mass3[i][j] = mass1[i][j]+mass2[i][j];
                    }
                }
            }
        }

        if(operation.DIF.name().equals(oper)){
            if((i1==i2) && (j1==j2)){
                mass3 = new double[i1][j1];
                for(int i=0; i<j2; i++){
                    for(int j=0; j<i2; j++){
                        mass3[i][j] = mass1[i][j]-mass2[i][j];
                    }
                }
            }
        }

        if(operation.PRO.name().equals(oper)){
            if(j1==i2){
                mass3 = new double[i1][j2];
                for(int i=0; i<i1; i++){
                    double sum = 0.0;
                    for(int j=0; j<j2; j++) {
                        for (int z = 0; z < j1; z++) {
                            sum = mass1[i][z] + mass2[i][z];
                        }
                        mass3[i][j] = sum;
                    }
                }
            }
        }

        if(operation.TRA.name().equals(oper)){
            System.out.println(Arrays.deepToString(mass3));
            mass3 = new double[j1][i1];
            for(int i=0; i<j1; i++){
                for(int j=0; j<i1; j++){
                    mass3[i][j] = mass1[j][i];
                }
            }
        }


        //System.out.println(Arrays.deepToString(mass1));
        //System.out.println(Arrays.deepToString(mass2));
        System.out.println(Arrays.deepToString(mass3));

    }

}
