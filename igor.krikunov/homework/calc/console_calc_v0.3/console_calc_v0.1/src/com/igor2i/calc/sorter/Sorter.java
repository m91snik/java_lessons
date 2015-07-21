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

        String pattern2 = "[+|-]|[*|/]|[!|\\^]";
        outNumbers = out1.split(pattern2);


        //outNumbers -- массив, только цифры

        String out3[];

        String pattern3 = "[0-9]|[.|,]|[\\s]";
        out3 = out1.split(pattern3);


        ArrayList<String> outSimbolList = new ArrayList<String>();

        for (int i = 0; i < out3.length; i++) {
            if (!out3[i].equals("")) {
                outSimbolList.add(out3[i]);
            }
        }

        //плюшка для любителей разделять числа с плавающей точкой - запятой
        for (int i = 0; i < outNumbers.length; i++) {
            outNumbers[i] = outNumbers[i].replace(",", ".");
        }


        String[] outSimbol;
        outSimbol = outSimbolList.toArray(new String[outSimbolList.size()]);


        return new String[][]{outNumbers, outSimbol};
    }
}
