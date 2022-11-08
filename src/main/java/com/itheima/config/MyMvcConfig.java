package com.itheima.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Autowired
  private   LoginHandlerInterceptor loginHandlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/pages/books.html","/pages/ReturnBooks.html",
        "/pages/books.html/**","/pages/ReturnBooks.html/**");
    }
}
