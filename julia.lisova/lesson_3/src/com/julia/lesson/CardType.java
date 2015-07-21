package com.julia.lesson;

/**
 * Created by User on 21.07.2015.
 */
public enum CardType {

    VI(0.01), MC(0.02), DP(0.02), AE, AMERICAN_EXPRESS;

    double tax;

    CardType() {

    }

    CardType(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public double calculateTaxAmount(double amount){
        return amount * tax;
    }

    @Override
    public String toString() {
        return "CardType - " + name();
    }
}
