package com.hezhongli.week3;

import sun.util.resources.cldr.rof.CalendarData_rof_TZ;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = {"/register"}, loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;//class variable

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection-->in RegisterServlet  " + con);//测试用
            //can do one times
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String birth = request.getParameter("birth");

        try {
            // 创建Statment对象
            Statement stmt = con.createStatement();
            // 获取插入结果集
            int rs = stmt
                    .executeUpdate("INSERT INTO usertable(id,username,password,Email,Gender,birth)" +
                            " Values('" + id + "'" + "," + "'" + username + "'" + "," + "'" + password + "'" + "," + "'" + Email + "'" + ","
                            + "'" + Gender + "'" + "," + "'" + birth + "')");
            if (rs == 1) {
                System.out.println("增加成功!");
            } else {
                System.out.println("增加失败!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //print
        PrintWriter writer = response.getWriter();
        writer.println("<br>username:" + username);
        writer.println("<br>password:" + password);
        writer.println("<br>Email:" + Email);
        writer.println("<br>Gender:" + Gender);
        writer.println("<br>birth:" + birth);
        writer.close();

    }
}
