package com.igor2i.calc.methods.matrix;

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

            double[][] outDoub = new double[inArr1.size()][inArr1.get(0).size()];

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
            double[][] outDoub = new double[inArr1.size()][inArr1.get(0).size()];

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
    INVO("^") {

    },
    TRANS("%"){
        protected double[][] set(double [][] m){
            double[][] temp = new double[m[0].length][m.length];
            for (int i = 0; i < m.length; i++)
                for (int j = 0; j < m[0].length; j++)
                    temp[j][i] = m[i][j];
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
    protected double[][] set(List<List<Double>> inArr1) {
        double nul[][] = {{0}};
        return nul;
    }

}
