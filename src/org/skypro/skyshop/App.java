package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Basket basket = new Basket(5);

        basket.addSimpleProduct("Вода", 55);
        basket.addSimpleProduct("Морковка", 16);
        basket.addDiscountedProduct("Говяжья вырезка", 990, 20);
        basket.addDiscountedProduct("Лавровый лист", 40, 40);
        basket.addFixPriceProduct("Редиска");
        basket.addFixPriceProduct("Проверка");

        basket.printAllProductsInfo();
        System.out.println(basket.basketCost());

        System.out.println();
        basket.printSpecialProductsInfo();

        System.out.println(basket.checkProduct("Морковка"));
        System.out.println(basket.checkProduct("Лук"));

        basket.cleanBasket();
        System.out.println(basket.basketCost());
        System.out.println(basket.checkProduct("Морковка"));

    }
}
