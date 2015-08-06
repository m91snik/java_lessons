package com;

import com.Animals.Animal;

import java.util.Scanner;

/**
 * Created by Anry on 30.07.2015.
 */
public interface InterfaceClass {

    public static String inputAnimalTypeMethod(StringBuffer animalTypeBuffer) {
        System.out.print("Enter animal type (cat, dog or elephant only):");
        Scanner inputAnimalType_scanner = new Scanner(System.in);
        animalTypeBuffer = animalTypeBuffer.append(inputAnimalType_scanner.next());
        System.out.println();
        return animalTypeBuffer.toString();
    }

    public static String inputNameMethod(String name) {
        System.out.print("Enter animal name:");
        Scanner inputName_scanner = new Scanner(System.in);
        name = inputName_scanner.next();
        System.out.println();
        return name;
    }


}
