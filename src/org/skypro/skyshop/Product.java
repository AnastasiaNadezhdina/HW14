package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
   private final String name;


   public Product(String name) {
      if (name == null || name.isBlank()) {
         throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов.");
      }
      this.name = name;
   }


   @Override
   public String getName() {
      return name;
   }

   @Override
   public String getSearchTerm() {
      return getName();
   }

   @Override
   public String getContentType() {
      return "PRODUCT";
   }

   public abstract boolean isSpecial();
   public abstract int getPrice();
   @Override
   public abstract String toString();

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Product product = (Product) o;
      return name.equals(product.name);
   }

   @Override
   public int hashCode() {
      return name.hashCode();
   }
}
