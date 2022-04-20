package com.hezhongli.controller;

import com.hezhongli.dao.UserDAo;
import com.hezhongli.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO1
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //6 request parameters

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String gander = request.getParameter("gander");
        String birthdate = request.getParameter("birthdate");

        //creat an object of User model and set values
        HttpSession session = request.getSession();
        User user = new User();
        User u = (User) session.getAttribute("user");
        int id;
        id = u.getId();
        user.setId(id);


        if (username != "") {
            user.setUsername(username);
        } else {
            user.setUsername(u.getUsername());
        }

        if (password != "") {
            user.setPassword(password);
        } else {
            user.setPassword(u.getPassword());
        }


        if (Email != "") {
            user.setEmail(Email);
        } else {
            user.setEmail(u.getEmail());
        }


        if (gander != null) {
            user.setGander(gander);
        } else {
            user.setGander(u.getGander());
        }


        if (birthdate != "") {
            Date birth = null;
            try {
                SimpleDateFormat format=new SimpleDateFormat("yyyy-mm-dd");
                format.setLenient(false);
                birth=format.parse(birthdate);
                user.setBirthdate(birth);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            user.setBirthdate(u.getBirthdate());
        }

        HttpSession session1 = request.getSession();
        session1.setAttribute("user", user);

        //creat UserDao
        UserDAo userDAo = new UserDAo();

        Connection con = null;
        con = (Connection) getServletContext().getAttribute("con");
        try {
            userDAo.updateUser(con, user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //forward to userinfo.jsp
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);


    }
}
