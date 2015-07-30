package com.Animals;

/**
 * Created by Anry on 30.07.2015.
 */
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public double foodWeightPerDayMethod(double kg) {
        kg = 0.5;
        return kg;
    }

    @Override
    public String nameOut(String name) {
        System.out.println("Your dog's name is " + super.name);
        return name;
    }
}
