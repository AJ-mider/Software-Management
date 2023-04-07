package com.huawei.ibooking.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentLoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object stuNum=request.getSession().getAttribute("stuNum");
        if (stuNum== null  ){
            request.setAttribute("msg","please log in first!");
            System.out.println("student!");
//            request.getRequestDispatcher("/index").forward(request,response);
            response.sendRedirect("/index");
            return false;
        }

        return true;
    }

}
