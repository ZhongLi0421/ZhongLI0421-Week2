package com.hezhongli.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ConfigDemoServlet", urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name", value = "HeZhongLi"),
                @WebInitParam(name = "studentId", value = "2020211001001205")
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig config = getServletConfig();

        String name = config.getInitParameter("name");
        String studentId = config.getInitParameter("studentId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> name: " + name + "</h1>");
        out.println("<h1> studentId: " + studentId + "</h1>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
