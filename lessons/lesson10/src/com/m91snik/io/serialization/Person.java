package com.m91snik.io.serialization;

import java.io.Serializable;

/**
 * Created by Valentin on 18.08.2015.
 */
public class Person implements Serializable {

    public static final long serialVersionUID = 2L;

    public static int counter = 0;

    private String name;
    private long age;
    private transient String password;

    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Person(String name, int age, String password) {
        counter++;
        if (age < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", weight=" + weight +
                '}';
    }

    public int getCounter() {
        return counter;
    }
}
