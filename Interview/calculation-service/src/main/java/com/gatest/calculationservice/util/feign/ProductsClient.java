package com.gatest.calculationservice.util.feign;

import com.gatest.calculationservice.util.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product-repository")
public interface ProductsClient {
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    Product getProductByProductId(@PathVariable("id") int id);
}
