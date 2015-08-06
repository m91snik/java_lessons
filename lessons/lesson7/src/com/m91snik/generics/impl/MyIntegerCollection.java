package com.m91snik.generics.impl;

import com.m91snik.generics.MyCollection;

/**
 * Created by Valentin on 04.08.2015.
 */
public class MyIntegerCollection extends MyCollection<Integer> {

    public MyIntegerCollection(Integer[] array) {
        super(array);
    }

    @Override
    protected int compare(Integer o1, Integer o2) {
       /// more impl
        return 0;
    }
}
