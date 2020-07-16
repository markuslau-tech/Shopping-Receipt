package com.shoppingreceipt.constant;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum Location {
    CA(0.0975, Arrays.asList(Category.FOOD)),
    NY(0.08875, Arrays.asList(Category.FOOD, Category.CLOTHING));

    private BigDecimal taxRate;
    private List<Category> exemptList;

    Location(Double taxRate, List<Category> exemptList) {
        this.taxRate = BigDecimal.valueOf(taxRate);
        this.exemptList = exemptList;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public List<Category> getExemptList() {
        return exemptList;
    }
}
