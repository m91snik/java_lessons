/**
 * Created by Anry on 21.07.2015.
 */
public enum CardType {
    VI(0.01) {
        int x = 0;

        @Override
        public String toString() {
            return "It's Visa Time!!";
        }

        public String doString() {
            return "adfgadfg";
        }
    },
    MC(0.04) {
        double calc = 0;
    },
    DP(0.03), AMERICAN_EXPRESS;

    double tax;

    CardType() {
    }

    CardType(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "CardType - " + name();
    }

    public double getTax() {
        return tax;
    }

    public double calculateTaxAmount(double amount) {
        return amount * tax;
    }

    ;
}
