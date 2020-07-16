package com.shoppingreceipt;

import com.shoppingreceipt.constant.Category;

public class Product {

    private String name;
    private Category category;
    private Double price;

    public Product(String name, Category category, Double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }

    public Category getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

}
