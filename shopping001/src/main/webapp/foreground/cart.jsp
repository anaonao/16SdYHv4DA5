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
    <link rel="icon" href="<%=request.getContextPath()%>/foreground/images/favicon.png" type="image/gif" />

    <title>购物车</title>

    <!-- bootstrap core css -->
    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
    <!-- fonts style -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700&display=swap" rel="stylesheet" />

    <!-- font awesome style -->
    <link href="<%=request.getContextPath()%>/foreground/css/font-awesome.min.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath()%>/foreground/css/style.css" rel="stylesheet" />
    <!-- responsive style -->
    <link href="<%=request.getContextPath()%>/foreground/css/responsive.css" rel="stylesheet" />

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/foreground/css/card.css"/>

</head>

<body>

<%@include file="myNav.jsp"%>


<!-- about section -->

<section class="about_section layout_padding ">
    <div class="container">
        <!--购物车-->

        <div class="card-head">
            <div class="row">
                <div class="col-xs-1 col-md-1">
                    <input type="checkbox" id="ckAll" class="ckAll" />全选
                </div>
                <div class="col-xs-3 col-md-3">
                    商品
                </div>
                <div class="col-xs-2 col-md-2">
                    属性
                </div>

                <div class="col-xs-1 col-md-1">
                    单价(元)
                </div>
                <div class="col-xs-3 col-md-3">
                    数量
                </div>
                <div class="col-xs-1 col-md-1">
                    小计(元)
                </div>
                <div class="col-xs-1 col-md-1">
                    操作
                </div>
            </div>
        </div>

        <!-- start card-main -->
        <div class="card-main" id="commisnull">
            <div class="row card-main-1 hidden">
                <div class="col-xs-12 col-md-12" style="text-align: center;">
                    购物车还没有选购商品，快去选购吧！！！
                </div>
            </div>
        </div>
        <!-- start card-main -->
        <div id="selectCart">

        </div>
            <%--<div class="card-main" style="margin-top: 20px;">
                <div class="row card-main-1">
                    <div class="col-md-1">
                        <input type="checkbox" name="ck" class="ck"/>
                    </div>
                    <div class="col-md-3">
                        <div class="row">
                            <div class="col-md-4">
                                <img src="#" />
                            </div>
                            <div class="col-md-8">
                                文字描述
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2">
                        颜色分类（）机型（）
                    </div>

                    <div class="col-md-1 price">
                    <span class="aa">3999</span>
                </div>
                <div class="col-xs-3 col-md-3 aaa">
                    <input type="button"  class="bt1 btn" value="-"/>
                    <input type="text" value="1" min="0" class="txt"/>
                    <input type="button" value="+" class="bt2 btn"/>
                </div>
                <div class="col-md-1 xj">
                    3999
                </div>
                <div class="col-md-1">
                    <a href="javascript:" class="outcomm">移出商品</a>
                </div>
            </div>--%>

        <!-- start bottom -->
        <div class="bottom">
            <div class="row">
                <div class="col-md-4">
                    <ul class="bottom-1">
                        <li><input type="checkbox" id="ckAll" class="ckAll"/>全选</li>
                        <li><a href="javascript:" class="delAll">批量删除</a></li>
                        <li><a href="javascript:">批量收藏</a></li>
                    </ul>
                </div>
                <div class="col-md-8" >
                    <ul class="bottom-2">
                        <li><span>已选商品</span><span style="color: red;" class="sum">0</span><span>件</span></li>
                        <li><span  style="color:#666666;">已省：</span><span>-￥0元</span></li>
                        <li><span  style="color:#666666;">总价(不含运费)：￥</span><span style="color: red;font-size: 20px;" class="zj">0</span>（元）</li>
                    </ul>
                    <div style="width: 80px;height:35px;background-color: red;line-height: 40px;text-align: center;color: #FFFFFF;position: absolute;margin-left: 682px;margin-top: -10px;"><a href="javascript:shoppingJS()" style="color: #FFFFFF;">去结算</a></div>
                </div>
            </div>
        </div>
        <!-- end bottom -->
    </div>
</section>

<!-- end about section -->

<%@include file="myFoot.jsp" %>


<!-- jQery -->
<script src="<%=request.getContextPath()%>/asserts/js/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
<!-- custom js -->
<script src="<%=request.getContextPath()%>/foreground/js/custom.js" charset="utf-8"></script>
<!-- bootstrap js -->
<script src="<%=request.getContextPath()%>/foreground/js/bootstrap.js"></script>

