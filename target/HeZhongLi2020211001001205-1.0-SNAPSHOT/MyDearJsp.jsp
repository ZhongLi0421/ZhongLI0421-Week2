<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/5/18
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Use java code</h1>
<table>
    <tr>
        <td>Name:</td>
        <td><%=request.getParameter("name")%>
        </td>
    </tr>
    <tr>
        <td>Classes:</td>
        <td><%=request.getParameter("classes")%>
        </td>
    </tr>
    <tr>
        <td>Id:</td>
        <td><%=request.getParameter("id")%>
        </td>
    </tr>
    <tr>
        <td><%=request.getParameter("submit")%>
        </td>
    </tr>

</table>
<h1>Use El code</h1>
Name:${param.name}  </br>
Classes:${param.classes}  </br>
Id:${param.id}  </br>
${param.submit}  </br>
</body>
</html>
