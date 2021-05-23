package com.msa.template.coffee.microservice.core.order.repository;

import com.msa.template.coffee.microservice.core.order.entity.OrdersHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersHistoryRepository extends JpaRepository<OrdersHistoryEntity, Long> {
}

