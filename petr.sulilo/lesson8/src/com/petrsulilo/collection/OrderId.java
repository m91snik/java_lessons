package com.petrsulilo.collection;

/**
 * Created by Petr on 06.08.2015.
 */
public class OrderId {
    String productName;
    String productType;
    String orderNumber;

    public OrderId(String productName, String productType, String productName1) {
        this.productName = productName;
        this.productType = productType;
        this.orderNumber = productName1;
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof OrderId))
        {
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
