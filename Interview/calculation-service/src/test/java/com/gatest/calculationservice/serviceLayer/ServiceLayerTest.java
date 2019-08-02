package com.gatest.calculationservice.serviceLayer;

import com.gatest.calculationservice.service.PriceCalculationServiceLayer;
import com.gatest.calculationservice.util.feign.ProductsClient;
import com.gatest.calculationservice.util.feign.TaxClient;
import org.junit.Before;
import org.mockito.Mock;


public class ServiceLayerTest {

    PriceCalculationServiceLayer serviceLayer;
    ProductsClient productsClient;
    TaxClient taxClient;

//    @Before
//    public void setUp(){
//        setUpProductsMock();
//        setUpTaxesMock();
//        serviceLayer = new PriceCalculationServiceLayer(taxClient,productsClient);
//    }
//
//    private void setUpProductsMock() {
//        productsClient = mock();
//    }
}
