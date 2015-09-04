package com.petrsulilo.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Petr on 06.08.2015.
 */
public class Main {
    public static void main(String[] args)
    {
        Map<OrderId, Order> orders = new HashMap<OrderId, Object>();
        OrderId OrderId1 = new OrderId("Dobrii","Juice","1");
        orders.put(OrderId1,new Order(OrderId1,70,"123"));


        integers.add(10);
        integers.add(20);

        System.out.println(integers.contains(10));


    }
}
