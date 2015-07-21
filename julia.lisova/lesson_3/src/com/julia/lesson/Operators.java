package com.julia.lesson;

import sun.java2d.ScreenUpdateManager;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by User on 21.07.2015.
 */
public class Operators {

    public static void main(String[] args) throws NoSuchFieldException {
//        int var = 5;
//        switch (var) {
//            case 5:
//                var++;
//        }
//
//        //int goto = 1;
//
//        for (float f = 2, i = 0; f < 100; f--) {
//        }

        Message message = new Message();
        //Annotation[] annotations = message.getClass().getDeclaredField("text").getAnnotation(MessageInfo.class);

        //System.out.println(Arrays.toString(annotations));

        System.out.println(CardType.VI.ordinal() == 0);


        System.out.println("dfdsfsdf");

        int[][] mas = new int[10][5];
        System.out.println(Arrays.deepToString(mas));

        for (int i = 0; i < mas.length; i++) {
            int[] ma = mas[i];
            ma[0] = 1;
            System.out.println("1");
        }

        mainFor:
        for (int i = 0; i < mas.length; i++) {

            boolean flag = false;
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = i + j;

                if((i+j) %2 == 0){
                    break mainFor;



            }

        }


//        for (; ; ) {
//        }

//        for (int d = 1; d < 4; ) {
//            d += 2;
//        }
//
//        for (Scanner scanner = new Scanner(System.in); scanner.hasNext(); ) {
//            scanner.next();
//        }


//        for (:){
//
//        }


    }

}}
