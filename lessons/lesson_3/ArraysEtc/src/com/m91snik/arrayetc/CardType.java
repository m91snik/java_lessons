package com.m91snik.arrayetc;

/**
 * Created by Valentin on 21.07.2015.
 */
public enum CardType {
    VI(0.01) {
        int x = 0;

        @Override
        public String toString() {
            return "It's Visa Time!!";
        }

        public String doSmth() {
            return "gdfgdfg";
        }
    },
    MC(0.02){
        double calc(int x, int y) {
            return x*y;
        }
    }, DP(0.02), AMERICAN_EXP;


    double calc(int x, int y) {
        return 0;
    }

    double tax;

    CardType() {

    }

    CardType(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public double calculateTaxAmount(double amount) {
        return amount * tax;
    }
}
