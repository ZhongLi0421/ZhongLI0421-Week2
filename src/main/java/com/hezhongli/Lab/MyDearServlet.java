package com.hezhongli.Lab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet", value = "/MyDear")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("name");
        String classes=request.getParameter("classes");
        String id=request.getParameter("id");
        String submit=request.getParameter("submit");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> name: " + name + "</h1>");
        out.println("<h1> classes: " + classes + "</h1>");
        out.println("<h1> Id: " + id + "</h1>");
        out.println("<h1> " + submit + "</h1>");
        out.println("</body></html>");
    }
}
