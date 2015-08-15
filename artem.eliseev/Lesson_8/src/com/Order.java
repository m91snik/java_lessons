package com;

/**
 * Created by Anry on 06.08.2015.
 */
public class Order {
    public Order(OrderId orderId, Integer id, String currency) {
        this.orderId = orderId;
        this.id = id;
        this.currency = currency;
    }

    OrderId orderId;
    Integer id;
    String currency;
}


