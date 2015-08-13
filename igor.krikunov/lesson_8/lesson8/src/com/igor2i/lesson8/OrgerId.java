package com.igor2i.lesson8;

/**
 * Created by igor2i on 06.08.15.
 */
public class OrgerId {

    String productName;

    String productNumber;

    String getProductType;

    public OrgerId(String productName, String productNumber, String getProductType) {
        this.productName = productName;
        this.productNumber = productNumber;
        this.getProductType = getProductType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof OrgerId)) {
            return false;
        }
        OrgerId orgerId = (OrgerId) o;
        return orgerId.productNumber.equals(this.productNumber);
    }

    @Override
    public int hashCode() {
        return this.productNumber.hashCode();
    }

    @Override
    public String toString() {
        return "OrgerId{" +
                "productName='" + productName + '\'' +
                ", productNumber='" + productNumber + '\'' +
                ", getProductType='" + getProductType + '\'' +
                '}';
    }
}
