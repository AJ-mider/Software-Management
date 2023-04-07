package com.huawei.ibooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/studentPage.html").setViewName("studentPage");
        //registry.addViewController("/studentPage").setViewName("studentPage");
        registry.addViewController("/manager.html").setViewName("manager/manager");
        registry.addViewController("/booking.html").setViewName("manager/booking");
        registry.addViewController("/manager/studyroomManager").setViewName("manager/studyroomManager");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StudentLoginHandlerInterceptor()).addPathPatterns("/studentPage","/student/**");
//                excludePathPatterns("/index","/register","/registerAccount","/","/login","/easyui/**","/manager","/manager/**");
        registry.addInterceptor(new ManagerLoginHandlerInterceptor()).addPathPatterns("/manager","/manager/**","studentManagement","studyroomManagement");
//                excludePathPatterns("/index","/register","/registerAccount","/","/login","/easyui/**","/studentPage");
    }

}
