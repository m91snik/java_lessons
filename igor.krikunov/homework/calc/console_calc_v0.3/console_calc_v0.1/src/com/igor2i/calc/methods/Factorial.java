package com.igor2i.calc.methods;

/**
 * Created by igor2i on 17.07.2015.
 */
public class Factorial {
    public static double factorial(double d1){
        if(d1 == 0){
            return 1;
        }
        return d1 * factorial(d1 - 1);
    }
}
