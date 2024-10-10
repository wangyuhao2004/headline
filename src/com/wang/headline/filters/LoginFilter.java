package com.wang.headline.filters;

import com.wang.headline.common.Result;
import com.wang.headline.common.ResultCodeEnum;
import com.wang.headline.util.JwtHelper;
import com.wang.headline.util.WebUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req =  (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String token = req.getHeader("token");
        Result result = Result.build(null, ResultCodeEnum.NOTLOGIN);
        boolean flag = false;
        if (token != null) {
            if (!JwtHelper.isExpiration(token)) {
                result = Result.ok(null);
                flag = true;
            }
        }
        if (flag) {
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            WebUtil.writeJson(resp,result);
        }

    }
}
