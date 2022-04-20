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
<%
    Cookie[] allCookie = request.getCookies();
    String username = "", password = "", rememberMeValue = "";
    if (allCookie != null) {
        for (Cookie c : allCookie) {
            if (c.getName().equals("cUsername")) {
                username = c.getValue();
            }
            if (c.getName().equals("cPassword")) {
                password = c.getValue();
            }
            if (c.getName().equals("cRememberMe")) {
                rememberMeValue = c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    <p>
        <input name="username" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="Username" value="<%=username%>">
    </p>
    <p>
        <input name="password" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="password" value="<%=password%>">
    </p>
    <p>
        <input name="rememberMe" type="checkbox" value="1" <%=rememberMeValue.equals("1")?"checked":""%>>RememberMe
    </p>
    <p>
        <input id="login" type="submit" style="background-color: coral"
               value="login">
    </p>
</form>
<%@include file="footer.jsp" %>
