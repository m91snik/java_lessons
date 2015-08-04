package com.vega.lesson3.mtcal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

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


    static void CheckException(int i1, int i2, int j1, int j2) throws MyException{
        if(i1!=i2 || j1!=j2){
            throw new MyException("WRONG MATRIX!");
        }
    }

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

        double[][] mass3 = new double[0][];
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

        LenghtMass lenghtMass2 = new LenghtMass();

        int i2 = lenghtMass2.getStoka();
        int j2 = lenghtMass2.getStolbec();

        double[][] mass2 = newMass.createMass(i2, j2);

        mass3 = chekSum(mass3, oper, i1, j1, mass1, i2, j2, mass2);
        mass3 = checkDif(mass3, oper, i1, j1, mass1, i2, j2, mass2);
        mass3 = checkPro(mass3, oper, i1, j1, mass1, i2, j2, mass2);
        mass3 = checkTra(mass3, oper, i1, j1, mass1);

        System.out.println(Arrays.deepToString(mass3));

    }


    /*
     * Подсчитывающие операции
     */

    private static double[][] checkTra(double[][] mass3, String oper, int i1, int j1, double[][] mass1) {
        if(operation.TRA.name().equals(oper)){
            System.out.println(Arrays.deepToString(mass3));
            mass3 = new double[j1][i1];
            for(int i=0; i<j1; i++){
                for(int j=0; j<i1; j++){
                    mass3[i][j] = mass1[j][i];
                }
            }
        }
        return mass3;
    }

    private static double[][] checkPro(double[][] mass3, String oper, int i1, int j1, double[][] mass1, int i2, int j2, double[][] mass2) {
        try{
            CheckException(i1,i2,j1,j2);
            if(operation.PRO.name().equals(oper)){
                if(j1==i2){
                    mass3 = new double[i1][j2];
                    for(int i=0; i<i1; i++){
                        for(int j=0; j<j2; j++) {
                            double sum = 0.0;
                            for (int z = 0; z < j1; z++) {
                                sum += mass1[i][z] + mass2[z][j];
                            }
                            mass3[i][j] = sum;
                        }
                    }
                }
            }
        } catch (MyException e) {
            e.printStackTrace();
        }
        return mass3;
    }

    private static double[][] checkDif(double[][] mass3, String oper, int i1, int j1, double[][] mass1, int i2, int j2, double[][] mass2) {
        try{
            CheckException(i1,i2,j1,j2);
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
        } catch (MyException e) {
            e.printStackTrace();
        }
        return mass3;
    }

    private static double[][] chekSum(double[][] mass3, String oper, int i1, int j1, double[][] mass1, int i2, int j2, double[][] mass2) {
        try{
            CheckException(i1,i2,j1,j2);
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
        } catch (MyException e) {
            e.printStackTrace();
        }
        return mass3;
    }


}
