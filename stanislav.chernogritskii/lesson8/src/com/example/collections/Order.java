package com.example.collections;

/**
 * Created by stanislav on 06.08.15.
 */
public class Order {

    OrderId orderId;

    long amount;

    String currency;

    public Order(OrderId orderId, long amount, String currency) {
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
    }
}
