package com.msa.template.coffee.productcompositeservice.services;

import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.product.ProductDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductCompositeIntegration implements ProductService {
	@Override
	public Mono<ProductDto> getProduct(int productId) {
		// to ProductServiceImpl
		return null;
	}

	@Override
	public Flux<ProductDto> getProducts() {
		return null;
	}
}
