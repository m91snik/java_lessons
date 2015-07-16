package com.mg.lesson2.primitives;

import java.net.SocketPermission;

public class PrimitivesTest {
    public static void main(String[] args) {
        byte bt1 = 127, btx = 0x44;
        short sh1 = 123;
        int i1 = sh1, i2 = 0b1001;
        long l1 = 111321111111111111L;

        float f = 13;
        double d = 13.D;

        double d1 = (double)0/(double)0;
        double d2 = 0.0D / 0.0D;
        System.out.print(Double.compare(d1, d2));

        boolean b = false;

        char c1 = 'a';
        char c2 = 'b';
        System.out.print(c1 + c2);

    }
}
