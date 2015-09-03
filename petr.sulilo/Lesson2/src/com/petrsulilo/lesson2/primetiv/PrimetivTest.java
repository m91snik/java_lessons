package com.petrsulilo.lesson2.primetiv;

/**
 * Created by Petr on 16.07.2015.
 */
public class PrimetivTest {
    public static void main(String... args) {
        byte bt = 127, bt1 = bt;
        short sh = bt, sh1 = 1235, sh2 = 0233;
        int i = 234, i1 = sh, i2 = bt;
        long l = 12312321123_______13L;
        l = (int)i;

        Double d = (double) 0 / (double) 0;
        Double d1 = 0.0d / 0.0d;

        boolean b4 = true;

        char c1 = 'a';
        int ci = c1;

        System.out.println('a');
        System.out.println('\n');
        System.out.println('b' / 'e');

        String str = "hello";

        String s = " world";
        String world = " world";
        String str1  = str + world;
        // alt +ctrl+v
        // alt +ctrl+enter

        boolean empty = str.isEmpty();

        String concat  =  s.concat("!");
        System.out.println(s);

        String nul = null;
        String operation = "/";
        if(operation.equals("+"))
        {}
        System.out.println(nul);

    }
}
