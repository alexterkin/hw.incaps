package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFoundException;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.LinkedList;
import java.util.Set;

public class App {
    public static void main(String[] args) throws BestResultNotFoundException {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Колбаса", 280));
        basket.addProduct(new FixPriceProduct("Масло"));
        basket.addProduct(new DiscountedProduct("Молоко", 140, 15));
        basket.addProduct(new SimpleProduct("Молоко топлёное", 175));
        basket.addProduct(new DiscountedProduct("Сыр", 250, 15));
        basket.addProduct(new FixPriceProduct("Хлеб"));
        basket.addProduct(new DiscountedProduct("Колбаса варёная", 320, 10));

        basket.printBasket();

        SearchEngine searchEngine = new SearchEngine();
        Searchable sausage = new SimpleProduct("Колбаса", 280);
        Searchable cheese = new DiscountedProduct("Сыр", 250, 15);
        Searchable butter = new FixPriceProduct("Масло");
        Searchable milk = new DiscountedProduct("Молоко", 140, 15);
        Searchable bread = new FixPriceProduct("Хлеб");
        Searchable milkOld = new SimpleProduct("Молоко топлёное", 175);
        searchEngine.add(sausage);
        searchEngine.add(cheese);
        searchEngine.add(butter);
        searchEngine.add(milk);
        searchEngine.add(bread);
        searchEngine.add(milkOld);

        Article aboutWhiteBread = new Article("Хлеб белый", "Часто используется для бутербродов");
        Article aboutBread = new Article("Хлеб", "Хлеб всему голова");
        Article aboutButter = new Article("Масло", "Бутерброд вкуснее с маслом");
        Article aboutCheese = new Article("Сыр", "Сыр бывает с плесенью");
        Article aboutMilk = new Article("Молоко пастеризованное", "Специально обработанное молоко");
        searchEngine.add(aboutWhiteBread);
        searchEngine.add(aboutBread);
        searchEngine.add(aboutButter);
        searchEngine.add(aboutCheese);
        searchEngine.add(aboutMilk);

        String clientRequest1 = "Хлеб";
        System.out.println("Поиск " + clientRequest1 + ": " + searchEngine.search(clientRequest1));
        String clientRequest2 = "Сыр";
        System.out.println("Поиск " + clientRequest2 + ": " + searchEngine.search(clientRequest2));
        String clientRequest3 = "Одежда";
        System.out.println("Поиск " + clientRequest3 + ": " + searchEngine.search(clientRequest3));
        String clientRequest4 = "Бутерброд";
        System.out.println("Поиск " + clientRequest4 + ": " + searchEngine.search(clientRequest4));

        try {
            basket.addProduct(new SimpleProduct("  ", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basket.addProduct(new SimpleProduct("Яблоко", -150));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basket.addProduct(new DiscountedProduct("Картофель", 85, 120));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Article aboutLemon = new Article("Польза лимона", "Лимон улучшает пищеварение");
        searchEngine.add(aboutLemon);

        searchEngine.getBestMatch("пищеварение");

        try {
            searchEngine.getBestMatch("витамины");
        } catch (BestResultNotFoundException e) {
            System.out.println(e.getMessage());
        }

        LinkedList<Product> deletedProducts = basket.deleteProductByName("Сыр");
        for (Product product: deletedProducts) {
            System.out.println(product);
        }

        basket.printBasket();

        basket.deleteProductByName("Лимон");

        String clientRequest = "Молоко";
        Set<Searchable> searchResults = searchEngine.search(clientRequest);
        for (Searchable entry : searchResults) {
            System.out.println("Имя продукта: " + entry.getName());
        }
    }
}