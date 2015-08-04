package com.igor2i.calc.methods.matrix;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by igor2i on 23.07.15.
 */
enum MatrixFunction {
    SUMM("+") {
        @Override
        protected double[][] set(List<List<Double>> inArr1, List<List<Double>> inArr2) {

            int max[] = maxLenght(inArr1, inArr2);
            double[][] outDoub = new double[max[0]][max[1]];


            for (int i = 0; i < inArr1.size(); i++) {
                for (int n = 0; n < inArr1.get(i).size(); n++) {
                    outDoub[i][n] = inArr1.get(i).get(n) + inArr2.get(i).get(n);
                }
            }
            return outDoub;
        }
    },
    MULT("*") {
        @Override
        protected double[][] set(List<List<Double>> inArr1, List<List<Double>> inArr2) {
            int max[] = maxLenght(inArr1, inArr2);
            double[][] outDoub = new double[max[0]][max[1]];

            for (int i = 0; i < inArr1.size(); i++) {
                for (int j = 0; j < inArr1.get(i).size(); j++) {
                    double s = 0;
                    for (int k = 0; k < inArr1.size(); k++) {
                        s += inArr1.get(i).get(k) * inArr2.get(k).get(j);
                    }
                    outDoub[i][j] = s;
                }
            }
            return outDoub;
        }
    },
    SUBTR("-") {
        @Override
        protected double[][] set(List<List<Double>> inArr1, List<List<Double>> inArr2) {

            int max[] = maxLenght(inArr1, inArr2);
            double[][] outDoub = new double[max[0]][max[1]];


            for (int i = 0; i < inArr1.size(); i++) {
                for (int n = 0; n < inArr1.get(i).size(); n++) {
                    outDoub[i][n] = inArr1.get(i).get(n) - inArr2.get(i).get(n);
                }
            }
            return outDoub;
        }
    },
    TRANS("%") {
        @Override
        protected double[][] set(List<List<Double>> inArr1) {
            double[][] temp = new double[inArr1.get(0).size()][inArr1.size()];
            for (int i = 0; i < inArr1.size(); i++)
                for (int j = 0; j < inArr1.get(0).size(); j++)
                    temp[j][i] = inArr1.get(i).get(j);
            return temp;
        }

    };

    String sim;

    MatrixFunction(String sim) {
        this.sim = sim;
    }

    protected String getSim() {
        return sim;
    }

    protected double[][] set(List<List<Double>> inArr1, List<List<Double>> inArr2) {
        double nul[][] = {{0}};
        return nul;
    }

    protected double[][] set(List<List<Double>> inArr1){
        double nul[][] = {{0}};
        return nul;
    }

    protected int[] maxLenght(List<List<Double>> inArr1, List<List<Double>> inArr2) {
        int max[] = new int[2];
        if (inArr1.size() > inArr2.size()) {
            max[0] = inArr1.size();
        } else {
            max[0] = inArr2.size();
        }
        max[1] = 0;
        for (List<Double> sip : inArr1) {
            if (sip.size() > max[1]) {
                max[1] = sip.size();
            }
        }
        for (List<Double> sip : inArr2) {
            if (sip.size() > max[1]) {
                max[1] = sip.size();
            }
        }

        return max;

    }
}
