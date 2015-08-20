package com.m91snik.lesson11.lambda.links;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Valentin on 20.08.2015.
 */
public class Main {

    private static Integer increment(Integer i) {
        return ++i;
    }

    private static <T> void applyOperation(List<T> list,
                                           UnaryOperation<T> operation) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, operation.doOperation(list.get(i)));
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3});
        System.out.println(integers);
        applyOperation(integers, Main::increment);
        System.out.println(integers);
    }
}
