package com.gatest.calculationservice.serviceLayer.unit;

import com.gatest.calculationservice.controller.PriceCalculationController;
import com.gatest.calculationservice.service.PriceCalculationServiceLayer;
import com.gatest.calculationservice.util.feign.ProductsClient;
import com.gatest.calculationservice.util.feign.TaxClient;
import com.gatest.calculationservice.viewmodel.PriceCalculationViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MockTests {

    @Mock
    private PriceCalculationServiceLayer service;
    @Autowired
    private TaxClient taxClient;
    @Autowired
    private ProductsClient productsClient;

    @Before
    public void setUp() {

        setUpService();

    }

    @Test
    public void contexLoads() throws Exception {
        assertNotNull(service);
    }

    public void setUpService() {

        PriceCalculationViewModel pvm = new PriceCalculationViewModel();
        pvm.setProductId("1001");
        pvm.setProductDescription("a bunch of apples");
        pvm.setPricePerUnit(1.5);
        pvm.setQuantity(20);
        pvm.setTaxPercent(8.25);
        pvm.setTotalTax(2.46);
        pvm.setTotal(32.46);

        doReturn(pvm).when(service).getCalculation(1001, 20, true);

    }

    @Test
    public void getCalculation() {

        PriceCalculationViewModel pvm = new PriceCalculationViewModel();
        pvm.setProductId("1001");
        pvm.setProductDescription("a bunch of apples");
        pvm.setPricePerUnit(1.5);
        pvm.setQuantity(20);
        pvm.setTaxPercent(8.25);
        pvm.setTotalTax(2.46);
        pvm.setTotal(32.46);

        PriceCalculationViewModel fromService = service.getCalculation(1001, 20, true);

        assertEquals(pvm, fromService);

    }

}
