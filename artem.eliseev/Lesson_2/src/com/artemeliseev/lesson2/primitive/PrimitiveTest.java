package com.artemeliseev.lesson2.primitive;

/**
 * Created by Anry on 16.07.2015.
 */
public class PrimitiveTest {
    public static void main(String... args) {
        byte bt = 127, bt1 = -128, btX = 0x23; //��������� 16����
        short sh = bt, sh1 = 1235, sh2 = 0233; //��������� 8����
        int i = 234, i1 = sh;
        long l = 324_523_462_3623456236L;

        // � ������� ������

        double d = (double) 0 / (double) 0;
        double d1 = 0.0d / 0.0d;

        System.out.println(d == d1);
        System.out.println(Double.compare(d, d1));

        boolean b4 = false, b5 = true; // �� 1 � 0

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

        //       s.concat ("!"); �� ��������� �������� � �������, ��������� �����
        String concat = s.concat("!");
        System.out.println(s);

        System.gc(); //����� ������

        int k = 1;

        //��� �����,���� ��� ������ (int) - �� �� �����
        k += 2.0;
        i = (int) (k + 2.0);
        // i+=false - ������

       // String nul = null;
       // System.out.println(nul.isEmpty());
       // ������

String nul = null;
 System.out.println(nul !=null && nul.isEmpty());

        String str=nul!=null ? (!nul.isEmpty () ?"not empty" : "empty");







    }
}
