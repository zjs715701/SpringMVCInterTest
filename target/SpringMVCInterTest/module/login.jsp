<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"  %>
<%
    String path = request.getContextPath();
    request.setAttribute("path",path);
%>
<html>
<head>
    <title>Title</title>
    <script  src="${path}/resources/jquery-2.1.3.js"></script>
</head>
<body>
    用户名:<input id="username" >
    密码:<input id="password">
    <input type="button" id="loginBtn"  value="登录">
<script>
    // $("#loginBtn").click(function () {
    //     alert(111);
    // })
    $("#loginBtn").click(function () {
        $.ajax({
            url:"${path}/account/login",
            data:{username:$("#username").val(),password:$("#password").val()},
            type:"post",
            dataType:"json",
            success:function (data) {
                if(data.state){
                    alert(data.message);
                    window.location.href = "${path}/module/employeeList.jsp";
                }else {
                    alert(data.message);
                }
            }
        })
    })


</script>
</body>
</html>
