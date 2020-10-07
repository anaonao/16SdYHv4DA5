<%--
  Created by IntelliJ IDEA.
  User: 安
  Date: 2020/9/17
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员登录页面</title>

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/asserts/css/bootstrap.css" />
    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<div class="container">
    <c:if test="${msg!=null}">
        <script>
            $(function () {
               alert('${msg}')
            })
        </script>
    </c:if>
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-6">
            <form class="form-horizontal" action="<%=request.getContextPath()%>/AdminServlet?op=login" method="post" id="formlogin">
                <h1 style="text-align: center;margin-top: 50px">管理员登录</h1>
                <div class="form-group" style="margin-top: 100px">
                    <label for="adminname" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adminname" name="adminname" placeholder="用户名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="pwd" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="密码">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="ck" id="ck"> 七天免登录
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-3">
        </div>
    </div>
</div>
<script>
    $(function () {
        $("#formlogin").submit(function () {
            $.ajax({
                url:"<%=request.getContextPath()%>/AdminServlet?op=login",
                type:"post",
                data:{
                    "adminname":$("#adminname").val(),
                    "pwd":$("#pwd").val(),
                    "ck":$("#ck").val()
                },
                success:function (data) {
                    if(data=="1"){
                        location.href="<%=request.getContextPath()%>/backend/admin/index.jsp";
                    }else if(data=="0"){
                        alert("用户名或者密码错误")
                    }
                }
            })
            return false;
        })
    })
</script>
</body>
</html>
