<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<html>
<head>
<link rel="stylesheet"
	href="/resource/css/bootstrap.min.css">

<decorator:head />
</head>

<body>
   	<!--zyd-top start-->
	<div class="zyd-top">
		<div class="zyd-top-nav">
			<div class="row">
				<div class="col-xs-4">欢迎您来到紫玉巅紫砂艺术网</div>
				<ul>
					<li>
					<c:choose>
		                <c:when test="${empty USER_SESSION_KEY}">
		                    <a href="<c:url value='/login' />">登录</a>
		                </c:when>
		                <c:otherwise>
		                    <a href="javascript:document.getElementById('logoutForm').submit();">退出</a>
		                </c:otherwise>
		            </c:choose>
					</li>
					<li class="zyd-top-nav-line"></li>
					<li><a href="<c:url value='/register' />">注册</a></li>
					<li class="zyd-top-nav-line"></li>
					<li><a href="我的订单.html">我的订单</a></li>
					<li class="zyd-top-nav-line"></li>
					<li><a href="我的紫玉颠index.html">我的紫玉颠</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!--zyd-top end-->

	<div class="zyd-header">
		<!--zyd-logo start-->
		<div class="row">
			<div class="col-xs-3">
				<div class="zyd-logo">
					<a href="<c:url value='/' />"><img src="/resource/images/logo.png"></a>
				</div>
			</div>
			<div class="col-xs-6">
				<div class="zyd-search">
					<div class="input-group input-group-lg">
						<input type="text" class="form-control" placeholder="高级紫砂壶">
						<span class="input-group-btn">
                               <button class="btn btn-danger" type="button">搜&nbsp;索</button>
                           </span>
					</div>
				</div>
			</div>
			<div class="col-xs-3">
				<div class="zyd-buy-cur">
					<button onClick="window.location.href='<c:url value="/party/cart/index" />'">
						<i class="fa fa-cart-plus"></i>我的购物车<span class="fa fa-angle-down transition_01"></span><em class="zyd-buy-cur-nmb">5</em>
					</button>
					<div class="spacer"></div>
					<div class="zyd-buy-cur-item">
					<c:choose>
		                <c:when test="${empty cartList}">
						<ol>
							<li>
								<i class="fa fa-cart-plus"></i><span>购物车中还没有商品，赶紧选购吧！</span>
							</li>
						</ol>
						</c:when>
		                <c:otherwise>
						<ul>
							<li>
								<a href="产品详情.html"><img src="/pic/images/003.jpg">
									<p>亿色(ESR)本色系列苹果6手机壳/保护套/软壳/透明硬壳 适用于苹</p> <b>￥233.50</b><strong>×2</strong></a><span class="zyd-buy-del"><i class="fa fa-times-circle"></i></span></li>
							<li>
								<a href="产品详情.html"><img src="/pic/images/003.jpg">
									<p>亿色(ESR)本色系列苹果6手机壳/保护套/软壳/透明硬壳 适用于苹</p> <b>￥233.50</b><strong>×2</strong></a><span class="zyd-buy-del"><i class="fa fa-times-circle"></i></span></li>
							<li>
								<a href="产品详情.html"><img src="/pic/images/003.jpg">
									<p>亿色(ESR)本色系列苹果6手机壳/保护套/软壳/透明硬壳 适用于苹</p> <b>￥233.50</b><strong>×2</strong></a><span class="zyd-buy-del"><i class="fa fa-times-circle"></i></span></li>
							<li>
								<a href="产品详情.html"><img src="/pic/images/003.jpg">
									<p>亿色(ESR)本色系列苹果6手机壳/保护套/软壳/透明硬壳 适用于苹</p> <b>￥233.50</b><strong>×2</strong></a><span class="zyd-buy-del"><i class="fa fa-times-circle"></i></span></li>
							<li>
								<a href="产品详情.html"><img src="/pic/images/003.jpg">
									<p>亿色(ESR)本色系列苹果6手机壳/保护套/软壳/透明硬壳 适用于苹</p> <b>￥233.50</b><strong>×2</strong></a><span class="zyd-buy-del"><i class="fa fa-times-circle"></i></span></li>
						</ul>
						<div class="zyd-buy-cur-item-bottom"><b>共5件商品</b><b>共计￥3897</b><a class="btn btn-danger"  onClick="window.location.href='我的购物车.html'" >查看购物车</a></div>
						</c:otherwise>
		            </c:choose>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--zyd-logo end-->

	<!--zyd-nav start-->
	<div class="zyd-nav">
		<div class="row">
			<a href="<c:url value='/teapot/list' />" class=" transition_02 col-xs-3 text-center cur">紫砂壶</a>
			<a href="<c:url value='/boutique/list' />" class=" transition_02 col-xs-3 text-center">紫玉精品</a>
			<a href="<c:url value='/encyclopedia/index' />" class=" transition_02 col-xs-3 text-center">紫砂百科</a>
			<a href="<c:url value='/tea/list' />" class=" transition_02 col-xs-3 text-center">茶叶</a>
		</div>
	</div>
	<!--zyd-nav end-->

	<decorator:body />

	<form action="<c:url value='/logout' />" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
