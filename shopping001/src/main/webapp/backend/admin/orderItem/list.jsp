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
    <title>显示所有订单详情信息</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>


</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <tr>
                    <th>编号</th>
                    <th>订单编号</th>
                    <th>商品编号</th>
                    <th>数量</th>
                </tr>
                <c:forEach items="${page.data}" var="orderItem">
                    <tr>
                        <td>${orderItem.orderitemId}</td>
                        <td>${orderItem.order.orderid}</td>
                        <td>${orderItem.product.productId}</td>
                        <td>${orderItem.productCount}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" style="text-align: center">
                        <a href="<%=request.getContextPath()%>/OrderItemServlet?op=selectAll&page=1">首页</a>
                        <a href="<%=request.getContextPath()%>/OrderItemServlet?op=selectAll&page=${page.prev()}">上一页</a>
                        <c:forEach begin="1" var="i" end="${page.getTotalPageCount()}">
                            <a href="<%=request.getContextPath()%>/OrderItemServlet?op=selectAll&page=${i}">${i}</a>
                        </c:forEach>
                        <a href="<%=request.getContextPath()%>/OrderItemServlet?op=selectAll&page=${page.next()}">下一页</a>
                        <a href="<%=request.getContextPath()%>/OrderItemServlet?op=selectAll&page=${page.getTotalPageCount()}">尾页</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
