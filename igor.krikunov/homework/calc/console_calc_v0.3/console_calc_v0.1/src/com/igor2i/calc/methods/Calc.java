package com.igor2i.calc.methods;

import com.igor2i.calc.sorter.IndexExists;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by igor2i on 20.07.15.
 */
public class Calc {

    public static double calc(ArrayList<Double> inArrDoub, ArrayList<String> inArrSimbol) {

        if (inArrSimbol.get(0).equals("-") & inArrSimbol.size() - Collections.frequency(inArrSimbol, "!") == inArrDoub.size()) {
            inArrDoub.set(0, Subtraction.inversion(inArrDoub.get(0)));
            inArrSimbol.remove(0);
        }


        for (int count = Collections.frequency(inArrSimbol, "!"), simbolI; count != 0; count = Collections.frequency(inArrSimbol, "!")) {
            simbolI = inArrSimbol.indexOf("!");
            if (inArrSimbol.get(simbolI).equals("!")) {
                inArrDoub.set(simbolI, Factorial.factorial(inArrDoub.get(simbolI)));
                inArrSimbol.remove(simbolI);
            }
        }


        for (int count = Collections.frequency(inArrSimbol, "^"), simbolI; count != 0; count = Collections.frequency(inArrSimbol, "^")) {
            simbolI = inArrSimbol.indexOf("^");
            if (inArrSimbol.get(simbolI).equals("^")) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, Involution.involution(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                }
            }
        }

        for (int simbolI = 0, count = Collections.frequency(inArrSimbol, "*") + Collections.frequency(inArrSimbol, "/"); count != 0; simbolI++, count = Collections.frequency(inArrSimbol, "*") + Collections.frequency(inArrSimbol, "/")) {
            if (simbolI < 0) {
                simbolI = 0;
            }

            if (inArrSimbol.get(simbolI).equals("*")) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, Multiplication.multiplication(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            }

            if (inArrSimbol.get(simbolI).equals("/")) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, Division.division(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
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

            if (inArrSimbol.get(simbolI).equals("+")) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, Summa.summa(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            } else if (inArrSimbol.get(simbolI).equals("-")) {
                if (IndexExists.indexExists(inArrDoub, simbolI + 1)) {
                    inArrDoub.set(simbolI, Subtraction.subtraction(inArrDoub.get(simbolI), inArrDoub.get(simbolI + 1)));
                    inArrDoub.remove(simbolI + 1);
                    inArrSimbol.remove(simbolI);
                    simbolI--;
                }
            }

        }
        double outDoub = inArrDoub.get(0);

        return outDoub;

    }

}
