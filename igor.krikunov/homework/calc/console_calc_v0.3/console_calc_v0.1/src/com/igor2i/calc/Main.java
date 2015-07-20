package com.igor2i.calc;

import com.igor2i.calc.methods.*;
import com.igor2i.calc.scaner.Scaner;
import com.igor2i.calc.sorter.Sorter;
import com.igor2i.calc.sorter.SorterListDouble;
import com.igor2i.calc.sorter.SorterListSimbol;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by igor2i on 17.07.2015.
 */

public class Main {

    public static void main(String args[]) {

        Prevetstvie.getPrevetstvie();

        for (String[][] ar = Sorter.sorter(Scaner.scan()); !ar[0][0].equals("exit"); ) {

            ArrayList<Double> arrayDoubStr = new ArrayList<Double>();
            arrayDoubStr = SorterListDouble.sorterListDouble(ar[0]);    // arrayDoubStr - массив из чисел double


            ArrayList<String> arraySimbolStr = new ArrayList<String>();
            arraySimbolStr = SorterListSimbol.sorterListSimbol(ar[1]);  //arraySimbolStr - массив из символов (+ - / *)

            double outFinish;
            outFinish = Calc.calc(arrayDoubStr, arraySimbolStr);    //отправим на вычисление

            DecimalFormat df = new DecimalFormat("#.###");

            if (outFinish == (long) outFinish) {
                System.out.println((long) outFinish);
            } else {
                System.out.println(df.format(outFinish));
            }
            System.out.println("|--------------------------------|");

            ar = Sorter.sorter(Scaner.scan());

        }
    }

}
