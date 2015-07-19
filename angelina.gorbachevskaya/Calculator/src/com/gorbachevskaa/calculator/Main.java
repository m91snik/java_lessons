package com.gorbachevskaa.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your task: ");
        c.setExpression(sc.nextLine());
        c.calculate();
        c.printCondition();
    }

}
