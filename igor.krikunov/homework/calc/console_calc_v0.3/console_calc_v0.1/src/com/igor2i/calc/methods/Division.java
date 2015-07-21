package com.igor2i.calc.methods;

/**
 * Created by igor2i on 17.07.2015.
 */
public class Division {
    public static double division(double d1, double d2) {
        double out;
        if (d2 == 0) {
            System.out.println("Нельзя делить на ноль!");
            return 0;
        }
        out = d1 / d2;

        return out;
    }
}
