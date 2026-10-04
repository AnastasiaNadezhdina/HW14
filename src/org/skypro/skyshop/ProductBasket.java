package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : products) {
                sum += p.getPrice();

        }
        return sum;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            int specialCount = 0;
            for (Product p : products) {
                System.out.println(p.toString());
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = new ArrayList<>();
        Iterator<Product> it = products.iterator();
        while (it.hasNext()) {
            Product p = it.next();
            if (p.getName().equals(name)) {
                removed.add(p);
                it.remove();
            }
        }
        return removed;
    }
}
//    @Override
//    public String toString() {
//        return "Общая стоимость корзины: " + getTotalPrice();
//    }

