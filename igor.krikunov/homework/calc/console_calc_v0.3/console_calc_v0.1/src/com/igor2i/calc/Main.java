package com.igor2i.calc;

import com.igor2i.calc.methods.*;
import com.igor2i.calc.scaner.Scaner;
import com.igor2i.calc.sorter.Sorter;
import com.igor2i.calc.sorter.SorterListDouble;
import com.igor2i.calc.sorter.SorterListSimbol;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by igor2i on 17.07.2015.
 */

public class Main {

    public static void main(String args[]) {

        Prevetstvie.getPrevetstvie();

        nextScan:
        for (String[][] ar = Sorter.sorter(Scaner.getScan()); !ar[0][0].equals("exit"); ar = Sorter.sorter(Scaner.getScan())) {

//            if(arrayDoubStr.equals("")){
//                continue nextScan;
//            }


            ArrayList<Double> arrayDoubStr = new ArrayList<Double>();
            arrayDoubStr = SorterListDouble.sorterListDouble(ar[0]);    // arrayDoubStr - массив из чисел double


            ArrayList<String> arraySimbolStr = new ArrayList<String>();
            arraySimbolStr = SorterListSimbol.sorterListSimbol(ar[1]);  //arraySimbolStr - массив из символов (+ - / *)


            if(Collections.frequency(arraySimbolStr,"matrix[") > 0){
                double outFinishMatrix[][];
                outFinishMatrix = CalcMatrix.calcMatrix(arrayDoubStr, arraySimbolStr);

                for(int i =0 ;i < outFinishMatrix[0].length;i++){
                    for(int n =0;n<outFinishMatrix[0].length;n++){
                        System.out.print(outFinishMatrix[i][n]+ "  ");
                    }
                    System.out.println();
                }

            }else{
                double outFinishCalc;
                outFinishCalc = Calc.calc(arrayDoubStr, arraySimbolStr);    //отправим на вычисление

                DecimalFormat df = new DecimalFormat("#.###");

                if (outFinishCalc == (long) outFinishCalc) {
                    System.out.println((long) outFinishCalc);
                } else {
                    System.out.println(df.format(outFinishCalc));
                }
            }

            System.out.println("|--------------------------------|");
        }
    }

}
