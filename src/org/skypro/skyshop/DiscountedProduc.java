package org.skypro.skyshop.product;

public class DiscountedProduc extends org.skypro.skyshop.product.Product {
    private final int basePrice;
    private final int discount;

    public DiscountedProduc(String name, int basePrice, int discount) throws IllegalAccessException {
        super(name);
        if (basePrice <= 0){
            throw new IllegalAccessException("Базовая цена должна быть строго больше 0 (указано: " + basePrice + ")");
        }
        if (discount < 0 || discount > 100){
            throw new IllegalAccessException("Скидка должна быть в диапазоне от 0 до 100 (указано: " + discount + ")");
        }
        this.basePrice = basePrice;
        this.discount = discount;
    }
    @Override
    public boolean isSpecial(){
        return true;
    }
    @Override
    public int getPrice() {
        return basePrice * (100 - discount) / 100;
    }
    @Override
    public String toString(){
        return getName() + ":" + getPrice() + " ( " + discount + " %)";
    }
}
