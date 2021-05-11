<%--
  Created by IntelliJ IDEA.
  User: Moveon
  Date: 2021/4/18
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/registerStyle.css">
</head>
<body>
<div id="bigBox">
    <h1>注册</h1>
    <form action="register" method="get">
        <div class="inputBox">
            <div class="inputTest">
                用户名<input type="text" placeholder="Username" name="username"><!-- 用户名 -->
            </div>
            <div class="inputTest">
                密码<input type="password" placeholder="Password" name="password"><!-- 用户密码 -->
            </div>
            <div class="inputTest">
                姓名<input type="text" placeholder="Name" name="name"><!-- 真实姓名 -->
            </div>
            <div class="inputRadio">
                <input type="radio" value="student" name="userType">学生
                <input type="radio" value="teacher" name="userType">教师
            </div>
            <div class="inputTest">
                邮箱<input type="email" placeholder="E-main" name="email">
            </div>
            <input type="submit" value="注册" name="register_btn" class="register_btn">
        </div>
    </form>
</div>
</body>
</html>
