<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <!-- Basic -->
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Site Metas -->
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="icon" href="<%=request.getContextPath()%>/foreground/images/favicon.png" type="image/gif"/>

    <title>二级页面</title>

    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/foreground/css/bootstrap.css"/>

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet"/>

    <!-- font awesome style -->
    <link href="<%=request.getContextPath()%>/foreground/css/font-awesome.min.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/foreground/css/style.css" rel="stylesheet"/>
    <!-- responsive style -->
    <link href="<%=request.getContextPath()%>/foreground/css/responsive.css" rel="stylesheet"/>

</head>

<body>

<%@include file="myNav.jsp" %>

<!-- blog section -->

<section class="blog_section layout_padding">
    <div class="container-fluid">
        <div class="heading_container">
            <h2>
                ${page.data[0].producttype.type_name}
            </h2>
        </div>

        <div class="row product">
            <c:forEach items="${page.data}" var="product">
                <div class="col-lg-3 ">
                    <div class="box">
                        <a href="<%=request.getContextPath()%>/ProductServlet?op=findById&id=${product.productId}"  >

                            <div>
                                <img src="<%=request.getContextPath()%>/foreground/images/${product.list[0].productImgName}"
                                     style="width: 300px; height: 300px;margin: 16px" alt="">
                                <div>
                                    <h5>
                                            ${product.productName}
                                    </h5>
                                    <p>
                                            ${product.productDiscraction}
                                    </p>
                                </div>
                            </div>
                        </a>

                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</section>

<!-- end blog section -->

<%@include file="myFoot.jsp" %>


<!-- jQery -->
<script src="<%=request.getContextPath()%>/foreground/js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="<%=request.getContextPath()%>/foreground/js/bootstrap.js"></script>

<!-- custom js -->
<script src="<%=request.getContextPath()%>/foreground/js/custom.js"></script>

</body>

</html>
