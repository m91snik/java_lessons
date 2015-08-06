package com.igor2i.lesson7;

import com.igor2i.lesson7.impl.ComparatorImpl;
import com.igor2i.lesson7.impl.MyIntegerCollections;
import com.igor2i.lesson7.impl.MyNumberCollections;

/**
 * Created by igor2i on 04.08.15.
 */
public class Main {

    public static void main(String[] args){

        System.out.println(new ComparatorImpl().comparate(1,2));

        MyNumberCollections myNumberCollections = new MyNumberCollections(new Integer[](1,2,3));

        MyIntegerCollections myIntegerCollections = new MyIntegerCollections(new Integer[](1,2,3));

    }

}
