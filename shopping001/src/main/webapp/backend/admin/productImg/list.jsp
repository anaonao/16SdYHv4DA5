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
    <title>显示所有商品图片信息</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        function confirm_del(id) {
            if (confirm("您确定要删除" + id + "的数据么?")) {
                location.href = "ProductImgServlet?op=deleteById&id=" +id;
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
                    <th>图片</th>
                    <th>商品名称</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${page.data}" var="productImg">
                    <tr>
                        <td>${productImg.productImgId}</td>
                        <td><img style="height: 50px;height: 70px" src="<%=request.getContextPath()%>/foreground/images/${productImg.productImgName}" /></td>
                        <td>${productImg.product.productName}</td>
                        <td>
                            <a href="<%=request.getContextPath()%>/ProductImgServlet?op=selectById&id=${productImg.productImgId}">详情</a>
                            <a href="javascript:confirm_del('${productImg.productImgId}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6" style="text-align: center">
                        <a href="<%=request.getContextPath()%>/ProductImgServlet?op=selectAll&page=1">首页</a>
                        <a href="<%=request.getContextPath()%>/ProductImgServlet?op=selectAll&page=${page.prev()}">上一页</a>
                        <c:forEach begin="1" var="i" end="${page.getTotalPageCount()}">
                            <a href="<%=request.getContextPath()%>/ProductImgServlet?op=selectAll&page=${i}">${i}</a>
                        </c:forEach>
                        <a href="<%=request.getContextPath()%>/ProductImgServlet?op=selectAll&page=${page.next()}">下一页</a>
                        <a href="<%=request.getContextPath()%>/ProductImgServlet?op=selectAll&page=${page.getTotalPageCount()}">尾页</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
