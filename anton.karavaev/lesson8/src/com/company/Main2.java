package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by HP on 06.08.2015.
 */
public class Main2 {
    public static void main(String[] args) {
        List<Integer> lst  = new ArrayList<>();
        lst.add(10);
        lst.add(20);
        lst.add(30);
        lst.add(40);

//        for (Iterator <Integer> iter = lst.iterator(); iter.hasNext();)
//        {   Integer next = iter.next();
//
//
//            if (next== 20) {iter.remove(); continue;}
//            System.out.println(next);
//        }

        Spliterator <Integer> spliterator = lst.spliterator();
        while   ( spliterator.tryAdvance(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                @Override
            }
        })

    }
}
