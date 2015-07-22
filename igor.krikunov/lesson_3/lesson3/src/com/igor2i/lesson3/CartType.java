package com.igor2i.lesson3;

/**
 * Created by igor2i on 21.07.15.
 */
public enum CartType {
    VI(0.01){
        @Override
        public String toString(){
            return "2313";
        }


    },MC(0.02){

    },DF(0.02){

    },AMERICAN{

    };

    double tax;

    CartType() {

    }

    CartType(double d) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    @Override
    public String toString() {
        return "CartType - " + name();
    }

    public double calc(double d1) {
        return d1 * tax;
    }
}
