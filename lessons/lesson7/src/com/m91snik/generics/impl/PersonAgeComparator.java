package com.m91snik.generics.impl;

import com.m91snik.generics.Comparator;
import com.m91snik.generics.Person;

/**
 * Created by Valentin on 04.08.2015.
 */
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2)
            throws IllegalArgumentException {

        return Integer.compare(o1.age, o2.age);

    }
}
