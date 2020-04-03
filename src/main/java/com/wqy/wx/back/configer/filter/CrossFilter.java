package com.wqy.wx.back.configer.filter;

import com.wqy.wx.back.configer.Req;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = httpServletRequest.getSession();
        Req req = (Req) session.getAttribute(request.getRemoteAddr());
        if (!path.contains("/logion") && null != req) {
            //将header 中的数据封装成对象，并放入header中
            BodyReaderHttpServletRequestWrapper requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
            //设置响应头
            HttpServletResponse httpResponse = getHttpServletResponse((HttpServletResponse) response);
            chain.doFilter(requestWrapper, httpResponse);
        } else {
            //设置响应头
            HttpServletResponse httpResponse = getHttpServletResponse((HttpServletResponse) response);
            chain.doFilter(request, httpResponse);
        }
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
