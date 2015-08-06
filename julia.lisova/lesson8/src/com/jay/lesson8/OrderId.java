package com.jay.lesson8;

import java.util.Objects;

/**
 * Created by User on 06.08.2015.
 */
public class OrderId implements Comparable<OrderId>{
    String productName;

    String productType;

    String orderNumber;

    public OrderId(String productName, String productType, String orderNumber) {
        this.productName = productName;
        this.productType = productType;
        this.orderNumber = orderNumber;
    }

    @Override
    public int hashCode() {
        return this.orderNumber.hashCode();
//        int result = productName != null ? productName.hashCode() : 0;
//        result = 31 * result + (productType != null ? productType.hashCode() : 0);
//        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
//        return result;
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
    public int compareTo(OrderId o) {
        return orderNumber.compareTo(o.orderNumber);
    }
}
