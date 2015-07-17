package com.m91snik.lesson2.primitives;

/**
 * Created by Valentin on 16.07.2015.
 */
public class PrimitivesTest {

    public static void main(String... args) {
        byte bt = 127, bt1 = bt, btX = 0x23;
        short sh = bt, sh1 = 1235, sh2 = 0233;
        int i = 234, i1 = sh, i2 = bt, i3 = 0b101;
        long l = 345645_64564___________56456L;

        int a = 10;
        int b = 010;

        double d = (double) 0 / (double) 0;
        double d1 = 0.0d / 0.0d;

        System.out.println(d == d1);

        boolean b4 = false, b5 = true;

        char c = 'c';


        int ci = c;

        System.out.print('a');
        System.out.print('\n');
        System.out.print('z' % 'a');

        String str = "hello";

        String s = " world";
        String world = s;
        String str1 = str + world;

        boolean empty = str.isEmpty();

        String concat = s.concat("!");

        System.out.print(s);

        System.gc();

//        String[] mm = new String[99999999];

//        while(true){
//            String str2=new String("dfgdfg");
//            System.out.println(str2);
//        }


        int k = 1;
        boolean j = false;
//        i+=false;

        String nul = null;

        int sss = true ? 0.0 : 0;

        String operation = "/";
        if (operation.equals("+")) {
            //dfgdfgdfgfdg
        } else if (operation.equals("-")) {
            //gdfgdfgfdgdfg
        }

        System.out.println(nul != null && nul.isEmpty());

    }
}
