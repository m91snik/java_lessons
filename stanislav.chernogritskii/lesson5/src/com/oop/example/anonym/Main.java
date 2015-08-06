package com.oop.example.anonym;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by stanislav on 30.07.15.
 */
public class Main {

    public static void main(String[] args) {

        Integer[] ints = {1, 2, 3, 4, 5};

        int i = Arrays.binarySearch(ints, 3, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(i);
    }
}
