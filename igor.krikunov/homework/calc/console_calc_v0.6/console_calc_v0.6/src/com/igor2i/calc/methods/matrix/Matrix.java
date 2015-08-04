package com.igor2i.calc.methods.matrix;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by igor2i on 23.07.15.
 */
class Matrix {

    protected static List<List<Double>> matrix(ArrayList<Double> inArrMatrixDoub, ArrayList<String> inArrMatrixSimbol){

        ArrayList<List<Double>> outDoub = new ArrayList<List<Double>>();

        int countArr = 0;
        nextBkt:
        for (int i = 0; i < inArrMatrixSimbol.size(); i++) {
            if (inArrMatrixSimbol.get(i).equals("(")) {
                for (int n = i; i < inArrMatrixSimbol.size(); n++) {
                    if (inArrMatrixSimbol.get(n).equals(")")) {
                        ArrayList<String> outArrSimbol = new ArrayList<String>();
                        outArrSimbol.addAll(inArrMatrixSimbol.subList(i, n));

                        outDoub.add(countArr, matrixBkt(inArrMatrixDoub, outArrSimbol));

                        for (int p = i; p < n+1; p++) {
                            inArrMatrixSimbol.remove(i);
                        }
                        for(int t = 0;t<outDoub.get(countArr).size();t++){
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

    private static ArrayList<Double> matrixBkt(ArrayList<Double> inArrDoBkt, ArrayList<String> inArrStBkt) {

        ArrayList<Double> outArr = new ArrayList<Double>();

        for(int i= 0; i < inArrStBkt.size();i++){
            outArr.add(inArrDoBkt.get(i));
        }

        return outArr;
    }

}
