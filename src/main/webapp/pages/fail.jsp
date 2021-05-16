<%--
  Created by IntelliJ IDEA.
  User: Moveon
  Date: 2021/5/16
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <meta charset="utf-8">
    <title>该页面不存在-404.life</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/all.css"/>
    <script src="js/_lib.js" type="text/javascript" charset="utf-8"></script>

</head>


<body>

<style>
    .notfind_wrapper{position: relative;}
    .notfind{ margin: 150px auto 0 auto; display: block;}
    .notfind_wrapper span{
        position: absolute;
        top: 36%;
        left: 42%;
        color: #999999;
        font-size: 18px;
    }
    .notfind_wrapper a{
        position: absolute;
        position: absolute;
        top: 43%;
        left: 47%;
        border: 2px solid #94BFF3;
        color: #94BFF3;
        border-radius: 15px;
        padding: 2px 14px;
        font-size: 15px;
    }
</style>

<div id="pb_position"></div>
<div class="container">
    <div class="notfind_wrapper">
        <img class="notfind" src="image/404.png" alt="">
        <span class="">很抱歉，登陆或注册失败，请返回首页</span>
        <a href="#" onclick="javascript:location.href='mainIndex'">返回首页</a>
    </div>
</div>
