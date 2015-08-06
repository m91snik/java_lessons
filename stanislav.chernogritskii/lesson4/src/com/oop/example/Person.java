package com.oop.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav on 23.07.15.
 */
public class Person {

    String name = "default";
    int age;

    private List validNames = new ArrayList();

    {
        // блок инициализации
        System.out.println(name);
        age = getDefaultAge();
//        validNames.add("ALice");
//        validNames.add("Bob");
        //.....
    }

    static int counter = 0;

    static int getCounter() {
        return counter;
    }

    static {
        for (int i = 0; i< 10; i++) {
            counter++;
        }
    }

    private int getDefaultAge() {
        return 18;
    }

    public Person() {
        super();
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        Person person = new Person("2324",0);
        System.out.println(person.age);
    }
}
