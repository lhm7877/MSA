package com.msa.template.coffee.microservices.core.product.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, String> {
	Mono<ProductEntity> findByProductId(int productId);
	Flux<ProductEntity> findAll();
}
