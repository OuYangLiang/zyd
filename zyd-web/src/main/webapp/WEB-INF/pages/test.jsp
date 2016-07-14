<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>登录</title>
<link rel="stylesheet" href="/resource/css/font-awesome.min.css" />
<link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resource/css/beyond.min.css" />
<link rel="stylesheet" href="/resource/css/public.css" />
<link rel="stylesheet" href="/resource/css/custom.css" />
</head>

<body>

    <div class="login-banner">
        <div class="login-con">
            <div class="row">
                <div class="col-xs-4">
                    <div class="register-container">
                        <div class="registerbox bg-white">
                            <div id="verifycode" <c:if test="${empty dynamicPwd}">style="display:none;"</c:if>>
                            <!--手机登录-->
                            <div class="registerbox-title">手机号码登录</div>
                            <form id='f2' >
                            <div class="registerbox-caption ">公共场所不建议自动登录，以防账号丢失</div>
                            <div class="registerbox-textbox">
                                <div class="form-group no-margin">
                                    <div class="input-group">
                                        <input type="text" name="username" class="form-control" placeholder="请输入手机号码">
                                              <span class="input-group-btn">
                                            <button class="btn btn-default" type="button">获取验证码</button>
                                        </span>
                                    </div>
                                    <!-- <small class="tip">请输入有效手机号码。</small> -->
                                </div>
                            </div>
                            <div class="registerbox-textbox">
                                <div class="form-group no-margin">
                                    <div class="input-group">
                                        <span class="input-group-addon bg-gray bordered-gray"><i class="fa fa-lock"></i></span> 
                                        <input type="password" name="password" class="form-control" placeholder="请输入手机验证码">
                                    </div>
                                    <!-- <small class="tip">验证码错误</small> -->
                                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                        <small class="tip"><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></small>
                                    </c:if>
                                </div>
                            </div>

                            <div class="registerbox-textbox">
                                <a href="#" id="ff2" class="btn btn-danger btn-block">登录</a>
                            </div>

                            <div class="registerbox-textbox no-padding-bottom clearfix">
                                <label class="no-padding">
                                    <input type="checkbox" id="_spring_security_remember_me" name="remember-me" class="colored-danger" value="true">
                                    <span class="text darkgray">自动登录</span>
                                </label>
                                <div class="vivo-nav cl">
                                    <div class="search-user">
                                        <a id="toPwd" href="#" class="search">用户名登录</a>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="dynamicPwd" value="Y" />
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                            <div class="registerbox-submit padding-bottom-20 clearfix">
                                <a href="<c:url value='/register' />" class="blue pull-right margin-left-10">马上注册</a>
                                <a href="<c:url value='/forgotPassword' />" class="blue pull-right">忘记密码</a>
                            </div>
                            </div>
                            <!--手机登录 end-->

                            <div id="pwd" <c:if test="${not empty dynamicPwd}">style="display:none;"</c:if>>
                            <div class="registerbox-title">会员登录</div>
                            <form id='f1' >
                            <div class="registerbox-caption ">公共场所不建议自动登录，以防账号丢失</div>
                            <div class="registerbox-textbox">
                                <div class="form-group no-margin">
                                    <div class="input-group">
                                        <span class="input-group-addon bg-gray bordered-gray"><i
                                            class="fa fa-user"></i></span> <input type="text" name="username"
                                            class="form-control" placeholder="用户名">
                                    </div>
                                    <!-- <small class="tip">用户名错误，请重新输入正确用户名。</small> -->
                                </div>
                            </div>
                            <div class="registerbox-textbox">
                                <div class="form-group no-margin">
                                    <div class="input-group">
                                        <span class="input-group-addon bg-gray bordered-gray"><i
                                            class="fa fa-lock"></i></span> <input type="password" name="password"
                                            class="form-control" placeholder="密码">
                                    </div>
                                    <!-- <small class="tip">密码错误，请重新输入正确密码。</small> -->
                                    <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                                        <small class="tip"><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></small>
                                    </c:if>
                                </div>
                            </div>


                            <div class="registerbox-textbox">
                                <a href="#" id="ff1" class="btn btn-danger btn-block">登录</a>
                            </div>


                            <div class="registerbox-textbox no-padding-bottom clearfix">
                                <label class="no-padding">
                                    <input type="checkbox" id="_spring_security_remember_me" name="remember-me" class="colored-danger" value="true"> 
                                    <span class="text darkgray">自动登录</span>
                                </label>
                                <div class="vivo-nav cl">
                                    <div class="search-user">
                                        <a id="toVerifyCode" href="#" class="search">手机号码登录</a>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                            <div class="registerbox-submit padding-bottom-20 clearfix">
                                <a href="<c:url value='/register' />" class="blue pull-right margin-left-10">马上注册</a>
                                <a href="<c:url value='/forgotPassword' />" class="blue pull-right">忘记密码</a>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="/resource/js/jquery-1.8.3.min.js"></script>
    <script>
       $(document).ready(function(){
           $ ("#toVerifyCode").click(function(){
               $("#pwd").css("display", "none");
               $("#verifycode").css("display", "");
           });
           
           $ ("#toPwd").click(function(){
               $("#verifycode").css("display", "none");
               $("#pwd").css("display", "");
           });
           
           $ ("#ff1").click(function(){
        	   $.ajax({
                   cache: false,
                   url: '<c:url value="/asyncProcessLogin" />',
                   type: "POST",
                   data: $('#f1').serialize(),
                   async: true,
                   success: function(data) {
                	   console.log(data);
                   },
                   error: function( xhr, status, errorThrown ) {
                       console.log(xhr);
                       console.log(status);
                       console.log(errorThrown);
                   }
               });
           });
           
           $ ("#ff2").click(function(){
        	   $.ajax({
                   cache: false,
                   url: '<c:url value="/asyncProcessLogin" />',
                   type: "POST",
                   data: {"username" : "18551602500", "password" : "xxxppp", "${_csrf.parameterName}" : "${_csrf.token}"},
                   async: true,
                   success: function(data) {
                       console.log(data);
                   },
                   error: function( xhr, status, errorThrown ) {
                       console.log(xhr);
                       console.log(status);
                       console.log(errorThrown);
                   }
               });
           });
           
       });
    </script>
</body>

</html>