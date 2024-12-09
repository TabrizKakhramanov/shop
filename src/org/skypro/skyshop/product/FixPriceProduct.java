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
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": Фиксированная цена " + getProductPrice();
    }

    @Override
    public String getSearchTerm() {
        return super.getSearchTerm();
    }

    @Override
    public String getObjectType() {
        return super.getObjectType();
    }

    @Override
    public String getObjectName() {
        return super.getObjectName();
    }
}
