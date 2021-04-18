package com.msa.template.coffee.orderservice.repository;

import com.msa.template.coffee.orderservice.entity.OrdersHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersHistoryRepository extends JpaRepository<OrdersHistory, Long> {
}

