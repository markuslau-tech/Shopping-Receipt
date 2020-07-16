package test;

import com.shoppingreceipt.Calculation;
import com.shoppingreceipt.Product;
import com.shoppingreceipt.QuantityOfProduct;
import com.shoppingreceipt.constant.Category;
import com.shoppingreceipt.constant.Location;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UnitTest {

    Calculation c = new Calculation();

    @Test
    public void subTotalTest(){
        Product test_product1 = new Product("test product", Category.OTHERS,1.1);
        Product test_product2 = new Product("test product2", Category.FOOD,2.31);
        QuantityOfProduct testQOP1 = new QuantityOfProduct(test_product1, 5);
        QuantityOfProduct testQOP2 = new QuantityOfProduct(test_product2, 3);
        List<QuantityOfProduct> testReceipt1 = Arrays.asList(testQOP1, testQOP2);
        assertEquals(BigDecimal.valueOf(12.43), c.getSubTotal(testReceipt1));
    }


    @Test
    public void taxTest(){
        Product test_product3 = new Product("test product3", Category.OTHERS,1.1);
        Product test_product4 = new Product("test product4", Category.CLOTHING,2.83);
        QuantityOfProduct testQOP3 = new QuantityOfProduct(test_product3, 3);
        QuantityOfProduct testQOP4 = new QuantityOfProduct(test_product4, 5);
        List<QuantityOfProduct> testReceipt2 = Arrays.asList(testQOP3, testQOP4);
        assertEquals(BigDecimal.valueOf(1.75), c.getTax(testReceipt2, Location.CA));
    }

    @Test
    public void taxExemptTest(){
        Product test_product5 = new Product("test product5", Category.FOOD,3.85);
        Product test_product6 = new Product("test product6", Category.FOOD,2.96);
        QuantityOfProduct testQOP5 = new QuantityOfProduct(test_product5, 3);
        QuantityOfProduct testQOP6 = new QuantityOfProduct(test_product6, 5);
        List<QuantityOfProduct> testReceipt3 = Arrays.asList(testQOP5, testQOP6);
        assertEquals(BigDecimal.ZERO, c.getTax(testReceipt3, Location.CA));
    }

    @Test
    public void totalTest(){
        Product test_product7 = new Product("test product7", Category.FOOD,2.6);
        Product test_product8 = new Product("test product8", Category.CLOTHING,1.0);
        Product test_product9 = new Product("test product9", Category.OTHERS,25.98);
        QuantityOfProduct testQOP7 = new QuantityOfProduct(test_product7, 3);
        QuantityOfProduct testQOP8 = new QuantityOfProduct(test_product8, 5);
        QuantityOfProduct testQOP9 = new QuantityOfProduct(test_product9, 1);
        List<QuantityOfProduct> testReceipt3 = Arrays.asList(testQOP7, testQOP8, testQOP9);
        assertEquals(BigDecimal.valueOf(41.83), c.getTotal(testReceipt3, Location.CA));
    }

}
