package com.vega.lesson;

import java.util.*;

/**
 * Created by Veg'Zul on 06.08.2015.
 */
public class Main {

    public static void main(String[] args) {
//        List<Integer> integers = new LinkedList<>();
//        Set<Integer> integers = new HashSet<>();
//        integers.add(10);
//        integers.add(20);

//        System.out.println(integers.get(1));

        Map<OrderId, Order> orders = new HashMap<>();
        OrderId orderId1 = new OrderId("Dobriy","Juice", "1");
        orders.put(orderId1, new Order(orderId1,70,"RUB"));
        OrderId orderId2 = new OrderId("J7","Juice", "1");
        orders.put(orderId2, new Order(orderId2,90,"RUB"));
        OrderId orderId3 = new OrderId("Dobriy","Juice", "2");
        orders.put(orderId3, new Order(orderId3,300,"RUB"));

        orders.replace(orderId3, new Order(orderId3, 100, "RUB"));

        System.out.println(orderId1.equals(orderId2));

        System.out.println(orders);
        System.out.println(orders.size());


    }

}
