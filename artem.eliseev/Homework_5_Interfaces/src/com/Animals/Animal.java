package com.Animals;

/**
 * Created by Anry on 30.07.2015.
 */
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    double kg;

    public double foodWeightPerMonthMethod(double kg) {
        return foodWeightPerDayMethod(kg) * 30;
    }

    abstract double foodWeightPerDayMethod(double kg);
    abstract public String nameOut (String name);

}
