package com.stas9005.lesson2.primitives;

/**
 * Created by stanislav on 16.07.15.
 */
public class PrimitivesTest {

    public static void main(String[] args) {

        byte bt = 127, bt1 = bt, btX = 0x24;
        short sh = bt, sh1 = 1235, sh2 = 0233;
        int i = 234, i1 = sh, i2 = bt, i3 = 0b101;
        long l = 234234_2423423L;

        double d = (double) 0 / (double) 0;

        double d1 = 0.0d / 0.0d;

        System.out.println(Double.compare(d, d1));

        boolean b = false, b1 = true;

        char c = 'c';
        int ci = c;

        System.out.println(c - 'a' + 'd');
        System.out.print('\t');
        System.out.println('\u0555');

        String str = "Hello";
        String s = " world";
        String world = s;
        String str1 = str + world;

        boolean empty = str.isEmpty();

        System.out.println(empty);

        String sub = s.substring(3);

        String concat = s.concat("!");

        System.out.println(sub);
        System.out.println(concat);

        System.gc();

        int i5 = 1;
        i5 += 2;
        i5 = (int)(i5 + 2);

        boolean b3 = true, b4 = false;

        System.out.println(b3 && b4);

        String nul = null;
        System.out.println(nul != null && nul.isEmpty());
    }

}
