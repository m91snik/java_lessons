package com.links;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anry on 20.08.2015.
 */
public class Main {


    private static Integer increment(int i) {
        return i;
    }

    private static <T> void applyOperation(List<T> list,
                                           UnaryOperation<T> operation) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, operation.doOperation(list.get(i)));
        }

    }



    public static void main(String[] args) {
        Main::increment
    }
}
