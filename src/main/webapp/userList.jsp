<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/4/4
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<h1>User List</h1>
<table border=1>
    <tr>
        <td>id</td>
        <td>username</td>
        <td>password</td>
        <td>Email</td>
        <td>Gander</td>
        <td>birthdate</td>
    </tr>
    <%
        //get rs from request attribute
        ResultSet rs = (ResultSet) request.getAttribute("rsname");
        if (rs == null) {
    %>
    <tr>
        <td>No data!</td>
    </tr>
    <%
        } else {

            while (rs.next()) {

                out.println("<tr>");
                out.println("<td>" + rs.getString("id") + "</td>");
                out.println("<td>" + rs.getString("username") + "</td>");
                out.println("<td>" + rs.getString("password") + "</td>");
                out.println("<td>" + rs.getString("Email") + "</td>");
                out.println("<td>" + rs.getString("Gander") + "</td>");
                out.println("<td>" + rs.getString("birthdate") + "</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");
        }
    %>
</table>

<%@include file="footer.jsp" %>
