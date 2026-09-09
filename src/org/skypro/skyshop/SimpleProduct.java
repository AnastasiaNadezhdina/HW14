package org.skypro.skyshop.product;

public class SimpleProduct extends org.skypro.skyshop.product.Product {
private final int price;

    public SimpleProduct(String name, int price) throws IllegalAccessException {
        super(name);
        if (price <= 0) {
            throw new IllegalAccessException("Цена продукта должна быть строго больше 0 (указано: " + price + ")");
        }
        this.price = price;
    }
    @Override
    public boolean isSpecial(){
        return false;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return getName() + " : " + getPrice();
    }


}
