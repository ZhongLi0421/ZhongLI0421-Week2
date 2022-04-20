package com.hezhongli.week5;

import com.hezhongli.dao.UserDAo;
import com.hezhongli.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")

public class LoginServlet extends HttpServlet {

    Connection con = null;//class variable

    @Override
    public void init() throws ServletException {
        /*super.init();
        ServletContext context=getServletContext();
        String driver= context.getInitParameter("driver");
        String url= context.getInitParameter("url");
        String username= context.getInitParameter("username");
        String password= context.getInitParameter("password");
        try {
            Class.forName(driver);
            System.out.println("驱动成功！");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功！");
            System.out.println("Connection-->in JDBCServlet" + con);//测试

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /*try {
            PrintWriter out = response.getWriter();
            // 创建Statment对象
            Statement stmt = con.createStatement();

            ResultSet rs = stmt
                    .executeQuery("SELECT * from usertable where username='" + username + "' and password='" + password + "'");

            if (rs.next()) {
//                out.println("Login Success!!!");
//                out.println("Welcome"+username);
                //get form
                request.setAttribute("id", rs.getString("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("Email", rs.getString("Email"));
                request.setAttribute("gander", rs.getString("gander"));
                request.setAttribute("birthdate", rs.getString("birthdate"));
                //forward to userInfo.jsp
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);

            } else {
//                out.println("username and password error!!!");
                request.setAttribute("message", "username and password error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
*/
        //use dao and model
        UserDAo userDAo = new UserDAo();
        try {
            User user = userDAo.findByUsernamePassword(con, username, password);
            //forward to jsp
            if (user != null) {
//                Cookie c =new Cookie("sessionid",""+user.getId());
//                c.setMaxAge(10*60);
//                response.addCookie(c);

                String rememberMe = request.getParameter("rememberMe");
                if (rememberMe != null && rememberMe.equals("1")) {
                    Cookie usernameCooike = new Cookie("cUsername", user.getUsername());
                    Cookie passwordCooike = new Cookie("cPassword", user.getPassword());
                    Cookie rememberCooike = new Cookie("cRememberMe", rememberMe);

                    System.out.println(user.getPassword());

                    usernameCooike.setMaxAge(5);
                    passwordCooike.setMaxAge(5);
                    rememberCooike.setMaxAge(5);


                    response.addCookie(usernameCooike);
                    response.addCookie(passwordCooike);
                    response.addCookie(rememberCooike);

                }

                HttpSession session = request.getSession();
                System.out.println("session id--" + session.getId());
//                session.setMaxInactiveInterval(10);//tomcat kill session when not come in 10 second later

                session.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "username and password error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
