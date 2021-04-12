package com.msa.template.coffee.review.controller;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

public abstract class BaseController {

    protected long getUserId(HttpServletRequest request) {
        String userIdStr = request.getHeader("X-User-Id");
        return Long.parseLong(userIdStr);
    }
}
