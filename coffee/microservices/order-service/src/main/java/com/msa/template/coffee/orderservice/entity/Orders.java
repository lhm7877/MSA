package com.msa.template.coffee.orderservice.entity;

import com.msa.template.coffee.api.core.order.enums.PaymentType;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class Orders extends BaseEntity {

    @Id
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

    private boolean cancelYn;

    private String cancelReason;

    @JoinColumn(name = "orders_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderGoods> orderGoods = new ArrayList<>();

    public boolean getCancelYn() {
        return this.cancelYn;
    }

    //TODO 이후민 : Orders에 addoptions랑 OrderGoods에 addoptions는 어떤 차이가 있는거에요?
    public List<OrderGoods> addOptions(List<OrderGoods> orderGoods) {
        this.orderGoods.addAll(orderGoods);
        return this.orderGoods;
    }

    public List<OrderGoods> removeOptions(List<OrderGoods> orderGoods) {
        this.orderGoods.removeAll(orderGoods);
        return this.orderGoods;
    }

    public void cancelOrder(String cancelReason) {
        this.cancelYn = true;
        this.cancelReason = cancelReason;
    }

    public static Orders create(Long memberId, PaymentType paymentType, BigDecimal originalPrice,
                                BigDecimal discountPercent, BigDecimal discountedPrice, boolean cancelYn,
                                List<OrderGoods> orderGoods) {
        Orders orders = new Orders();

        orders.memberId = memberId;
        orders.paymentType = paymentType;
        orders.originalPrice = originalPrice;
        orders.discountPercent = discountPercent;
        orders.discountedPrice = discountedPrice;
        orders.cancelYn = cancelYn;
        orders.orderGoods.addAll(orderGoods);

        return orders;
    }

}
