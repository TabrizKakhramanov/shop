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
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        //создание объектов продуктов
        SimpleProduct milk = new SimpleProduct("milk", 90);
        SimpleProduct milk2 = new SimpleProduct("milk2", 190);
        SimpleProduct milk3 = new SimpleProduct("milk3", 290);
        FixPriceProduct banana = new FixPriceProduct("banana");
        DiscountedProduct chocolate = new DiscountedProduct("chocolate", 90, 30);

        //создание списков объектов продуктов и их заполнение
        List<Product> products1 = new LinkedList<>();
        List<Product> products2 = new LinkedList<>();
        List<Product> products3 = new LinkedList<>();

        products1.add(milk);
        products1.add(banana);
        products2.add(milk2);
        products2.add(chocolate);
        products3.add(chocolate);
        products3.add(milk3);


        //добавление продукта в заполненную корзину
        productBasket.addProduct("Dima", products1);
        productBasket.addProduct("Nikita", products2);
        productBasket.addProduct("Egor", products3);

        //печать содержимого корзины
        productBasket.printAllProducts();

        //получение стоимости корзины
        System.out.println(productBasket.allProductsPrise());

        //поиск товара, который есть в корзине
        System.out.println(productBasket.checkProductByProductsName("tomatoes"));

        //поиск товара, которого нет в корзине
        System.out.println(productBasket.checkProductByProductsName("alcohol"));

        //количество особенных товаров
        System.out.println("Количество особенных твоаров: "+productBasket.countOfSpecialProducts());

        //очистка корзины
        productBasket.cleanProductBasket();

        //печать содержимого пустой корзины
        productBasket.printAllProducts();

        //получение стоимости пустой корзины
        System.out.println(productBasket.allProductsPrise());

        //поиск товара по имени в пустой корзине
        System.out.println(productBasket.checkProductByProductsName("milk"));


        SearchEngine searchEngine = new SearchEngine();

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
        System.out.println("Проверка поиска:");
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

        //Сеты дз


    }
}
