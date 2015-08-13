package com.igor2i.lesson8;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by igor2i on 06.08.15.
 */
public class Main2 {
    public static void main(String args[]) {

        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(12);
        list.add(99);
        list.add(76);

//        for (Iterator<Integer> iter = list.iterator();  iter.hasNext();) {
//            Integer next = iter.next();
//            if(next == 99){
//                iter.remove();
//                continue;
//            }
//            System.out.println(next);
//
//
//        }

//        Spliterator<Integer> spliterator = list.spliterator();
//        while (spliterator.tryAdvance(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        }));
//

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);
            }
        });




        System.out.println(list);

    }

}
