package com.vega.cycle;

import com.vega.cycle.List.DoubleLinked;
import com.vega.cycle.List.DoubleLinkedList;

/**
 * Created by Вася-Вега on 10.08.2015.
 */
public class Main {

    public static void main(String[] args) {

        DoubleLinked<String> doubleLinked = new DoubleLinkedList<>();

        doubleLinked.addFirst("hello");
        doubleLinked.addLast("word");
        doubleLinked.addLast("people");
        doubleLinked.addLast("persik!");

        doubleLinked.goToLast();
        System.out.println(doubleLinked.showThis());
        doubleLinked.goToFirst();
        System.out.println(doubleLinked.showThis());
        doubleLinked.goToNext();
        System.out.println(doubleLinked.showThis());
        doubleLinked.goToNext();
        doubleLinked.editNextSrc(0);
        System.out.println(doubleLinked.showThis());
        doubleLinked.goToNext();
        System.out.println(doubleLinked.showThis());
        doubleLinked.goToNext();
        System.out.println(doubleLinked.showThis());

    }

}
