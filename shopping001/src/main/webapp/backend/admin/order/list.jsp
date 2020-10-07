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
    <title>显示所有订单信息</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        function confirm_del(id) {
            if (confirm("您确定要给" + id + "的数据发货吗?")) {
                location.href = "OrderServlet?op=updateByState&id=" +id;
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
                    <th>时间</th>
                    <th>总价格</th>
                    <th>状态</th>
                    <th>用户编号</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${page.data}" var="order">
                    <tr>
                        <td>${order.orderid}</td>
                        <td>${order.orderDate}</td>
                        <td>${order.order_price}</td>
                        <td>
                        <c:if test="${order.state==0}">未发货</c:if>
                        <c:if test="${order.state==1}">已发货</c:if>
                        <c:if test="${order.state==2}">未收货</c:if>
                        <c:if test="${order.state==3}">已收货</c:if>
                        <c:if test="${order.state==4}">退货</c:if>
                        </td>
                        <td>${order.user.userId}</td>
                        <td>
                            <c:if test="${order.state==0}"><a href="javascript:confirm_del('${order.orderid}')">发货</a></c:if>
                            <c:if test="${order.state==1}">已发货</c:if>
                            <c:if test="${order.state==3}">已收货</c:if>
                            <c:if test="${order.state==4}">退货</c:if>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" style="text-align: center">
                        <a href="<%=request.getContextPath()%>/OrderServlet?op=selectAll&page=1">首页</a>
                        <a href="<%=request.getContextPath()%>/OrderServlet?op=selectAll&page=${page.prev()}">上一页</a>
                        <c:forEach begin="1" var="i" end="${page.getTotalPageCount()}">
                            <a href="<%=request.getContextPath()%>/OrderServlet?op=selectAll&page=${i}">${i}</a>
                        </c:forEach>
                        <a href="<%=request.getContextPath()%>/OrderServlet?op=selectAll&page=${page.next()}">下一页</a>
                        <a href="<%=request.getContextPath()%>/OrderServlet?op=selectAll&page=${page.getTotalPageCount()}">尾页</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
