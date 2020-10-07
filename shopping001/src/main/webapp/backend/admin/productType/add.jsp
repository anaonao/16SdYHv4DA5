<%--
  Created by IntelliJ IDEA.
  User: 安
  Date: 2020/10/5
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品类型信息添加</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">商品类型信息添加</h1>
    <form id="formadd" class="form-horizontal">
        <div class="form-group">
            <label  class="col-sm-2 control-label">商品类型</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="productTypeName" id="productTypeName">
            </div>
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
        $("#formadd").submit(function () {
            /*判断商品类不能重复*/
            $.ajax({
                url:"<%=request.getContextPath()%>/ProductTypeServlet?op=addProductType",
                type:"post",
                data:{
                    "productTypeId":$("#productTypeId").val(),
                    "productTypeName":$("#productTypeName").val()
                },
                success:function (data) {
                    console.log(data)
                    if(data=="1"){
                        location.href="<%=request.getContextPath()%>/ProductTypeServlet?op=selectAll";
                    }
                    if(data=="0"){
                        alert("添加失败！");
                    }
                }
            })
            return false;
        })
    })
</script>
</body>
</html>
