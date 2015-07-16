package com.igor2i.lesson2.ssilki;

/**
 * Created by igor2i on 16.07.15.
 */
public class Ssilki {
    private static void ssilki() {


        String str = "Hello";

        String world = "world";
        String str1 = str + world;


        boolean strEmpty = str.isEmpty();

        System.out.println(str1);

        String concat = str1.concat("!");

        System.out.println(concat);

        System.gc();

    }

    public static void getSsilki() {
        ssilki();
    }
}
