<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导航</title>
</head>
<body>

<header class="header_section innerpage_header">
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container">
            <a class="navbar-brand" href="index.html">
          <span>
            凯瑞智能家居
          </span>
            </a>
            <div class="" id="">

                <div class="custom_menu-btn">
                    <button onclick="openNav()">
                        <span class="s-1"> </span>
                        <span class="s-2"> </span>
                        <span class="s-3"> </span>
                    </button>
                    <%--                    导航--%>
                    <div id="myNav" class="overlay">
                        <div class="overlay-content">
                            <a href="index.jsp">首页</a>
                            <a href="cart.jsp">购物车</a>
                            <a href="person_center.jsp">个人中心</a>
                            <a href="message.jsp">留言</a>
                            <a href="about.jsp">关于我们</a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- custom js -->
<script src="<%=request.getContextPath()%>/foreground/js/custom.js"></script>

</body>
</html>
