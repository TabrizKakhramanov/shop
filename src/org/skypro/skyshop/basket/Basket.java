package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class Basket {
    private Product[] productBasket;
    private int size;
    private static int id;
    private int idNumber;

    public Basket(int size) {
        productBasket = new Product[size];
        this.size = size;
    }

    public void addSimpleProduct(String name, int cost) {
        if (id < size) {
            this.idNumber = id;
            productBasket[idNumber] = new SimpleProduct(name, cost);
            id++;
        } else {
            System.out.println("Корзина заполнена!");
        }
    }

    public void addDiscountedProduct(String name, int cost, int discount) {
        if (id < size) {
            this.idNumber = id;
            productBasket[idNumber] = new DiscountedProduct(cost, discount, name);
            id++;
        } else {
            System.out.println("Корзина заполнена");
        }
    }

    public void addFixPriceProduct(String name) {
        if (id < size) {
            this.idNumber = id;
            productBasket[idNumber] = new FixPriceProduct(name);
            id++;
        } else {
            System.out.println("Корзина заполнена");
        }
    }

    public int basketCost() {
        int sum = 0;
        for (int i = 0; i < id; i++) {
            sum += productBasket[i].getProductPrice();
        }
        return sum;
    }

    public void printAllProductsInfo() {
        if (id > 0) {
            for (int i = 0; i < id; i++) {
                System.out.println(productBasket[i].toString());
            }
        } else {
            System.out.println("В корзине пусто!");
        }
    }

    public boolean checkProduct(String name) {
        if (id > 0) {
            for (int i = 0; i < id; i++) {
                if (productBasket[i].getProductName().equals(name)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public void cleanBasket() {
        if (id > 0) {
            for (int i = 0; i < id; i++) {
                productBasket[i] = null;
            }
            id = 0;
        }
    }

    public void printSpecialProductsInfo() {
        if (id > 0) {
            for (int i = 0; i < id; i++) {
                if (productBasket[i].isSpecial()) {
                    System.out.println(productBasket[i].toString());
                }

            }
        }
    }

}
