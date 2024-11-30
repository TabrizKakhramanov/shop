package org.skypro.skyshop;

import org.skypro.skyshop.basket.Basket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Basket basket = new Basket(5);

        basket.addProduct("Вода", 55);
        basket.addProduct("Морковка", 16);
        basket.addProduct("Говяжья вырезка", 990);
        basket.addProduct("Лавровый лист", 40);
        basket.addProduct("Редиска", 70);
        basket.addProduct("Проверка", 0);

        basket.printAllProductsInfo();
        System.out.println(basket.basketCost());

        System.out.println(basket.checkProduct("Морковка"));
        System.out.println(basket.checkProduct("Лук"));

        basket.cleanBasket();
        System.out.println(basket.basketCost());
        System.out.println(basket.checkProduct("Морковка"));

    }
}