<script>
    $(function() {
        /*页面初始化加载用户购物车数据*/
        $.ajax({
            url:"<%=request.getContextPath()%>/CartSrvlet?op=findAll",
            type:"post",
            data:{
            },
            success:function (data) {
                console.log(data.data)

                /*动态数据展示*/
                $.each(data.data,function (i,item) {
                    $("#selectCart").append("<div class=\"card-main\" style=\"margin-top: 20px;\">\n" +
                        "                <div class=\"row card-main-1\">\n" +
                        "                    <div class=\"col-md-1\">\n" +
                        "                        <input type=\"checkbox\" name=\"ck\" class=\"ck\"/>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-md-3\">\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-md-4\">\n" +
                        "                                <img src=\"#\" />\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-md-8\">\n" +
                        "                                "+item.product.productDiscraction+"\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </div>\n" +
                        "                    <div class=\"col-md-2\">\n" +
                        "                        颜色分类（）机型（）\n" +
                        "                    </div>\n" +
                        "\n" +
                        "                    <div class=\"col-md-1 price\">\n" +
                        "                    <span class=\"aa\">3999</span>\n" +
                        "                </div>\n" +
                        "                <div class=\"col-xs-3 col-md-3 aaa\">\n" +
                        "                    <input type=\"button\"  class=\"bt1 btn\" value=\"-\"/>\n" +
                        "                    <input type=\"text\" value=\"1\" min=\"0\" class=\"txt\"/>\n" +
                        "                    <input type=\"button\" value=\"+\" class=\"bt2 btn\"/>\n" +
                        "                </div>\n" +
                        "                <div class=\"col-md-1 xj\">\n" +
                        "                    3999\n" +
                        "                </div>\n" +
                        "                <div class=\"col-md-1\">\n" +
                        "                    <a href=\"javascript:\" class=\"outcomm\">移出商品</a>\n" +
                        "                </div>\n" +
                        "            </div>")
                })

                /*数据end*/

            },
            dataType:"json"
        })

        //全选功能
        $(".ckAll").click(function() {
            //获取复选框状态
            var ckAll = $(this).prop("checked");
            // alert(ckAll)
            // 调整所有复选框状态
            $(".ck").prop("checked", ckAll)
            zj();
            zjj();
        })
        //商品是否全选调整
        $(".ck").click(function() {
            var flag = true;
            $(".ck").each(function() {
                if ($(this).prop("checked") == false) {
                    flag = false;
                }
            })
            $(".ckAll").prop("checked", flag);
            zj();
            zjj();
        })

        //购物车加减
        $(".bt1").click(function() {
            var jian = $(this).next().val();
            // alert(jian)
            if (jian > 1) {
                jian--;
            }
            $(this).next().val(jian);

            //价格
            var price = $(this).parent().prev().text();
            //小计
            $(this).parent().next().text(price * jian);
            zj();
            zjj();
        })

        //购物车加减
        $(".bt2").click(function() {
            var jia = $(this).prev().val();
            // alert(jian)
            jia++;
            $(this).prev().val(jia);

            //价格
            var price = $(this).parent().prev().text();
            //小计
            $(this).parent().next().text(price * jia);
            zj();
            zjj();
        })

        //删除单个商品
        $(".outcomm").click(function() {
            if (confirm("是否移除当前选中商品???")) {
                $(this).parents(".card-main").remove();
                commisnull();
            }
            zj();
            zjj();
        })
        //判断商品是否为空
        function commisnull() {
            if ($(".card-main").length == 1) {
                $("#commisnull .card-main-1").removeClass("hidden");
            }
        }
        //批量删除
        $(".delAll").click(function() {
            if (confirm("是否移除当前选中商品???")) {
                $(".ck").each(function() {
                    if ($(this).prop("checked")) {
                        $(this).parents(".card-main").remove();
                        commisnull();
                    }
                })
            }
            zj();
            zjj();
        })
        //页面加载就判断当前商品是否为空
        commisnull();
        xj();
        //单价
        function xj(){
            $(".price").each(function(){
                // $("xj").text()
                var price = ($(this).parents(".card-main-1").children(".price").text())
                var num =($(this).parents(".card-main-1").children(".aaa").children(".txt").val())
                $(this).parents(".card-main-1").children(".xj").text(price*num)
            })
        }


        //总计
        function zj(){
            var sum=0;
            $(".ck").each(function(){
                if($(this).prop("checked")){
                    var p =$(this).parents(".card-main-1").children(".xj").text();
                    sum+=parseInt(p);
                }
            })
            $(".zj").text(sum);
        }

        //件数
        function zjj(){
            var sum=0;
            $(".ck").each(function(){
                if($(this).prop("checked")){
                    var p =($(this).parents(".card-main-1").children(".aaa").children(".txt").val())
                    sum+=parseInt(p);
                }
            })
            $(".sum").text(sum);
        }
    })

</script>


</body>

</html>
