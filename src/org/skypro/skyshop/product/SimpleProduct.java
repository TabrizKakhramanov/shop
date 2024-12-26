package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int productPrice;

    public SimpleProduct(String productName, int productPrice) {
        super(productName);
        if (productPrice > 0) {
            this.productPrice = productPrice;
        } else {
            throw new IllegalArgumentException("Цена должна быть больше 0!");
        }
    }


    @Override
    public int getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
