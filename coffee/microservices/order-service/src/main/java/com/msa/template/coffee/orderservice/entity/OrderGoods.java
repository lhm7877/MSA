package com.msa.template.coffee.orderservice.entity;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "order_goods")
@Table(indexes = {
        @Index(columnList = "menuId")
})
public class OrderGoods {

    @Id
    private Long id;

    @Column(nullable = false)
    private Long menuId;

    private Long parentMenuId;

    @Column(precision = 5, scale = 2)
    private BigDecimal originalPrice;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountPercent;

    @Column(precision = 5, scale = 2)
    private BigDecimal discountedPrice;

    @JoinColumn(name = "order_goods_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<OrderGoods> options = new ArrayList<>();

    public List<OrderGoods> addOptions(List<OrderGoods> options) {
        this.options.addAll(options);
        return this.options;
    }

    public List<OrderGoods> removeOptions(List<OrderGoods> options) {
        this.options.removeAll(options);
        return this.options;
    }

    public static OrderGoods create(Long menuId, Long parentMenuId, BigDecimal originalPrice,
                                    BigDecimal discountPercent, BigDecimal discountedPrice, List<OrderGoods> options) {
        OrderGoods orderGoods = new OrderGoods();

        orderGoods.menuId = menuId;
        orderGoods.parentMenuId = parentMenuId;
        orderGoods.originalPrice = originalPrice;
        orderGoods.discountPercent = discountPercent;
        orderGoods.discountedPrice = discountedPrice;
        orderGoods.options.addAll(options);

        return orderGoods;
    }

}
