package com.m91snik.lesson5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Valentin on 28.07.2015.
 */
public class Main {

    public static void main(String... args) {
        List<Object> objects = Arrays.asList();
//        objects.get(0);

        for (String arg : args) {
            System.out.print(arg);
        }

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner1 = outer.new Inner();
        inner.counter = 1;

        long[] secondOrder = {1, 2, 3};
        new Main().process(secondOrder, secondOrder);
    }

    public void process(long[]... secondOrder) {
        process1(secondOrder);
        // validation
    }

    public void process1(long[][] secondOrder) {
        // validation
    }
}
