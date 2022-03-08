package com.hezhongli.week3;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String birth = request.getParameter("birth");

        //print
        PrintWriter writer=response.getWriter();
        writer.println("<br>username:"+username);
        writer.println("<br>password:"+password);
        writer.println("<br>Email:"+Email);
        writer.println("<br>Gender:"+Gender);
        writer.println("<br>birth:"+birth);
        writer.close();

    }
}
