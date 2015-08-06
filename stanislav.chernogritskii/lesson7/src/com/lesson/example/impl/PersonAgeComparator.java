package com.lesson.example.impl;

import com.lesson.example.Comparator;
import com.lesson.example.Person;

/**
 * Created by stanislav on 04.08.15.
 */
public class PersonAgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.age, o2.age);
    }
}
