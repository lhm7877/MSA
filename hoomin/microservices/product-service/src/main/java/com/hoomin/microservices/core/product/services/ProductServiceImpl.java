package com.hoomin.microservices.core.product.services;

import com.hoomin.api.core.product.Product;
import com.hoomin.api.core.product.ProductService;
import com.hoomin.util.http.ServiceUtil;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceImpl implements ProductService {

    private final ServiceUtil serviceUtil;

    public ProductServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }
}
