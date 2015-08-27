package com.gorbachevskaya.lambda.links;

import java.util.Collection;
import java.util.List;

/**
 * Created by Ангелина on 20.08.2015.
 */
public class Main {

    private static int increment(int i) {
        return i;
    }


    private static <T> void applyOperation(List<T> list, UnaryOperation<T> operation) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, operation.doOPeratioin(list.get(i)));
        }

    }


    public static void main(String[] args) {
//        Main::increment
    }
}
