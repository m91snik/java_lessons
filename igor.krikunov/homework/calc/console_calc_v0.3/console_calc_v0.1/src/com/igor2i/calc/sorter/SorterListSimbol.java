package com.igor2i.calc.sorter;

import java.util.ArrayList;

/**
 * Created by igor2i on 19.07.15.
 */
public class SorterListSimbol {

    public static ArrayList<String> sorterListSimbol(String[] arStr) {

        ArrayList<String> outArrayString = new ArrayList<String>();

        for (int i = 0; i < arStr.length; i++) {
            if (!arStr[i].equals("")) {
                if (arStr[i].length() == 1) {
                    outArrayString.add(arStr[i]);
                } else {
                    for (int n = 0; n < arStr[i].length(); n++) {
                        if ('m' == arStr[i].charAt(n) && (n + 7 < arStr[i].length())) {
                            if ("matrix[".equals(arStr[i].substring(n, n + 7))) {
                                outArrayString.add(arStr[i].substring(n, n + 7));
                                n += 6;
                            }
                        } else {
                            char ch1 = arStr[i].charAt(n);
                            String s1 = "" + ch1;
                            outArrayString.add(s1);
                        }
                    }
                }
            }
        }
        return outArrayString;

    }

}
