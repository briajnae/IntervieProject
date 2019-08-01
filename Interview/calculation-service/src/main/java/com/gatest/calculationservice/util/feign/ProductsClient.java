package com.gatest.calculationservice.util.feign;

import com.gatest.calculationservice.util.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "products-repository", path = "/products")
public interface ProductsClient {
    @GetMapping
    Product getProductByProductId(int id);
}
