package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getProductPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getProductName() + ": фиксированная цена - " + getProductPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
