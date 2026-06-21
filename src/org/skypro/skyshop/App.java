package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;


public class App {
    public static void main (String [] args){
        Product product1 = new Product("Хлеб", 65);
        Product product2 = new Product("Молоко", 209);
        Product product3 = new Product("Сметана", 95);
        Product product4 = new Product("Колбаса", 185);
        Product product5 = new Product("Квас", 74);
        Product product6 = new Product("Творог", 85);

        ProductBasket basket = new ProductBasket();
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);
        basket.addProduct(product6);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println("Молоко " + basket.containsProductByName("Молоко"));
        System.out.println("Сушки " + basket.containsProductByName("Сушки"));

        basket.clear();
        basket.printBasket();
        System.out.println("Общая стоимость: " + basket.getTotalPrice());
        System.out.println("Молоко " + basket.containsProductByName("Молоко"));
    }
}
