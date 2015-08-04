package com.gorbachevskaya.homework3;

// спроектировать интерфейс коллекция, с основными crud операциями,
// создать 2 реализации( на основе массива и на основе списка),
// создать методы для демонстрации работы с ними через интерфейс

public class Main {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Array<Integer> arInt = new Array<>(ints);
        String[] strs = {"Hey", "Hello", "Good morning", "Hi"};
        DoubleLinkedList<String> lsStr = new DoubleLinkedList<>(strs);

        printSecondElem(arInt);
        printSecondElem(lsStr);

    }

    public static void printSecondElem(Collecctions<?> collecctions) {
        System.out.print("The second element of collection is ");
        System.out.println(collecctions.read(1));
    }
}
