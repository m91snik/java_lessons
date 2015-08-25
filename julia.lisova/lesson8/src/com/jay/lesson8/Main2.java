package com.jay.lesson8;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by User on 06.08.2015.
 */
public class Main2 {

    public static void main(String[] args) {
        List<OrderId> lst = new ArrayList<>();
        lst.add(new OrderId("d", "d", "2"));
        lst.add(new OrderId("d", "d", "233"));
        lst.add(new OrderId("d", "d", "2"));
        lst.add(new OrderId("d", "d", "3"));

//       Collections.sort(lst, new Comparator<Integer>() {
//           @Override
//           public int compare(Integer o1, Integer o2) {
//               return Integer.compare(o2, o1);
//           }
//       });
//        System.out.println(lst);



//        Spliterator<Integer> spliterator = lst.spliterator();
//        spliterator.tryAdvance(new Consumer<Integer>()) {
//            @Override
//            public void accept(Integer integer) {
//
//                    System.out.println(integer);
//                }
//            }}


//        for (Iterator<Integer> iter = lst.iterator(); iter.hasNext(); ) {
//            Integer next = iter.next();
//            if (next == 10) {
//                iter.remove();
//                continue;
//            }
//            System.out.println(next);
//
//
//        }
//        for (Integer i : lst) {
//
//            System.out.println(lst);
//            if (i == 20) {
//                lst.remove(new Integer(20));
//            }
//        }
    }
}
