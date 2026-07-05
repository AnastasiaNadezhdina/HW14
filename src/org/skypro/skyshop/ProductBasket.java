package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int size = 0;

    public void addProduct(Product product) {
        if (size < products.length) {
            products[size++] = product;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }

    public int getTotalPrice() {
        int sum = 0;
        for (Product p : products) {
            if (p != null) {
                sum += p.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        boolean empty = true;
        int specialCount = 0;
        for (Product p : products) {
            if (p != null) {
                System.out.println(p.toString());
                if (p.isSpecial()) {
                    specialCount++;
            }

                empty = false;
            }
        }
        if (empty) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println("Итого: " + getTotalPrice());
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProductByName(String name) {
        for (Product p : products) {
            if (p != null && p.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        size = 0;
    }
//    @Override
//    public String toString() {
//        return "Общая стоимость корзины: " + getTotalPrice();
//    }
}
