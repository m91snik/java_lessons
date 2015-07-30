package com.makedonsky94.main;

import com.makedonsky94.interfaces.ArrayCollection;
import com.makedonsky94.interfaces.Collection;

/**
 * Created by Sasha on 30.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        Collection<String> notebook = new ArrayCollection<>();
        notebook.add("Bob");
        notebook.add("Mary");
        notebook.add("Jimmy");
        System.out.format("Count names in notebook: %s \n", notebook.getLength());
        System.out.format("First name: %s \n", notebook.get(0));
        System.out.format("Names array: %s \n", notebook.toString());
    }
}
