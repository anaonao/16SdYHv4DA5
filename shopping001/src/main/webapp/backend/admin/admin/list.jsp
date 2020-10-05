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
    <title>显示所有管理员信息</title>
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        function confirm_del(stuNO) {
            if(confirm("您确定要删除" + stuNO + "的数据么?")) {
                location.href="DeptDeleteServlet?stuNO=" + stuNO ;
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
                    <th>管理员名称</th>
                    <th>密码</th>
                    <th>联系方式</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <c:forEach items="${page.data}" var="admin">
                        <td>${admin.adminId}</td>
                        <td>${admin.adminName}</td>
                        <td>${admin.adminPwd}</td>
                        <td>${admin.adminPhone}</td>
                        <td>
                            <c:if test="${admin.adminState}=1">
                                启用
                            </c:if>
                            <c:if test="${admin.adminState}=0">
                                禁用
                            </c:if>
                        </td>
                        <td>
                            <a href="javascript:">详情</a>
                            <a href="javascript:">删除</a>
                        </td>
                    </c:forEach>

                </tr>
                <tr>
                    <td colspan="3">
                        <a href="javascript">首页</a>
                        <a href="javascript">上一页</a>
                        <a href="javascript">下一页</a>
                        <a href="javascript">尾页</a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>


</body>
</html>
