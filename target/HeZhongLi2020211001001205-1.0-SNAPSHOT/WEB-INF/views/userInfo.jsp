<%@ page import="com.hezhongli.model.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/4/4
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>User Info</h1>
<%
    //read cookie
    Cookie[] allCooikes = request.getCookies();
    for (Cookie c : allCooikes) {
        out.println("<br/>" + c.getName() + "-----"+c.getValue());
    }
%>
<%
    User u = (User) session.getAttribute("user");
%>
<table>
    <tr>
        <td>Username:</td>
        <td><%=u.getUsername()%>
        </td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=u.getPassword()%>
        </td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><%=u.getEmail()%>
        </td>
    </tr>
    <tr>
        <td>Gender:</td>
        <td><%=u.getGender()%>
        </td>
    </tr>
    <tr>
        <td>Birthdate:</td>
        <td><%=u.getBirthdate()%>
        </td>
    </tr>
    <tr>
        <td><a href="updateUser">update</a></td>
    </tr>
</table>

<%@include file="footer.jsp" %>
