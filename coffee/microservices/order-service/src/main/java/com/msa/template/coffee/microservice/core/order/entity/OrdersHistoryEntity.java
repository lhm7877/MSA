package com.msa.template.coffee.microservice.core.order.entity;

import com.msa.template.coffee.api.core.order.enums.PaymentType;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrdersHistoryEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private Long orderId;

    /* 주문 번호에 해당하는 회원은 변경 불가 */
    @Column(nullable = false, updatable = false)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(precision = 5, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountedPrice;

    private boolean cancelYn;

    @JoinColumn(name = "orders_history_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderGoodsEntity> orderGoodEntities = new ArrayList<>();

    public List<OrderGoodsEntity> addOptions(List<OrderGoodsEntity> orderGoodEntities) {
        this.orderGoodEntities.addAll(orderGoodEntities);
        return this.orderGoodEntities;
    }

    public List<OrderGoodsEntity> removeOptions(List<OrderGoodsEntity> orderGoodEntities) {
        this.orderGoodEntities.removeAll(orderGoodEntities);
        return this.orderGoodEntities;
    }

    public Long getId() {
        return id;
    }

    public static OrdersHistoryEntity create(Long orderId, Long memberId, PaymentType paymentType, BigDecimal originalPrice,
                                             BigDecimal discountPercent, BigDecimal discountedPrice, boolean cancelYn,
                                             List<OrderGoodsEntity> orderGoodEntities) {
        OrdersHistoryEntity ordersHistoryEntity = new OrdersHistoryEntity();

        ordersHistoryEntity.orderId = orderId;
        ordersHistoryEntity.memberId = memberId;
        ordersHistoryEntity.paymentType = paymentType;
        ordersHistoryEntity.originalPrice = originalPrice;
        ordersHistoryEntity.discountPercent = discountPercent;
        ordersHistoryEntity.discountedPrice = discountedPrice;
        ordersHistoryEntity.cancelYn = cancelYn;
        ordersHistoryEntity.orderGoodEntities.addAll(orderGoodEntities);

        return ordersHistoryEntity;
    }

    public static OrdersHistoryEntity of(OrdersEntity ordersEntity) {
        OrdersHistoryEntity ordersHistoryEntity = new OrdersHistoryEntity();

        ordersHistoryEntity.orderId = ordersEntity.getId();
        ordersHistoryEntity.memberId = ordersEntity.getMemberId();
        ordersHistoryEntity.paymentType = ordersEntity.getPaymentType();
        ordersHistoryEntity.originalPrice = ordersEntity.getOriginalPrice();
        ordersHistoryEntity.discountPercent = ordersEntity.getDiscountPercent();
        ordersHistoryEntity.discountedPrice = ordersEntity.getDiscountedPrice();
        ordersHistoryEntity.cancelYn = ordersEntity.getCancelYn();
        ordersHistoryEntity.orderGoodEntities.addAll(ordersEntity.getOrderGoodEntities());

        return ordersHistoryEntity;
    }

}
