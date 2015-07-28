package com.stanislav.matrixcalc;

import java.util.Scanner;

/**
 * Created by stanislav on 28.07.15.
 */
public class Input {

    public static int returnInt() {
        Scanner sc = new Scanner(System.in);

        return sc.nextInt();
    }

    public static Double returnDouble() {
        Scanner sc = new Scanner(System.in);

        return sc.nextDouble();
    }

    public static String returnString() {
        Scanner sc = new Scanner(System.in);

        return sc.next();
    }
}
