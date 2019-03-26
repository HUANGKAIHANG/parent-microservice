package com.example.gateway.config;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("Filter run...");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURL = request.getRequestURL().toString();
        System.out.println(request.getRequestURL().toString());
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession().getAttribute(request.getSession().getId()));

        if (requestURL.contains("v0"))
            System.out.println("这是v0请求，不需要拦截");
        else if (requestURL.contains("v1")) {
            System.out.println("这是v1请求，需要拦截验证登录情况");
            HttpSession session = request.getSession();
            if (session.getAttribute(session.getId())==null){
                System.out.println("检测到需要先登录的请求");
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(400);
                ctx.setResponseBody(JSON.toJSONString("please login first"));
                ctx.set("msg",JSON.toJSONString("please login first"));
            }
        }
        return null;
    }
}
