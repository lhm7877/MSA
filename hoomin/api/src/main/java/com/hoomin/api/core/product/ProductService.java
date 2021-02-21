package com.hoomin.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    @GetMapping(
            value = "/product/{productId}",
            produces = "applcation/json")
    Product getProduct(@PathVariable int productId);
}
