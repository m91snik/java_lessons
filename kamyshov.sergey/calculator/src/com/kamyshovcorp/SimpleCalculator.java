package com.kamyshovcorp;

import java.io.IOException;
import java.util.Scanner;

/**
 * Home work: реализовать консольный калькулятор  (операции +, -, *, /, битовые; форматированный вывод на консоль)
 *
 * @author kamyshov.sergey
 * @since 18.07.2015
 */

public class SimpleCalculator {

    public static void main(String[] args) throws IOException {
        System.out.println("Программа \"Консольный калькулятор\"");
        System.out.println("Поддерживаемые операции: сложение (+), вычитание (-), умножение (*) и деление (/)");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите знак операции: ");
        String operation = scanner.nextLine();
        System.out.print("Введите первое число: ");
        double valueOne = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double valueTwo = scanner.nextDouble();

        if (operation.equals("+")) {
            System.out.println("Результат операции сложение: " + (valueOne + valueTwo));
        } else if (operation.equals("-")) {
            System.out.println("Результат операции вычитание: " + (valueOne - valueTwo));
        } else if (operation.equals("*")) {
            System.out.println("Результат операции умножение: " + (valueOne * valueTwo));
        } else if (operation.equals("/")) {
            System.out.println("Результат операции деление: " + (valueOne / valueTwo));
        } else {
            System.out.println("Извините, но операция \"" + operation + "\" не поддерживается.");
        }
    }
}
