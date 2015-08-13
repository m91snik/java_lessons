package com;

/**
 * Created by Anry on 30.07.2015.
 */

import com.Animals.Animal;
import com.Animals.Cat;
import com.Animals.Dog;
import com.Animals.Elephant;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public abstract class Main {
    int idCounter;
    StringBuffer animalTypeBuffer;
    String name;
    double kg;

    public static void main(String... args) {
        Animal animal;
        List<Animal> animalList = new LinkedList<>();
        String name = "";
        StringBuffer operationType = new StringBuffer();
        StringBuffer animalTypeBuffer = new StringBuffer();
        int idCounter = 1;
        StringBuffer stringBufferOut = new StringBuffer();

//toDo do add & all operation only in one o couple method.

        animal = animalAddMethod(
                idCounter, name, animalTypeBuffer, Constants.CAT, Constants.DOG, Constants.ELEPHANT);
        animalList.add(animal);
        idCounter++;
        animalTypeBuffer.setLength(0);
        animal.nameOut(name);
        double kg = 0;
        System.out.println("It needs " + animal.foodWeightPerMonthMethod(kg) + "kg food every month.");
        System.out.println();

        while (!InterfaceClass.inputOperationTypeMethod(operationType).toString().equalsIgnoreCase("exit")) {
            switch (operationType.toString()) {
                case "add":
                    animal = animalAddMethod(
                            idCounter, name, animalTypeBuffer, Constants.CAT, Constants.DOG, Constants.ELEPHANT);
                    animalList.add(animal);
                    idCounter++;
                    animalTypeBuffer.setLength(0);
                    animal.nameOut(name);
                    kg = 0;
                    System.out.println("It needs " + animal.foodWeightPerMonthMethod(kg) + "kg food every month.");
                    System.out.println();
                    break;
                case "all":
//                    System.out.println(animalList.toString());
//                    collectionOut(animalList);
                    stringBufferOut = new StringBuffer();
                    System.out.println();

                    for (Iterator<Animal> outIterator = animalList.iterator(); outIterator.hasNext(); ) {
                        Animal nextIteratorElement = outIterator.next();
                        stringBufferOut.append(nextIteratorElement.animalOut());
                    }
                    System.out.println(stringBufferOut.toString());
                    stringBufferOut.setLength(0);
                    break;
            }
            operationType.setLength(0);

        }

//        animal = animalAddMethod(idCounter, name, animalTypeBuffer, Constants.CAT, Constants.DOG, Constants.ELEPHANT);
//
//        animal.nameOut(name);
//        double kg = 0;
//        System.out.println("It needs " + animal.foodWeightPerMonthMethod(kg) + "kg food every month.");
    }

    private static Animal animalAddMethod(
            int idCounter, String name, StringBuffer animalTypeBuffer, String CAT, String DOG, String ELEPHANT) {
        Animal animal;
        animalTypeBuffer = new StringBuffer(InterfaceClass.inputAnimalTypeMethod(animalTypeBuffer));

        if (animalTypeBuffer.toString().equalsIgnoreCase(Constants.CAT)) {
            animal = new Cat(idCounter, InterfaceClass.inputNameMethod(name), animalTypeBuffer);
        } else if (animalTypeBuffer.toString().equalsIgnoreCase(Constants.DOG)) {
            animal = new Dog(idCounter, InterfaceClass.inputNameMethod(name), animalTypeBuffer);
        } else if (animalTypeBuffer.toString().equalsIgnoreCase(Constants.ELEPHANT)) {
            animal = new Elephant(idCounter, InterfaceClass.inputNameMethod(name), animalTypeBuffer);
        } else {
            System.out.print("It's wrong type. Your animal is cat by default.");
            animalTypeBuffer.setLength(0);
            animalTypeBuffer.append(Constants.CAT);
            animal = new Cat(idCounter, InterfaceClass.inputNameMethod(name), animalTypeBuffer);
        }
        return animal;
    }

//    private static StringBuffer collectionOut(List<Animal> animalList) {
//        Animal animal = null;
//        StringBuffer stringBufferOut = null;
//        for (Iterator<Animal> outIterator = animalList.iterator(); outIterator.hasNext(); ) {
//            Animal iteratorNextAnimal = outIterator.next();
//            animal.animalOut();
//        }
//        return stringBufferOut;

//    @Override
//    public String toString() {
//        return "id:" + idCounter + ", " + animalTypeBuffer.toString() + " " + name + ", " + kg + "kg food every month.\n";
//    }

}
