package com.vega.lesson5.main.inheritance;

/**
 * Created by Veg'Zul on 28.07.2015.
 */
public class Engineer extends Employee {

    public Engineer(String name) {
    }

    @Override
    protected  int workPerDayInternal(int hours){
        String name="";

        System.out.println("i'm working"+super.name);

        return hours /2;
    }

    @Override
    public int doLaunch(){
        return 24;
    }
}
