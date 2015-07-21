package com.lessons.lesson2;

import java.io.IOException;

/**
 * Created by Sasha on 20.07.2015.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        calc.readCommand();
        calc.executeCommand();
        System.out.println("end");
    }
}
