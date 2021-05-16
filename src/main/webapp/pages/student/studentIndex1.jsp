<%--
  Created by IntelliJ IDEA.
  User: Moveon
  Date: 2021/4/27
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>学生主页</title>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

<style>

    body{
        /*background: url("${pageContext.request.contextPath}/image/111.jpg");*/
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

<div>
    <!-- 顶部导航栏 -->
    <div id="topBox" class="aaa">
        <div class="admin">
            <input type="button" class="btn-primary" value="更新个人信息" onclick="updateStudentInfoOnclick()">
            <input type="button" class="btn-primary" value="查询课程" onclick="studentFindCourseOnclick()">
            <i class="fa fa-user-circle-o" aria-hidden="true"></i>
            <b>欢迎 ${sessionScope.sname} 同学</b>
            <a href="javascript:location.href='logoutUser';">退出</a>
        </div>
    </div>

    <%--左侧导航栏--%>
    <div id="bigBox" class="row aaa">
        <div id="indexLeft" class="col-xs-2">
            <ul class="nav nav-pills nav-stacked" id="indexLeftList">
                <li role="presentation"><a href="javascript:findAllCourseFun()">所有课程</a></li>
                <li role="presentation"><a href="javascript:findStudentCourseFun();">已选课程</a></li>
                <li role="presentation"><a href="javascript:findCourseScoreFun()">成绩查询</a></li>
                <li role="presentation"><a href="javascript:modifyPassword()">修改密码</a></li>
                <li role="presentation"><a href="javascript:location.href='logoutUser';">退出系统</a></li>
            </ul>
        </div>
        <div class="col-xs-10">
            <table id = "allCourse" class="table table-hover">
                <tr>
                    <th>课程编号</th>
                    <th>课程名称</th>
                    <th>课程教师</th>
                    <th>课程地点</th>
                    <th>课程时间</th>
                    <th id="aaa">选课状态</th>
                </tr>
                <tbody id="allCourseTbody">

                </tbody>
            </table>
        </div>
    </div>
</div>

<script>

    /*页面加载后获取所有的课程信息*/
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
        findAllCourseFun();
    })

    //学生模糊查询课程
    function studentFindCourseOnclick() {
        $("#allCourseTbody").html("");
        var course = window.prompt("请输入课程名称");
        $.ajax({
            url: "adminFindOneCourse",
            type: "POST",
            data: {cname:course},
            success: function (result) {
                var json = JSON.parse(result);
                for (var i in json){
                    $("#allCourseTbody").append("<tr>\n" +
                        "                    <td class='courseId'>"+json[i].courseId+"</td>\n" +
                        "                    <td>"+json[i].courseName+"</td>\n" +
                        "                    <td>"+json[i].courseTeacher+"</td>\n" +
                        "                    <td>"+json[i].courseSite+"</td>\n" +
                        "                    <td>"+json[i].courseTime+"</td>\n" +
                        "                    <td><button button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"addCourse(this)\">选课</button></td>\n" +
                        "                </tr>")
                }
            }
        })
    }

    //单击按钮发送请求，通过登陆的id查询到该学生的所有课程
    function findStudentCourseFun() {
        $.ajax({
            url:"findStudentCourse",
            type:"POST",
            data:{sid: ${sid}},
            success:function (result) {
                var json = JSON.parse(result);
                $("#allCourseTbody").html("");
                $("#aaa").text("选课状态");
                for (var i in json){
                    $("#allCourseTbody").append("<tr>\n" +
                        "            <td class=\"courseId\">"+json[i].courseId+"</td>\n" +
                        "            <td>"+json[i].courseName+"</td>\n" +
                        "            <td>"+json[i].courseTeacher+"</td>\n" +
                        "            <td>"+json[i].courseSite+"</td>\n" +
                        "            <td>"+json[i].courseTime+"</td>\n" +
                        "            <td><button button type=\"button\" class=\"btn btn-danger btn-sm\" onclick=\"delTr(this)\">退选</button></td>\n" +
                        "        </tr>")
                }
            }
    })
}
    /*单击按钮发送请求，查询所有课程*/
    function findAllCourseFun() {
        $.ajax({
            url: "findAllCourse",
            success: function (result) {
                var json = JSON.parse(result);
                $("#aaa").text("选课状态");
                $("#allCourseTbody").html("");
                for (var i in json){
                    $("#allCourseTbody").append("<tr>\n" +
                        "            <td class=\"courseId\">"+json[i].courseId+"</td>\n" +
                        "            <td>"+json[i].courseName+"</td>\n" +
                        "            <td>"+json[i].courseTeacher+"</td>\n" +
                        "            <td>"+json[i].courseSite+"</td>\n" +
                        "            <td>"+json[i].courseTime+"</td>\n" +
                        "            <td><button button type=\"button\" class=\"btn btn-primary btn-sm\" onclick=\"addCourse(this)\">选课</button></td>\n" +
                        "        </tr>")
                }
            }
        })
    }

    /*通过id查询学生课程成绩*/
    function findCourseScoreFun() {
        $.ajax({
            url: "findAllScore",
            type: "POST",
            data:{sid:${sessionScope.sid}},
            success: function (result) {
                var json = JSON.parse(result);
                $("#aaa").text("课程分数");
                $("#allCourseTbody").html("");
                for (var i in json){
                    $("#allCourseTbody").append("<tr>\n" +
                        "                <td>"+json[i].cid+"</td>\n" +
                        "                <td>"+json[i].courseName+"</td>\n" +
                        "                <td>"+json[i].courseTeacher+"</td>\n" +
                        "                <td>"+json[i].courseSite+"</td>\n" +
                        "                <td>"+json[i].courseTime+"</td>\n" +
                        "                <td>"+json[i].score+"</td>\n" +
                        "            </tr>")
                }
            }
        })
    }

    //选课
    function addCourse(obj) {
        var cid = $(obj).parent().parent().children(".courseId").text();
        $.ajax({
            url: "addCourse",
            type: "POST",
            data: {sid:${sessionScope.sid},cid:cid},
            success: function () {
                alert("选课成功")
            }
        })
    }

    //退选课程
    function delTr(obj){
        var table = obj.parentNode.parentNode.parentNode;
        var tr = obj.parentNode.parentNode;
        var cid = $(obj).parent().parent().children(".courseId").text();
        $.ajax({
            url:"deleteCourse",
            type:"POST",
            dataType: "text",
            data: {sid:${sid},cid:cid},
            success: function () {
                alert("退选成功")
            }
        });
        table.removeChild(tr);
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
                data: {id: ${sessionScope.sid},newPassword: newPassword},
                success: function () {
                    alert("修改成功")
                }
            })
        }
    }

    //完善学生信息
    function updateStudentInfoOnclick() {
        var age = window.prompt("请输入你的年龄");
        var cls = window.prompt("请输入你的班级");
        var birthday = window.prompt("请输入你的生日");
        var sex = window.prompt("请输入你的性别");
        var num = window.prompt("请输入你的学号");
        $.ajax({
            url: "updateStudentInfo",
            type: "POST",
            data: {
                sid: ${sessionScope.sid},
                name: "${sessionScope.sname}",
                age: age,
                cls: cls,
                birthday: birthday,
                sex: sex,
                num: num
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
