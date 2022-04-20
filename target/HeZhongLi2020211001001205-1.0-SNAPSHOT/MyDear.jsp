<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/5/18
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab</title>
</head>
<body>
<form method="post" action="MyDearJsp.jsp">
    <p>
        Name:<input name="name" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="name">
    </p>
    <p>
        Classes:<input name="classes" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="classes">
    </p>
    <p>
        Id:<input name="id" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="id">
    </p>
    <p>
        <input name="submit" id="submit" type="submit" style="background-color: coral"
               value="Send data to server">
    </p>
</form>
</body>
</html>
