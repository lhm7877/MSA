package com.msa.template.coffee.api.core.review.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewDto extends BaseDto {

    private long userId;
    private long productId;
    private String contents;
    private int rating;
    private String createDate;

    public ReviewDto(long userId, long productId, String contents, int rating, LocalDateTime lastUpdateDate) {
        this.userId = userId;
        this.productId = productId;
        this.contents = contents;
        this.rating = rating;
        this.createDate = localDateTimeToString(lastUpdateDate);
    }
}
