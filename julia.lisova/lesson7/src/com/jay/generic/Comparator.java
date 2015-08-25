package com.jay.generic;

import java.util.Objects;

/**
 * Created by User on 04.08.2015.
 */
public interface Comparator<T> {

    int compare (T o1, T o2);
}
