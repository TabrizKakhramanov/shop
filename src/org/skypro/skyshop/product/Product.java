package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName) {
        if (!productName.isBlank() && productName != null) {
            this.productName = productName;
        } else {
                throw new IllegalArgumentException("Неверное имя продукта!");
        }
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();

    @Override
    public String toString() {
        return getProductName() + ": " + getProductPrice();
    }

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getSearchContentType() {
        return "PRODUCT";
    }
}
