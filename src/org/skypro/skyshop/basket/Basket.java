package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class Basket {
    Product[] productBasket;
    private int size;
    private static int id;
    private int idNumber;

    public Basket(int size) {
        productBasket = new Product[size];
        this.size = size;
    }

    public void addProduct(String name, int cost) {
        if (id < size) {
            this.idNumber = id;
            productBasket[idNumber] = new Product(name, cost);
            id++;
        } else {
            System.out.println("Корзина заполнена!");
        }
    }

    public int basketCost() {
        int sum = 0;
        for (int i = 0; i < id; i++) {
            Product product = productBasket[i];
            sum += product.getProductCost();
        }
        return sum;
    }

    public void printAllProductsInfo() {
        if (id > 0) {
            for (int i = 0; i < id; i++) {
                Product product = productBasket[i];
                System.out.println(productBasket[i].toString());
            }
        } else {
            System.out.println("В корзине пусто!");
        }
    }

    public boolean checkProduct(String name) {
        if (id > 0) {
            for (int i = 0; i < id; i++) {
                Product product = productBasket[i];
                if (product.getProductName().equals(name)) {
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


}
