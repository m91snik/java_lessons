package com.igor2i.calc.methods;

import java.util.ArrayList;

/**
 * Created by igor2i on 23.07.15.
 */
public class CalcMatrix {

    public static double[][] calcMatrix(ArrayList<Double> inArrDoub, ArrayList<String> inArrSimbol) {

        double forDoub[][][] = new double[10][][];

        int countArr = 0;
        forArr:
        for (int i = 0; i < inArrSimbol.size(); i++) {

            if (inArrSimbol.get(i).equals("matrix[")) {

                for (int n = i; n < inArrSimbol.size(); n++) {

                    if (inArrSimbol.get(n).equals("]")) {

                        ArrayList<String> outArrSimbol = new ArrayList<String>();
                        outArrSimbol.addAll(inArrSimbol.subList(i+1,n));

                        forDoub[countArr] = Matrix.matrix(inArrDoub,outArrSimbol);

                        for (int p = i; p < n+1; p++) {
                            inArrSimbol.remove(i);
                        }

//                        int countDelDoub = 0;
//                        for (int x = 0; x<forDoub[countArr].length;x++ ) {
//                            for (int y = 0; y<forDoub[countArr][x].length;y++ ) {
//                                countDelDoub++;
//                            }
//                        }
//
//                        for (int t = 0; t < countDelDoub; t++) {
//                            inArrDoub.remove(0);
//                        }

                        countArr++;
                        i = -1;
                        continue forArr;

                    }

                }

            }

        }
        double outDoub[][] = new double[forDoub[0][0].length][];

        for(int i = 0 ; i< inArrSimbol.size();i++){
            if(inArrSimbol.get(i).equals("+")){

                outDoub = MatrixFunction.Summ.set(forDoub[i],forDoub[i+1]);

            }
//            else if(inArrSimbol.get(i).equals(MatrixFunction.Mult.getSim())){
//                outDoub = null;
        }

        return outDoub;
    }


}
