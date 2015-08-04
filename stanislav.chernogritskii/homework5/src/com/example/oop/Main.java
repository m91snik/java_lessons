package com.example.oop;

/**
 * Created by stanislav on 30.07.15.
 */
public class Main {

    private final static int SIZE = 5;

    public static void main(String[] args) {

        Array arrayInstance = new Array(SIZE);

        for (int i = 0; i < SIZE; i++) {
            arrayInstance.create(i);
        }

        printArray(arrayInstance);

        printSeparator();
        int updateNum = 1;
        System.out.println("Element value before update: " + arrayInstance.read()[updateNum]);
        System.out.println("Element value after update: " + arrayInstance.update(updateNum)[updateNum]);

        printSeparator();
        int deleteNum = 2;
        System.out.println("Element value before delete: " + arrayInstance.read()[deleteNum]);
        System.out.println("Element value after delete: " + arrayInstance.delete(deleteNum)[deleteNum]);

        printSeparator();
        printArray(arrayInstance);
    }

    public static void printArray(Array array) {
        for (int j = 0; j < array.read().length; j++) {
            System.out.println(array.read()[j]);
        }
    }

    private static void printSeparator() {
        System.out.println("--------------");
    }
}
