/**
 * Created by Petr on 21.07.2015.
 */
public enum CartType {
    VI(0.01), MC(0.02) , DP(0.02), AMERECAN_EXP;

    double tax;

    CartType(double tax)
    {
        this.tax = tax;
    }
    CartType()
    {}

    @Override
    public String toString() {
        return "CartType - " + name();
    }

    public double getTax() {
        return tax;
    }

    public double calculateTaxAmount(double db)
    {
    return 1;
    }
}
