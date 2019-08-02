package com.gatest.calculationservice.util.feign;

import com.gatest.calculationservice.util.model.Tax;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "Tax-repository", path = "/taxes")
public interface TaxClient {

    @GetMapping(value = "/{category}")
    Tax getTaxByCategory(@PathVariable("category") String category);
}
