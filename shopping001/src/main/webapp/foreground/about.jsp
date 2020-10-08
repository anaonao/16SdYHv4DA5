<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Site Metas -->
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <link rel="icon" href="<%=request.getContextPath()%>/foreground/images/favicon.png" type="image/gif"/>

    <title>商品详情页</title>

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

    <style type="text/css">
        #child img{
            width: 126px;
            float: left;
            margin: 5px;
        }
    </style>
</head>

<body>

<%@include file="myNav.jsp" %>

<!-- about section -->



<section class="about_section layout_padding ">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <div class="img-box">
                    <img src="<%=request.getContextPath()%>/foreground/images/${product.list[0].productImgName }" alt="">
                    <div id="child">
                        <img src="<%=request.getContextPath()%>/foreground/images/${product.list[1].productImgName}" alt="">
                        <img src="<%=request.getContextPath()%>/foreground/images/${product.list[2].productImgName}" alt="">
                        <img src="<%=request.getContextPath()%>/foreground/images/${product.list[3].productImgName}" alt="">
                        <img src="<%=request.getContextPath()%>/foreground/images/${product.list[4].productImgName}" alt="">
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="detail-box">
                    <div class="heading_container">
                        <p>
                        <h2>
                            ${product.productName}
                        </h2>
                        </p>
                    </div>
                    <p>
                        <del>
                            原价：${product.productPrice}
                        </del>
                    </p>
                    <p>
                        现价
                    </p>
                    <p>
                        ${product.productDiscraction}
                    </p>
                    <a href="javascript:" id="isloginCart">
                        加入购物车
                    </a>
                    <a href="javascript:">
                        立即购买
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- end about section -->

<%@include file="myFoot.jsp" %>

<!-- jQery -->
<script src="<%=request.getContextPath()%>/foreground/js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="<%=request.getContextPath()%>/foreground/js/bootstrap.js"></script>
<!-- custom js -->
<script src="<%=request.getContextPath()%>/foreground/js/custom.js"></script>
<script>
    $(function () {
           //添加购物车
            $("#isloginCart").click(function () {
                console.log("购物车点击事件")
                //如果用户没有登录不能点击加入购物车
                if(${userName==nul}){
                    if(confirm("您还没有登录,是否现在登录???")){
                        console.log("跳转到登录陆")
                        location.href="<%=request.getContextPath()%>/foreground/login.jsp"
                    }
                }else {
                    //把当前数据加入购物车
                    console.log("加入购物车")
                    $.ajax({
                        url:"<%=request.getContextPath()%>/CartSrvlet?op=addCart",
                        type:"post",
                        data:{
                            "productId":${product.productId},
                            "userId":${userId}+""
                        },
                        success:function (data) {
                            console.log(data)
                            if(data=="1"){
                                alert("添加购物车成功")
                            }else if(data=="0"){
                                alert("添加购物车失败！！！")
                            }
                        }
                    })
                }
            })
    })
</script>
</body>

</html>
