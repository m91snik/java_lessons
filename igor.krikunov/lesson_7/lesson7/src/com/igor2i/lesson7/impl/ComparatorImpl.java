package com.igor2i.lesson7.impl;

import com.igor2i.lesson7.Comparator;

/**
 * Created by igor2i on 04.08.15.
 */
public class ComparatorImpl implements Comparator<Integer> {

    /**
     * @param o1
     * @param o2
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public int comparate(Integer o1, Integer o2) {
//
//        if (!(o1 instanceof Integer) || !(o2 instanceof Integer)) {
//            throw new IllegalArgumentException("o1 & o2 must be Integer");
//
//        }
//
//        Integer i1 = (Integer)o1;
//        Integer i2 = (Integer)o2;


        return o1.compareTo(o2);

    }


}
