package com.vega.lesson5.main.inheritance;

/**
 * Created by Veg'Zul on 28.07.2015.
 */
public abstract class Employee {
    protected String name;

//    public abstract int work(int hours);

    public int workPerWeek(int hours){
        if(hours > 23){
            throw new IllegalArgumentException("You are crazy!!");
        }
        return workPerDayInternal(hours) - doLaunch();
    }

    public abstract int doLaunch();

    protected abstract int workPerDayInternal(int hours);
}
