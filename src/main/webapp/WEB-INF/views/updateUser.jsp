<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/4/19
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>
<h1>User update</h1>
<form name="f" method="post" action="updateUser">
    <p>
        <input type="hidden" name="id">
    </p>
    <p>
        <input name="username" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="Username">
    </p>
    <p>
        <input name="password" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="password">
    </p>
    <p>
        <input name="Email" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="Email">
    </p>
    <p>
        <label>Gender</label><input name="gander" type="radio" value="Male">Male
        <input name="gander" type="radio" value="Female">Female
    </p>
    <p>
        <input name="birthdate" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="Date Of Birth(yyyy-mm-dd)">
    </p>
    <p>
        <input id="register" type="submit" style="background-color: coral"
               value="Save Changes">
    </p>
    <%@include file="footer.jsp" %>
