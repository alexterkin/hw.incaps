package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int counter = 0;

    public void addProduct(Product product) {
        if (counter >= products.length) {
            System.out.println("Невозможно добавить продукт ");
        }
        for (int i =  0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                counter++;
                break;
            }
        }
    }

    public int getTotalCost() {
      int sum = 0;
      for (Product product: products) {
          if (product != null) {
              sum += product.getPrice();
          }
      }
      return sum;
    }

    public void printBasket() {
        if (counter == 0) {
            System.out.println("В корзине пусто ");
        }
        for (Product product: products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean findByName(String name) {
        for (Product product: products) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        Arrays.fill(products, null);
    }
}
