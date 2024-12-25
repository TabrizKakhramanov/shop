package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class ProductBasket {
    private Product[] productBasket;
    private int id;

    public ProductBasket() {
        productBasket = new Product[5];
    }

    public void addProduct(String productName, int productPrice) {
        if (id < 5) {
            productBasket[id] = new SimpleProduct(productName, productPrice);
            id++;
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public void addDiscountedProduct(String productName, int productPrice, int discount) {
        if (id < 5) {
            productBasket[id] = new DiscountedProduct(productName, productPrice, discount);
            id++;
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public void addFixPriceProduct(String productName) {
        if (id < 5) {
            productBasket[id] = new FixPriceProduct(productName);
            id++;
        } else {
            System.out.println("Невозможно добавить продукт.");
        }
    }

    public int allProductsPrise() {
        int sum = 0;
        for (int i = 0; i < id; i++) {
            sum += productBasket[i].getProductPrice();
        }
        return sum;
    }

    public void printAllProducts() {
        for (int i = 0; i < id; i++) {
            System.out.println(productBasket[i].toString());
        }
    }

    public boolean checkProductByName(String productName) {
        for (int i = 0; i < id; i++) {
            if (productBasket[i].getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanProductBasket() {
        for (int i = 0; i < id; i++) {
            productBasket[i] = null;
        }
        id = 0;
    }

    public int countOfSpecialProducts() {
        int count = 0;
        for (int i = 0; i < id; i++) {
            if (productBasket[i].isSpecial()) {
                count++;
            }
        }
        return count;
    }

}
