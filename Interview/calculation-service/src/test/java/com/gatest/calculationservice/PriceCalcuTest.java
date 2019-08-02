package com.gatest.calculationservice;

import com.gatest.calculationservice.util.feign.ProductsClient;
import com.gatest.calculationservice.util.feign.TaxClient;
import com.gatest.calculationservice.util.model.Product;
import com.gatest.calculationservice.util.model.Tax;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PriceCalcuTest {


    @Autowired
    TaxClient taxClient;
    @Autowired
    ProductsClient productClient;
    @Test
    public void getProduct() {
        Product product = productClient.getProductByProductId(1001);
        Product testProduct = new Product();
        testProduct.setProductId(product.getProductId());
        testProduct.setProductDescription(product.getProductDescription());
        testProduct.setPricePerUnit(product.getPricePerUnit());
        testProduct.setCategory(product.getCategory());
        assertEquals(testProduct, product);
    }
    @Test
    public void getTax() {
        Tax tax = taxClient.getTaxByCategory("tobacco");

        Tax testTax = new Tax();
        testTax.setCategory(tax.getCategory());
        testTax.setTaxPercent(tax.getTaxPercent());

        assertEquals(testTax, tax);
    }

}
