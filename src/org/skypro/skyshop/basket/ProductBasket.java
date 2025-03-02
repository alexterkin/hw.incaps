package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private final LinkedList<Product> products = new LinkedList<>();
    private int counter = 0;

    public void addProduct(Product product) {
        products.add(product);
        counter++;
    }

    public LinkedList<Product> deleteProductByName(String name) {
        LinkedList<Product> deletedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            if(element.getName().equals(name)) {
                deletedProducts.add(element);
                iterator.remove();
                System.out.println("Продукт " + name + " удален из корзины");
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Корзина пуста!");
        }
        return deletedProducts;
    }

    public double getTotalCost() {
      double sum = 0;
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
        double totalPrice = 0;
        int countSpecialProduct = 0;
        for (Product product: products) {
            if (product != null) {
                System.out.println(product);
                totalPrice += product.getPrice();
                if(product.isSpecial()) {
                    countSpecialProduct++;
                }
            }
        }
        System.out.println("Итого: " + totalPrice);
        System.out.println("Специальных товаров: " + countSpecialProduct);
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
        products.clear();
    }
}
