<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/5/28
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<%
    Cookie[] cookies = request.getCookies();
    String first = "";
    String second = "";
    String result = "";
    String name = "";
    String length = "";
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("FirstValue")) {
                first = cookie.getValue();
            }
            if (cookie.getName().equals("SecondValue")) {
                second = cookie.getValue();
            }
            if (cookie.getName().equals("Result")) {
                result = cookie.getValue();
            }
            if (cookie.getName().equals("name")) {
                name = cookie.getValue();
            }
            if (cookie.getName().equals("length")) {
                length = cookie.getValue();
            }
        }
    }
%>
<form method="post" action="<%=request.getContextPath()%>/CalServlet" name="form">
    First val: <input id="first" name="FirstVal" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" value="<%=first%>">
    Enter a Name: <input name="name" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" value="<%=name%>"><br>
    Second Val:<input id="second" name="SecondVal" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" value="<%=second%>">
    Length:<input name="length" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" value="<%=length%>"><br>
    Result: <input name="result" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" value="<%=result%>"><br>
    <input type="submit" value="Add" name="action">
    <input type="submit" value="Subtract" name="action">
    <input type="submit" value="Multiply" name="action">
    <input type="submit" value="Divide" name="action">
    <input type="submit" value="Compute_Length" name="action">
    <input type="reset" value="Reset">
</form>
<h2>Id:2020211001001205</h2><br>
<h2>HeZhongLI</h2>
<script>
    function check1(form) {
        var num = document.getElementById("first").value;
        if (!/[^\d.]/g.test(num)) {
            alert("只能输入数字！");
        }
    }
</script>
</html>
