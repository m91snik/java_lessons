package com.vega.lesson2.primitiv;

/**
 * Created by Veg'Zul on 16.07.2015.
 */
public class PrimitivesTest {

    public static void main(String[] args) {
        byte bt = 127, bt1 = bt, btX = 0x01;
        short sh = bt, sh1 = 1235, sh2 = 0233;
        int i = 234, i1 = sh, i2 = bt, i3 = 0b101;
        long l = 3232423444434L;

        Double d = (double) 0 / (double) 0;

        double d1 = 0.0d / 0.0d;

        System.out.println(Double.compare(d1, d));

        boolean b4 = false, b5 = true;

        char c1 = 'a';
        char ci = c1;

        System.out.println(c1 - 'c');

        String str = "Hello";
        String world = " world";
        String str1 = world;

        boolean empty = str.isEmpty();

        String newworld = world.concat("!");

        System.out.print(world);

        System.gc();

       // String[] mm=new String[99999999];

        System.out.println((int)l);

        int i4 = 1;

        i4+=2;

        i4=(int)(i4+2); // равны
        i4=i4+2; // не обязательно равны(не эквивалентны)

        boolean bl1 = true, bl2 = false;

        System.out.println(bl1&bl2);
        System.out.println(bl1&&bl2);
        System.out.println(bl2&bl1);
        System.out.println(bl2&&bl1);

        String nul = null;

        System.out.println(nul != null && nul.isEmpty());
    }

}
