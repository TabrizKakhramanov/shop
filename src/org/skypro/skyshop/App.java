package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket productBasket = new ProductBasket();

        //добавление продукта в корзину
        productBasket.addProduct("milk",90);
        productBasket.addProduct("chocolate",60);
        productBasket.addDiscountedProduct("water",40,15);
        productBasket.addFixPriceProduct("tomatoes");
        productBasket.addProduct("meat",650);

        //добавление продукта в заполненную корзину
        productBasket.addProduct("juice",80);

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


        SearchEngine searchEngine = new SearchEngine(10);

        //создаем объекты классов наследников Product
        SimpleProduct milk = new SimpleProduct("milk",90);
        SimpleProduct milk2 = new SimpleProduct("milk2",190);
        SimpleProduct milk3 = new SimpleProduct("milk3",290);
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
        System.out.println(Arrays.toString(searchEngine.search("banana")));
        System.out.println(Arrays.toString(searchEngine.search("milk")));


    }
}
