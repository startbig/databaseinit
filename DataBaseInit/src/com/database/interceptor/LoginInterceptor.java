package com.database.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.database.po.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
 
    @Override  
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,  
            Object obj) throws Exception { 
        User loginUser = (User) request.getSession().getAttribute("loginUser");  
        if (loginUser == null) { 
        	response.getWriter().write("9998");
            return false;
          }   
        return true;  
    }  
}

