<%--
  Created by IntelliJ IDEA.
  User: 安
  Date: 2020/10/5
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员添加页面</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>


</head>
<body>
<div class="container">
    <h1 style="text-align: center">添加管理员</h1>
    <form id="form-s" class="form-horizontal" action="<%=request.getContextPath()%>/AdminServlet?op=add" method="post">
        <div class="form-group">
            <label for="adminname" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="adminname" name="adminname" placeholder="用户名" required>
            </div>
            <span id="namespan" style="color: red"></span>
        </div>
        <div class="form-group">
            <label for="pwd" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="pwd" name="pwd" placeholder="密码" required>
            </div>
        </div>
        <div class="form-group">
            <label for="pwd2" class="col-sm-2 control-label">重复密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="重复密码" required>
            </div>
            <span id="pwd2span" style="color: red"></span>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">手机号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="手机号" required>
            </div>
            <span id="phonepan" style="color: red"></span>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </div>
    </form>
</div>
<script>
    $(function () {
        $("#form-s").submit(function () {
          if($("#pwd").val()!=$("#pwd2").val()){
              $("#pwd2span").text("俩次密码不一致请重新输入")
              return false;
          }
          /*验证手机号是否合法*/
          /*判断用户名是否存在*/
          /*判断是否添加成功*/
            $.ajax({
                url:"<%=request.getContextPath()%>/AdminServlet?op=add",
                type:"post",
                data:{

                },
                success:function (data) {
                 alert(data);
                    if(data=="管理员注册成功"){
                        return true;
                    }else{
                        return false;
                    }
                }
            })
            return false;
        })
    })
</script>
</body>
</html>
