package com.igor2i.lesson11;

/**
 * Created by igor2i on 20.08.15.
 */
public class Main {

    public static void main(String args[]) {

        Calc<Long> summator = (i, j) -> i + j;

        Calc<Double> diff = (i, j) -> i + j;

        System.out.println(summator.calc(10L, 20L));
        System.out.println(diff.calc(10.0, 20.0));

        //Printer.print(String.valueOf(new String[]{String.valueOf(new String[])}) ("a","b","c"));

        System.out.println(new Main().fack.recursionn(10));



    }

    Rec fack = (i) -> i == 1 ? 1 : i * this.fack.recursionn(i - 1);


    //public static <U extends Number> U doSmith(Calc<U> calc, U i, U j)

}
