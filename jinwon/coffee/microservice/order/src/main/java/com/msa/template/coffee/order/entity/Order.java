package com.msa.template.coffee.order.entity;

import com.msa.template.coffee.order.enums.PaymentType;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(indexes = {
        @Index(columnList = "memberSn"),
        @Index(columnList = "paymentType"),
        @Index(columnList = "cancelYn")
})
public class Order extends BaseEntity {

    @Id
    private Long id;

    /* 주문 번호에 해당하는 회원은 변경 불가 */
    @Column(nullable = false, updatable = false)
    private Long memberSn;

    private PaymentType paymentType;

    @Column(precision = 5, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountedPrice;

    private boolean cancelYn;

    private String cancelReason;

    @OneToMany
    private final List<OrderGoods> orderGoods = new ArrayList<>();

    public boolean getCancelYn() {
        return this.cancelYn;
    }

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

    public static Order create(Long memberSn, PaymentType paymentType, BigDecimal originalPrice,
                               BigDecimal discountPercent, BigDecimal discountedPrice, boolean cancelYn,
                               List<OrderGoods> orderGoods) {
        Order order = new Order();

        order.memberSn = memberSn;
        order.paymentType = paymentType;
        order.originalPrice = originalPrice;
        order.discountPercent = discountPercent;
        order.discountedPrice = discountedPrice;
        order.cancelYn = cancelYn;
        order.orderGoods.addAll(orderGoods);

        return order;
    }

}
