package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basicPrice;
    private int discountPercent;

    public DiscountedProduct(int basicPrice, int discountPercent, String productName) {
        super(productName);
        this.basicPrice = basicPrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public int getProductPrice() {
        return basicPrice - (basicPrice * discountPercent / 100);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice() + " (cкидка: " + getDiscountPercent() + "%)";
    }

    @Override
    public String getObjectName() {
        return super.getObjectName();
    }

    @Override
    public String getSearchTerm() {
        return super.getSearchTerm();
    }

    @Override
    public String getObjectType() {
        return super.getObjectType();
    }
}
