package com.vega.lesson3.leas;

/**
 * Created by Veg'Zul on 21.07.2015.
 */
public enum CardType {
    VI(0.01){/*можно исспользовать как класс*/},MC(0.02),DP(0.02),AMERICAN_EXP;

    double tax;

    CardType(){

    }

    CardType(double tax){
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
        return "CardType - "+name();
    }
}
