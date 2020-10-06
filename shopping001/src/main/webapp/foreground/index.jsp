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
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Site Metas -->
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="icon" href="images/favicon.png" type="image/gif"/>

    <title>首页</title>

    <!-- bootstrap core css -->
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>

    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet"/>

    <!-- lightbox Gallery-->
    <link rel="stylesheet" href="css/ekko-lightbox.css"/>

    <!-- font awesome style -->
    <link href="css/font-awesome.min.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet"/>
    <!-- responsive style -->
    <link href="css/responsive.css" rel="stylesheet"/>

    <style type="text/css">
        .detail-box {
            height: 400px;
        }

    </style>

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
                            360度全景摄像头
                            家用卡片机
                            智能猫眼
                            枪机监控
                            半球监控

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
                        <img src="images/kongtiao.png" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            空调
                        </h5>
                        <p>
                            独立除湿
                            自动清洁
                            智能空调
                            圆柱式空调
                            易拆洗
                            静音空调
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
                        <img src="images/chuang.png" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            床
                        </h5>
                        <p>
                            现代中式
                            美式轻奢
                            简美
                            欧式
                            美式乡村
                            新中式
                            后现代
                            现代简约
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
                        <img src="images/zaojiao.png" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            早教启智
                        </h5>
                        <p>
                            塑料
                            仿生
                            婴儿
                            学龄前儿童
                            学龄后儿童
                            进口
                            国产
                            其它
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
                        <img src="images/chaji.png" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            边桌/茶几
                        </h5>
                        <p>
                            美式轻奢
                            欧式
                            后现代
                            现代简约
                            意式
                            复古怀旧
                            低调简约
                            其他
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
                        <img src="images/shafa.png" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            沙发
                        </h5>
                        <p>
                            美式轻奢
                            简美
                            欧式
                            美式乡村
                            新中式
                            后现代
                            现代简约
                            东南亚
                            意式
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
                    <img src="images/login.jpg" alt="">
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
                        智能家居（smart home, home automation）是以住宅为平台，利用综合布线技术、网络通信技术、 安全防范技术、自动控制技术、音视频技术将家居生活有关的设施集成，构建高效的住宅设施与家庭日程事务的管理系统，提升家居安全性、便利性、舒适性、艺术性，并实现环保节能的居住环境。
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
                                    <img src="images/client.jpg" alt=""/>
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
                                    <img src="images/client.jpg" alt=""/>
                                </div>
                                <div class="detail-box">
                                    <div class="name">
                                        <h6>
                                            Siaalya
                                        </h6>
                                    </div>
                                    <p style="width: 1200px">
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
                                    <img src="images/client.jpg" alt=""/>
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
                            <input type="text" placeholder="请输入您的姓名"/>
                        </div>
                        <div>
                            <input type="text" placeholder="请输入您的手机号码"/>
                        </div>
                        <div>
                            <input type="email" placeholder="请输入您的邮箱"/>
                        </div>
                        <div>
                            <input type="text" class="message-box" placeholder="留言"/>
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


</body>

</html>
