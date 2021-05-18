package com.msa.template.coffee.orderservice.repository;

import com.msa.template.coffee.orderservice.entity.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Long> {

    List<OrdersEntity> findAllByMemberId(long memberId);
    Optional<OrdersEntity> findByIdAndMemberId(long id, long memberId);

}

