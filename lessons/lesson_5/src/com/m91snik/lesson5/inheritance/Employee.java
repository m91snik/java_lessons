package com.m91snik.lesson5.inheritance;

/**
 * Created by Valentin on 28.07.2015.
 */
public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public int workPerDay(int hours) {
        if (hours > 23) {
            throw new IllegalArgumentException("You are crazy!!");
        }
        // a lot of code
        return workPerDayInternal(hours) - doLaunch();
    }

    private int doLaunch() {
        return 1;
    }

    protected abstract int workPerDayInternal(int hours);

}
