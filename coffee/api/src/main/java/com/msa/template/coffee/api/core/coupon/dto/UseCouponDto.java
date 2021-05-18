package com.msa.template.coffee.api.core.coupon.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 쿠폰 사용처리 요청시 쿠폰id와 memberid 넘겨줌
 *
 * @author : pjh0904
 * @date : 2021-05-11 오후 3:44
 */
@Getter @Setter
public class UseCouponDto {

    private Long id;

    private String number;
}
