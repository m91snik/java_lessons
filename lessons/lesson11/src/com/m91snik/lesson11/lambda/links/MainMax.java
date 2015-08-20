package com.m91snik.lesson11.lambda.links;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Valentin on 20.08.2015.
 */
public class MainMax {

    int VALUE;

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3});

        Integer max = Collections.max(integers,
                (o1, o2) -> o1.equals(o2) ? 0 : (o2 > o1 ? 1 : -1)
        );
        System.out.println(max);

        boolean b = 1 > 2 ? false : true;
    }
}
