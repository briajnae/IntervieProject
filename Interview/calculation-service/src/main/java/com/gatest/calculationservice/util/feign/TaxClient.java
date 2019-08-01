package com.gatest.calculationservice.util.feign;

import com.gatest.calculationservice.util.model.Tax;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "Tax-repository", path = "/taxes")
public interface TaxClient {

    @GetMapping
    Tax getTaxByCategory(String category);
}
