package com.igor2i.lesson4;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by igor2i on 23.07.15.
 */
public class Person {

    String name = "def";
    int age;



    public Person() {
        super();
    }

    public Person(String name) {
        this.name = name;
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("igor", 22);
        System.out.println(person.name + "  " + person.age);

    }
}
