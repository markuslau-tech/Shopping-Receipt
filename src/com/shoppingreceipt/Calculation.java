package com.shoppingreceipt;

import com.shoppingreceipt.constant.Location;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculation {

    public BigDecimal getSubTotal(List<QuantityOfProduct> productList) {
        return productList.stream()
                .reduce(BigDecimal.ZERO, (subtotal, product) ->
                        subtotal.add(BigDecimal.valueOf(product.getProduct().getPrice()).multiply(BigDecimal.valueOf(product.getQty()))), BigDecimal::add);
    }

    public BigDecimal getTax(List<QuantityOfProduct> productList, Location location) {
        BigDecimal taxAmt = productList.stream().reduce(BigDecimal.ZERO, (tax, product) ->
            !location.getExemptList().contains(product.getProduct().getCategory()) ?
                    tax.add(location.getTaxRate()
                            .multiply(BigDecimal.valueOf(product.getProduct().getPrice()))
                            .multiply(BigDecimal.valueOf(product.getQty()))) : tax
        , BigDecimal::add);
        return taxAmt.multiply(BigDecimal.valueOf(20)).setScale(0,RoundingMode.UP).divide(BigDecimal.valueOf(20));
    }
    
    public BigDecimal getTotal(List<QuantityOfProduct> productList, Location location) {
        return getSubTotal(productList).add(getTax(productList, location));
    }

}
