package com.vega.lesson;

/**
 * Created by Veg'Zul on 06.08.2015.
 */
public class OrderId{
    String producntName;
    String productType;
    String orderNumber;

    public OrderId(String producntName, String productType, String orderNumber) {
        this.producntName = producntName;
        this.productType = productType;
        this.orderNumber = orderNumber;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof OrderId))
        return false;

        OrderId orderId = (OrderId) o;
        return orderId.orderNumber.equals(this.orderNumber);
    }

    @Override
    public int hashCode(){
        return this.orderNumber.hashCode();
    }

}
