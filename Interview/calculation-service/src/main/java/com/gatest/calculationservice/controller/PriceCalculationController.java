package com.gatest.calculationservice.controller;

import com.gatest.calculationservice.service.PriceCalculationServiceLayer;
import com.gatest.calculationservice.viewmodel.PriceCalculationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCalculationController {

    @Autowired
    private  PriceCalculationServiceLayer serviceLayer;

    @GetMapping(value = "api/price/product/{product_id}?quantity={num}")
    PriceCalculationViewModel getPrice(@PathVariable("num") int num, @PathVariable("product_id") int id){
        return serviceLayer.getCalculation(id,num);
    }
}
