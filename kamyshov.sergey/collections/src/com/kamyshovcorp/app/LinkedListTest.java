package com.kamyshovcorp.app;

import com.kamyshovcorp.LinkedList;
import com.kamyshovcorp.List;

public class LinkedListTest {

    public static void main(String[] args) {
        List lst = new LinkedList();
        System.out.println(String.format("The start size: %d", lst.size()));

        lst.write("One");
        System.out.println(String.format("The size after adding first element: %d", lst.size()));
        lst.write("Two");
        System.out.println(String.format("The size after adding second element: %d", lst.size()));
        lst.write("Three");
        System.out.println(String.format("The size after adding third element: %d", lst.size()));

        System.out.println();
        System.out.println("The list before deleting: " + lst);
        lst.delete("Two");
        System.out.println(String.format("The size after deleting second element: %d", lst.size()));
        System.out.println("The list after deleting: " + lst);

        System.out.println();
        lst.update("One", "Two");
        System.out.println("The list after updating: " + lst);
    }
}
