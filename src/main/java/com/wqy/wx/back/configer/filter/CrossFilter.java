package com.wqy.wx.back.configer.filter;

import com.wqy.wx.back.common.Constant;
import com.wqy.wx.back.configer.Req;
import com.wqy.wx.back.configer.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
//@Configuration
//@WebFilter(urlPatterns = {"/api/*"},filterName = "securityRequestFilter")
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
        String token = httpServletRequest.getHeader("token");
        String userId = httpServletRequest.getHeader("userId");
        HttpSession session = httpServletRequest.getSession();
        if(path.contains(Constant.MAPPING)) {
            if(StringUtils.isNotEmpty(token) && StringUtils.isNotEmpty(userId)){
                Req vxLoginDto1 = (Req)session.getAttribute(userId);
                if(vxLoginDto1!=null){
                    if(!vxLoginDto1.getIp().equals((request.getRemoteAddr()))){
                        throw new BizException("单点登陆，此用户已在其他设备上登陆使用");
                    }
                }else{
                    throw new BizException("错误认证，请先登陆!");
                }
            }else{
                throw new BizException("请先登陆!");
            }
        }
//      设置响应头
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
