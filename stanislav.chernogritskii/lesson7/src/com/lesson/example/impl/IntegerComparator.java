package com.lesson.example.impl;

import com.lesson.example.Comparator;

/**
 * Created by stanislav on 04.08.15.
 */
public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
//        if (!(o1 instanceof Integer) || !(o2 instanceof Integer)) {
//            throw new IllegalArgumentException("o1 & o2 must be Integer");
//        }
//
//        Integer i1 = (Integer) o1;
//        Integer i2 = (Integer) o2;

        return o1.compareTo(o2);
    }
}
