package com.m91snik.generics;

import com.m91snik.generics.impl.MyIntegerCollection;
import com.m91snik.generics.impl.MyLongCollection;
import com.m91snik.generics.impl.MyNumberCollection;

/**
 * Created by Valentin on 04.08.2015.
 */
public class Main {

    public static void main(String[] args) {
        MyIntegerCollection myIntegerCollection =
                new MyIntegerCollection(new Integer[]{1, 2, 3});

        MyLongCollection myLongCollection =
                new MyLongCollection(new Long[]{1L, 2L, 3L});

        MyNumberCollection myNumberCollection =
                new MyNumberCollection(new Long[]{1L, 2L, 3L});

        myNumberCollection.compareTo(myIntegerCollection);
    }
}
