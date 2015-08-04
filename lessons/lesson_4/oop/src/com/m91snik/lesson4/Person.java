package com.m91snik.lesson4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valentin on 23.07.2015.
 */
public class Person {

    //TODO: rename name to dfgdfgdfg
    String name = "default";
    int age;

    static int counter;

    static {
        for (int i = 0; i < 10; i++) {
            counter++;
        }
        System.out.println(counter);
    }

    private List validNames = new ArrayList();

    {
        validNames.add("Alice");
        validNames.add("Bob");
        //....
    }

    private int getDefaultAge() {
        return 18;
    }

    //    todo: remove it
    public Person(String name) {
        // code
       this.name=name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    int getCounter() {
        return counter;
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Person person = new Person("gdfgdg", 4);
//        System.out.println(person.age);

        Class<?> aClass = Class.forName("com.m91snik.lesson4.Person");
//        Person p = (Person) aClass.newInstance();

    }
}

class BB{}
