package com.wqy.wx.back.configer.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Configuration
//@WebFilter(urlPatterns = "/*")
public class CrossFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("过滤器初始化。。。");
    }

    @Override
    public void destroy() {
        log.debug("过滤器已销毁。。。");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.debug("跨域请求进来了。。。");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String path = httpServletRequest.getServletPath();
        System.out.println("請求路徑：" + path);
//        //设置响应头
        HttpServletResponse httpResponse = getHttpServletResponse((HttpServletResponse) response);
        chain.doFilter(request, httpResponse);

    }

    private HttpServletResponse getHttpServletResponse(HttpServletResponse response) {
        HttpServletResponse httpResponse = response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        return httpResponse;
    }
}
