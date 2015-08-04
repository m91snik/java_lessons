package com;

/**
 * Created by Anry on 30.07.2015.
 */

import com.Animals.Animal;
import com.Animals.Cat;
import com.Animals.Dog;
import com.Animals.Elephant;


public abstract class Main {
    public static void main(String... args) {
        Animal animal;
        String name = "";
        StringBuffer animalTypeBuffer = new StringBuffer();
        String animalType = new StringBuffer(InterfaceClass.inputAnimalTypeMethod(animalTypeBuffer)).toString();

        String CAT = "cat", DOG = "dog", ELEPHANT = "elephant";
        animal = animalTypeMethod(name, animalType, CAT, DOG, ELEPHANT);
        animal.nameOut(name);

        double kg = 0;
        System.out.println("It needs " + animal.foodWeightPerMonthMethod(kg) + "kg food every month.");
    }

    private static Animal animalTypeMethod(String name, String animalType, String CAT, String DOG, String ELEPHANT) {
        Animal animal;
        if (animalType.equalsIgnoreCase(CAT)) {
            animal = new Cat(InterfaceClass.inputNameMethod(name));
        } else if (animalType.equalsIgnoreCase(DOG)) {
            animal = new Dog(InterfaceClass.inputNameMethod(name));
        } else if (animalType.equalsIgnoreCase(ELEPHANT)) {
            animal = new Elephant(InterfaceClass.inputNameMethod(name));
        } else {
            System.out.print("It's wrong type. Your animal is cat by default.");
            animal = new Cat(InterfaceClass.inputNameMethod(name));
        }
        return animal;
    }

}
