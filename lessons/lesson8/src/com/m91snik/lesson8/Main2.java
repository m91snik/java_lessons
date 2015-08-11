package com.m91snik.lesson8;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Valentin on 06.08.2015.
 */
public class Main2 {

    public static void main(String[] args) {
        Map<OrderId, Order> lst = new TreeMap<OrderId, Order>(
                new Comparator<OrderId>() {
                    @Override
                    public int compare(OrderId o1, OrderId o2) {
                        return o2.orderNumber.compareTo(o1.orderNumber);
                    }
                });
        OrderId key1 = new OrderId("A", "B", "12");
        lst.put(key1, new Order(key1, 1, "A"));
        OrderId key2 = new OrderId("A", "B", "123");
        lst.put(key2, new Order(key2, 1, "A"));
        OrderId key3 = new OrderId("A", "B", "121");
        lst.put(key3, new Order(key3, 1, "A"));
        OrderId key4 = new OrderId("A", "B", "1");
        lst.put(key4, new Order(key4, 1, "A"));


        System.out.println(lst);

//        for (Iterator<Integer> iter = lst.iterator(); iter.hasNext(); ) {
//            Integer next = iter.next();
//            if (next == 20) {
//                iter.remove();
//                continue;
//            }
//            System.out.println(next);
//        }

//        Spliterator<Integer> spliterator = lst.spliterator();
//        while (spliterator.tryAdvance(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        })) {
//        }

    }
}
