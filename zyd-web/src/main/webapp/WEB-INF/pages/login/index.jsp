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
	<div class="login-header">
		<div class="row">
			<div class="col-xs-8">
				<div class="login-logo">
					<a href="<c:url value='/' />"><img src="/resource/images/login-logo.png"></a>
				</div>
			</div>
		</div>
	</div>

	<div class="login-banner">
		<div class="login-con">
			<div class="row">
				<div class="col-xs-8">
					<img src="/resource/images/login-banner.png">
				</div>
				<div class="col-xs-4">
					<div class="register-container">
						<div class="registerbox bg-white">
                            <div id="verifycode" <c:if test="${empty dynamicPwd}">style="display:none;"</c:if>>
							<!--手机登录-->
                            <div class="registerbox-title">手机号码登录</div>
                            <form id='f2' action='<c:out value="/zyd-web/processLogin${curl }" />' method='POST'>
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
                                <a href="javascript:document.getElementById('f2').submit();" class="btn btn-danger btn-block">登录</a>
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
                            <form id='f1' action='<c:out value="/zyd-web/processLogin${curl }" />' method='POST'>
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
								<a href="javascript:document.getElementById('f1').submit();" class="btn btn-danger btn-block">登录</a>
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

	<!--zyd-footer srart-->
	<div class="login-footer">
		<!--footer bottom start-->
		<div class="row">
			<div class="col-xs-7">
				<a href="#" class="transition_02">帮助中心</a> <a href="#"
					class="transition_02">开放平台</a> <a href="#" class="transition_02">联系我们</a>
				<a href="#" class="transition_02">网站合作</a> <a href="#"
					class="transition_02">法律声明</a> <a href="#" class="transition_02">规则意见征集</a>
			</div>
			<div class="col-xs-5 text-right">
				帮助中心Copyright© 紫玉颠 2007-2015 <span>All Rights Reserved</span>
			</div>
		</div>
	</div>
	<!--footer bottom end-->
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
	   });
	</script>
</body>

</html>