package com.msa.template.coffee.orderservice.repository;

import com.msa.template.coffee.orderservice.entity.OrderGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsRepository extends JpaRepository<OrderGoods, Long> {
}

