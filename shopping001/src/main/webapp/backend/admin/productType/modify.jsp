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
    <title>商品图片信息修改</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">商品图片信息修改</h1>
    <form id="formadd" class="form-horizontal" action="<%=request.getContextPath()%>/ProductImgServlet?op=updateProductImg" method="post" enctype="multipart/form-data">
        <input type="hidden" name="productImgId" id="productImgId" value="${productImg.productImgId}">
        <div class="form-group">
            <label  class="col-sm-2 control-label">图片</label>
            <div class="col-sm-10">
                <img style="height: 200px;width: 150px;border:1px solid #0c0c0c;" src="<%=request.getContextPath()%>/foreground/images/${productImg.productImgName}" />
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">图片选择</label>
            <div class="col-sm-10">
                <input class="form-control" type="file" name="productImg" id="productImg" multiple>
            </div>
        </div>
        <div class="form-group">
            <label  class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <select class="form-control" name="product" id="product">
                    <c:forEach items="${product}" var="product">
                        <option value="${product.productId}" <c:if test="${productImg.product.productId==product.productId}">selected</c:if> >${product.productName}</option>
                    </c:forEach>

                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">添加</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
