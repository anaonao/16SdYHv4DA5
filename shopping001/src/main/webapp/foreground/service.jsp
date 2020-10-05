<%--
  Created by IntelliJ IDEA.
  User: wkx
  Date: 2020/10/5
  Time: 14:52
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

    <title>商品分类</title>

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
                    <div id="myNav" class="overlay">
                        <div class="overlay-content">
                            <a href="index.html">Home</a>
                            <a href="about.html">About</a>
                            <a href="gallery.html">Gallery</a>
                            <a href="service.html">Service</a>
                            <a href="blog.html">Blog</a>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</header>
<!-- end header section -->

<!-- service section -->

<section class="service_section layout_padding">
    <div class="container">
        <div class="heading_container heading_center">
            <h2>
                Services
            </h2>
        </div>
        <div class="row">
            <div class="col-md-6 col-lg-4 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s1.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            Residential Decoration
                        </h5>
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque distinctio aspernatur officiis exercitationem asperiores praesentium
                        </p>
                        <a href="">
                            Read More
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s2.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            Ecommercial Decoration
                        </h5>
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque distinctio aspernatur officiis exercitationem asperiores praesentium
                        </p>
                        <a href="">
                            Read More
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 mx-auto">
                <div class="box">
                    <div class="img-box">
                        <img src="images/s3.jpg" alt="">
                    </div>
                    <div class="detail-box">
                        <h5>
                            Office Decoration
                        </h5>
                        <p>
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque distinctio aspernatur officiis exercitationem asperiores praesentium
                        </p>
                        <a href="">
                            Read More
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</section>

<!-- end service section -->

<!-- info section -->
<section class="info_section innerpage_info_section">
    <div class="container">
        <div class="row info_main_row">
            <div class="col-md-6 col-lg-3">
                <div class="info_insta">
                    <h4>
                        <a href="index.html" class="navbar-brand m-0 p-0">
                <span>
                  Shapel
                </span>
                        </a>
                    </h4>
                    <p class="mb-0">
                        Asperiores at, error, delectus aut voluptatem provident cum quam magni necessitatibus molestias eveniet reprehenderit maiores voluptate.
                    </p>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <div class="info_detail">
                    <h4>
                        Company
                    </h4>
                    <p class="mb-0">
                        when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to
                    </p>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <h4>
                    Contact Us
                </h4>
                <div class="info_contact">
                    <a href="">
                        <i class="fa fa-map-marker" aria-hidden="true"></i>
                        <span>
                Location
              </span>
                    </a>
                    <a href="">
                        <i class="fa fa-phone" aria-hidden="true"></i>
                        <span>
                Call +01 1234567890
              </span>
                    </a>
                    <a href="">
                        <i class="fa fa-envelope"></i>
                        <span>
                demo@gmail.com
              </span>
                    </a>
                </div>
            </div>
            <div class="col-md-6 col-lg-3">
                <h4>
                    Follow Us
                </h4>
                <div class="social_box">
                    <a href="">
                        <i class="fa fa-facebook" aria-hidden="true"></i>
                    </a>
                    <a href="">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                    <a href="">
                        <i class="fa fa-linkedin" aria-hidden="true"></i>
                    </a>
                    <a href="">
                        <i class="fa fa-instagram" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- end info_section -->


<!-- footer section -->
<footer class="footer_section">
    <div class="container">
        <p>
            Copyright &copy; 2020.Company name All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a>
        </p>
    </div>
</footer>
<!-- footer section -->


<!-- jQery -->
<script src="js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="js/bootstrap.js"></script>
<!-- custom js -->
<script src="js/custom.js"></script>

</body>

</html>
