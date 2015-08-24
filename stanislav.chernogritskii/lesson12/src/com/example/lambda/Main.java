package com.example.lambda;

import java.util.Arrays;

/**
 * Created by stanislav on 20.08.15.
 */
public class Main {

    public static <U extends Number> U doSmth(Calculator<U> calculator, U i, U j) {

        return calculator.calc(i,j);
    }

    public static void main(String[] args) {

        Calculator<Double> summator = (i, j) -> i + j;
        Calculator<Long> diff = (Long i, Long j) -> {
            return i - j;
        };

//        Calculator summator = new Calculator() {
//            @Override
//            public int calc(int i, int j) {
//                return i + j;
//            }
//        };

        System.out.println(summator.calc(10.0,20.0));
        System.out.println(diff.calc(10L,20L));

        Printer printer = (String[] strings) -> {
            for (String string : strings) {
                System.out.println(string);
            }
        };

        printer.print(new String[]{"a", "b", "c"});

        System.out.println(doSmth(summator, 4.0, 3.0));
    }
}
