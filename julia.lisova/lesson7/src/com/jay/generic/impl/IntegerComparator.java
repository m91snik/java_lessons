package com.jay.generic.impl;

import com.jay.generic.Comparator;

import java.util.Objects;

/**
 * Created by User on 04.08.2015.
 */
public class IntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
//        if(!(o1 instanceof Integer)
//                || !(o2 instanceof Integer)){
//            throw new IllegalArgumentException("sdf");
//        }
//
//        Integer i1 = (Integer) o1;
//        Integer i2 = (Integer) o2;

        return o1.compareTo(o2);
    }
}
