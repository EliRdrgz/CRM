package com.ironhack.classes;

import com.ironhack.enums.TypeOfProduct;

public class Product {

    final TypeOfProduct product;
    final int quantity;

    public Product(TypeOfProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + product + "\n" +
                "Quantity: " + quantity;
    }
}