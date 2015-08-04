package com.igor2i.calc.methods.algExp;


import com.igor2i.calc.methods.exception.BktException;
import com.igor2i.calc.sorter.IndexExists;
import com.igor2i.calc.sorter.Sorter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by igor2i on 20.07.15.
 */
public class Calc {

    public static double calc(ArrayList<Double> inArrDoub, ArrayList<String> inArrSimbol) {

        try {

            if (Collections.frequency(inArrSimbol, "(") - Collections.frequency(inArrSimbol, ")") != 0) {
                throw new BktException("Ошибка синтаксиса, не чётное количество скобок.");
            }

            /**
             * рекурсивный метод нахождения круглых кавычек
             */
            forArr:
            for (int i = 0; i < inArrSimbol.size(); i++) {

                if (")".equals(inArrSimbol.get(i))) {

                    for (int n = i; n > -1; n--)
                        if ("(".equals(inArrSimbol.get(n))) {

                            int sdvig = 0;

                            for (int k = 0; k < n; k++) {
                                if ("(".equals(inArrSimbol.get(k))) {
                                    sdvig++;
                                } else if ("!".equals(inArrSimbol.get(k))) {
                                    sdvig++;
                                }
                            }

                            int sdvigFak = 0;
                            for (int k = n; k < i; k++) {
                                if ("!".equals(inArrSimbol.get(k))) {
                                    sdvigFak++;
                                }
                            }

                            int sdvigMin = 0;
                            if (IndexExists.indexExists(inArrSimbol, 0) && "-".equals(inArrSimbol.get(0))) {
                                int count = 0;
                                final String str[] = {"+", "-", "*", "/", "^"};
                                for (String sim : str) {
                                    count += Collections.frequency(inArrSimbol, sim);
                                }
                                if (count >= inArrDoub.size()) {
                                    sdvigMin++;
                                }
                            }

                            ArrayList<Double> forDoub = new ArrayList<Double>();
                            forDoub.addAll(inArrDoub.subList(n - sdvig - sdvigMin, i - sdvig - sdvigMin - sdvigFak));
                            ArrayList<String> forSimbol = new ArrayList<String>();
                            forSimbol.addAll(inArrSimbol.subList(n + 1, i));

                            inArrDoub.set(n - sdvig - sdvigMin, Calc.calc(forDoub, forSimbol));

                            for (int k = n; k < i + 1; k++) {
                                inArrSimbol.remove(n);
                            }

                            if (n == 0) {
                                i -= 1;
                            } else if (Collections.frequency(inArrSimbol.subList(0, n), "(") == n) {
                                i -= Collections.frequency(inArrSimbol.subList(0, n), "(") + 1;
                            }

                            for (int k = n - sdvig - sdvigMin + 1; k < i - sdvig - sdvigMin - sdvigFak; k++) {
                                inArrDoub.remove(n - sdvig - sdvigMin + 1);
                            }

                            i = i - n;
                            continue forArr;
                        }
                }
            }

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
        } catch (IndexOutOfBoundsException ex) {
            System.out.print("Ошибка синтаксиса, IndexOutOfBoundsException  ");
            // ex.printStackTrace();
            return -1;
        } catch (BktException ex1) {
            System.out.print("Ошибка синтаксиса, BktException  ");
            //ex1.printStackTrace();
            return -1;
        }catch (Exception ex3){
            System.out.print("Ошибка синтаксиса  ");
            return -1;
        }

    }

}
