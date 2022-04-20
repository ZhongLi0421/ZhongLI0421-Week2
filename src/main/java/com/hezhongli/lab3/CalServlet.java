package com.hezhongli.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/CalServlet")
public class CalServlet extends HttpServlet {
    public double add(int firstVal, int secondVal) {
        return firstVal + secondVal;
    }

    public double subtract(int firstVal, int secondVal) {
        return firstVal - secondVal;
    }

    public double multiply(int firstVal, int secondVal) {
        return firstVal * secondVal;
    }

    public double divide(int firstVal, int secondVal) {
        return firstVal / secondVal;
    }

    public int computeLength(String name) {
        return name.length();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //todo 6
        int f = Integer.parseInt(request.getParameter("FirstVal"));
        String name = request.getParameter("name");
        int s = Integer.parseInt(request.getParameter("SecondVal"));
        String action = request.getParameter("action");
        double result = 0.0;
        int result1 = 0;

        //todo 7,8
        if (action.equals("Add") || action.equals("Subtract") || action.equals("Multiply") || action.equals("Divide")) {

            if (action.equals("Add")) {
                result = add(f, s);
            } else if (action.equals("Subtract")) {
                result = subtract(f, s);
            } else if (action.equals("Multiply")) {
                result = multiply(f, s);
            } else if (action.equals("Divide")) {
                result = divide(f, s);
            }

            Cookie cFirstValue = new Cookie("FirstValue", String.valueOf(f));
            Cookie cSecondValue = new Cookie("SecondValue", String.valueOf(s));
            Cookie cResult = new Cookie("Result", String.valueOf(result));

            cFirstValue.setMaxAge(60);
            cSecondValue.setMaxAge(60);
            cResult.setMaxAge(60);

            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);


        } else if (action.equals("Compute_Length")) {
            result1 = computeLength(name);

            Cookie cName = new Cookie("name", name);
            Cookie cLength = new Cookie("length", String.valueOf(result1));

            cName.setMaxAge(60);
            cLength.setMaxAge(60);

            response.addCookie(cName);
            response.addCookie(cLength);
        }

        response.sendRedirect(request.getContextPath() + "/lab3/cal.jsp");


    }
}
