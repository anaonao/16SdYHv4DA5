<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 14:45
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

<!-- header section strats -->
<header class="header_section">
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
                    <%@include file="myNav.jsp" %>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- end header section -->

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
                <h1>
                    凯瑞智能家居<br>
                    工作室
                </h1>
                <p>
                    凯瑞智能家居商城欢迎您的到来~
                </p>
                <div>
                    <a href="login.jsp" class="slider-link">
                       登录
                    </a>
                </div>
                <div>
                    <a href="register.jsp" class="slider-link">
                        注册
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end slider section -->

<%--商品分类--%>
<section class="service_section layout_padding">
    <div class="container">
        <div class="heading_container heading_center">
            <h2>
                商品分类
            </h2>
        </div>
        <div class="row">
            <div class="col-md-6 col-lg-2 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/1-1.png" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            监控摄像
                        </h5>
                        <p>
                            监控摄像
                        </p>
                        <a href="">
                            了解更多
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-2 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s2.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            空调
                        </h5>
                        <p>
                            空调
                        </p>
                        <a href="">
                            了解更多
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-2 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s3.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            床
                        </h5>
                        <p>
                            床
                        </p>
                        <a href="">
                            了解更多
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-2 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s3.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            早教启智
                        </h5>
                        <p>
                            床
                        </p>
                        <a href="">
                            了解更多
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-2 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s3.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            边桌/茶几
                        </h5>
                        <p>
                            床
                        </p>
                        <a href="">
                            了解更多
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-2 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s3.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            沙发
                        </h5>
                        <p>
                            床
                        </p>
                        <a href="">
                            了解更多
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>

<!-- end service section -->

<!-- gallery section -->

<div class="gallery_section layout_padding2">
    <div class="container-fluid">
        <div class="heading_container heading_center">
            <h2>
                热销商品
            </h2>
        </div>
        <div class="row">
            <div class=" col-sm-8 col-md-6 px-0">
                <div class="img-box">
                    <img src="images/g1.jpg" alt="">
                    <a href="images/g1.jpg" data-toggle="lightbox" data-gallery="gallery">
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="col-sm-4 col-md-3 px-0">
                <div class="img-box">
                    <img src="images/g2.jpg" alt="">
                    <a href="images/g2.jpg" data-toggle="lightbox" data-gallery="gallery">
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="col-sm-6 col-md-3 px-0">
                <div class="img-box">
                    <img src="images/g3.jpg" alt="">
                    <a href="images/g3.jpg" data-toggle="lightbox" data-gallery="gallery">
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="col-sm-6 col-md-3 px-0">
                <div class="img-box">
                    <img src="images/g4.jpg" alt="">
                    <a href="images/g4.jpg" data-toggle="lightbox" data-gallery="gallery">
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="col-sm-4 col-md-3 px-0">
                <div class="img-box">
                    <img src="images/g5.jpg" alt="">
                    <a href="images/g5.jpg" data-toggle="lightbox" data-gallery="gallery">
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <div class="col-sm-8 col-md-6 px-0">
                <div class="img-box">
                    <img src="images/g6.jpg" alt="">
                    <a href="images/g6.jpg" data-toggle="lightbox" data-gallery="gallery">
                        <i class="fa fa-picture-o" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="btn-box">
            <a href="">
                查看所有
            </a>
        </div>
    </div>
</div>

<!-- end gallery section -->


<!-- about section -->

<section class="about_section layout_padding ">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="img-box">
                    <img src="images/about-img.jpg" alt="">
                </div>
            </div>
            <div class="col-md-6">
                <div class="detail-box">
                    <div class="heading_container">
                        <h2>
                            关于我们
                        </h2>
                    </div>
                    <p>
                        凯瑞智能家居致力于向广大消费者提供可靠、便捷的智能家居通道。
                    </p>
                    <a href="">
                        了解更多
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- end about section -->


<!-- client section -->

<section class="client_section layout_padding">
    <div class="container">
        <div class="heading_container">
            <h2>
                留言
            </h2>
        </div>
        <div id="carouselExample2Controls" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="row">
                        <div class="col-md-11 col-lg-10 mx-auto">
                            <div class="box">
                                <div class="img-box">
                                    <img src="images/client.jpg" alt="" />
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <h6>
                                            Siaalya
                                        </h6>
                                    </div>
                                    <p style="width: 1200px">
                                        特别好
                                    </p>
                                    <i class="fa fa-quote-left" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-11 col-lg-10 mx-auto">
                            <div class="box">
                                <div class="img-box">
                                    <img src="images/client.jpg" alt="" />
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <h6>
                                            Siaalya
                                        </h6>
                                    </div>
                                    <p>
                                        大没离开过
                                    </p>
                                    <i class="fa fa-quote-left" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="row">
                        <div class="col-md-11 col-lg-10 mx-auto">
                            <div class="box">
                                <div class="img-box">
                                    <img src="images/client.jpg" alt="" />
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <h6>
                                            用户名
                                        </h6>
                                    </div>
                                    <p>
                                        留言
                                    </p>
                                    <i class="fa fa-quote-left" aria-hidden="true"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel_btn-container">
                <a class="carousel-control-prev" href="#carouselExample2Controls" role="button" data-slide="prev">
                    <i class="fa fa-long-arrow-left" aria-hidden="true"></i>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExample2Controls" role="button" data-slide="next">
                    <i class="fa fa-long-arrow-right" aria-hidden="true"></i>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</section>

<!-- end client section -->

<!-- contact section -->
<section class="contact_section  ">
    <div class="container">
        <div class="row">
            <div class="col-md-7 col-lg-6 ">
                <div class="form_container">
                    <div class="heading_container ">
                        <h2>
                            联系我们
                        </h2>
                    </div>
                    <form action="">
                        <div>
                            <input type="text" placeholder="请输入您的姓名" />
                        </div>
                        <div>
                            <input type="text" placeholder="请输入您的手机号码" />
                        </div>
                        <div>
                            <input type="email" placeholder="请输入您的邮箱" />
                        </div>
                        <div>
                            <input type="text" class="message-box" placeholder="留言" />
                        </div>
                        <div class="btn_box">
                            <button>
                                发送
                            </button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-5 col-lg-6">
                <div class="subscribe-box">
                    <h3>
                        订阅我们的新闻
                    </h3>
                    <p>
                        欢迎订阅
                    </p>
                    <form action="">
                        <input type="email" placeholder="请输入您的邮箱">
                        <button>
                            订阅
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end contact section -->

<%@include file="myFoot.jsp" %>

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
