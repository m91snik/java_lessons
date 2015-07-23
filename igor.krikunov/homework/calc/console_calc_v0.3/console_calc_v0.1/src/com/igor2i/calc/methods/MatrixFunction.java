package com.igor2i.calc.methods;

import java.util.Collections;

/**
 * Created by igor2i on 23.07.15.
 */
public enum MatrixFunction {
    Summ("+") {
        @Override
        public double[][] set(double d1[][], double d2[][]) {

            double[][] outDoub = new double[d1[0].length][d1[0].length];

            for (int i = 0; i < d1[0].length; i++) {
                for (int n = 0; n < d1[i].length; n++) {
                    outDoub[i][n] = d1[i][n] + d2[i][n];
                }
            }

            return outDoub;
        }
    },
    Mult("*") {
        //@Override
        public double mult() {
            return 0;
        }
    }, Invo("^") {

    };

    String sim;

    MatrixFunction(String s) {
        this.sim = sim;
    }

    public String getSim() {
        return sim;
    }

    public double[][] set(double[][] d1,double[][] d2){
        double nul[][] = {{0}};
        return nul;
    }

}
