package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        basket.addProduct(new SimpleProduct("Колбаса", 280));
        basket.addProduct(new DiscountedProduct("Сыр", 250, 15));
        basket.addProduct(new FixPriceProduct("Масло"));
        basket.addProduct(new DiscountedProduct("Молоко", 140, 15));
        basket.addProduct(new FixPriceProduct("Хлеб"));

        basket.printBasket();
    }
}