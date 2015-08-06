package com.m91snik.generics.impl;

import com.m91snik.generics.MyCollection;

/**
 * Created by Valentin on 04.08.2015.
 */
public class MyLongCollection extends MyCollection<Long> {

    public MyLongCollection(Long[] array) {
        super(array);
    }

    @Override
    protected int compare(Long o1, Long o2) {
        return 0;
    }
}
