package com.msa.template.coffee.api.core.review.dto;

import java.time.LocalDateTime;

public class ReviewDto extends BaseDto {

    private long userId;
    private long productId;
    private String contents;
    private int rating;
    private String createDate;

    public ReviewDto(long userId, long productId, String contents, int rating, LocalDateTime createDate) {
        this.userId = userId;
        this.productId = productId;
        this.contents = contents;
        this.rating = rating;
        this.createDate = localDateTimeToString(createDate);
    }
}
