<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    request.setAttribute("path",path);
%>
<html>
<head>
    <title>Title</title>
    <script  src="${path}/resources/jquery-2.1.3.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script>

    </script>
</head>
<body>
    <div class="form-group">
        <label for="departName">部门选择</label>
        <select id="departName">
            <option value="0">请选择</option>
        </select>
    </div>
    <div class="form-group">
        <label for="employeeName">员工姓名</label>
        <input type="text" class="form-control" id="employeeName" placeholder="员工姓名">
    </div>
    <br>
    <div class="form-group">
        <label for="empSex">员工性别</label>
        <select id="empSex">
            <option value="1">男</option>
            <option value="2">女</option>
        </select>
    </div>
    <button id="insertBtn" class="button">提交</button>
<script>
        $.ajax({
            url:"${path}/department/selectDepAll",
            type:"get",
            data:{},
            dataType:"json",
            success:function (data) {
                console.log(data);
                for (var i = 0; i<data.length;i++){
                    var line = data[i];
                    var html = "<option value='"+line.departmentId+"'>"+line.departmentName+"</option>";
                    $("#departName").append(html);
                }
            }
        })

    $("#insertBtn").click(function () {
        $.ajax({
            url:"${path}/emp/insertEmp",
            data:{
                departmentId:$("#departName option:selected").val()
                ,employeeName:$("#employeeName").val()
                ,employeeSex:$("#empSex option:selected").html()
            },
            contentType:"application/json",
            type:"post",
            dataType:"json",
            success:function (data) {
                if (data.state){
                    alert(data.message);
                    window.location.href="${path}/module/login.jsp"
                }else {
                    alert(data.message);
                }
            }
        })
    })
</script>
</body>
</html>
