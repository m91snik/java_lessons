package com.gorbachevskaya.lambda;

import java.util.ArrayList;
import java.util.LongSummaryStatistics;

/**
 * Created by Ангелина on 20.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        // так делали раньше, использовали анонимные классы
//        Calculator summator = new Calculator() {
//            @Override
//            public int calc(int i, int j) {
//                return i+j;
//            }
//        };

        // но потом появились лямбды!
        Calculator<Double> summatorWithLambda = (i,j) -> i+j;
        Calculator<Long> diff = (i,j)-> i-j;

        System.out.println(summatorWithLambda.calc(10.0, 20.0));
        System.out.println(diff.calc(10L,20L));

        Printer printer = (String[] strings) -> {
            for (String string:strings) {
                System.out.println(string);
            }
        };

        printer.print(new String[]{"a", "b", "c"});
    }
}
