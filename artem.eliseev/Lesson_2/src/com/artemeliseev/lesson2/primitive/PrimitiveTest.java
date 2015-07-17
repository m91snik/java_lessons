package com.artemeliseev.lesson2.primitive;

/**
 * Created by Anry on 16.07.2015.
 */
public class PrimitiveTest {
    public static void main(String... args) {
        byte bt = 127, bt1 = -128, btX = 0x23; //последний 16ричн
        short sh = bt, sh1 = 1235, sh2 = 0233; //последний 8ричн
        int i = 234, i1 = sh;
        long l = 324_523_462_3623456236L;

        // с плавающ точкой

        double d = (double) 0 / (double) 0;
        double d1 = 0.0d / 0.0d;

        System.out.println(d == d1);
        System.out.println(Double.compare(d, d1));

        boolean b4 = false, b5 = true; // не 1 и 0

        char c = 'c';
        int ci = c;

        System.out.println(ci);
        System.out.println(c - 'a');

        System.out.print('a');
        System.out.print('\n');
        System.out.println('b');
        System.out.print('b' + '\t' + 'a');

        String str = "hello";
        boolean empty = str.isEmpty();
        String world = "world";
        String str1 = str + world;
        String s = "teretereter";

        //       s.concat ("!"); Не получится добавить в текущую, создастся новая
        String concat = s.concat("!");
        System.out.println(s);

        System.gc(); //сборщ мусора

        int k = 1;

        //эти равны,если без скобки (int) - то не равны
        k += 2.0;
        i = (int) (k + 2.0);
        // i+=false - ошибка

       // String nul = null;
       // System.out.println(nul.isEmpty());
       // ошибка

String nul = null;
 System.out.println(nul !=null && nul.isEmpty());

        String str=nul!=null ? (!nul.isEmpty () ?"not empty" : "empty");







    }
}
