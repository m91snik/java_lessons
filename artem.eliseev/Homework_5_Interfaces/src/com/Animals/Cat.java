package com.Animals;

/**
 * Created by Anry on 30.07.2015.
 */
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public double foodWeightPerDayMethod(double kg) {
        kg = 0.2;

        return kg;
    }

    @Override
    public String nameOut(String name) {
        System.out.println("Your cat's name is " + super.name);
        return name;
    }

}
