package com.msa.template.coffee.microservices.core.product.services;

import org.springframework.web.bind.annotation.RestController;

import com.msa.template.coffee.api.core.product.ProductDto;
import com.msa.template.coffee.api.core.product.ProductService;
import com.msa.template.coffee.microservices.core.product.persistence.ProductRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;
	private final ProductMapper mapper;

	@Override
	public Mono<ProductDto> getProduct(int productId) {
		return repository.findByProductId(productId)
			.switchIfEmpty(Mono.error(new RuntimeException("없어")))
			.map(mapper::entityToApi);
	}

	@Override
	public Flux<ProductDto> getProducts() {
		return null;
	}
}
