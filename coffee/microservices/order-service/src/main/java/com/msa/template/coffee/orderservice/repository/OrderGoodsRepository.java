package com.msa.template.coffee.orderservice.repository;

import com.msa.template.coffee.orderservice.entity.OrderGoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsRepository extends JpaRepository<OrderGoodsEntity, Long> {
}

