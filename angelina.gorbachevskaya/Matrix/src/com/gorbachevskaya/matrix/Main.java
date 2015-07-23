package com.gorbachevskaya.matrix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Matrix m = new Matrix();
        m.in();
        m.print();

        Matrix m2 = new Matrix();
        m2.in();
        m2.print();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter operation: ");
        String str = sc.next();

        MatrxCalc mc = new MatrxCalc(m, m2, str);

        mc.calculate();
        mc.getResult().print();

    }
}
