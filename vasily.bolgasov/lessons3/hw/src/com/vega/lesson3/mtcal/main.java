package com.vega.lesson3.mtcal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Вася-Вега on 22.07.2015.
 */

class LenghtMass{

    int stroka,stolbec = 0;
    static Scanner vvod = new Scanner(System.in);

    public LenghtMass() {

        /**
         * указываем длину матрицы
         */

        System.out.print("mass[i][j]\ni=");
        this.stroka = vvod.nextInt();
        System.out.print("j=");
        this.stolbec = vvod.nextInt();

    }

    /**
     * возвращаем столбцы и строки матрицы
     * @return
     */

    public int getStoka(){
        return this.stroka;
    }

    public int getStolbec(){
        return this.stolbec;
    }

}

public class main {

    static Scanner vvod = new Scanner(System.in);

    /**
     * создаем матрицу
     * @param strk
     * @param stlb
     * @return
     */

    private double[][] createMass(int strk, int stlb){
        double[][] mass = new double[strk][stlb];
        System.out.println("ellement mass:");
        for(int i=0; i<strk; i++){
            for(int j=0; j<stlb; j++){
                mass[i][j] = vvod.nextDouble();
            }
        }
        return mass;
    }

    public static void main(String[] args) {

        double[][] mass3 = new double[1][1];
        /*
         * Выбор операции
         */
        System.out.println("Operation: SUM or DIF or PRO or TRA");
        String oper = vvod.next();


        LenghtMass lenghtMass = new LenghtMass();

        int i1 = lenghtMass.getStoka();
        int j1 = lenghtMass.getStolbec();

        main newMass = new main();

        double[][] mass1 = newMass.createMass(i1,j1);

        int i2 = 0;
        int j2 = 0;

        double[][] mass2 = new double[i2][j2];

        if(operation.TRA.name().equals(oper)) {
            LenghtMass lenghtMass2 = new LenghtMass();

            i2 = lenghtMass2.getStoka();
            j2 = lenghtMass2.getStolbec();

            mass2 = newMass.createMass(i2, j2);
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
