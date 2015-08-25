package com.gorbachevskaya.lesson8hw;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        Vocabulary v = new Vocabulary();
        v.create("Hello my friend hello man i love you man are you");
        v.create("Hello my friends how are you");
        System.out.println(v.vocabulary);
        v.vocabulary.replace("love", "lubov");
        System.out.println(v.vocabulary);


        Integer[] integers = {1, 3, 5, 2, 7, 8, 40, 31, 27};
        DoubleLinkedList<Integer> lst = new DoubleLinkedList<>(integers);
        System.out.println(lst.findLoop());

        lst.createLoopList(integers, 5);

        System.out.println(lst.findLoop());


    }
}
