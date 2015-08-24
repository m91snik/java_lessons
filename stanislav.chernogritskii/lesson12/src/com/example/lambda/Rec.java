package com.example.lambda;

/**
 * Created by stanislav on 20.08.15.
 */
public class Rec {

    Recursion fact = (i) -> i == 1 ? 1 : i * this.fact.rec(i - 1);

    public static void main(String[] args) {

        System.out.println(new Rec().fact.rec(6));
    }
}
