<%--
  Created by IntelliJ IDEA.
  User: Moveon
  Date: 2021/5/4
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<style>

    body{
        /*background: url("${pageContext.request.contextPath}/image/sunset01.jpg") no-repeat;*/
        background-image: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
    }

    .aaa{
        background-color: #00000000;
    }

    .aaa a{
        font-size: 17px;
        color:deepskyblue;
    }

    #allCourse{
        color: #000000;
    }

    /* 顶部导航栏 */
    #topBox {
        margin: 0 auto;
        padding: 20px 50px;
        background-color: #00000020;
        width: 100%;
        height: 8px;
        border-radius: 10px;
        float: right;
    }

    /* 导航栏个人用户 */
    #topBox .admin{
        float:right
    }
    /* 导航栏个人用户字体 */
    #topBox .admin b{
        font-size: 15px;
        color: #000000;
    }
</style>

<div id="topBox" class="aaa">
    <div class="admin">
        <input type="button" class="btn-primary" value="更新个人信息" onclick="updateTeacherInfoOnclick()">
        <input type="button" class="btn-primary" value="查询学生" onclick="findOneStudentOnclick();">
        <i class="fa fa-user-circle-o" aria-hidden="true"></i>
        <b>欢迎 ${sessionScope.tname} 老师</b>
        <a href="javascript:location.href='logoutUser';">退出</a>
    </div>
</div>

<%--左侧导航栏--%>
<div id="bigBox" class="row aaa">
    <div id="indexLeft" class="col-xs-2">
        <ul class="nav nav-pills nav-stacked" id="indexLeftList">
            <li role="presentation"><a href="javascript:findMyCourse()">我的课程</a></li>
            <li role="presentation"><a href="javascript:managerStudent()">管理学生</a></li>
            <li role="presentation"><a href="javascript:modifyPassword()">修改密码</a></li>
            <li role="presentation"><a href="javascript:location.href='logoutUser';">退出系统</a></li>
        </ul>
    </div>
    <div class="col-xs-10">
        <table id = "allCourse" class="table table-hover">
            <tbody id="topBody">

            </tbody>
            <tbody id="mainBody">

            </tbody>
        </table>
    </div>
</div>

