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

    <title>个人信息</title>

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
        #child img {
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

                    <button data-toggle="modal" data-target="#myModal2">
                        <img src="<%=request.getContextPath()%>/foreground/images/${user.userImg }"
                             alt="" style="width: 200px; height: 200px"><br>
                        <span style="color:#454545 ">点击头像进行修改</span>
                    </button>
                    <!-- Button trigger modal -->


                    <!-- Modal -->
                    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel2">个人信息修改</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>

                                </div>
                                <form id="formModify" method="post"
                                      enctype="multipart/form-data">
                                    <div class="modal-body">
                                        头像修改：<input type="file" id="userImg" name="userImg" value="${user.userImg}"><br>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                                        <input type="submit" style="background: #EFEFEF; border: 0; color: #0b2e13"
                                               value="确认修改"></input>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="col-md-6">
                <div class="detail-box" >
                    <div id="info">
                        <P>
                        <div class="heading_container">
                            用户名：${user.userName}
                        </div>
                        手机号：${user.userIphone}
                        <br>
                        </P>
                    </div>


                    <button data-toggle="modal" data-target="#myModal">
                        <a style="background: #EFEFEF; border: 0; color: #0b2e13">修改信息</a>
                    </button>
                    <button data-toggle="modal" data-target="#myModalPwd">
                        <a style="background: #EFEFEF; border: 0; color: #0b2e13">修改密码</a>
                    </button>
                    <!-- Button trigger modal -->


                    <!-- Modal -->
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel">个人信息修改</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>

                                </div>
                                <form action="<%=request.getContextPath()%>/UserServlet?op=updateUser" method="post"
                                      enctype="multipart/form-data" id="formModify2">
                                    <div class="modal-body">
                                        用户名修改：<input type="text" id="userName" name="userName"
                                                     value="${userName}"><br><br>
                                        手机号修改：<input type="text" id="userPhone" name="userPhone"
                                                     value="${user.userIphone}"><br><br>
                                        密码修改：<input type="password" id="userPwd" name="userPwd" value="${user.userPwd}"><br><br>
                                        <%--                                        头像修改：<input type="file" id="userImg" name="userImg" value="${user.userImg}"><br>--%>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                                        <input type="button" id="but1" style="background: #EFEFEF; border: 0; color: #0b2e13"
                                               value="确认修改"></input>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <%--密码--%>
                    <!-- Modal -->
                    <div class="modal fade" id="myModalPwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel3">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title" id="myModalLabel3">修改密码</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>

                                </div>
                                <form>
                                    <div class="modal-body">
                                        密码修改：<input type="password" id="UpdateuserPwd" name="UpdateuserPwd" value=""><br><br>
                                        重复密码：<input type="password" id="UpdateuserPwd2" name="UpdateuserPwd2" value=""><br><br>
                                      <span id="pwdspan" style="color: red"></span>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消修改</button>
                                        <input type="button" id="but2" style="background: #EFEFEF; border: 0; color: #0b2e13"
                                               value="确认修改"></input>
                                    </div>
                                </form>
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
<script src="<%=request.getContextPath()%>/foreground/js/jquery-3.4.1.min.js"></script>
<!-- bootstrap js -->
<script src="<%=request.getContextPath()%>/foreground/js/bootstrap.js"></script>
<!-- custom js -->
<script src="<%=request.getContextPath()%>/foreground/js/custom.js"></script>
</body>

<script>
    $(function () {
        $("#but1").click(function () {
            $.ajax({
                url: "<%=request.getContextPath()%>/UserServlet?op=updateUser",
                type: "post",
                data: {
                    "userName": $("#userName").val(),
                    "userPhone": $("#userPhone").val()
                },
                success: function (data) {
                    if(data=="1"){
                        alert("修改成功！")
                    }else if(data=="0"){
                        alert("修改失败！！！")
                    }
                }

            })
        })


        /*判断文本框中俩个值是否一致*/
        $("#UpdateuserPwd").blur(function(){
            if($("#UpdateuserPwd").val()!=$("#UpdateuserPwd2").val()){
               $("#pwdspan").html("俩次密码不一致请重新输入");
            }else {
                $("#pwdspan").html("");
            }
        })
        /*判断文本框中俩个值是否一致*/
        $("#UpdateuserPwd2").blur(function(){
            if($("#UpdateuserPwd").val()!=$("#UpdateuserPwd2").val()){
                $("#pwdspan").html("俩次密码不一致请重新输入");
            }else {
                $("#pwdspan").html("");
            }
        })
        /*修改密码绑定*/
        $("#but2").click(function () {
            if($("#UpdateuserPwd").val()!=$("#UpdateuserPwd2").val()){
                alert("俩次密码输入不一致,请重新输入！！！")
            }else {
                $.ajax({
                    url: "<%=request.getContextPath()%>/UserServlet?op=updateUserPwd",
                    type: "post",
                    data: {
                        "userPwd": $("#UpdateuserPwd").val()
                    },
                    success: function (data) {
                        if(data=="1"){
                            alert("修改成功！")
                        }else if(data=="0"){
                            alert("修改失败！！！")
                        }
                    }

                })
            }

        })

    })
</script>
</html>
