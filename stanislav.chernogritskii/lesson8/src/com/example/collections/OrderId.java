package com.example.collections;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by stanislav on 06.08.15.
 */
public class OrderId implements Comparable<OrderId> {

    String productName;

    String productType;

    String orderNumber;

    public OrderId (String productName, String productType, String orderNumber) {
        this.productName = productName;
        this.productType = productType;
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrderId)) {
            return false;
        }
        OrderId orderId = (OrderId) o;
        return orderId.orderNumber.equals(this.orderNumber);
    }

    @Override
    public int hashCode() {
        return this.orderNumber.hashCode();
    }

    @Override
    public int compareTo(OrderId o) {
        return orderNumber.compareTo(o.orderNumber);
    }
}