<script>

    $(function () {
        /*var myDate = new Date();
        var hours = myDate.getHours();
        if (hours > 6 && hours < 14){
            //早晨
            $("body").css("background","url(\"${pageContext.request.contextPath}/image/day01.jpg\") no-repeat")
        }else if (hours > 14 && hours < 17){
            //傍晚
            $("body").css("background","url(\"${pageContext.request.contextPath}/image/sunset01.jpg\") no-repeat")
        }else {
            //晚上
            $("body").css("background","url(\"${pageContext.request.contextPath}/image/night01.jpg\") no-repeat")
        }*/
        findMyCourse();
    })

    function myCourseFun(){
        $("#a").text("课程编号")
        $("#b").text("课程名称")
        $("#c").text("课程教师")
        $("#d").text("课程地点")
        $("#e").text("课程时间")
    }

    function managerStudentFun(){
        $("#a").text("学生id")
        $("#b").text("学生姓名")
        $("#c").text("学生班级")
        $("#d").text("学生性别")
        $("#e").text("学生成绩")
    }

    function findOneStudentOnclick() {
        var student = window.prompt("请输入学生姓名");
        $("#topBody").html("");
        $("#topBody").append("<th>学生id</th>\n" +
            "                <th>学生姓名</th>\n" +
            "                <th>学生年龄</th>\n" +
            "                <th>学生班级</th>\n" +
            "                <th>学生生日</th>"+
            "                <th>学生性别</th>"+
            "                <th>学生学号</th>");
        $("#mainBody").html("");
        $.ajax({
            url: "findOneStudent",
            type: "POST",
            data: {
                sname:student
            },
            success: function (result) {
                var json = JSON.parse(result);
                for (var i in json){
                    $("#mainBody").append("<tr>" +
                        "<td>"+json[i].sid+"</td>"+
                        "<td>"+json[i].name+"</td>"+
                        "<td>"+json[i].age+"</td>"+
                        "<td>"+json[i].cls+"</td>"+
                        "<td>"+json[i].birthday+"</td>"+
                        "<td>"+json[i].sex+"</td>"+
                        "<td>"+json[i].num+"</td>"+
                    "</tr>");
                }
            }
        })
    }

    function findMyCourse() {
        $("#topBody").html("");
        $("#topBody").append("<tr>" +
            "<th>课程编号</th>" +
            "<th>课程名称</th>" +
            "<th>课程教师</th>" +
            "<th>课程位置</th>" +
            "<th>课程时间</th>" +
        "</tr>")
        $.ajax({
            url: "findMyCourse",
            type: "POST",
            data: {tid:${sessionScope.tid}},
            success: function (result) {
                var json = JSON.parse(result);
                $("#mainBody").html("");
                for(var i in json){
                    $("#mainBody").append("<tr>\n" +
                        "                <td>"+json[i].courseId+"</td>\n" +
                        "                <td>"+json[i].courseName+"</td>\n" +
                        "                <td>"+json[i].courseTeacher+"</td>\n" +
                        "                <td>"+json[i].courseSite+"</td>\n" +
                        "                <td>"+json[i].courseTime+"</td>\n" +
                        "            </tr>")
                }
            }
        })
    }

    function managerStudent() {
        $("#topBody").html("");
        $("#topBody").append("<tr>" +
            "<th>学生id</th>" +
            "<th>学生姓名</th>" +
            "<th>学生班级</th>" +
            "<th>学生性别</th>" +
            "<th>学生成绩</th>" +
            "</tr>")
        $.ajax({
            url: "managerStudent",
            type: "POST",
            data: {tid: ${sessionScope.tid}},
            success:function (result) {
                var json = JSON.parse(result);
                $("#mainBody").html("");
                for (var i in json){
                    $("#mainBody").append("<tr>\n" +
                        "                <td class='tdSid'>"+json[i].sid+"</td>\n" +
                        "                <td>"+json[i].name+"</td>\n" +
                        "                <td>"+json[i].cls+"</td>\n" +
                        "                <td>"+json[i].sex+"</td>\n" +
                        "                <td><a href='#' onclick='modifyScore(this)'>"+json[i].score+"</a></td>\n" +
                        "            </tr>")
                }
            }
        })
    }

    function modifyScore(obj) {
        var newScore = window.prompt("请输入该学生的新成绩");
        var sid = $(obj).parent().parent().children(".tdSid").text();
        $.ajax({
            url: "modifyScore",
            type: "POST",
            data: {sid:sid,tid:${sessionScope.tid},newScore:newScore},
            success: function () {
                alert("修改成功");
                managerStudent();
            }
        })
    }

    //修改密码
    function modifyPassword() {
        var newPassword = window.prompt("请输入您的新密码");
        if (newPassword == null || newPassword.length < 5){
            alert("请输入正确的密码格式")
        }else {
            $.ajax({
                url: "modifyPassword",
                type: "POST",
                data: {id: ${sessionScope.tid},newPassword: newPassword},
                success: function () {
                    alert("修改成功")
                }
            })
        }
    }

    function updateTeacherInfoOnclick() {
        var age = window.prompt("请输入你的年龄");
        var birthday = window.prompt("请输入你的生日");
        var sex = window.prompt("请输入你的性别");
        var course = window.prompt("请输入你的课程");
        $.ajax({
            url: "updateTeacherInfo",
            type: "POST",
            data: {
                tid:${sessionScope.tid},
                tname: '${sessionScope.tname}',
                age: age,
                birthday: birthday,
                sex: sex,
                course: course
            },
            success: function () {
                alert("更新成功")
            },
            error: function () {
                alert("更新失败")
            }
        })
    }
</script>

</body>
</html>
