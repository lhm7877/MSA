package com.msa.template.coffee.productservice.services;

import org.springframework.web.bind.annotation.RestController;

import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.api.core.product.ProductVo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductServiceImpl implements ProductService {
	@Override
	public Mono<ProductVo> getProduct(int productId) {
		return null;
	}

	@Override
	public Flux<ProductVo> getProducts() {
		return null;
	}
}
