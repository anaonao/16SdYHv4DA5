<%--
  Created by IntelliJ IDEA.
  User: 安
  Date: 2020/10/8
  Time: 15:08
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
    <link rel="icon" href="<%=request.getContextPath()%>/foreground/images/favicon.png" type="image/gif"/>

    <title>购物车</title>

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

    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/foreground/css/card.css"/>

</head>

<body>

<%@include file="myNav.jsp"%>


<!-- about section -->

<section class="about_section layout_padding ">
    <div class="container">
        <!--购物车-->
        <!-- 结算主体页面 -->
        <div class="accounts-main">
            <div class="row">
                <div class="col-lg-1">

                </div>
                <div class="col-lg-10">
                    <!-- 购物结算流程 -->
                    <ul class="accounts-main1">
                        <li>
                            <div class="accounts-main1-1">
                                1
                            </div>
                            <strong>
									<span>
										查看购物车
									</span>
                            </strong>

                        </li>
                        <li>
                            <div class="accounts-main1-2">
                                2
                            </div>
                            <span>
									拍下商品
								</span>
                        </li>
                        <li>
                            <div class="accounts-main1-3">
                                3
                            </div>
                            <span>
									付款到支付宝
								</span>
                        </li>
                        <li>
                            <div class="accounts-main1-4">
                                4
                            </div>
                            <span>
									确认收货
								</span>
                        </li>
                        <li>
                            <div class="accounts-main1-5">
                                5
                            </div>
                            <span>
									评价
								</span>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-1">

                </div>
            </div>
            <!-- 选择收货地址 -->
            <div class="address">
                <div class="row">
                    <div class="col-md-3">
                        <div class="address-1">
                            <p>天津(yanan)</p>
                            <hr />
                            <p>滨海新区第七大街81号</p>
                            <a href="javascript:">修改</a>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="address-2">
                            <p>吉林省(yanan)</p>
                            <hr />
                            <p>四平市梨树县</p>
                            <a href="javascript:">修改</a>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="address-3">
                            <p>天津(yanan)</p>
                            <hr />
                            <p>滨海新区第七大街81号</p>
                            <a href="javascript:">修改</a>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="address2">
                <div class="row">
                    <div class="col-md-6">
							<span>
								<a href="javascript:">显示全部地址</a>
							</span>
                    </div>
                    <div class="col-md-6">
							<span class="address2-2">
								<a href="javascript:">管理收货地址</a>
							</span>
                    </div>
                </div>
            </div>
            <!-- 代收服务 -->
            <div class="ds">
                <div>
                    菜鸟驿站代收服务
                    <div class="row">
                        <div class="col-md-12">
                            <input type="checkbox" name="ds" id="ds" />
                            [菜鸟驿站]天津 天津市 滨海新区 开发区联发第五街盛和园18号楼103室(电话:17627883177)（闫安收）15134424004
                            <P><a href="javascript:">修改</a></P>
                        </div>
                    </div>
                </div>

            </div>
            <!-- 确认订单信息 -->
            <div class="order-fprm">
                <strong><h5>确认订单信息</h5></strong>
                <table class="table">
                    <tr>
                        <td>店铺宝贝</td>
                        <td>商品属性</td>
                        <td>单价</td>
                        <td>数量</td>
                        <td>优惠方式</td>
                        <td>小计</td>
                    </tr>
                    <tr>&nbsp;
                        <td><img src="img/main4-2.png" >&nbsp;&nbsp;<span>商品描述（）</span></td>
                        <td>商品属性描述（）</td>
                        <td>50</td>
                        <td>23</td>
                        <td>省39.90:爆款特卖</td>
                        <td>10.10</td>
                    </tr>
                    <tr>
                        <td colspan="6" class="sum">
                            <div>
                                <span>店铺合计(含运费)￥</span><span>49.90</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="sum">
                            <div>
                                <span>实付款：￥</span><span>49.90</span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="sum">
                            <div>
                                <span class="glyphicon glyphicon-hand-left"></span><span><a href="购物车.html">返回购物车</a></span>
                                &nbsp;
                                &nbsp;
                                &nbsp;
                                <button type="button" class="btn btn-danger">提交订单</button>
                            </div>
                        </td>
                    </tr>

                </table>
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
</body>
</html>
