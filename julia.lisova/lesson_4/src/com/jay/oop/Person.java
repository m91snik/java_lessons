package com.jay.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23.07.2015.
 */
public class Person {

    String name;
    int age;



    {
        System.out.println(name);

    }

    private List validNames = new ArrayList();

    {
        validNames.add("Al");
        validNames.add("Bo");
    }

    private String getDefaultAge(){
        return "18";

    }

    public Person() {
        super();

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;


    }


    public static void main(String[] args) {
        Person person = new Person("sdf", 5);
        System.out.println(person.age);
    }
}
