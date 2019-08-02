package com.gatest.calculationservice.controller;

import com.gatest.calculationservice.service.PriceCalculationServiceLayer;
import com.gatest.calculationservice.viewmodel.PriceCalculationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceCalculationController {

    private PriceCalculationServiceLayer serviceLayer;

    public PriceCalculationController(PriceCalculationServiceLayer serviceLayer){
        this.serviceLayer=serviceLayer;
    }

    @GetMapping(value = "api/price/product/{product_id}")
    PriceCalculationViewModel getCalculation(@RequestParam int quantity, @PathVariable("product_id") int id, @RequestParam(value = "exempt", required = false) boolean exempt){
        return serviceLayer.getCalculation(id,quantity,exempt);
    }

}
