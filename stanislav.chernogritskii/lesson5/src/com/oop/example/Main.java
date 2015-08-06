package com.oop.example;

/**
 * Created by stanislav on 28.07.15.
 */
public class Main {

    public static void main(String[] args) {

        for(String arg : args) {
            System.out.println(arg);
        }

        A.B b = new A.B();

        A.C c = new A().new C();
        c.counter = 1;
    }

    public void process(String firstOrder, String... orderIds) {
        // значит, что в метод нужно передать как минимум один аргумент
    }
}
