package com.shoppingreceipt;

import com.shoppingreceipt.constant.Location;

import java.util.List;

public class Printer {

    private static final String HR = "======================================";

    public static void printReceipt(List<QuantityOfProduct> products, Location location) {

        Calculation calculation = new Calculation();

        System.out.println(HR);
        System.out.format("%-15s %10s %10s %n", "Name", "Price", "qty");
        for (QuantityOfProduct product:products) {
            System.out.format("%-15s %5s %5s %9s %n",
                    product.getProduct().getName(),
                    "$", product.getProduct().getPrice(),
                    product.getQty());
        }

        System.out.format("%-15s %15s %5.2f %n", "subtotal:", "$", calculation.getSubTotal(products));
        System.out.format("%-15s %15s %5.2f %n", "sale tax:", "$", calculation.getTax(products, location));
        System.out.format("%-15s %15s %5.2f %n", "total:", "$", calculation.getTotal(products, location));
        System.out.println(HR);
    }
}
