package com.igor2i.calc.sorter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by igor2i on 19.07.15.
 */
public class SorterListDouble {
    public static ArrayList<Double> sorterListDouble(String[] arDoub){

        ArrayList<Double> outArrayDoub = new ArrayList<Double>();

        for (int i = 0; i < arDoub.length; i++) {
            if (!arDoub[i].equals("")) {
                outArrayDoub.add(Double.parseDouble(arDoub[i]));
            }
        }

        return outArrayDoub;
    }
}
