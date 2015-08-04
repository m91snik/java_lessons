package com.oop.example.inheritance;

/**
 * Created by stanislav on 28.07.15.
 */
public abstract class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public int workPerDay(int hours) {
        if(hours > 23) {
            throw new IllegalArgumentException("You are crazy");
        }

        return workPerDayInternal(hours);
    }

    protected abstract int workPerDayInternal(int hours);
}
