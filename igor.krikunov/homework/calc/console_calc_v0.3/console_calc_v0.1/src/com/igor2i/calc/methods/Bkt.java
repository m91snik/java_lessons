package com.igor2i.calc.methods;

import java.util.ArrayList;

/**
 * Created by igor2i on 22.07.15.
 */
public class Bkt {

    public static double[] matrixBkt(ArrayList<Double> inArrDoBkt, ArrayList<String> inArrStBkt){

        ArrayList<Double> outArr = new ArrayList<Double>();

        for(int i= 0; i < inArrStBkt.size();i++){
            outArr.add(inArrDoBkt.get(i));
        }

        double outArrDoub[] = new double[outArr.size()];

        for(int i = 0; i < outArr.size();i++){
            outArrDoub[i] = outArr.get(i);
        }

        return outArrDoub;

    }
}
