package com.vega.lesson5.main;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Veg'Zul on 28.07.2015.
 */
public class Main {

    public static void main(String... args) {
//        System.out.println(args.length);

        List<Object> object = Arrays.asList();
        object.get(0);

        System.out.println(args[0]);

        for(String arg : args){
            System.out.print(arg);
        }

        int[] ints = new int[0];

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        Outer.Inner inner1 = outer.new Inner();
//        inner.counter = 1;

    }

    public void process(String firstOrder, String... orderIds){
        // validation
    }
}
