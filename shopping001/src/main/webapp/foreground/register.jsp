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
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Site Metas -->
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="icon" href="images/favicon.png" type="image/gif"/>

    <title>注册</title>

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
        .form-group div{
            color: yellow;
        }

    </style>

</head>

<body>

<%@include file="myNav.jsp" %>


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
                <form id="formregister" action="<%=request.getContextPath()%>/UserServlet?op=register" method="post">
                    <h1>
                        凯瑞智能家居<br>
                        工作室
                    </h1>
                    <p>
                        凯瑞智能家居商城欢迎您的加入~
                    </p>
                    <div class="col-lg-8 mx-auto">
                        <div class="form-group">
                            用户名：<input class="form-control" id="userName" name="userName">
                            <div></div>
                        </div>
                        <div class="form-group">
                            手机号：<input class="form-control" id="userPhone" name="userPhone">
                            <div></div>
                        </div>
                        <div class="form-group">
                            密码(只能输入6-20个字母、数字、下划线)：<input type="password" class="form-control" id="userPwd" name="userPwd">
                            <div></div>
                        </div>
                        <div class="form-group">
                            确认密码：<input type="password" class="form-control" id="userPwd2" name="userPwd">
                            <div></div>
                        </div>
                        <div>
                            <button type="submit" class="slider-link" style="margin-bottom: 40px">注册</button>
                        </div>
                        <a href="login.jsp" class="btn btn-default" style="color: white ;">已有账号？登录</a><br>
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

<script>

    $(function () {
        //手机号验证
        function phoneTest(phone) {
            return /^1[3456789]\d{9}$/.test(phone);
        }

        //	alert(phoneTest(13483327279));

        //密码验证(只能输入6-20个字母、数字、下划线)
        function passwordTest(password1) {
            return /^(\w){6,20}$/.test(password1);
        }

        //	alert(passwordTest(123456));

        //最后提交的时候用于做判断的变量
        var phoneflag;
        var pass1flag;
        var pass2flag;
        var flag = false;
        //利用失去焦点事件动态获取和验证信息的准确性

        $("#userName").blur(function () {
            //获取
            var phone = $("#userName").val();

            //判断名字是否重复
            if (phone != "") {
                //判断格式
                var phoneFlag = phoneTest(phone);
                phoneflag = phoneFlag;
                if (phoneFlag == false) {
                    alert(phone)
                    //alert(phoneFlag)
                    $("#userPhone").next().show();
                    $("#userPhone").next().text("手机号码有误，请重填");
                } else {
                    $("#userPhone").next().hide();
                }
            } else {
                $("#userPhone").next().show();
                $("#userPhone").next().text("手机号码不能为空，请重填");
            }
        });


        $("#userPhone").blur(function () {
            //获取
            var phone = $("#userPhone").val();
            //判空
            if (phone != "") {
                //判断格式
                var phoneFlag = phoneTest(phone);
                phoneflag = phoneFlag;
                if (phoneFlag == false) {
                    alert(phone)
                    //alert(phoneFlag)
                    $("#userPhone").next().show();
                    $("#userPhone").next().text("手机号码有误，请重填");
                } else {
                    $("#userPhone").next().hide();
                }
            } else {
                $("#userPhone").next().show();
                $("#userPhone").next().text("手机号码不能为空，请重填");
            }
        });
        $("#userPwd").blur(function () {
            //获取
            var password1 = $("#userPwd").val();
            //判空
            if (password1 != "") {
                //判断格式
                var passFlag = passwordTest(password1);
                pass1flag = passFlag;
                if (passFlag == false) {
                    this.next().show();
                    $("#userPwd").next().text("密码有误，请重填");
                } else {
                    $("#userPwd").next().hide();
                }
            } else {
                $("#userPwd").next().show();
                $("#userPwd").next().text("密码不能为空，请重填");
            }
        })
        $("#userPwd2").blur(function () {
            //获取
            var password2 = $("#password2").val();
            //判空
            if (password2 != "") {
                //判断格式
                var password1 = $("#userPwd").val();
                var pass2Flag = (password2 == password1);
                //alert(pass2Flag)
                pass2flag = pass2Flag;
                if (password2 != password1) {
                    $("#userPwd2").next().show();
                    $("#userPwd2").next().text("密码不一致，请重填");
                } else {
                    $("#userPwd2").next().hide();
                }
            } else {
                $("#userPwd2").next().show();
                $("#userPwd2").next().text("密码不能为空，请重填");
            }
        })
        //返回submit函数的结果值
        $("#formregister").submit(function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/UserServlet?op=register",
                type: "post",
                data: {
                    "userName": $("#userName").val(),
                    "userPwd": $("#userPwd").val(),
                    "userPhone": $("#userPhone").val()
                },
                success: function (data) {
                    alert("恭喜您" + data);
                    if ("添加成功" == data) {
                        location.href = "<%=request.getContextPath()%>/foreground/login.jsp";
                    }
                }
            })
            return false;
        })
    })
</script>


</body>

</html>




