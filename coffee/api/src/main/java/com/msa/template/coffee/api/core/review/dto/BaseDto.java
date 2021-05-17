package com.msa.template.coffee.api.core.review.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class BaseDto<T> {
    protected List<T> data;
}
