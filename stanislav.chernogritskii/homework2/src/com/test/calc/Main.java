package com.test.calc;

import java.util.Scanner;

/**
 * Created by stanislav on 20.07.15.
 * Simple calculator
 */

public class Main {

    public static void main(String[] args) {

        char answer = handler();

        for (;;) {
            if (answer == 'n') {
                System.exit(0);
            } else if (answer == 'y') {
                answer = handler();
            } else {
                System.out.println("Unknown option");
                System.exit(0);
            }
        }
    }

    public static char handler() {

        char action, answer;
        double num1, num2, result;

        num1 = getNumber(1);

        System.out.print("Введите действие: ");
        try {
            action = (char) System.in.read();
        }
        catch (Exception e) {
            action = '0';
            System.out.println("Not a char symbol!");
        }

        if (action != '*' && action != '+' && action != '/' && action != '-') {
            System.exit(0);
        }

        num2 = getNumber(2);

        switch(action) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                result = 0;
                break;
        }

        System.out.println("-----------------------------");
        System.out.print((int) num1 + " " + action + " " + (int) num2 + " = ");

        if (result % 1 == 0) {
            int total_result = (int) result;
            System.out.println(total_result);
        } else {
            System.out.format("%.2f%n", result);
        }

        System.out.print("Выполнить еще одну операцию? [y/n] ");

        try {
            answer = (char) System.in.read();
        }
        catch (Exception e) {
            System.out.println("Not a correct answer!");
            answer = 'n';
        }

        return answer;
    }

    public static double getNumber(int c) {

        double number;

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите " + (c == 1 ? "первое" : "второе") + " число: ");

        try {
            number = sc.nextDouble();
        }
        catch (Exception e) {
            number = 0.0;
            System.out.println("Not a number!");
            System.exit(0);
        }

        return number;
    }
}
