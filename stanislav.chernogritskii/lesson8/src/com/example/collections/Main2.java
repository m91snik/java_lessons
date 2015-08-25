package com.example.collections;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by stanislav on 06.08.15.
 */
public class Main2 {

    public static void main(String[] args) {

        List<OrderId> lst = new ArrayList<>();

        lst.add(new OrderId("A", "B", "12"));
        lst.add(new OrderId("A", "B", "123"));
        lst.add(new OrderId("A", "B", "121"));
        lst.add(new OrderId("A", "B", "1"));

//        for (Iterator<Integer> iter = lst.iterator(); iter.hasNext(); ) {
//            Integer next = iter.next();
//            if(next == 20) {
//                iter.remove();
//                continue;
//            }
//            System.out.println(next);
//        }

//        Spliterator<Integer> spliterator = lst.spliterator();

//        while (spliterator.tryAdvance(new Consumer<Integer>() {
//                                   @Override
//                                   public void accept(Integer integer) {
//                                       System.out.println(integer);
//                                   }
//                               }
//        )) {
//
//        };

//        int i = Collections.binarySearch(lst, 20, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });

        Collections.sort(lst, new Comparator<OrderId>() {
            @Override
            public int compare(OrderId o1, OrderId o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println(lst);
    }
}
