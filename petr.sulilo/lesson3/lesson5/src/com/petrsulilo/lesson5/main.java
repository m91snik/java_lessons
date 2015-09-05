package com.petrsulilo.lesson5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Petr on 30.07.2015.
 */
public class main {
    public static void main(String[] args)
    {
        Integer[] ints = {1,2,3,4,5};

        int i = Arrays.binarySearch(ints, 3, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2 - o1;
            }
        });

        System.out.println(i);
    }
}
