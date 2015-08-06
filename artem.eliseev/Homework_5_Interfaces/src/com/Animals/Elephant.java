package com.Animals;

/**
 * Created by Anry on 30.07.2015.
 */
public class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public double foodWeightPerDayMethod(double kg) {
        kg = 50;
        return kg;
    }

    @Override
    public String nameOut(String name) {
        System.out.println("Your elephan's name is " + super.name + ".");
        return name;
    }
}
