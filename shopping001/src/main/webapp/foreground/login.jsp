<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <title>首页</title>

    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

    <!-- lightbox Gallery-->
    <link rel="stylesheet" href="css/ekko-lightbox.css" />

    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet" />

</head>

<body>

<%@include file="myNav.jsp"%>

<!-- 轮播图-->
<section class="slider_section position-relative">
    <div id="customCarousel1" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="img_container">
                    <div class="img-box">
                        <img src="images/timg.jpg" class="" alt="...">
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="img_container">
                    <div class="img-box">
                        <img src="images/slider-bg.jpg" class="" alt="...">
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <div class="img_container">
                    <div class="img-box">
                        <img src="images/slider-bg.jpg" class="" alt="...">
                    </div>
                </div>
            </div>
        </div>
        <div class="carousel_btn_box">
            <a class="carousel-control-prev" href="#customCarousel1" role="button" data-slide="prev">
                <i class="fa fa-arrow-left" aria-hidden="true"></i>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#customCarousel1" role="button" data-slide="next">
                <i class="fa fa-arrow-right" aria-hidden="true"></i>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="detail-box">
        <div class="col-md-8 col-lg-6 mx-auto">
            <div class="inner_detail-box">
                <form>
                    <h1>
                        凯瑞智能家居<br>
                        工作室
                    </h1>
                    <p>
                        凯瑞智能家居商城欢迎您的到来~
                    </p>
                    <div class="col-lg-4 mx-auto" >
                        <div class="form-group">
                            <input type="email" class="form-control" id="exampleInputEmail1" placeholder="请输入您的账号">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入您的密码">
                        </div>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox"> 记住我
                            </label>
                        </div>
                        <div>
                            <button type="submit" class="slider-link" style="margin-bottom: 40px">登录</button>
                        </div>
                        <a href="register.jsp" class="btn btn-default" style="color: white">还没有账号？注册</a><br>
                        <a href="index.jsp" class="btn btn-default" style="color: white">暂不登录</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<!-- jQery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>
<!-- lightbox Gallery-->
<script src="js/ekko-lightbox.min.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>

</body>

</html>




