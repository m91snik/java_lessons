package com.igor2i.calc.sorter;

import java.util.ArrayList;

/**
 * Created by igor2i on 20.07.2015.
 */
public class IndexExists {

    public static boolean indexExists(final ArrayList list, final int index) {
        return index >= 0 && index < list.size();
    }

}
