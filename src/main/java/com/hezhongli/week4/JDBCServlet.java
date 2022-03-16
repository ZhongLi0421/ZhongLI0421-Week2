package com.hezhongli.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//use another way
//@WebServlet(name = "JDBCServlet", urlPatterns = {"/jdbc"},
//        initParams = {
//                @WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url", value = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
//                @WebInitParam(name = "username", value = "sa"),
//                @WebInitParam(name = "password", value = "123456")
//        },
//        loadOnStartup = 1
//)//no web.xml code

@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)
public class JDBCServlet extends HttpServlet {
    Connection con = null;//class variable

    @Override
    public void init() throws ServletException {
        super.init();
        //way 2 --connection with init()
        //String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        //String username = "sa";
        //String password = "123456";

        //step 1--get servlet config
//        ServletConfig config = getServletConfig();
        //step 2--get param
//        String driver = config.getInitParameter("driver");
//        String url = config.getInitParameter("url");
//        String username = config.getInitParameter("username");
//        String password = config.getInitParameter("password");

        //demo 3 --use Servletcontext
        ServletContext context=getServletContext();
        String driver= context.getInitParameter("driver");
        String url= context.getInitParameter("url");
        String username= context.getInitParameter("username");
        String password= context.getInitParameter("password");

        //now use 4 variable to get connection

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection-->in JDBCServlet" + con);//测试用
            //can do one times
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //way 1


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        //close connection----when stop tomcat
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
