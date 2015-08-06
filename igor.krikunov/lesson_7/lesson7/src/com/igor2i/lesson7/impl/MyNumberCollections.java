package com.igor2i.lesson7.impl;

import com.igor2i.lesson7.MyCollections;

/**
 * Created by igor2i on 04.08.15.
 */
public class MyNumberCollections extends MyCollections<Number> {

    public MyNumberCollections(Number[] array) {
        super(array);
    }

    @Override
    public int compare(Number o1, Number o2) {
        return 0;
    }


}
