package com.m91snik.generics.impl;

import com.m91snik.generics.MyCollection;

/**
 * Created by Valentin on 04.08.2015.
 */
public class MyNumberCollection extends MyCollection<Number> {

    public MyNumberCollection(Number[] array) {
        super(array);
    }

    @Override
    protected int compare(Number o1, Number o2) {
        return 0;
    }
}
