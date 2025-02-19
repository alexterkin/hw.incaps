package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Колбаса", 280));
        basket.addProduct(new DiscountedProduct("Сыр", 250, 15));
        basket.addProduct(new FixPriceProduct("Масло"));
        basket.addProduct(new DiscountedProduct("Молоко", 140, 15));
        basket.addProduct(new FixPriceProduct("Хлеб"));

        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine(5);
        Searchable sausage = new SimpleProduct("Колбаса", 280);
        Searchable cheese = new DiscountedProduct("Сыр", 250, 15);
        Searchable butter = new FixPriceProduct("Масло");
        Searchable milk = new DiscountedProduct("Молоко", 140, 15);
        Searchable bread = new FixPriceProduct("Хлеб");
        searchEngine.add(sausage);
        searchEngine.add(cheese);
        searchEngine.add(butter);
        searchEngine.add(milk);
        searchEngine.add(bread);

        Article aboutBread = new Article("Хлеб", "Хлеб всему голова");
        Article aboutButter = new Article("Масло", "Бутерброд вкуснее с маслом");
        Article aboutCheese = new Article("Сыр", "Сыр бывает с плесенью");
        searchEngine.add(aboutBread);
        searchEngine.add(aboutButter);
        searchEngine.add(aboutCheese);

        String clientRequest1 = "Хлеб";
        System.out.println("Поиск " + clientRequest1 + ": " + Arrays.toString(searchEngine.search(clientRequest1)));
        String clientRequest2 = "Сыр";
        System.out.println("Поиск " + clientRequest2 + ": " + Arrays.toString(searchEngine.search(clientRequest2)));
        String clientRequest3 = "Одежда";
        System.out.println("Поиск " + clientRequest3 + ": " + Arrays.toString(searchEngine.search(clientRequest3)));
        String clientRequest4 = "Бутерброд";
        System.out.println("Поиск " + clientRequest4 + ": " + Arrays.toString(searchEngine.search(clientRequest4)));
    }
}