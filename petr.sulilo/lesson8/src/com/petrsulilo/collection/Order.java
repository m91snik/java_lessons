package com.petrsulilo.collection;

/**
 * Created by Petr on 06.08.2015.
 */
public class Order {
    OrderId  orderid;
    long amount;
    String currency;

    public Order(OrderId orderid, long amount, String currency) {
        this.orderid = orderid;
        this.amount = amount;
        this.currency = currency;
    }
}
