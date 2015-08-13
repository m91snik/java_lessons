package com.m91snik.lesson8;

/**
 * Created by Valentin on 06.08.2015.
 */
public class OrderId {

    String productName;

    String productType;

    String orderNumber;

    public OrderId(String productName, String productType, String orderNumber) {
        this.productName = productName;
        this.productType = productType;
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        //o==null
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

//    @Override
//    public int compareTo(OrderId o) {
//        return orderNumber.compareTo(o.orderNumber);
//    }

    @Override
    public String toString() {
        return "OrderId{" +
                "orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
