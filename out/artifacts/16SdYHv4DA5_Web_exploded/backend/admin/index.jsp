<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>凯瑞智能家居后台管理系统</title>

    <link href="<%=request.getContextPath()%>/asserts/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

    <script src="<%=request.getContextPath()%>/asserts/js/jquery-1.12.4.js" type="text/javascript"></script>

    <script src="<%=request.getContextPath()%>/asserts/js/bootstrap.min.js" type="text/javascript"></script>

    <script type="text/javascript">
        $(function(){
            $(".main-ml>ul>li:odd").hide();

            $(".main-ml>ul>li:even").click(function(){
                $(this).next().slideToggle();
                if($(this).children("span").attr("class")=="glyphicon glyphicon-menu-right"){
                    $(this).children("span").attr("class","glyphicon glyphicon-menu-down")
                }else{
                    $(this).children("span").attr("class","glyphicon glyphicon-menu-right")
                }
            })
        })
    </script>
    <style type="text/css">
        .main-ml ul{
            list-style: none;
            color: #FFF;
        }
        .main-ml ul li{
            margin-top: 10px;
            position: relative;

        }
        .main-ml ul li:hover{
            cursor:pointer;
        }
    </style>

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" style="background-color: #000000;height: 60px; width: 100%;">
            <div class="col-md-6">
                <strong><label style="font-size:30px; line-height: 65px;color: #FFF;">凯瑞智能家居后台管理系统</label></strong>
            </div>
            <div class="col-md-6">
                <div style="position: absolute;right: 0;line-height: 50px">
                    <div style="color: #FFF;float: left;">当前访问量:${applicationScope.num}</div>
                    <c:if test="${adminname!=null}">
                        <div style="float: left;margin-left: 50px;color: #FFF">欢迎${adminname}&nbsp;<a style="color: #FFF" href="<%=request.getContextPath()%>/AdminServlet?op=removeLogin">注销</a></div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-2 main-ml" style="background-color:#262626 ;height: 600px;border-top: 2px solid #FFF;border-bottom: 2px solid #FFF;">
            <label style="font-size: 16px;color: #FFF;margin-top:20px;">凯瑞智能家居后台管理系统</label>
            <ul style="margin-top: 20px;">
                <li>
                    管理员管理
                    <span class="glyphicon glyphicon-menu-right" style="position:absolute ;right: 10px;top: 3px;"></span>
                </li>
                <li>
                    <ul>
                        <li><a href="<%=request.getContextPath()%>/AdminServlet?op=selectAll" target="frame">显示所有管理员信息</a></li>
                        <li><a href="<%=request.getContextPath()%>/backend/admin/admin/add.jsp" target="frame">添加管理员</a></li>
                    </ul>
                </li>
                <li>
                    商品管理
                    <span class="glyphicon glyphicon-menu-right" style="position:absolute ;right: 10px;top: 3px;"></span>
                </li>
                <li>
                    <ul>
                        <li><a href="javascript:" target="frame">显示所有商品</a></li>
                        <li><a href="javascript:" target="frame">添加商品</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <div class="col-md-10" style="height: 600px;">
            <iframe name="frame" src="<%=request.getContextPath()%>/backend/admin/indexCount.jsp" frameborder="0" height="100%" width="100%">

            </iframe>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12" style="background-color: #000000;height: 94px; width: 100%;">
            <div style="color: #FFF;text-align: center;margin-top: 10px;">
                <label>&copy;魏凯旋、闫安、王成良备案</label><br/>
                <label>联系方式：13677778888</label><br/>
                <label>凯瑞智能家居</label>
            </div>
        </div>
    </div>
</div>
</body>
</html>
