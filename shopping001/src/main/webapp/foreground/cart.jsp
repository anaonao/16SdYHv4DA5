<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 14:48
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

    <title>商品详情页</title>

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

    <link href="css/cart.css" rel="stylesheet" />

</head>

<body>

<!-- header section strats -->
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
                    <%@include file="myNav.jsp" %>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- end header section -->


<!-- about section -->

<section class="about_section layout_padding ">
    <div class="container">
        <!--购物车-->
        <div class="row">
            <div class="col-md-10" id="movie">
                <div id="cart">
                    <!--头部-->
                    <div id="cartHead">
                        <div class="row">
                            <div class="col-md-1">
                                <input type="checkbox" class="ckAll" checked="checked" />全选
                            </div>
                            <div class="col-md-2">商品图片</div>
                            <div class="col-md-3">商品名字</div>
                            <div class="col-md-1">价格</div>
                            <div class="col-md-2">数量</div>
                            <div class="col-md-1">小计</div>
                            <div class="col-md-2">操作</div>
                        </div>
                    </div>
                    <!--身体-->
                    <div id="cartBody">
                        <!--加载购买的商品-->
                        <div class="row">
                            <div class="col-md-1">
                                <input type="checkbox" class="ck" checked="checked" />
                            </div>
                            <!--图片-->
                            <div class="col-md-2"><img  class="shopImg" style="width: 100px;height: 150px;"/></div>
                            <!--名字-->
                            <div class="col-md-3 shopName"></div>
                            <!--价格-->
                            <div class="col-md-1 pri" ></div>
                            <div class="col-md-2">
                                <input type="button" value="-" class="sub" />
                                <!--默认是一个-->
                                <input value="1" class="num" style="width: 100px;"/>
                                <input type="button" value="+" class="add" />
                            </div>
                            <!--小计默认是单价-->
                            <div class="col-md-1 sSum"></div>
                            <div class="col-md-2">
                                <a href="javascript:">删除</a>
                            </div>
                        </div>
                    </div>
                    <div id="cartFoot">
                        <div class="row">
                            <div class="col-md-1">
                                <a href="javascript:">批量删除</a>
                            </div>
                            <div class="col-md-7"></div>
                            <div class="col-md-2">总价</div>
                            <div class="col-md-2"><span id="sum"></span></div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-right">
                                <input type="submit"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- end about section -->

<%@include file="myFoot.jsp" %>


<!-- jQery -->
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/cart.js" type="text/javascript" />
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>

</body>

</html>
