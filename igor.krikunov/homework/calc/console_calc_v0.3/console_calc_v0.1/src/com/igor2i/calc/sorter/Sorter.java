package com.igor2i.calc.sorter;

import java.util.ArrayList;

/**
 * Created by igor2i on 18.07.15.
 */
public class Sorter {
    public static String[][] sorter(String out1) {

        if (out1.equals("exit")) {
            String out[][] = new String[1][1];
            out[0][0] = out1;
            return out;
        }

        String outNumbers[];

        String pattern2 = "[+|-]|[*|/]|[!|\\^]|[(|)]|(matrix\\[)|(\\])|(;)";
        outNumbers = out1.split(pattern2);


        //outNumbers -- массив, только цифры

        String outSimbol[];

        String pattern3 = "[0-9]|[.|,]|[\\s]";
        outSimbol = out1.split(pattern3);


        //замена запятой на точку, в числах с плавающей точкой
        for (int i = 0; i < outNumbers.length; i++) {
            outNumbers[i] = outNumbers[i].replace(",", ".");
        }


        return new String[][]{outNumbers, outSimbol};
    }
}
