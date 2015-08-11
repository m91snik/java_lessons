package com;

import com.Animals.Animal;

import java.util.Scanner;

/**
 * Created by Anry on 30.07.2015.
 */
public interface InterfaceClass {
    static StringBuffer inputOperationTypeMethod(StringBuffer operationType) {
        System.out.print("Enter operation type ('add', 'all'(to show all animals), 'exit')");
        Scanner operationType_scanner = new Scanner(System.in);
        operationType = operationType.append(operationType_scanner.next());
        return operationType;
    }

    static String inputAnimalTypeMethod(StringBuffer animalTypeBuffer) {
        System.out.print("Enter animal type (cat, dog or elephant only):");
        Scanner inputAnimalType_scanner = new Scanner(System.in);
        animalTypeBuffer = animalTypeBuffer.append(inputAnimalType_scanner.next());
        System.out.println();
        return animalTypeBuffer.toString();
    }

    static String inputNameMethod(String name) {
        System.out.print("Enter animal name:");
        Scanner inputName_scanner = new Scanner(System.in);
        name = inputName_scanner.next();
        System.out.println();
        return name;
    }


}
