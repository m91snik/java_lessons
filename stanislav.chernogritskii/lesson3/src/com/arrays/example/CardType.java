package com.arrays.example;

/**
 * Created by stanislav on 22.07.15.
 */
public enum CardType {

    VI(0.01) {
        int x = 0;

        @Override
        public String toString() {
            return "It's Visa Time!";
        }

        public String doSmth() {
            return "ssdada";
        }
    }, MC(0.02), DP(0.02), AMERICAN_EXP; // По Java конвенции - это константы

    double tax;

    CardType() {

    } // дефолтный конструктор (в нашем случае - для AMERICAN_EXP)

    CardType(double tax) {
        this.tax = tax;
    } // конструктор

    public double getTax() {
        return tax;
    }

    public double calculateTaxAmount(double d) {
        return d * tax;
    }

    @Override
    public String toString() {
        return "CardType - " + name();
    }
}
