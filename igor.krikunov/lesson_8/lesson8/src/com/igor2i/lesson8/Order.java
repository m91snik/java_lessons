package com.igor2i.lesson8;

/**
 * Created by igor2i on 06.08.15.
 */
public class Order {

    OrgerId orgerId;

    long amount;


    String currency;

    public Order(OrgerId orgerId, long amount, String currency) {
        this.orgerId = orgerId;
        this.amount = amount;
        this.currency = currency;
    }

}
