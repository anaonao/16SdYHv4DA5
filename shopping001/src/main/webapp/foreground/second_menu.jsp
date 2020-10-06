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
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <!-- Site Metas -->
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link rel="icon" href="images/favicon.png" type="image/gif" />

    <title>二级页面</title>

    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" />
    <style type="text/css">
        .product img{
            width: 300px;
            height: 300px;
            margin: 4px;
        }
    </style>

</head>

<body>

<%@include file="myNav.jsp"%>

<!-- blog section -->

<section class="blog_section layout_padding">
    <div class="container-fluid">
        <div class="heading_container">
            <h2>
                监控/摄像
            </h2>
        </div>
        <div class="row product" >
            <div class="col-lg-3 ">
                <div class="box">
                    <div >
                        <img src="images/b1.jpg" alt="">
                        <div >
                            <h5>
                                商品名称
                            </h5>
                            <p>
                                商品简介
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 ">
                <div class="box">
                    <div >
                        <img src="images/b1.jpg" alt="">
                        <div >
                            <h5>
                                商品名称
                            </h5>
                            <p>
                                商品简介
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 ">
                <div class="box">
                    <div >
                        <img src="images/b1.jpg" alt="">
                        <div >
                            <h5>
                                商品名称
                            </h5>
                            <p>
                                商品简介
                            </p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 ">
                <div class="box">
                    <div >
                        <img src="images/b1.jpg" alt="">
                        <div >
                            <h5>
                                商品名称
                            </h5>
                            <p>
                                商品简介
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- end blog section -->

<%@include file="myFoot.jsp" %>


<!-- jQery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>

<!-- custom js -->
<script src="js/custom.js"></script>

</body>

</html>
