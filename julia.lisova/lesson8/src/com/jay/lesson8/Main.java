package com.jay.lesson8;

import java.util.*;

/**
 * Created by User on 06.08.2015.
 */
public class Main {

    public static void main(String[] args) {
        Map<OrderId, Order> orders = new HashMap<>();

        OrderId order1 = new OrderId("Dobriy", "Juce", "1");
        orders.put(order1, new Order(order1, 70, "RUB"));
        OrderId order2 = new OrderId("J7", "Juce", "1");
        orders.put(order2, new Order(order2, 90, "RUB"));
        OrderId order3 = new OrderId("J7", "Juce", "2");
        orders.put(order3, new Order(order3, 300, "RUB"));

        orders.replace(order3, new Order(order3, 100, "RUB"));

        System.out.println(order1.equals(order2));

        System.out.println(orders);
    }
}
