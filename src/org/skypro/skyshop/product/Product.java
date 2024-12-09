package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private String productName;

    public Product(String productName) {
        this.productName = productName;
    }


    public String getProductName() {
        return productName;
    }

    public abstract int getProductPrice();
    public abstract boolean isSpecial();

    @Override
    public String getObjectName() {
        return "PRODUCT";
    }

    @Override
    public String getSearchTerm() {
        return this.productName;
    }

    @Override
    public String getObjectType() {
        return "PRODUCT";
    }
}
