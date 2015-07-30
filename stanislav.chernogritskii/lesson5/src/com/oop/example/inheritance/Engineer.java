package com.oop.example.inheritance;

/**
 * Created by stanislav on 28.07.15.
 */
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    protected int workPerDayInternal(int hours) {
        // work hard!!!

        System.out.println(super.name);

        return hours / 2;
    }
}
