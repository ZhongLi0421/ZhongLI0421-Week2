package com.hezhongli.Lab;

import com.example.hezhongli2020211001001205.HelloServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LifeCycleServlet extends HelloServlet {
    @Override
    public void init() {
        ServletContext context=getServletContext();
        context.setAttribute("times",1);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I Am from default constructor");
        ServletContext context=getServletContext();
        int times=(int) context.getAttribute("times");
        PrintWriter out = response.getWriter();
        out.println("Id:2020211001001205");
        out.println("Since loading,this servlet has been accessed "+times+"  times");
        times++;
        context.setAttribute("times",times);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
