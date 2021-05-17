package com.msa.template.coffee.api.core.review.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BaseVo {
	private final DateTimeFormatter CREATE_DATE_STRING_FORMATTER
		= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	protected String localDateTimeToString(LocalDateTime localDateTime) {
		return localDateTime.now().format(CREATE_DATE_STRING_FORMATTER);
	}
}
