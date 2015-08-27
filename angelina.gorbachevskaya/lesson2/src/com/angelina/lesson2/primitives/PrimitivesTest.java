package com.angelina.lesson2.primitives;
import java.util.Scanner;

/**
 * Created by Ангелина on 16.07.2015.
 */

public class PrimitivesTest {
    public static void main(String... args) {
        byte bt = 127, bt1 = bt; // так позволяет селать язык, но так делать не нужно!
        short sh = bt, sh1 = 5678;
        int i1 = 234, i2 = sh;
        long l = 456789875456L; // в конце надо ставить букву l, можно и ббольшую. И лучше большую, т к маленькая кажется 1цифрой один
        byte b = 0x23;
        sh = 03456;
        l = 123_123_________________6;

        double d = (double) 0 / (double) 0;
        double d1 = 0.0d / 0.0d;


        System.out.println(Double.compare(d, d1));

        boolean b1 = false, b2;

        char c1 = 'a';
        int ci = c1;
        System.out.print('b');
        System.out.print('\n');
        System.out.println('k' + '\t' + 'e');

        String str = "Hello";
        String world = "world";
        String str1 = str + world + "!";

        boolean strEmpty = str.isEmpty();

        String sub = str.substring(1, 3);

        System.out.println(sub);

        System.gc();

        String[] str2 = new String[999];
//        while (true) {
//            String str11 = new String("AbcdE");
//            System.out.println(str11);
//        }

        int t = (int)l;

        int i = 1;
        i += 2;
        i = i + 2;          // это не эквивалентно i+=2;
        i = (int)(i + 2);   // а это эквивалентно i+=2;

        // тут более понятнее
        // i+=2.0
        // i=(int)(i+2.0)

        String nul=null;

        System.out.println(nul != null && nul.isEmpty());

        b1 = true;
        b2 = false;

        byte bb[] = new byte[10];

        Scanner sc = new Scanner(System.in);
        double a,c;
        a = sc.nextInt();
        c = sc.nextDouble();
        System.out.println(a+c);

    }
}
