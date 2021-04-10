package com.msa.template.coffee.ordercompositeservice.services;

import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.product.ProductVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductCompositeIntegration implements ProductService {
	@Override
	public Mono<ProductVo> getProduct(int productId) {
		// to ProductServiceImpl
		return null;
	}

	@Override
	public Flux<ProductVo> getProducts() {
		return null;
	}
}
