package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduc;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;



public class App {
    public static void main (String [] args){
        Product product1 = new SimpleProduct("Батон", 65);
        Product product2 = new SimpleProduct("Молоко", 209);
        Product product3 = new DiscountedProduc("Сметана", 95, 15);
        Product product4 = new DiscountedProduc("Колбаса", 185, 25);
        Product product5 = new FixPriceProduct("Квас");
        Product product6 = new FixPriceProduct("Творог");

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
