package org.skypro.skyshop.product;

public class SimpleProduct extends org.skypro.skyshop.product.Product {
private final int price;

    public SimpleProduct(String name, int price) {
        super(name);
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
