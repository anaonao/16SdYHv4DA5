<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script type="javascript" src="js/bootstrap.js"></script>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <style type="text/css">
        form{
            color: white;
        }
    </style>
</head>
<body>
<form>
    <div style="background-image: url('<%=request.getContextPath()%>/foreground/images/timg.jpg');height: 100%;width: 100%; ">
    <div class="col-lg-4 mx-auto" >;
    <div class="form-group" style="margin-top: 150px">
        <label for="exampleInputEmail1">手机号</label>
        <input type="email" class="form-control" id="exampleInputEmail1" >
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">密码</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="form-group">
        <label for="exampleInputFile">请选择您的头像 </label>
        <input type="file" id="exampleInputFile">
        <p class="help-block">Example block-level help text here.</p>
    </div>
    <div class="checkbox">
        <label>
            <input type="checkbox"> Check me out
        </label>
    </div>
    <button type="submit" class="btn btn-default">登录</button>
    </div>
    </div>
</form>
</body>
</html>
