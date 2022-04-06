package com.hezhongli.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = {"/register"}, loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con = null;//class variable

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

      /*  ServletContext context = getServletContext();
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
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String gander = request.getParameter("gander");
        String birthdate = request.getParameter("birthdate");

        try {
            // 创建Statment对象
            Statement stmt = con.createStatement();
            // 获取插入结果集
            int rs = stmt
                    .executeUpdate("INSERT INTO usertable(username,password,Email,gander,birthdate)" +
                            " Values('" + username + "'" + "," + "'" + password + "'" + "," + "'" + Email + "'" + ","
                            + "'" + gander + "'" + "," + "'" + birthdate + "')");
            if (rs == 1) {
                System.out.println("增加成功!");
            } else {
                System.out.println("增加失败!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //print
        // 创建Statment对象
        try {
            Statement stmt = con.createStatement();
//            String sql = "select * from usertable";
//            ResultSet rs = stmt.executeQuery(sql);
//            PrintWriter out = response.getWriter();
//            out.println("<html><title></title><body><table border=1><tr>");
//            out.println("<td>id</td><td>username</td><td>password</td><td>Email</td><td>Gander</td><td>birthdate</td>");
//            while (rs.next()){
//                out.println("<tr>");
//                out.println("<td>"+rs.getString("id")+"</td>");
//                out.println("<td>"+rs.getString("username")+"</td>");
//                out.println("<td>"+rs.getString("password")+"</td>");
//                out.println("<td>"+rs.getString("Email")+"</td>");
//                out.println("<td>"+rs.getString("Gander")+"</td>");
//                out.println("<td>"+rs.getString("birthdate")+"</td>");
//                out.println("</tr>");
//            }
//            out.println("</table></body></html>");
//            request.setAttribute("rsname",rs);
//            request.getRequestDispatcher("userList.jsp").forward(request,response);
//
//            System.out.println("i am in RegisterServlet-->doPost()-->after forward");

            response.sendRedirect("login.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
