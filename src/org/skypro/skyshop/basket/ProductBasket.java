package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productMap = new TreeMap<>();

    public void addProduct(Product product) {
        LinkedList<Product> products = new LinkedList<>();
        if (!productMap.containsKey(product.getName())) {
            products = new LinkedList<>();
            productMap.put(product.getName(), products);
        } else {
            productMap.get(product.getName());
        }
        products.add(product);
    }

    public LinkedList<Product> deleteProductByName(String name) {
        if (productMap.containsKey(name)) {
            List<Product> deletedProducts = productMap.remove(name);
            return new LinkedList<>(deletedProducts);
        }
        return new LinkedList<>();
    }

    public double getTotalCost() {
      double sum = 0;
      for (List <Product> products: productMap.values()) {
          for (Product product: products) {
              sum += product.getPrice();
          }
      }
      return sum;
    }

    public void printBasket() {
        int counter = 0;
        System.out.println("В корзине пусто ");
        double totalPrice = 0;
        int countSpecialProduct = 0;
        for (List <Product> products: productMap.values()) {
            for (Product product: products) {
                if (product != null) {
                    System.out.println(product);
                    totalPrice += product.getPrice();
                    if(product.isSpecial()) {
                        countSpecialProduct++;
                    }
                }
            }
        }
        System.out.println("Итого: " + totalPrice);
        System.out.println("Специальных товаров: " + countSpecialProduct);
    }

    public boolean findByName(String name) {
        return productMap.containsKey(name);
    }

    public void clearBasket() {
        productMap.clear();
    }
}
