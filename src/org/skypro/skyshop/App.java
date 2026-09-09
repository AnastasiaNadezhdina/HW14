package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.search.Searchable;

public class App {
    public static void main (String [] args) throws IllegalAccessException {

        try {
            Product p1 = new org.skypro.skyshop.product.SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product p2 = new org.skypro.skyshop.product.SimpleProduct("Молоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product p3 = new org.skypro.skyshop.product.DiscountedProduc("Сметана", 90, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        try {
            Product p4 = new org.skypro.skyshop.product.DiscountedProduc("Сыр", 80, 101);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Product product1 = new org.skypro.skyshop.product.SimpleProduct("Батон", 65);
        Product product2 = new org.skypro.skyshop.product.SimpleProduct("Молоко", 209);
        Product product3 = new org.skypro.skyshop.product.DiscountedProduc("Сметана", 95, 15);
        Product product4 = new org.skypro.skyshop.product.DiscountedProduc("Колбаса", 185, 25);
        Product product5 = new org.skypro.skyshop.product.FixPriceProduct("Квас");
        Product product6 = new org.skypro.skyshop.product.FixPriceProduct("Творог");

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

        // Создаём статьи
        Article a1 = new Article("Польза молока", "Молоко содержит кальций и витамины.");
        Article a2 = new Article("Как выбрать хлеб", "Советы по выбору свежего хлеба.");
        // Поисковый движок
        org.skypro.skyshop.search.SearchEngine se = new org.skypro.skyshop.search.SearchEngine(10);
        se.add(product1);
        se.add(product2);
        se.add(product3);
        se.add(product4);
        se.add(product5);
        se.add(product6);
        se.add(a1);
        se.add(a2);
        // Демонстрация поиска
        try{
            Searchable best = se.findBest("Молоко");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (org.skypro.skyshop.search.BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        // Поиск без результата
        try {
            Searchable best = se.findBest("несуществующее слово");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (org.skypro.skyshop.search.BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}


