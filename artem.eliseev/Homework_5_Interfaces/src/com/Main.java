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
//        animal = new Cat(" ");
        String animalType = "";
        String name = "";


        InterfaceClass.inputAnimalTypeMethod(animalType);
        String CAT = "cat", DOG = "dog", ELEPHANT = "elephant";
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
        //       System.out.println("your" + super.name);
        animal.nameOut(name);

        double kg = 0;
        System.out.println("It need " + animal.foodWeightPerMonthMethod(kg) + "kg food every month");

    }

}
