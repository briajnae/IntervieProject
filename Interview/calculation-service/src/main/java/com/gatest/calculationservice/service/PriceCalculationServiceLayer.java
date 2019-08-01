package com.gatest.calculationservice.service;

import com.gatest.calculationservice.util.feign.ProductsClient;
import com.gatest.calculationservice.util.feign.TaxClient;
import com.gatest.calculationservice.util.model.Product;
import com.gatest.calculationservice.util.model.Tax;
import com.gatest.calculationservice.viewmodel.PriceCalculationViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    public PriceCalculationViewModel getCalculation(int id, int quantity){
        try{
          Product product = productsClient.getProductByProductId(id);
          Tax tax =taxClient.getTaxByCategory(product.getCategory());

          double totalTaxCal = product.getPricePerUnit() * (tax.getTaxPercent() / 100);
          double totalCal = product.getPricePerUnit() + totalTaxCal;

          PriceCalculationViewModel pvm = new PriceCalculationViewModel();
          pvm.setProductId(product.getProductId());
          pvm.setProductDescription(product.getProductDescription());
          pvm.setQuantity(quantity);
          pvm.setPricePerUnit(product.getPricePerUnit());
          pvm.setTaxPercent(tax.getTaxPercent());
          pvm.setTotalTax(totalTaxCal);
          pvm.setTotal(totalCal);

          return pvm;

        }catch (EmptyResultDataAccessException e){
            System.out.println(e.getMessage());
            return null;
        }


    }


}
