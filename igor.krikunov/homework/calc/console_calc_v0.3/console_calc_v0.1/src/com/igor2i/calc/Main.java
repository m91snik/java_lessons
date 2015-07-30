package com.igor2i.calc;

import com.igor2i.calc.methods.algExp.Calc;
import com.igor2i.calc.methods.Prevetstvie;
import com.igor2i.calc.methods.matrix.CalcMatrix;
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

            if ("reScan".equals(ar[0][0])) {
                continue nextScan;
            }else if ("help".equals(ar[0][0])){
                Prevetstvie.getHelp();
                continue nextScan;
            }

            ArrayList<Double> arrayDoubStr = new ArrayList<Double>();
            arrayDoubStr = SorterListDouble.sorterListDouble(ar[0]);    // arrayDoubStr - массив из чисел double


            ArrayList<String> arraySimbolStr = new ArrayList<String>();
            arraySimbolStr = SorterListSimbol.sorterListSimbol(ar[1]);  //arraySimbolStr - массив из символов (+ - / *)


            DecimalFormat df = new DecimalFormat("#.###");

            if (Collections.frequency(arraySimbolStr, "matrix[") > 0) {

                double outFinishMatrix[][];
                outFinishMatrix = CalcMatrix.calcMatrix(arrayDoubStr, arraySimbolStr);

                for (int i = 0; i < outFinishMatrix.length; i++) {
                    for (int n = 0; n < outFinishMatrix[i].length; n++) {
                        System.out.print(df.format(outFinishMatrix[i][n]) + "  ");
                    }
                    System.out.println();
                }

            } else {
                double outFinishCalc;
                outFinishCalc = Calc.calc(arrayDoubStr, arraySimbolStr);    //отправим на вычисление

                System.out.println(df.format(outFinishCalc));
            }

            System.out.println("|--------------------------------|");
        }
    }

}
