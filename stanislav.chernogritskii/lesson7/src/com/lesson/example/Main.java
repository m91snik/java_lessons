package com.lesson.example;

import com.lesson.example.impl.IntegerComparator;
import com.lesson.example.impl.PersonAgeComparator;

/**
 * Created by stanislav on 04.08.15.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(new IntegerComparator().compare(1,1));

        Person p1 = new Person();
        p1.age = 24;

        Person p2 = new Person();
        p2.age = 26;

        System.out.println(new PersonAgeComparator().compare(p1, p2));
    }
}
