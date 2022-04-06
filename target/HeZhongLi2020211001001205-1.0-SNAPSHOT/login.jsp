<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/3/29
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message") == null)) {
        out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="login">
    <p>
        <input name="username" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="Username">
    </p>
    <p>
        <input name="password" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="password">
    </p>
    <p>
        <input id="login" type="submit" style="background-color: coral"
               value="login">
    </p>
</form>
<%@include file="footer.jsp" %>
