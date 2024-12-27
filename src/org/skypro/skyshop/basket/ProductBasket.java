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
        productBasket.add(new DiscountedProduct(productName,productPrice,discount));
    }

    public void addFixPriceProduct(String productName) {
        productBasket.add(new FixPriceProduct(productName));
    }

    public int allProductsPrise() {
        int sum = 0;
        for (int i = 0; i < productBasket.size(); i++) {
            sum += productBasket.get(i).getProductPrice();
        }
        return sum;
    }

    public void printAllProducts() {
        if (productBasket.isEmpty()){
            System.out.println("Корзина пустая!");
            return;
        }
        for (int i = 0; i < productBasket.size(); i++) {
            System.out.println(productBasket.get(i).toString());
        }
    }

    public boolean checkProductByName(String productName) {
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i).getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanProductBasket() {
        while(!productBasket.isEmpty()){
            productBasket.removeFirst();
        }
    }

    public List<Product> removeProductsByName (String name){
        Iterator<Product> iterator = productBasket.iterator();
        List<Product> result = new ArrayList<>();

        while (iterator.hasNext()){
            Product element = iterator.next();
            if (element.getProductName().equals(name)){
                result.add(element);
            }
        }
        return result;
    }

    public int countOfSpecialProducts() {
        int count = 0;
        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i).isSpecial()) {
                count++;
            }
        }
        return count;
    }

}
