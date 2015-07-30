package com;

import com.Animals.Animal;

import java.util.Scanner;

/**
 * Created by Anry on 30.07.2015.
 */
public interface InterfaceClass {

    public static String inputAnimalTypeMethod(String animalType) {
        System.out.print("Enter animal type (cat, dog or elephant only):");
        Scanner inputAnimalType_scanner = new Scanner(System.in);
        animalType = inputAnimalType_scanner.next();
        System.out.println();
        return animalType;
    }

    public static String inputNameMethod(String name) {
        System.out.print("Enter animal name:");
        Scanner inputName_scanner = new Scanner(System.in);
        name = inputName_scanner.next();
        System.out.println();
        return name;
    }


}
