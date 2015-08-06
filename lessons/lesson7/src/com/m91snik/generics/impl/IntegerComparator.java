package com.m91snik.generics.impl;

import com.m91snik.generics.Comparator;

/**
 * Created by Valentin on 04.08.2015.
 */
public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2)
            throws IllegalArgumentException {
//        if (!(o1 instanceof Integer)
//                || !(o2 instanceof Integer)) {
//            throw new IllegalArgumentException("o1 & o2 must be Integer");
//        }
//        Integer i1 = (Integer) o1;
//        Integer i2 = (Integer) o2;

        return o1.compareTo(o2);

    }
}
