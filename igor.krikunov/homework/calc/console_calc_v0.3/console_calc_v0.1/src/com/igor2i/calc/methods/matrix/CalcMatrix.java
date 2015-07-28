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
                        outArrSimbol.addAll(inArrSimbol.subList(i + 1, n));

                        forDoub.add(countArr, Matrix.matrix(inArrDoub, outArrSimbol));

                        for (int p = i; p < n + 1; p++) {
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

        for (int i = 0; i < inArrSimbol.size(); i++) {
            if (MatrixFunction.TRANS.getSim().equals(inArrSimbol.get(i))) {
                outDoub = MatrixFunction.TRANS.set(forDoub.get(i));
                for (int k = 0; k < outDoub.length; k++) {
                    for (int p = 0; p < outDoub[k].length; p++) {
                        forDoub.get(i).get(k).set(p, outDoub[k][p]);
                    }
                }
            }
        }

        for (int i = 0; i < inArrSimbol.size(); i++) {
            if (MatrixFunction.MULT.getSim().equals(inArrSimbol.get(i))) {
                if (i + 1 < forDoub.size()) {
                    outDoub = MatrixFunction.MULT.set(forDoub.get(i), forDoub.get(i + 1));
                    for (int k = 0; k < outDoub.length; k++) {
                        for (int p = 0; p < outDoub[k].length; p++) {
                            forDoub.get(i + 1).get(k).set(p, outDoub[k][p]);
                        }
                    }
                    forDoub.remove(i);
                }
            }
        }

        for (int i = 0; i < inArrSimbol.size(); i++) {
            if (MatrixFunction.SUMM.getSim().equals(inArrSimbol.get(i))) {
                if (i + 1 < forDoub.size()) {
                    outDoub = MatrixFunction.SUMM.set(forDoub.get(i), forDoub.get(i + 1));
                    for (int k = 0; k < outDoub.length; k++) {
                        for (int p = 0; p < outDoub[k].length; p++) {
                            forDoub.get(i + 1).get(k).set(p, outDoub[k][p]);
                        }
                    }
                }
            } else if (MatrixFunction.SUBTR.getSim().equals(inArrSimbol.get(i))) {
                if (i + 1 < forDoub.size()) {
                    outDoub = MatrixFunction.SUBTR.set(forDoub.get(i), forDoub.get(i + 1));
                    for (int k = 0; k < outDoub.length; k++) {
                        for (int p = 0; p < outDoub[k].length; p++) {
                            forDoub.get(i + 1).get(k).set(p, outDoub[k][p]);
                        }
                    }
                }
            }
        }

        return outDoub;
    }


}
