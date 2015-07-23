package com.igor2i.calc.methods;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by igor2i on 23.07.15.
 */
public class Matrix {

    public static double[][] matrix(ArrayList<Double> inArrMatrixDoub, ArrayList<String> inArrMatrixSimbol) {
        double outDoub[][] = new double[10][];

        int countArr = 0;
        nextBkt:
        for (int i = 0; i < inArrMatrixSimbol.size(); i++) {
            if (inArrMatrixSimbol.get(i).equals("(")) {
                for (int n = i; i < inArrMatrixSimbol.size(); n++) {
                    if (inArrMatrixSimbol.get(n).equals(")")) {
                        ArrayList<String> outArrSimbol = new ArrayList<String>();
                        outArrSimbol.addAll(inArrMatrixSimbol.subList(i, n));

                        outDoub[countArr] = Bkt.matrixBkt(inArrMatrixDoub,outArrSimbol);

                        for (int p = i; p < n+1; p++) {
                            inArrMatrixSimbol.remove(i);
                        }
                        for(int t = 0;t<outDoub[countArr].length;t++){
                            inArrMatrixDoub.remove(0);
                        }

                        countArr++;
                        i = -1;
                        continue nextBkt;

                    }
                }
            }
        }

        return outDoub;
    }

}
