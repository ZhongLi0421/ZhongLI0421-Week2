package com.hezhongli.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "LoggerFilter")
public class LoggerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoggerFilter---->doFilter()--before servlet-request come");
        chain.doFilter(request, response);    //call next filter--if no next filter then go to servlet
        //response after servlet come back here
        System.out.println("i am in LoggerFilter---->doFilter()--after servlet-response come");

    }
}
