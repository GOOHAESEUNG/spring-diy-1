package com.diy.framework.web;

import com.diy.framework.web.view.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface Controller {
    ModelAndView handleRequest(final HttpServletRequest request, final HttpServletResponse response) throws Exception;
}

//커밋용 테스트 주석