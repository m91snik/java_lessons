package com;

import java.util.*;

/**
 * Created by Anry on 06.08.2015.
 */
public class Main {
    public static void main(String... args) {
        //       LinkedList<Integer> integers = new LinkedList<>();
        Map<OrderId, Order> orders = new HashMap<>();

        OrderId orderId1 = new OrderId("Dobry", "Juce", "1");
        orders.put(orderId1, new Order(orderId1, 70, "RUB"));

        OrderId orderId2 = new OrderId("J7", "Juce", "1");
        orders.put(orderId2, new Order(orderId2, 90, "RUB"));

        OrderId orderId3 = new OrderId("J7", "Juce", "2");
        orders.put(orderId3, new Order(orderId3, 90, "RUB"));
        orders.replace(orderId3, new Order(orderId3, 100, "RUB"));

        System.out.println(orders);
        System.out.println(orders.toString());
        System.out.println(orderId1);
        System.out.println(orderId2);
        System.out.println(orderId3);

//        integers.add(10);
//        integers.add(20);

        //       System.out.println( integers.get(0));
//        System.out.println( integers.contains(10));

    }
}
