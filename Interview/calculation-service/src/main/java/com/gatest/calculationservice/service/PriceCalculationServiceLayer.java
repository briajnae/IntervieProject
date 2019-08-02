package com.gatest.calculationservice.service;

import com.gatest.calculationservice.util.feign.ProductsClient;
import com.gatest.calculationservice.util.feign.TaxClient;
import com.gatest.calculationservice.util.model.Product;
import com.gatest.calculationservice.util.model.Tax;
import com.gatest.calculationservice.viewmodel.PriceCalculationViewModel;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Objects;

@Component
public class PriceCalculationServiceLayer {

    private  TaxClient taxClient;
    private ProductsClient productsClient;

    @Autowired
    public PriceCalculationServiceLayer(TaxClient taxClient, ProductsClient productsClient){
        this.taxClient = taxClient;
        this.productsClient = productsClient;
    }

    public PriceCalculationViewModel getCalculation(int id, int quantity, boolean exempt){

        NumberFormat format = new DecimalFormat("#.##");

        Product product = productsClient.getProductByProductId(id);
        Tax tax = taxClient.getTaxByCategory(product.getCategory());

        double totalTaxCal = (product.getPricePerUnit() * quantity) * (tax.getTaxPercent() / 100);

        if(exempt){
            totalTaxCal = 0;
        }

        double totalCal = (product.getPricePerUnit() * quantity) + totalTaxCal;

        PriceCalculationViewModel pvm = new PriceCalculationViewModel();
        pvm.setProductId(Integer.toString(id));
        pvm.setProductDescription(product.getProductDescription());
        pvm.setQuantity(quantity);
        pvm.setPricePerUnit(product.getPricePerUnit());
        pvm.setTaxPercent(tax.getTaxPercent());
        pvm.setTotalTax(Double.parseDouble(format.format(totalTaxCal)));
        pvm.setTotal(Double.parseDouble(format.format(totalCal)));

        return pvm;

    }

}
