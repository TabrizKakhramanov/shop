package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;

public class ProductBasket {
    private Map<String,List<Product>> productBasket;

    public ProductBasket() {
        productBasket = new HashMap<>();
    }

    public void addProduct(String keyName, List<Product> products) {
        productBasket.put(keyName,products);
    }

    public int allProductsPrise() {
        int sum = 0;
        //итерируемся по значениям Мапа
        for (List<Product> personProducts: productBasket.values()){
            //итерируемся по элементам каждого значения (т.к. значение - Лист)
            for (Product element:personProducts) {
                sum += element.getProductPrice();
            }
        }
        return sum;
    }

    public void printAllProducts() {
        for (List<Product> personProducts: productBasket.values()) {
            for (Product element : personProducts) {
                System.out.println(element.toString());
            }
        }
    }

    public boolean checkProductByProductsName(String productName) {
        for(List<Product> personProducts: productBasket.values()) {
            for (Product element : personProducts) {
                if (element.getProductName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cleanProductBasket() {
        productBasket.clear();
    }

    public int countOfSpecialProducts() {
        int count = 0;
        for(List<Product> personProducts:productBasket.values()) {
            for (Product element : personProducts) {
                if (element.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Product> removeProductsByProductsName(String name){
        List<Product> result = new LinkedList<>();
        for(List<Product> personProducts:productBasket.values()) {
            Iterator<Product> iterator = personProducts.iterator();
            while (iterator.hasNext()) {
                Product element = iterator.next();
                if (element.getProductName().equals(name)) {
                    result.add(element);
                }
            }
            personProducts.removeAll(result);
        }
        return result;
    }
}
