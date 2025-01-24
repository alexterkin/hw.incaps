package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new Product("Колбаса", 280));
        basket.addProduct(new Product("Сыр", 230));
        basket.addProduct(new Product("Масло", 210));
        basket.addProduct(new Product("Молоко", 130));
        basket.addProduct(new Product("Хлеб", 90));

        basket.addProduct(new Product("Рыба", 350));
        basket.addProduct(new Product("Пельмени", 310));

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost() + " рублей");

        System.out.println("Поиск товара: " + basket.findByName("Колбаса"));

        System.out.println("Поиск товара: " + basket.findByName("Кофе"));

        basket.clearBasket();

        ProductBasket basket1 = new ProductBasket();

        basket1.printBasket();

        System.out.println("Общая стоимость корзины: " + basket1.getTotalCost() + " рублей");

        System.out.println("Поиск товара: " + basket1.findByName("Йогурт"));
    }
}