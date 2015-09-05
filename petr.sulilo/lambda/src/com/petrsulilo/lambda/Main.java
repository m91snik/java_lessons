package com.petrsulilo.lambda;

/**
 * Created by Petr on 20.08.2015.
 */
public class Main {

    public static  void main(String... args)
    {
        calculatyr summator = (i,j) -> i + j;

        System.out.println(summator.calc(10,20));
    }
}
