<%--
  Created by IntelliJ IDEA.
  User: Moveon
  Date: 2021/5/4
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>管理员主页</title>
</head>
<body>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style>

    body{
        background: url("${pageContext.request.contextPath}/image/sunset01.jpg") no-repeat;
    }

    .aaa{
        background-color: #00000000;
    }

    .aaa a{
        font-size: 17px;
        color:skyblue;
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

<div>
    <!-- 顶部导航栏 -->
    <div id="topBox" class="aaa">
        <div class="admin">
            <input type="button" value="设置课程教师" class="btn-primary" onclick="addCourseTeacherOnclick()">
            <input type="button" value="查询课程信息" class="btn-primary" onclick="findCourseOnclick()">
            <input type="button" value="查询教师信息" class="btn-primary" onclick="findTeacherOnclick()">
            <input type="button" value="查询学生信息" class="btn-primary" onclick="findStudentOnclick()">
            <input type="button" value="添加课程信息" class="btn-primary" onclick="insertCourseOnclick()">
            <input type="button" value="添加教师信息" class="btn-primary" onclick="insertTeacherOnclick()">
            <input type="button" value="添加学生信息" class="btn-primary" onclick="insertStudentOnclick()">
            <i class="fa fa-user-circle-o" aria-hidden="true"></i>
            <b>欢迎 ${sessionScope.aname} 管理员</b>
            <a href="javascript:location.href='logoutUser';">退出</a>
        </div>
    </div>

    <%--左侧导航栏--%>
    <div id="bigBox" class="row aaa">
        <div id="indexLeft" class="col-xs-2">
            <ul class="nav nav-pills nav-stacked" id="indexLeftList">
                <li role="presentation"><a href="javascript:courseManagerFun()">课程管理</a></li>
                <li role="presentation"><a href="javascript:managerTeacherFun()">教师管理</a></li>
                <li role="presentation"><a href="javascript:managerStudentFun()">学生管理</a></li>
                <li role="presentation"><a href="javascript:modifyPassword()">修改密码</a></li>
                <li role="presentation"><a href="javascript:location.href='logoutUser';">退出系统</a></li>
            </ul>
        </div>
        <div class="col-xs-10">
            <table id = "allCourse" class="table table-hover">
                <tbody id="topBody">

                </tbody>
                <tbody id="mainTbody">
                    <tr>
                        <td><input type="text" id="CourseIdInput"></td>
                        <td><input type="text" id="CourseNameInput"></td>
                        <td><input type="text" id="CourseTeacherInput"></td>
                        <td><input type="text" id="CourseSiteInput"></td>
                        <td><input type="text" id="CourseTimeInput"></td>
                        <td><a href="javascript:insertCourseInfo();"></a></td>
                    </tr>
                </tbody>
            </table>
        </div>
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
        courseManagerFun();
    })

    //管理所有课程
    function courseManagerFun() {
        $("#topBody").html("");
        $("#topBody").append("<tr>\n" +
            "                        <th>课程编号</th>\n" +
            "                        <th>课程名称</th>\n" +
            "                        <th>课程教师</th>\n" +
            "                        <th>课程位置</th>\n" +
            "                        <th>课程时间</th>\n" +
            "                        <th>操作</th>\n" +
            "                    </tr>")
        $.ajax({
            url: "adminFindAllCourse",
            type: "POST",
            async: false,
            success: function (result) {
                var json = JSON.parse(result);
                $("#mainTbody").html("");
                for (var i in json){
                    $("#mainTbody").append("<tr>\n" +
                        "                        <td class=\"courseId\">"+json[i].courseId+"</td>\n" +
                        "                        <td>"+json[i].courseName+"</td>\n" +
                        "                        <td>"+json[i].courseTeacher+"</td>\n" +
                        "                        <td>"+json[i].courseSite+"</td>\n" +
                        "                        <td>"+json[i].courseTime+"</td>\n" +
                        "                        <td><a href='#' onclick='delCourseTr(this)'>删除课程</a></td>\n" +
                        "                    </tr>")
                }
            }
        })
    }

    //管理所有教师
    function managerTeacherFun() {
        $("#topBody").html("");
        $("#topBody").append("<tr>\n" +
            "                        <th>教师id</th>\n" +
            "                        <th>教师姓名</th>\n" +
            "                        <th>教师年龄</th>\n" +
            "                        <th>教师生日</th>\n" +
            "                        <th>教师性别</th>\n" +
            "                        <th>教授课程</th>\n" +
            "                        <th>操作</th>\n" +
            "                    </tr>");
        $.ajax({
            url: "adminFindAllTeacher",
            type: "POST",
            async: false,
            success: function (result) {
                var json = JSON.parse(result);
                $("#mainTbody").html("");
                for (var i in json){
                    $("#mainTbody").append("<tr>\n" +
                        "                        <td class='teacherId'>"+json[i].tid+"</td>\n" +
                        "                        <td>"+json[i].tname+"</td>\n" +
                        "                        <td>"+json[i].age+"</td>\n" +
                        "                        <td>"+json[i].birthday+"</td>\n" +
                        "                        <td>"+json[i].sex+"</td>\n" +
                        "                        <td>"+json[i].course+"</td>\n" +
                        "                        <td><a href='#' onclick='delTeacherTr(this)'>删除教师</a></td>\n" +
                        "                    </tr>")
                }
            }
        })
    }

    //管理所有学生
    function managerStudentFun() {
        $("#topBody").html("");
        $("#topBody").append("<tr>\n" +
            "                        <th>学生id</th>\n" +
            "                        <th>学生姓名</th>\n" +
            "                        <th>学生年龄</th>\n" +
            "                        <th>学生班级</th>\n" +
            "                        <th>学生生日</th>\n" +
            "                        <th>学生性别</th>\n" +
            "                        <th>学生学号</th>\n" +
            "                        <th>操作</th>\n" +
            "                    </tr>");
        $.ajax({
            url: "adminFindAllStudent",
            type: "POST",
            async: false,
            success: function (result) {
                var json = JSON.parse(result);
                $("#mainTbody").html("");
                for (var i in json){
                    $("#mainTbody").append("<tr>\n" +
                        "                        <td class=\"studentId\">"+json[i].sid+"</td>\n" +
                        "                        <td>"+json[i].name+"</td>\n" +
                        "                        <td>"+json[i].age+"</td>\n" +
                        "                        <td>"+json[i].cls+"</td>\n" +
                        "                        <td>"+json[i].birthday+"</td>\n" +
                        "                        <td>"+json[i].sex+"</td>\n" +
                        "                        <td>"+json[i].num+"</td>\n" +
                        "                        <td><a href='#' onclick='delStudentTr(this)'>删除学生</a></td>\n" +
                        "                    </tr>")
                }
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
                data: {id: ${sessionScope.aid},newPassword: newPassword},
                success: function () {
                    alert("修改成功")
                }
            })
        }
    }

    //删除课程
    function delCourseTr(obj) {
        var cid = $(obj).parent().parent().children(".courseId").text()
        $.ajax({
            url: "deleteOneCourse",
            type: "POST",
            data: {cid:cid},
            success: function () {
                alert("删除成功")
            }
        })
        /*table.removeChild(tr);*/
        courseManagerFun();
    }

    //删除教师
    function delTeacherTr(obj) {
        /*var table = obj.parentNode.parentNode.parentNode.parentNode;
        var tr = obj.parentNode.parentNode;*/
        var tid = $(obj).parent().parent().children(".teacherId").text();
        $.ajax({
            url: "deleteOneTeacher",
            type: "POST",
            data: {tid:tid},
            success: function () {
                alert("删除成功")
            }
        })
        /*table.removeChild(tr);*/
        managerTeacherFun();
    }

    //删除学生
    function delStudentTr(obj) {
        /*var table = obj.parentNode.parentNode.parentNode;
        var tr = obj.parentNode.parentNode;*/
        var sid = $(obj).parent().parent().children(".studentId").text();
        $.ajax({
            url: "deleteOneStudent",
            type: "POST",
            data: {sid:sid},
            success: function () {
                alert("删除成功")
            }
        })
        managerStudentFun()
    }

    //查询课程按钮单击
    function findCourseOnclick() {
        var courseFindInfo = window.prompt("请输入要查找的课程名称");
        $("#topBody").html("");
        $("#topBody").html("<tr>" +
            "<th>课程id</th>" +
            "<th>课程名称</th>" +
            "<th>课程教师</th>" +
            "<th>课程地点</th>" +
            "<th>课程时间</th>" +
            "</tr>");
        $("#mainTbody").html("");
        $.ajax({
            url: "adminFindOneCourse",
            type: "POST",
            data: {cname:courseFindInfo},
            success: function (result) {
                var json = JSON.parse(result);
                for (var i in json){
                    $("#mainTbody").append("<tr>" +
                        "<td>"+ json[i].courseId+"</td>" +
                        "<td>"+ json[i].courseName+"</td>" +
                        "<td>"+ json[i].courseTeacher+"</td>" +
                        "<td>"+ json[i].courseSite+"</td>" +
                        "<td>"+ json[i].courseTime+"</td>" +
                        "</th>")
                }
            }
        })
    }

    //查询教师按钮单击
    function findTeacherOnclick() {
        var teacherFindInfo = window.prompt("请输入要查找的教师名称");
        $("#topBody").html("");
        $("#topBody").html("<tr>" +
            "<th>教师id</th>" +
            "<th>教师姓名</th>" +
            "<th>教师年龄</th>" +
            "<th>教师生日</th>" +
            "<th>教师性别</th>" +
            "<th>教师课程</th>" +
            "</tr>");
        $("#mainTbody").html("");
        $.ajax({
            url: "findOneTeacher",
            type: "POST",
            data: {tname:teacherFindInfo},
            success: function (result) {
                var json = JSON.parse(result);
                for (var i in json){
                    $("#mainTbody").append("<tr>" +
                        "<td>"+ json[i].tid+"</td>" +
                        "<td>"+ json[i].tname+"</td>" +
                        "<td>"+ json[i].age+"</td>" +
                        "<td>"+ json[i].birthday+"</td>" +
                        "<td>"+ json[i].sex+"</td>" +
                        "<td>"+ json[i].course+"</td>" +
                        "</th>")
                }
            }
        })
    }

    //查询学生按钮单击
    function findStudentOnclick() {
        var studentFindInfo = window.prompt("请输入要查找的学生名称");
        $("#topBody").html("");
        $("#topBody").html("<tr>" +
            "<th>学生id</th>" +
            "<th>学生姓名</th>" +
            "<th>学生年龄</th>" +
            "<th>学生班级</th>" +
            "<th>学生生日</th>" +
            "<th>学生性别</th>" +
            "<th>学生学号</th>" +
            "</tr>");
        $("#mainTbody").html("");
        $.ajax({
            url: "findOneStudent",
            type: "POST",
            data: {sname:studentFindInfo},
            success: function (result) {
                var json = JSON.parse(result);
                for (var i in json){
                    $("#mainTbody").append("<tr>" +
                        "<td>"+ json[i].sid+"</td>" +
                        "<td>"+ json[i].name+"</td>" +
                        "<td>"+ json[i].age+"</td>" +
                        "<td>"+ json[i].cls+"</td>" +
                        "<td>"+ json[i].birthday+"</td>" +
                        "<td>"+ json[i].sex+"</td>" +
                        "<td>"+ json[i].num+"</td>" +
                        "</th>")
                }
            }
        })
    }

    //添加课程按钮单击
    function insertCourseOnclick() {
        $("#topBody").html("");
        $("#topBody").append("<tr>\n" +
            "                        <th>课程编号</th>\n" +
            "                        <th>课程名称</th>\n" +
            "                        <th>课程教师</th>\n" +
            "                        <th>课程位置</th>\n" +
            "                        <th>课程时间</th>\n" +
            "                        <th>操作</th>\n" +
            "                    </tr>")
        $("#mainTbody").html("")
        $("#mainTbody").append("<tr>\n" +
            "                        <td><input type=\"text\" id=\"CourseIdInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"CourseNameInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"CourseTeacherInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"CourseSiteInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"CourseTimeInput\"></td>\n" +
            "                        <td><a href=\"javascript:insertCourseInfo();\">添加</a></td>\n" +
            "                    </tr>")
    }

    //添加教师按钮单击
    function insertTeacherOnclick() {
        $("#topBody").html("");
        $("#topBody").append("<tr>\n" +
            "                        <th>教师id</th>\n" +
            "                        <th>教师姓名</th>\n" +
            "                        <th>教师年龄</th>\n" +
            "                        <th>教师生日</th>\n" +
            "                        <th>教师性别</th>\n" +
            "                        <th>教授课程</th>\n" +
            "                        <th>操作</th>\n" +
            "                    </tr>");
        $("#mainTbody").html("");
        $("#mainTbody").append("<tr>\n" +
            "                        <td><input type=\"text\" id=\"tidInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"tnameInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"tageInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"tbirthdayInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"tsexInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"tcourseInput\"></td>\n" +
            "                        <td><a href=\"javascript:insertTeacherInfo();\">添加</a></td>\n" +
            "                    </tr>")
    }

    //添加学生按钮单击
    function insertStudentOnclick() {
        $("#topBody").html("");
        $("#topBody").append("<tr>\n" +
            "                        <th>学生id</th>\n" +
            "                        <th>学生姓名</th>\n" +
            "                        <th>学生年龄</th>\n" +
            "                        <th>学生班级</th>\n" +
            "                        <th>学生生日</th>\n" +
            "                        <th>学生性别</th>\n" +
            "                        <th>学生学号</th>\n" +
            "                        <th>操作</th>\n" +
            "                    </tr>");
        $("#mainTbody").html("");
        $("#mainTbody").append("<tr>\n" +
            "                        <td><input type=\"text\" id=\"sidInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"sameInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"sageInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"sclsInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"sbirthdayInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"ssexInput\"></td>\n" +
            "                        <td><input type=\"text\" id=\"snumInput\"></td>\n" +
            "                        <td><a href=\"javascript:insertStudentInfo();\">添加</a></td>\n" +
            "                    </tr>")
    }

    //添加课程信息
    function insertCourseInfo() {
        var courseId = $("#CourseIdInput").val();
        var courseName = $("#CourseNameInput").val();
        var courseTeacher = $("#CourseTeacherInput").val();
        var courseSite = $("#CourseSiteInput").val();
        var courseTime = $("#CourseTimeInput").val();
        $.ajax({
            url: "insertNewCourse",
            type: "POST",
            data: {courseId:courseId,courseName:courseName,courseTeacher:courseTeacher,courseSite:courseSite,courseTime:courseTime},
            success: function () {
                alert("添加成功")
                courseManagerFun();
            }
        })
    }

    //添加教师信息
    function insertTeacherInfo() {
        var tid = $("#tidInput").val();
        var tname = $("#tnameInput").val();
        var tage = $("#tageInput").val();
        var tbirthday = $("#tbirthdayInput").val();
        var tsex = $("#tsexInput").val();
        var tcourse = $("#tcourseInput").val();
        $.ajax({
            url: "insertNewTeacher",
            type: "POST",
            data: {tid:tid,tname:tname,tage:tage,tbirthday:tbirthday,tsex:tsex,tcourse:tcourse},
            success: function (result) {
                alert(result)
                managerTeacherFun();
            }
        })
    }

    //添加学生信息
    function insertStudentInfo() {
        var sid = $("#sidInput").val();
        var sname = $("#snameInput").val();
        var sage = $("#sageInput").val();
        var scls = $("#sclsInpu").val();
        var sbirthday = $("#sbirthdayInput").val();
        var ssex = $("#ssexInput").val();
        var snum = $("#snumInput").val();
        $.ajax({
            url: "insertNewStudent",
            type: "POST",
            data: {sid:sid,sname:sname,sage:sage,scls:scls,sbirthday:sbirthday,ssex:ssex,snum:snum},
            success: function (result) {
                alert(result)
                managerStudentFun();
            }
        })
    }

    //设置课程的教师
    function addCourseTeacherOnclick() {
        var cid = window.prompt("请输入课程id");
        var tid = window.prompt("请输入教师id");
        $.ajax({
            url: "addCourseTeacher",
            type: "POST",
            data: {tid: tid,cid: cid},
            success: function () {
                alert("设置成功")
            },
            error: function () {
                alert("设置失败")
            }
        })
    }

</script>

</body>
</html>
