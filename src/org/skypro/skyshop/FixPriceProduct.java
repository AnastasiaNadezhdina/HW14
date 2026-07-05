package org.skypro.skyshop.product;

public class FixPriceProduct extends org.skypro.skyshop.product.Product {
    private static final int FIXED_PRICE = 115;

    public FixPriceProduct(String name) {
        super(name);
    }
    @Override
    public boolean isSpecial(){
        return true;
    }
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }
    @Override
    public String toString(){
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }
}
