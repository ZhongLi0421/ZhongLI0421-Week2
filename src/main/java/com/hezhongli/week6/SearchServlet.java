package com.hezhongli.week6;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String txt = request.getParameter("txt");
        String search = request.getParameter("search");
        if (txt.equals(null)) {
            response.sendRedirect("register.jsp");
        } else {
            if (search.equals("baidu")) {
                response.sendRedirect("https://www.baidu.com");
            } else if (search.equals("jingdong")) {
                response.sendRedirect("https://www.jd.com");
            } else if (search.equals("taobao")) {
                response.sendRedirect("https://www.taobao.com");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
