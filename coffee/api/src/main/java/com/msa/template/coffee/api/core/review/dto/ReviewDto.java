package com.msa.template.coffee.api.core.review.dto;

import java.util.List;

import com.msa.template.coffee.api.core.review.vo.ReviewVo;

import lombok.Getter;

@Getter
public class ReviewDto extends BaseDto<ReviewVo> {

    public ReviewDto(List<ReviewVo> reviewVoList) {
        this.data = reviewVoList;
    }
}
