package com.igor2i.lesson10.serilization;

import java.io.Serializable;

/**
 * Created by igor2i on 18.08.15.
 */
public class Person implements Serializable {
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passwd='" + passwd + '\'' +
                '}';
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    private transient String passwd;

    private int age;

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

    private String name;


}
