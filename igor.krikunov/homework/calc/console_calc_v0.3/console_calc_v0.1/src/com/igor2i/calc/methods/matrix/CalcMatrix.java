package com.igor2i.calc.methods.matrix;

import com.igor2i.calc.methods.matrix.Matrix;
import com.igor2i.calc.methods.matrix.MatrixFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor2i on 23.07.15.
 */
public class CalcMatrix {

    public static double[][] calcMatrix(ArrayList<Double> inArrDoub, ArrayList<String> inArrSimbol) {

        List<List<List<Double>>> forDoub = new ArrayList<List<List<Double>>>();

        int countArr = 0;
        forArr:
        for (int i = 0; i < inArrSimbol.size(); i++) {

            if ("matrix[".equals(inArrSimbol.get(i))) {

                for (int n = i; n < inArrSimbol.size(); n++) {

                    if ("]".equals(inArrSimbol.get(n))) {

                        ArrayList<String> outArrSimbol = new ArrayList<String>();
                        outArrSimbol.addAll(inArrSimbol.subList(i+1,n));

                        forDoub.add(countArr, Matrix.matrix(inArrDoub, outArrSimbol));

                        for (int p = i; p < n+1; p++) {
                            inArrSimbol.remove(i);
                        }
                        countArr++;
                        i = -1;
                        continue forArr;
                    }
                }
            }
        }

        double outDoub[][] = new double[forDoub.size()][];

        for(int i = 0 ; i< inArrSimbol.size();i++) {
            if (MatrixFunction.SUMM.getSim().equals(inArrSimbol.get(i))) {

                outDoub = MatrixFunction.SUMM.set(forDoub.get(i), forDoub.get(i+1));

            } else if (MatrixFunction.MULT.getSim().equals(inArrSimbol.get(i))) {

                outDoub = MatrixFunction.MULT.set(forDoub.get(i), forDoub.get(i+1));

            }
        }
        return outDoub;
    }


}
