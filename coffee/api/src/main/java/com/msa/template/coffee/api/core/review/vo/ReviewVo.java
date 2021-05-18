package com.msa.template.coffee.api.core.review.vo;

import java.time.LocalDateTime;

public class ReviewVo extends BaseVo{
	private long userId;
	private long productId;
	private String contents;
	private int rating;
	private String createDate;

	public ReviewVo(long userId, long productId, String contents, int rating, LocalDateTime lastUpdateDate) {
		this.userId = userId;
		this.productId = productId;
		this.contents = contents;
		this.rating = rating;
		this.createDate = localDateTimeToString(lastUpdateDate);
	}
}
