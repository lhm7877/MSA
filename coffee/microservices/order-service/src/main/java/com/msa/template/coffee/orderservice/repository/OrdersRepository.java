package com.msa.template.coffee.orderservice.repository;

import com.msa.template.coffee.orderservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    List<Orders> findAllByMemberId(long memberId);
    Optional<Orders> findByIdAndMemberId(long id, long memberId);

}

