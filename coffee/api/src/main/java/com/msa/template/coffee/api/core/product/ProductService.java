package com.msa.template.coffee.api.core.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
	@GetMapping(
		value    = "/product/{productId}",
		produces = "application/json")
	Mono<ProductVo> getProduct(@PathVariable int productId);

	@GetMapping(
		value    = "/products",
		produces = "application/json")
	Flux<ProductVo> getProducts();
}
