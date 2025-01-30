package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, List<Product>> productBasket;

    public ProductBasket() {
        productBasket = new HashMap<>();
    }

    public void addProduct(String keyName, List<Product> products) {
        productBasket.put(keyName, products);
    }

    public int allProductsPrise() {
        int sum = productBasket.values().stream().flatMap(Collection::stream).mapToInt(el -> el.getProductPrice()).sum();
        return sum;
    }

    public void printAllProducts() {
        productBasket.values().stream().flatMap(el -> el.stream()).forEach(System.out::println);
    }

    public boolean checkProductByProductsName(String productName) {
        return productBasket.values().stream().flatMap(el -> el.stream()).anyMatch(el -> el.getProductName().equals(productName));

    }

    public void cleanProductBasket() {
        productBasket.clear();
    }

    public long countOfSpecialProducts() {
        long count = productBasket.values().stream().flatMap(Collection::stream).filter(el -> el.isSpecial()).count();
        return count;
    }

    public List<Product> removeProductsByProductsName(String name) {
        List<Product> result = new LinkedList<>();
        productBasket.values().forEach(personProducts -> {
            List<Product> deleted = personProducts.stream().filter(el -> el.getProductName().equals(name)).toList();
            result.addAll(deleted);
            personProducts.removeAll(deleted);
        });
        return result;
    }
}
