package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
     //   Object delete1=request.getSession().getAttribute("delete1");
        Object loginUser = request.getSession().getAttribute("loginUser");

        System.out.println(loginUser+"0000");
        if (loginUser==null)
        {
            System.out.println("过了");
            return false;
        }
        else{
            System.out.println("token时间未过，拦截器未拦截");
            return true;}
    }
}
