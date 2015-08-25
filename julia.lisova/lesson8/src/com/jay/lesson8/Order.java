package com.jay.lesson8;

/**
 * Created by User on 06.08.2015.
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
