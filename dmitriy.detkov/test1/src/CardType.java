public enum CardType {
    VI(0.01), MC(0.02), DP(0.02), AE;

    double tax;

    CardType() {

    }

    CardType(double tax) {
        this.tax = tax;
    }

    public double getTax() {
        return tax;
    }

    public double calTex(double amount) {
        return amount * tax;
    }

    @Override
    public String toString() {
        return "CardType - " + name();
    }
}
