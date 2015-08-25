package com.m91snik.lesson5;

/**
 * Created by Valentin on 28.07.2015.
 */
public class Outer {
    public class Inner {
        public class Inner1 {}

        public int counter = calc(10);


        public Inner() {
        }


        public Inner(int counter) {
            this.counter = counter;
        }
    }

    private int outerCounter;

    private int calc(int i) {
        return i * 10;
    }
}
