package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products = new HashMap<>();


    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product p : productList) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("в корзине пусто");
        } else {
            int specialCount = 0;
            for (List<Product> productList : products.values()) {
                for (Product p : productList) {
                System.out.println(p.toString());
                if (p.isSpecial()) specialCount++;
                }
            }
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProductByName(String name) {
        List<Product> list = products.get(name);
        return list != null && !list.isEmpty();
    }

    public void clear() {
        products.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = products.remove(name);
        return removed != null ? removed : Collections.emptyList();
    }
}



