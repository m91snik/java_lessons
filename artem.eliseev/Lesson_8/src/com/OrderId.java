package com;

/**
 * Created by Anry on 06.08.2015.
 */
public class OrderId {
    String productName, productType, orderNumber;

    public OrderId(String productName, String orderNumber, String productType) {
        this.productName = productName;
        this.orderNumber = orderNumber;
        this.productType = productType;
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
}
