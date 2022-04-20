package com.hezhongli.lab2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("I am in LoginFilter-->init()");
    }

    public void destroy() {
        System.out.println("I am in LoginFilter-->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("I am in LoginFilter-->doFilter()-->request before chain");
        //change ServletRequest to HttpServletRequest
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        //get session
        HttpSession session = httpRequest.getSession(false);
        if(session.getAttribute("login")!=null){
            httpRequest.getRequestDispatcher("welcome.jsp").forward(httpRequest,httpResponse);
        }else {
            httpResponse.sendRedirect("login.jsp");
        }
        chain.doFilter(request, response);
        System.out.println("I am in LoginFilter-->doFilter()-->request after chain");
    }
}
