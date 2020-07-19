<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/4/9
  Time: 12:05
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


<!-- Modal -->
<div  class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                <form class="form-inline">
                    <input id="employeeId" readonly="readonly">
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
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" id="svenBtn" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>
    <button id="insertBtn">新增</button>
    <table class="table table-hover table-striped table-bordered table-striped">
        <thead>
            <tr>
                <th>序号</th>
                <th>部门名称</th>
                <th>员工姓名</th>
                <th>员工性别</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody  id="emList">

        </tbody>
    </table>

<script>

    function page(){
        $.ajax({
            url:"${path}/emp/selectEmpAll",
            type:"get",
            data:{},
            dataType:"json",
            success:function (data) {
                console.log(data);
                $("#emList").html("");
                for (var i=0;i<data.length;i++){
                    var line = data[i];
                    var html = "<tr>" +
                        "   <td>"+(i+1)+"<input type='hidden' class='employeeId' value='"+line.employeeId+"' >" +
                        "       <input type='hidden' class='departmentId' value='"+line.departmentId+"' /></td>" +
                        "   <td>"+line.departmentEntity.departmentName+"</td>" +
                        "   <td>"+line.employeeName+"</td>" +
                        "   <td>"+line.employeeSex+"</td>" +
                        "   <td><input value='修改' type='button' class='updateBtn'/>" +
                        "       <input value='删除' type='button' class='insertBtn'/>" +
                        "   </td>" +
                        "</tr>";
                    $("#emList").append(html);
                }
            }
        })
    }
    page();

    $("#emList").on("click",".updateBtn",function () {
        var employeeId = $(this).parent().parent().find(".employeeId").val();
        var departmentId = $(this).parent().parent().find(".departmentId").val();
        $("#myModal").modal("show");
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
                    if (line.departmentId==departmentId){
                        $("#departName").find("option:contains('"+line.departmentName+"')").attr("selected",true);
                    }
                }
            }
        })

        $.ajax({
            url:"${path}/emp/selectById",
            type:"get",
            data:{employeeId:employeeId},
            dataType:"json",
            async:false,
            success:function (data) {
                console.log(data);
                $("#employeeId").val(data.employeeId);
                $("#employeeName").val(data.employeeName);
                $("#empSex").find("option:contains('"+data.employeeSex+"')").attr("selected",true);
            }
        })
    })

    $("#svenBtn").click(function () {
        var employeeEntity = {
                 employeeId:$("#employeeId").val()
                ,departmentId:$("#departName option:selected").val()
                ,employeeName:$("#employeeName").val()
                ,employeeSex:$("#empSex option:selected").html()
            };
        var dataArray = new Array();
        dataArray.push(employeeEntity);
        console.log(employeeEntity);
        $.ajax({
            url:"${path}/emp/updateEmp",
            type:"put",
            data:JSON.stringify(employeeEntity),
            contentType:"application/json",
            dataType:"json",
            success:function (data) {
                if (data.state){
                    alert(data.message);
                    $("#myModal").modal("hide");
                    page();

                }else{
                    alert(data.message);
                }
            }
        })
    })

    $("#insertBtn").click(function () {
        window.location.href="${path}/module/insertEmployee.jsp";
    })
</script>
</body>
</html>
