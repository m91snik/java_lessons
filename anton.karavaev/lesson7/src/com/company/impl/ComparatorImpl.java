package com.company.impl;

import com.company.Comparator;

/**
 * Created by HP on 04.08.2015.
 */
public class ComparatorImpl implements Comparator <Integer> {

    @Override
    public int compare(Integer o1, Integer o2)
                  throws  IllegalArgumentException {
        return o1.compareTo(o2);
    }
        // Оператор instanceof  позволяет нам в RunTime проверяет принадлежность переменной на Integer или другое


}
