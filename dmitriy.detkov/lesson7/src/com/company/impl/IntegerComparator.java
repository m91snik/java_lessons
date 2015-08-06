package com.company.impl;

import com.company.Comparator;

public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
//        if (!(o1 instanceof Integer) && !(o2 instanceof Integer)) {
//            throw new IllegalArgumentException("o1 or o2must be integer");
//        }
//
//        Integer i1 = (Integer) o1;
//        Integer i2 = (Integer) o2;

        return o1.compareTo(o2);
    }

}

