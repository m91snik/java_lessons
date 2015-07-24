package com.igor2i.calc.methods.algExp;

/**
 * Created by igor2i on 24.07.2015.
 */
enum AlgExpressions {
    SUMM("+") {
        @Override
        protected double calcul(double d1, double d2) {
            double out;
            out = d1 + d2;
            return out;
        }
    }, SUBTRACTION("-") {
        @Override
        protected double calcul(double d1, double d2) {
            double out;
            out = d1 - d2;
            return out;
        }

        @Override
        protected double calcul(double d1) {
            return -d1;
        }
    }, MULTIPLICATION("*") {
        @Override
        protected double calcul(double d1, double d2) {
            double out;
            out = d1 * d2;
            return out;
        }
    }, DIVISION("/") {
        @Override
        protected double calcul(double d1, double d2) {
            double out;
            if (d2 == 0) {
                System.out.println("Нельзя делить на ноль!");
                return 0;
            }
            out = d1 / d2;
            return out;
        }
    }, INVOLUTION("^") {
        @Override
        protected double calcul(double d1, double d2) {
            return Math.pow(d1, d2);
        }
    }, FACTORIAL("!") {
        private double factorial(double d1) {
            if (d1 == 0) {
                return 1;
            }
            return d1 * factorial(d1 - 1);
        }

        @Override
        protected double calcul(double d1) {
            if (d1 < 200) {
                return factorial((long) d1);
            } else {
                return factorial(200.0);
            }
        }
    };

    protected String sim;

    AlgExpressions(String sim) {
        this.sim = sim;
    }

    protected String getSim() {
        return sim;
    }

    protected double calcul(double d1, double d2) {
        return 0;
    }

    protected double calcul(double d1) {
        return 0;
    }

}
