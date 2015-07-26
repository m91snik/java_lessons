package com.vega.lesson.main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Veg'Zul on 23.07.2015.
 */
public class Person {

    String name;
    int age;

    static int counter = 0;

    static{
        counter++;
    }

    private List validNames = new ArrayList();
    {
        validNames.add("Alice");
        validNames.add("Bob");
    }

//    public Person(){
//        super();
//    }

    {
        System.out.println(name);
        age = getDefaultAge();
    }

    private int getDefaultAge(){
        return 16;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("this",22);
        System.out.print(person.age);
    }

}
