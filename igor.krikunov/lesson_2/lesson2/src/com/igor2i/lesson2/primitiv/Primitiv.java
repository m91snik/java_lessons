package com.igor2i.lesson2.primitiv;

/**
 * Created by igor2i on 16.07.15.
 */
public class Primitiv {
    private static void primitiv() {
        byte b1 = 127, b2 = -128; // 0x321 - 16hex system
        short sh1 = b1, sh2 = 1288; //0321 - 8 system
        int in1 = sh2, in2 = 89392;
        long l1 = in2;
        long l2 = 7_823_648_638_746_726L;

        //float fl1 = 3.14;
        double d1 = 1.13;

        double d4 = 0d / 0d;
        double d2 = (double) 0 / (double) 0;

        System.out.println(d1 + " " + d2);

        boolean bo1 = false, bo2 = true;

        char ch1 = 'c';
        int c1 = ch1;

        System.out.println(c1 - 'a');
        System.out.println((int) 'A' + " " + (int) 'Z' + " " + " " + (int) 'a');
        System.out.println('b' + "\t" + 'a');

        long int123 = 83213;

        int int321 = (int) int123;

        int i = 1;


        int in31 = (i + 2);

        i += 2.0;

        System.out.println(i == in31);

        boolean bb = true, bv = false;
        String nul = null;
        System.out.println(nul != null && nul.isEmpty());

        String st132 = nul != null ? (!nul.isEmpty() ? "not empty" : "emty") : "null";

        System.out.println(st132);

        System.out.close(); //вот оно как

    }

    public static void getPrimitiv() {
        primitiv();
    }
}
