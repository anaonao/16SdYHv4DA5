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
    <title>商品信息修改</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h1 style="text-align: center">商品信息修改</h1>
    <form class="form-horizontal" action="<%=request.getContextPath()%>/ProductServlet?op=updateProduct" method="post">
        <input type="hidden"  id="productId" name="productId" value="${product.productId}">
        <div class="form-group">
            <label for="productName" class="col-sm-2 control-label">商品名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="productName" name="productName" placeholder="商品名称" required value="${product.productName}">
            </div>
        </div>
        <div class="form-group">
            <label for="productCount" class="col-sm-2 control-label">商品库存</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="productCount" name="productCount" placeholder="商品库存" required value="${product.productCount}" min="0">
            </div>
        </div>
        <div class="form-group">
            <label for="productPrice" class="col-sm-2 control-label">商品价格</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="productPrice" name="productPrice" placeholder="商品价格" required value="${product.productPrice}" min="0">
            </div>
        </div>
        <div class="form-group">
            <label for="productPrice" class="col-sm-2 control-label">商品描述</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="productDiscraction" name="productDiscraction">${product.productDiscraction}</textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="productSales" class="col-sm-2 control-label">商品热度</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="productSales" name="productSales" placeholder="商品价格" required value="${product.productSales}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="producttype" class="col-sm-2 control-label">商品类型</label>
            <div class="col-sm-10">
                <select name="producttype" id="producttype" class="form-control">
                    <c:forEach items="${listTypeAll}" var="list">
                        <option value="${list.type_id}" <c:if test="${list.type_id==product.producttype.type_id}">selected</c:if> >${list.type_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="productDiscount" class="col-sm-2 control-label">折扣</label>
            <div class="col-sm-10">
                <select name="productDiscount" id="productDiscount" class="form-control">
                    <option value="0" <c:if test="${product.productDiscount=='0'}">selected</c:if>>不打折</option>
                    <option value="1" <c:if test="${product.productDiscount=='1'}">selected</c:if>>1折</option>
                    <option value="2" <c:if test="${product.productDiscount=='2'}">selected</c:if>>2折</option>
                    <option value="3" <c:if test="${product.productDiscount=='3'}">selected</c:if>>3折</option>
                    <option value="4" <c:if test="${product.productDiscount=='4'}">selected</c:if>>4折</option>
                    <option value="5" <c:if test="${product.productDiscount=='5'}">selected</c:if>>5折</option>
                    <option value="6" <c:if test="${product.productDiscount=='6'}">selected</c:if>>6折</option>
                    <option value="7" <c:if test="${product.productDiscount=='7'}">selected</c:if>>7折</option>
                    <option value="8" <c:if test="${product.productDiscount=='8'}">selected</c:if>>8折</option>
                    <option value="9" <c:if test="${product.productDiscount=='9'}">selected</c:if>>9折</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">修改</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
