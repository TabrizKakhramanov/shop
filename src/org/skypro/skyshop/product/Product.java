package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}
