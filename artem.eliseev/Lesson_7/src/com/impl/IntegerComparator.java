package com.impl;

import com.Comparator;

/**
 * Created by Anry on 04.08.2015.
 */
public class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2)
        throws IllegalArgumentException{
 //       return -1;


//        if (!(o1 instanceof Integer) || !(o2 instanceof Integer)) {
//            throw new IllegalArgumentException("O1, O2 INTEGER!!!");
//        }
//        Integer i1 = (Integer) o1;
//        Integer i2 = (Integer) o2;

//        ����� �� �����
//        return i1-i2;    ����� ����� �� ������� int

//        return i1.compareTo(i2);
        return o1.compareTo(o2);
    }
}
