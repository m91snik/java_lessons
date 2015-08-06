package com.oop.example;

/**
 * Created by stanislav on 28.07.15.
 */
public class A {

    static class B {

    }

    public class C {
        public int counter = calc(10);

        public C() {
        }

        public C(int counter) {
            this.counter = counter;
        }
    }

    private int outerCounter;

    private int calc(int i) {
        return i * 10;
    }
}
