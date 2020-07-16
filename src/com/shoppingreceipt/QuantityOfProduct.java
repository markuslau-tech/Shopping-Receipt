package com.shoppingreceipt;

public class QuantityOfProduct {

    private Product product;
    private Integer qty;

    public QuantityOfProduct(Product product, Integer qty) {
        this.product = product;
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQty() {
        return qty;
    }
}
