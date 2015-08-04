package com.exception;

/**
 * Created by stanislav on 30.07.15.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(process());
    }

    private static Integer process() {
        Integer i = 0;

        try {
            i++;
            throw new NullPointerException("Just for fun");
        } catch (NullPointerException t) {
            i++;
            return i;
        } finally {
            return i++;
        }
    }
}
