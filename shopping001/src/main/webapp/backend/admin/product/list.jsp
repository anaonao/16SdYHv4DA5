<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 安
  Date: 2020/9/30
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有商品信息</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        function confirm_del(id) {
            if (confirm("您确定要删除" + id + "的数据么?")) {
                location.href = "ProductServlet?op=deleteById&id=" +id;
            }
        }
    </script>

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <tr>
                    <th>编号</th>
                    <th>商品名称</th>
                    <th>商品库存</th>
                    <th>商品价格</th>
                    <th>商品描述</th>
                    <th>商品热度</th>
                    <th>商品类型</th>
                    <th>折扣</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${page.data}" var="product">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productCount}</td>
                        <td>${product.productPrice}</td>
                        <td>${product.productDiscraction}</td>
                        <td>${product.productSales}</td>
                        <td>${product.producttype.type_name}</td>
                        <td>
                            <c:if test="${product.productDiscount=='0'}">不打折</c:if>
                            <c:if test="${product.productDiscount=='1'}">1折</c:if>
                            <c:if test="${product.productDiscount=='2'}">2折</c:if>
                            <c:if test="${product.productDiscount=='3'}">3折</c:if>
                            <c:if test="${product.productDiscount=='4'}">4折</c:if>
                            <c:if test="${product.productDiscount=='5'}">5折</c:if>
                            <c:if test="${product.productDiscount=='6'}">6折</c:if>
                            <c:if test="${product.productDiscount=='7'}">7折</c:if>
                            <c:if test="${product.productDiscount=='8'}">8折</c:if>
                            <c:if test="${product.productDiscount=='9'}">9折</c:if>
                        </td>
                        <td>
                            <a href="<%=request.getContextPath()%>/ProductServlet?op=selectById&id=${product.productId}">详情</a>
                            <a href="javascript:confirm_del('${product.productId}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" style="text-align: center">
                        <a href="<%=request.getContextPath()%>/ProductServlet?op=selectAll&page=1">首页</a>
                        <a href="<%=request.getContextPath()%>/ProductServlet?op=selectAll&page=${page.prev()}">上一页</a>
                        <c:forEach begin="1" var="i" end="${page.getTotalPageCount()}">
                            <a href="<%=request.getContextPath()%>/ProductServlet?op=selectAll&page=${i}">${i}</a>
                        </c:forEach>
                        <a href="<%=request.getContextPath()%>/ProductServlet?op=selectAll&page=${page.next()}">下一页</a>
                        <a href="<%=request.getContextPath()%>/ProductServlet?op=selectAll&page=${page.getTotalPageCount()}">尾页</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
