package com.igor2i.calc.methods.algExp;


import com.igor2i.calc.sorter.IndexExists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by igor2i on 20.07.15.
 */
public class Calc {

    static int contSrez = 0;

    public static double calc(ArrayList<Double> inArrDoub, ArrayList<String> inArrSimbol) {

        /**
         * рекурсионный метод нахождения круглых кавычек
         */
//
//        List<List<Double>> forDoub = new ArrayList<List<Double>>();
//
//        int countArr = 0;
//        forArr:
//        for (int i = 0; i < inArrSimbol.size(); i++) {
//
//            if ("(".equals(inArrSimbol.get(i))) {
//
//                for (int n = i; n < inArrSimbol.size(); n++) {
//                    if("(".equals(inArrSimbol.get(n))){
//                        contSrez++;
//
//                        Calc.calc(inArrDoub,inArrSimbol);
//
//                        for (int p = i; p < n+1; p++) {
//                            inArrMatrixSimbol.remove(i);
//                        }
//
//
//                    }else if (")".equals(inArrSimbol.get(n))) {
//
//                        ArrayList<String> outArrSimbol = new ArrayList<String>();
//                        outArrSimbol.addAll(inArrSimbol.subList(i+1,n));
//
//                        forDoub.add(countArr, Matrix.matrix(inArrDoub, outArrSimbol));
//
//                        for (int p = i; p < n+1; p++) {
//                            inArrSimbol.remove(i);
//                        }
//                        for(int t = 0;t<inArrDoub.get(countArr).size();t++){
//                            inArrMatrixDoub.remove(0);
//                        }
//
//                        countArr++;
//                        i = -1;
//                        contSrez--;
//                        continue forArr;
//                    }
//                }
//            }
//        }



        if (AlgExpressions.SUBTRACTION.getSim().equals(inArrSimbol.get(0)) && inArrSimbol.size() - Collections.frequency(inArrSimbol, "!") == inArrDoub.size()) {
            inArrDoub.set(0, AlgExpressions.SUBTRACTION.calcul(inArrDoub.get(0)));
            inArrSimbol.remove(0);
        }


        for (int count = Collections.frequency(inArrSimbol, "!"), simbolI; count != 0; count = Collections.frequency(inArrSimbol, "!")) {
            simbolI = inArrSimbol.indexOf("!");
            if (AlgExpressions.FACTORIAL.getSim().equals(inArrSimbol.get(simbolI))) {
                inArrDoub.set(simbolI, AlgExpressions.FACTORIAL.calcul(inArrDoub.get(simbolI)));
                inArrSimbol.remove(simbolI);
            }
        }


        for (int count = Collections.frequency(inArrSimbol, "^"), simbolI; count != 0; count = Collections.frequency(inArrSimbol, "^")) {
            simbolI = inArrSimbol.indexOf("^");
            if (AlgExpressions.INVOLUTION.getSim().equals(inArrSimbol.get(simbolI))) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, AlgExpressions.INVOLUTION.calcul(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                }
            }
        }

        for (int simbolI = 0, count = Collections.frequency(inArrSimbol, "*") + Collections.frequency(inArrSimbol, "/"); count != 0; simbolI++, count = Collections.frequency(inArrSimbol, "*") + Collections.frequency(inArrSimbol, "/")) {
            if (simbolI < 0) {
                simbolI = 0;
            }

            if (AlgExpressions.MULTIPLICATION.getSim().equals(inArrSimbol.get(simbolI))) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, AlgExpressions.MULTIPLICATION.calcul(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            } else if (AlgExpressions.DIVISION.getSim().equals(inArrSimbol.get(simbolI))) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, AlgExpressions.DIVISION.calcul(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            }
        }


        for (int simbolI = 0, count = Collections.frequency(inArrSimbol, "+") + Collections.frequency(inArrSimbol, "-"); count != 0; simbolI++, count = Collections.frequency(inArrSimbol, "+") + Collections.frequency(inArrSimbol, "-")) {
            if (simbolI < 0) {
                simbolI = 0;
            }

            if (AlgExpressions.SUMM.getSim().equals(inArrSimbol.get(simbolI))) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, AlgExpressions.SUMM.calcul(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            } else if (AlgExpressions.SUBTRACTION.getSim().equals(inArrSimbol.get(simbolI))) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, AlgExpressions.SUBTRACTION.calcul(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            }

        }

        double out;
        out = inArrDoub.get(0);


        return out;

    }

}
