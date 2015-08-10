package com.Animals;


/**
 * Created by Anry on 30.07.2015.
 */
public abstract class Animal {
    protected String name;
    protected int idCounter;
    StringBuffer animalTypeBuffer;

    public Animal(int idCounter, String name, StringBuffer animalTypeBuffer) {
        this.name = name;
        this.idCounter = idCounter;
        this.animalTypeBuffer = animalTypeBuffer;
    }

    double kg;

    public double foodWeightPerMonthMethod(double kg) {
        return foodWeightPerDayMethod(kg) * 30;
    }

    abstract double foodWeightPerDayMethod(double kg);

    abstract public String nameOut(String name);

    //    @Override
//    public String toString() {
//        return "id:" + idCounter + ", " + animalTypeBuffer + " " + name + ", " + kg + "kg food every month.\n";
//    }
    abstract public String animalOut();


}