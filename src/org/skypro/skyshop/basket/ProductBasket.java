package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> productBasket;

    public ProductBasket() {
        productBasket = new LinkedList<>();
    }

    public void addProduct(String productName, int productPrice) {
        productBasket.add(new SimpleProduct(productName,productPrice));
    }

    public void addDiscountedProduct(String productName, int productPrice, int discount) {
        productBasket.add( new DiscountedProduct(productName, productPrice, discount));

    }

    public void addFixPriceProduct(String productName) {
        productBasket.add( new FixPriceProduct(productName));
    }

    public int allProductsPrise() {
        int sum = 0;
        for (Product element:productBasket) {
            sum += element.getProductPrice();
        }
        return sum;
    }

    public void printAllProducts() {
        for (Product element:productBasket) {
            System.out.println(element.toString());
        }
    }

    public boolean checkProductByName(String productName) {
        for (Product element:productBasket) {
            if (element.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanProductBasket() {
        for (Product element:productBasket) {
            element = null;
        }
    }

    public int countOfSpecialProducts() {
        int count = 0;
        for (Product element:productBasket) {
            if (element.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public List<Product> removeProductsByName(String name){
        List<Product> result = new LinkedList<>();
        Iterator<Product> iterator = productBasket.iterator();
        while (iterator.hasNext()){
            Product element=iterator.next();
            if (element.getProductName().equals(name)){
                result.add(element);
            }
        }
        productBasket.removeAll(result);
        return result;
    }
}
