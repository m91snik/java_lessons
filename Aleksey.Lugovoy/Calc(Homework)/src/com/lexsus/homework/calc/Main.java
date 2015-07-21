package com.lexsus.homework.calc;

import java.io.IOException;

/**
 * Created by LugovoyAV on 20.07.2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Enter first number:");
        byte text[] = new byte[10];
        System.in.read(text);
        String str = new String(text,"UTF-8");
        double a =  Double.parseDouble(str);

        System.out.println("Enter second number:");
        text = new byte[10];
        System.in.read(text);
        str = new String(text,"UTF-8");
        double b =  Double.parseDouble(str);



        System.out.println("Enter operation:");
        text = new byte[1];
        System.in.read(text);
        String  operator = new String(text,"UTF-8");
        Double res;

        switch (operator){
            case "+":
                System.out.println("Result: "+ (a+b));
                break;
            case "-":
                System.out.println("Result: "+ (a-b));
                break;
            case "/":
                System.out.println("Result: "+ (a/b));
                break;
            case "*":
                System.out.println("Result: "+ (a*b));
                break;
            default:
                System.out.println("Operation not supported");
        }

    }
}
