<%--
  Created by IntelliJ IDEA.
  User: Moveon
  Date: 2021/4/17
  Time: 1:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生管理登陆</title>
    <link rel="stylesheet" href="css/loginStyle.css">
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/webgradients.css">
</head>
<body>
    <div id="bigBox">
        <h1>LOGIN</h1>
        <form action="index" method="post">
            <div class="inputBox">
                <div class="inputTest">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <input type="text" placeholder="Username" name="username">
                </div>
                <div class="inputTest">
                    <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                    <input type="password" placeholder="Password" name="password">
                </div>
                <input type="submit" class="inputButton" value="登陆">
            </div>
        </form>
        <input type="button" value="注册" id="register_btn" onclick="javascript:window.location.href='${pageContext.request.contextPath}/register.jsp'">
    </div>
</body>

</html>
