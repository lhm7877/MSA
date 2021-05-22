package com.msa.template.coffee.microservice.core.order.entity;

import com.msa.template.coffee.api.core.order.enums.PaymentType;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(indexes = {
        @Index(columnList = "memberId"),
        @Index(columnList = "paymentType")
})
public class OrdersEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

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

    private boolean cancelYn = false;

    private String cancelReason;

    @JoinColumn(name = "orders_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderGoodsEntity> orderGoodEntities = new ArrayList<>();

    public boolean getCancelYn() {
        return this.cancelYn;
    }

    //XXX 이후민 : Orders에 addoptions랑 OrderGoods에 addoptions는 어떤 차이가 있는거에요?
    public List<OrderGoodsEntity> addOptions(List<OrderGoodsEntity> orderGoodEntities) {
        this.orderGoodEntities.addAll(orderGoodEntities);
        return this.orderGoodEntities;
    }

    public List<OrderGoodsEntity> removeOptions(List<OrderGoodsEntity> orderGoodEntities) {
        this.orderGoodEntities.removeAll(orderGoodEntities);
        return this.orderGoodEntities;
    }

    public void cancelOrder(String cancelReason) {
        this.cancelYn = true;
        this.cancelReason = cancelReason;
    }

    public static OrdersEntity create(Long memberId, PaymentType paymentType, BigDecimal originalPrice,
                                      BigDecimal discountPercent, BigDecimal discountedPrice, boolean cancelYn,
                                      List<OrderGoodsEntity> orderGoodEntities) {
        OrdersEntity ordersEntity = new OrdersEntity();

        ordersEntity.memberId = memberId;
        ordersEntity.paymentType = paymentType;
        ordersEntity.originalPrice = originalPrice;
        ordersEntity.discountPercent = discountPercent;
        ordersEntity.discountedPrice = discountedPrice;
        ordersEntity.cancelYn = cancelYn;
        ordersEntity.orderGoodEntities.addAll(orderGoodEntities);

        return ordersEntity;
    }

}
