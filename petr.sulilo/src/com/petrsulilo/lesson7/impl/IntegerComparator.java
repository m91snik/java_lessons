package com.petrsulilo.lesson7.impl;

import com.petrsulilo.lesson7.Comparator;

/**
 * Created by Petr on 04.08.2015.
 */
public class IntegerComparator implements Comparator {
    @Override
    public int compare(Integer o1, Integer o2)
    {
    //    if (!(o1 instanceof Integer)
    //            || !(o2 instanceof Integer)) {
    //        throw new IllegalArgumentException("SSSsssSSS");
    //    }
    //    Integer i1 = (Integer) o1;
    //    Integer i2 = (Integer) o2;

        return  o1.compareTo(o2);

    }
}
