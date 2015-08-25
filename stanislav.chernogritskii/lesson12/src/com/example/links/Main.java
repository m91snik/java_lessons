package com.example.links;

import java.util.Arrays;
import java.util.List;

/**
 * Created by stanislav on 20.08.15.
 */
public class Main {

    private static Integer increment(Integer i) {
        return ++i;
    }

    private static <T> void applyOperation(List<T> list, UnaryOperation<T> operation) {

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
