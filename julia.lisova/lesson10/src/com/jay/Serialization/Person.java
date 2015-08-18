package com.jay.Serialization;

import java.io.Serializable;

/**
 * Created by User on 18.08.2015.
 */
public class Person implements Serializable {

    private String name;
    private int age;

    public String getPassword() {
        return password;
    }

    public void setPassword(String a) {
        this.password = a;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private transient String password;
}
