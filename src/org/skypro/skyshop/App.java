package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.sql.SQLOutput;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        //добавление продукта в корзину
        productBasket.addProduct("milk", 90);
        productBasket.addProduct("chocolate", 60);
        productBasket.addDiscountedProduct("water", 40, 15);
        productBasket.addFixPriceProduct("tomatoes");
        productBasket.addProduct("meat", 650);

        //добавление продукта в заполненную корзину
        productBasket.addProduct("juice", 80);

        //печать содержимого корзины
        productBasket.printAllProducts();

        //получение стоимости корзины
        System.out.println(productBasket.allProductsPrise());

        //поиск товара, который есть в корзине
        System.out.println(productBasket.checkProductByName("tomatoes"));

        //поиск товара, которого нет в корзине
        System.out.println(productBasket.checkProductByName("alcohol"));

        //очистка корзины
        productBasket.cleanProductBasket();

        //печать содержимого пустой корзины
        productBasket.printAllProducts();

        //получение стоимости пустой корзины
        System.out.println(productBasket.allProductsPrise());

        //поиск товара по имени в пустой корзине
        System.out.println(productBasket.checkProductByName("milk"));


        SearchEngine searchEngine = new SearchEngine();

        //создаем объекты классов наследников Product
        SimpleProduct milk = new SimpleProduct("milk", 90);
        SimpleProduct milk2 = new SimpleProduct("milk2", 190);
        SimpleProduct milk3 = new SimpleProduct("milk3", 290);
        FixPriceProduct banana = new FixPriceProduct("banana");
        DiscountedProduct chocolate = new DiscountedProduct("chocolate", 90, 30);

        //добавляем ранее созданные товары в массив для поиска
        searchEngine.add(milk);
        searchEngine.add(milk2);
        searchEngine.add(milk3);
        searchEngine.add(banana);
        searchEngine.add(chocolate);

        //создаем объекты класса Article
        Article article1 = new Article("bananas article", "Eat bananas!!!");
        Article article2 = new Article("milk article", "Drink milk!!!");

        //добавляем их в массив
        searchEngine.add(article1);
        searchEngine.add(article2);

        //проверка поиска
        System.out.println(searchEngine.search("banana"));
        System.out.println(searchEngine.search("milk"));

        //проверка работы выброса исключений
        System.out.println(" ");
        System.out.println("ИСКЛЮЧЕНИЯ ДЗ:");
        try {
            SimpleProduct potato = new SimpleProduct("  ", 100);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct pen = new DiscountedProduct("Pen", 9, 120);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        //проверка работы метода поиска лучшего результата
        try {
            System.out.println(searchEngine.searchTheBest("banana").toString());
        } catch (BestResultNotFound e) {
            System.out.println("Нет совпадений!");
        }
        try {
            System.out.println(searchEngine.searchTheBest("jeans").toString());
        } catch (BestResultNotFound e) {
            System.out.println("Нет совпадений!");
        }

        //Листы дз
        System.out.println(" ");
        System.out.println("ЛИСТЫ ДЗ:");

        ProductBasket basket = new ProductBasket();
        basket.addProduct("banana",100);
        basket.addProduct("avocado",90);
        basket.addProduct("pringles",150);
        basket.addProduct("pen", 30);
        basket.addDiscountedProduct("bread",100,40);
        basket.addDiscountedProduct("beer", 200,15);
        basket.addFixPriceProduct("pen");
        basket.addFixPriceProduct("pencil");
        basket.addFixPriceProduct("banana");

        basket.printAllProducts();
        System.out.println("Удаленные продукты: " + basket.removeProductsByName("beer"));
        System.out.println("Удаленные продукты: " +basket.removeProductsByName("pen"));
        System.out.println("Удаленные продукты: " +basket.removeProductsByName("banana"));
        System.out.println("После удаления!");
        basket.printAllProducts();

        System.out.println(basket.removeProductsByName("pen"));
        if (basket.removeProductsByName("pen").isEmpty()){
            System.out.println("Список пуст!");
        }

    }
}
