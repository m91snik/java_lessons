package com.jay.lesson2.primitive;

/**
 * Copyright DonRiver Inc. All Rights Reserved.
 * Created by Julia Lisova
 * Created on 14.07.2015.
 */
public class Primitive {

    public static void main(String[] args) {
        //Double d;

        byte bt = 127;

        double d = (double) 0 / (double) 0;

        double d2 = 0.0d / 0;

        System.out.println(Double.compare(d, d2));

        boolean b = false, b5 = true;

        char c = 'e';
        //char c2= bt;
        int ci = c;

        System.out.print('a');
        System.out.print('\n');
        System.out.println('z' % 'a');

        String str = "Hello";

        final String s = "world";
        final String world = s;
        String str1 = str + world;

        final boolean empty = str.isEmpty();

        //str = "ab";

        String concat = s.concat("!");

        System.out.println(s);

        System.gc();

        //String[] str2 = new String[99999999];


        boolean b1 = true, b2 = false;

        // b1 & b2 = true;

        String nul = null;
        System.out.print(nul != null && nul.isEmpty());

//        while (true) {
//
//            String str3 = new String("dsf");
//            System.out.println(str);
//        }

//        int qwer = 1;
//
//        qwer += 2.0;


    }


}
