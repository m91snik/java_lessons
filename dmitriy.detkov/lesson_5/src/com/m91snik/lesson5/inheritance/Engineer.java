package com.m91snik.lesson5.inheritance;

/**
 * Created by Valentin on 28.07.2015.
 */
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    @Override
    protected int workPerDayInternal(int hours) {
        // work hard!!!

        String name = "";

        System.out.println("I'm working " + super.name);

        return hours / 2;
    }
}
