package com.m91snik.lesson11.lambda.recursion;

/**
 * Created by Valentin on 20.08.2015.
 */
public class Main {

    Recursion fact = (i) -> i == 1 ? 1 : i * this.fact.rec(i - 1);

    public static void main(String[] args) {

        System.out.println(new Main().fact.rec(6));
    }
}
