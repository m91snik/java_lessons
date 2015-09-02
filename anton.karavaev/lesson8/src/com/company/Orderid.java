package com.company;

/**
 * Created by HP on 06.08.2015.
 */
public class OrderId {
    String productName;
    String productType;
    String orderNumber;

    public OrderId(String productName, String productType, String prderNumber) {
        this.productName = productName;
        this.productType = productType;
        this.orderNumber = prderNumber;
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
