<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/3/14
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<p>New User Registration!</p>
<form name="f" method="post" action="register">
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
        <label>Gender</label><input name="Gender" type="radio" value="Male">Male
        <input name="Gender" type="radio" value="Female">Female
    </p>
    <p>
        <input name="birth" type="text" style="width: 200px;height: 30px;
    background-color: antiquewhite" placeholder="Date Of Birth(yyyy-mm-dd)">
    </p>
    <p>
        <input id="register" type="submit" style="background-color: coral"
               value="Register">
    </p>

    <script type="text/javascript">
        document.getElementById("register").onclick = function click() {
            var u = f.username.value.trim();
            var p = f.password.value.trim().length;
            var e = f.Email.value.trim().length;
            var b = f.birth.value.trim();
            if (p < 8) {
                alert("密码必须是8位数以上！")
            } else if (b != 10) {
                alert("生日格式不对！")
            }
            if (u != 0 && p >= 8 && e != 0 && b != 10) {
                alert("注册成功！")
            } else {
                alert("请仔细检查！")
            }
        }
    </script>
</form>
</body>
</html>
