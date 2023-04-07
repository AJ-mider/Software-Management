package com.huawei.ibooking.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object managerNum=request.getSession().getAttribute("managerNum");
        if (managerNum ==null ){
            request.setAttribute("msg","please log in first!");

            System.out.println("manager!");
//            request.getRequestDispatcher("/index").forward(request,response);
            response.sendRedirect("/index");
            return false;
        }

        return true;
    }

}