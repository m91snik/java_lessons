package com.gorbachevskaya.lambda.Recursion;

/**
 * Created by Ангелина on 20.08.2015.
 */
public class Main {

    Recursion fact = (i) -> i == 1 ? 1 : i * this.fact.rec(i - 1);

    public static void main(String[] args) {
//        Recursion fact = (r, i) -> i == 1 ? 1 : i * r.rec(r, i - 1);

        System.out.println(new Main().fact.rec(6));
    }

}
