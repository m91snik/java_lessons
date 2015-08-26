package com;

/**
 * Created by Anry on 20.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        Calculator<Double> summator = (i, j) -> i + j;
        Calculator<Long> diff = (Long i, Long j) -> {
            return i - j;

        };
        System.out.println(summator.calc(10.0, 20.0));


//        Printer printer = (String[] strings) -> {
//            for (String string : strings) {
//                System.out.println(string);
//            }
//        };

//        printer.print(new String[]{"a", "b", "c"})

        System.out.println((strings) -> " Hi");

    }
}
