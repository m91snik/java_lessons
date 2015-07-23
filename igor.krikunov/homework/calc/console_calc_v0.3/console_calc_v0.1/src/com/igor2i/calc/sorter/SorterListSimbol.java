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
                } else if(arStr[i].equals("matrix[(")) {
                    outArrayString.add("matrix[");
                    outArrayString.add("(");
                } else if(arStr[i].equals(")]+matrix[(")) {
                    outArrayString.add(")");
                    outArrayString.add("]");
                    outArrayString.add("+");
                    outArrayString.add("matrix[");
                    outArrayString.add("(");
                }else{
                    for (int n = 0; n < arStr[i].length(); n++) {
                        char ch1 = arStr[i].charAt(n);
                        String s1 = "" + ch1;
                        outArrayString.add(s1);
                    }
                }
            }
        }
        return outArrayString;

    }

}
