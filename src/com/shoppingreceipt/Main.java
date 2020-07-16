package com.shoppingreceipt;

import com.shoppingreceipt.constant.Category;
import com.shoppingreceipt.constant.Location;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product book = new Product("book", Category.OTHERS,17.99);
        Product potatoChips = new Product("potato chips", Category.FOOD,3.99);
        Product pencil = new Product("pencil", Category.OTHERS, 2.99);
        Product shirt = new Product("shirt", Category.CLOTHING, 29.99);

        QuantityOfProduct book1 = new QuantityOfProduct(book, 1);
        QuantityOfProduct potatoChips1 = new QuantityOfProduct(potatoChips, 1);
        QuantityOfProduct pencil3 = new QuantityOfProduct(pencil, 3);
        QuantityOfProduct pencil2 = new QuantityOfProduct(pencil, 2);
        QuantityOfProduct shirt1 = new QuantityOfProduct(shirt, 1);

        Printer printer = new Printer();

        List<QuantityOfProduct> receipt1 = Arrays.asList(book1,potatoChips1);
        printer.printReceipt(receipt1, Location.CA);

        List<QuantityOfProduct> receipt2 = Arrays.asList(book1,pencil3);
        printer.printReceipt(receipt2, Location.NY);

        List<QuantityOfProduct> receipt3 = Arrays.asList(pencil2,shirt1);
        printer.printReceipt(receipt3, Location.NY);

    }
}
