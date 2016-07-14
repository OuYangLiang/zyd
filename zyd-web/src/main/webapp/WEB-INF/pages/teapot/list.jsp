<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>zyd—紫砂壶</title>
		<link rel="stylesheet" href="/resource/css/public.css" />
		<link rel="stylesheet" href="/resource/css/custom.css" />
		<link rel="stylesheet" href="/resource/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/resource/css/beyond.min.css" />
		<!--分页-->
		<script type="text/javascript" src="/resource/js/page.js"></script>
	</head>

	<body>
		<main>
			<!--zyd-page-breadcrumbs start-->
			<div class="zyd-page-breadcrumbs">
				<div class="page-breadcrumbs">
					<ul class="breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="<c:url value='/' />">首页</a>
						</li>
						<li class="active">紫砂壶</li>
					</ul>
				</div>
			</div>
			<!--zyd-page-breadcrumbs end-->

			<!--zyd-screening start-->
			<div class="zyd-screening">
				<div class="list-screen">
					<div class="screen-top" id="s_rc">
						<div class="row">
							<h4>紫砂壶</h4><span id="time-num"><font>${count }</font>个结果</span>
						</div>
					</div>
					<div class="screen-term">
						<div id="selectList" class="screenBox">
							<c:if test="${!empty types}">
							<dl class="listIndex" attr="terminal_type_s">
								<dt id="t">器型</dt>
								<dd>
									<label><a href="javascript:;" onclick="cParams('235')" values2="" values1="" attrval="不限">不限</a></label>
									<c:forEach var="type" items="${types }" varStatus="status">
									<label>
										<c:choose>
				               	 			<c:when test="${queryParam.type == type.key }">
												<a href="javascript:;" values2="" values1="${type.key}" attrval="${type.value }" class="selected">${type.value }</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:;" onclick="sParams('235','${type.key}')" values2="" values1="${type.key}" attrval="${type.value }" class="text">${type.value }</a>
											</c:otherwise>
										</c:choose>
									</label>
									</c:forEach>
								</dd>
							</dl>
							</c:if>
							<c:if test="${!empty shapes}">
							<dl class="listIndex" attr="terminal_shape_s">
								<dt id="s">壶型</dt>
								<dd data-more=true class="zyd-screen-hidden" id="zyd-screen-contentID">
									<label><a href="javascript:;" onclick="cParams('240')" values2="" values1="" attrval="不限">不限</a></label>
									<div class="screening clearfix" id="s_container">
									<c:forEach var="shape" items="${shapes }" varStatus="status">
									<label>
										<c:choose>
				               	 			<c:when test="${queryParam.shape == shape.key }">
												<a href="javascript:;" values2="" values1="${shape.key}" id="s_${shape.key}" attrval="${shape.value }" class="selected">${shape.value }</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:;" onclick="sParams('240','${shape.key}')" values2="" values1="${shape.key}" attrval="${shape.value }" class="text">${shape.value }</a>
											</c:otherwise>
										</c:choose>
									</label>
									</c:forEach>
									</div>
								</dd>
								<span class="zyd-screen-more" id="zyd-screen-moreID">更多<i class="fa fa-angle-double-down"></i></span>
							</dl>
							</c:if>
							<c:if test="${!empty materials}">
							<dl class="listIndex" attr="terminal_material_s">
								<dt id="m">泥料</dt>
								<dd data-more=true class="zyd-screen-hidden" id="zyd-material-contentID">
									<label><a href="javascript:;" onclick="cParams('250')" values2="" values1="" attrval="不限">不限</a></label>
									<div class="screening clearfix">
									<c:forEach var="material" items="${materials }" varStatus="status">
									<label>
										<c:choose>
				               	 			<c:when test="${queryParam.material == material.key }">
												<a href="javascript:;" values2="" values1="${material.key}" id="m_${material.key}" attrval="${material.value }" class="selected">${material.value }</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:;" onclick="sParams('250','${material.key}')" values2="" values1="${material.key}" attrval="${material.value }" class="text">${material.value }</a>
											</c:otherwise>
										</c:choose>
									</label>
									</c:forEach>
									</div>
								</dd>
								<span class="zyd-screen-more" id="zyd-material-moreID">更多<i class="fa fa-angle-double-down"></i></span>
							</dl>
							</c:if>
							<c:if test="${!empty levels}">
							<dl class=" listIndex" attr="terminal_os_s">
								<dt id="l">级别</dt>
								<dd>
									<label><a href="javascript:;" onclick="cParams('430')" values2="" values1="" attrval="不限">不限</a> </label>
									<c:forEach var="level" items="${levels }" varStatus="status">
									<span>
										<c:choose>
				               	 			<c:when test="${queryParam.level == level.key }">
												<a href="javascript:;" values2="" values1="${level.key }" attrval="${level.value }" class="selected">${level.value }</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:;" onclick="sParams('430','${level.key}')" values2="" values1="${level.key }" attrval="${level.value }" class="text">${level.value }</a>
											</c:otherwise>
										</c:choose>
									</span>
									</c:forEach>
								</dd>
							</dl>
							</c:if>
							<c:if test="${!empty priceRegions}">
							<dl class="listIndex" attr="价格范围">
								<dt id="p">价格</dt>
								<dd>
									<label><a href="javascript:;" onclick="cParams('220')" values2="" values1="" attrval="不限">不限</a></label>
									<c:forEach var="region" items="${priceRegions }" varStatus="status">
									<label>
										<c:choose>
				               	 			<c:when test="${queryParam.priceRegion == region.key }">
												<a href="javascript:;" values2="99" values1="${region.key }" attrval="${region.value }" class="selected">${region.value }</a>
											</c:when>
											<c:otherwise>
												<a href="javascript:;" onclick="sParams('220','${region.key}')" values2="99" values1="${region.key }" attrval="${region.value }" class="text">${region.value }</a>
											</c:otherwise>
										</c:choose>
									</label>
									</c:forEach>
								</dd>
							</dl>
							</c:if>
						</div>
					</div>
				</div>
			</div>
			<!--zyd-screening end-->

			<!--zyd-title-header start-->
			<div class="zyd-title-header-line" id="s_ft">
				<div class="row">
					<h3 class="col-xs-2">紫砂壶</h3>
					<div class="col-xs-4">
						<div class="row">
							<c:choose>
				                <c:when test="${sort == 'default_sort' }">
				                    <div class="zyd-product-order down cur" onclick="sSort('default')">默认<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('sales')">销量<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('eval')">评论<span><i class="fa fa-angle-down"></i></span></div>
									<div class="zyd-product-order default" onclick="sSort('price_a')">价格<span class="fa-stack1"><i class="fa fa-angle-up fa-stack-1x"></i><i class="fa fa-angle-down fa-stack-1x"></i></span></div>
				                </c:when>
				                <c:when test="${sort == 'sales_desc' }">
				                    <div class="zyd-product-order down" onclick="sSort('default')">默认<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down cur" onclick="sSort('sales')">销量<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('eval')">评论<span><i class="fa fa-angle-down"></i></span></div>
									<div class="zyd-product-order default" onclick="sSort('price_a')">价格<span class="fa-stack1"><i class="fa fa-angle-up fa-stack-1x"></i><i class="fa fa-angle-down fa-stack-1x"></i></span></div>
				                </c:when>
				                <c:when test="${sort == 'evaluated_desc' }">
				                    <div class="zyd-product-order down" onclick="sSort('default')">默认<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('sales')">销量<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down cur" onclick="sSort('eval')">评论<span><i class="fa fa-angle-down"></i></span></div>
									<div class="zyd-product-order default" onclick="sSort('price_a')">价格<span class="fa-stack1"><i class="fa fa-angle-up fa-stack-1x"></i><i class="fa fa-angle-down fa-stack-1x"></i></span></div>
				                </c:when>
				                <c:when test="${sort == 'price_asc' }">
				                    <div class="zyd-product-order down" onclick="sSort('default')">默认<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('sales')">销量<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('eval')">评论<span><i class="fa fa-angle-down"></i></span></div>
									<div class="zyd-product-order default cur" onclick="sSort('price_d')">价格<span class="fa-stack1"><i class="fa fa-angle-up fa-stack-1x"></i><i class="fa fa-angle-down fa-stack-1x fa-stack-un"></i></span></div>
				                </c:when>
				                <c:otherwise>
				                	 <div class="zyd-product-order down" onclick="sSort('default')">默认<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('sales')">销量<span><i class="fa fa-angle-down"></i></span></div>
				                    <div class="zyd-product-order down" onclick="sSort('eval')">评论<span><i class="fa fa-angle-down"></i></span></div>
									<div class="zyd-product-order default cur" onclick="sSort('price_a')">价格<span class="fa-stack1"><i class="fa fa-angle-up fa-stack-1x fa-stack-un"></i><i class="fa fa-angle-down fa-stack-1x"></i></span></div>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="col-xs-6 text-right transition_02">
						<!--分页-->
						<script language="JavaScript">
							var pg = new showPages('pg');
							pg.pageCount = "${pageCount}"; // 定义总页数(必要)
							pg.argName = 'p';  // 定义参数名(可选,默认为page)
							document.write();
							pg.printHtml(2);
						</script>
						<!--分页 end-->
					</div>
				</div>
			</div>
			<!--zyd-title-header end-->

			<!--zyd-product-list start-->
			<div class="zyd-product-list">
				<div class="row">
					<c:choose>
		                <c:when test="${empty list}">
		                    <div align="center">此分类下暂无商品，看看其他的吧~</div> 
		                </c:when>
		                <c:otherwise>
		                	<c:forEach var="item" items="${list }" varStatus="status">
		                 	<div class="col-xs-3">
								<a href="<c:url value='/teapot/${item.cmmdtyId}/view' />" class="transition_02"><img class="lazy" src="/resource/images/grey.gif" data-original="/pic${item.defaultImageAddrs}">
									<div class="zyd-product-list-font margin-10">
										<h5 class="text-left line_ellipsis_2"><b>${item.producer}</b><b>${item.cmmdtyName}</b><b>￥${item.currentPrice}</b></h5>
										<div class="top"><b>泥料：${item.material.desc}</b><b>容量：${item.size}</b></div>
										<div class="bottom">
											<c:if test="${item.currentPrice > 300}">
											<b>免费送货<div class="lined"></div></b>
											</c:if>
											<c:if test="${item.numStored > 0}">
											<b>有现货<div class="lined"></div></b>
											</c:if>
											<b>销量(${item.numSales})<div class="lined"></div></b>
											<b>评论(${item.numEvaluated})</b>
										</div>
									</div>
									<c:if test="${!empty item.labelDto}">
									<!--活动标签 start-->
									<div class="pentagon"><span>${item.labelDto.labelVal}</span></div>
									<!--活动标签 end-->
									</c:if>
								</a>
							</div>
							</c:forEach>
		                </c:otherwise>
		            </c:choose>
				</div>
			</div>
			<!--zyd-product-list end-->
			<!--zyd-list-bottom-line start-->
			<div class="zyd-list-bottom-line">
				<div class="row">
					<div class="col-xs-6 hot"><span>热门推荐</span><a class="transition_02">藏壶者</a><a class="transition_02">藏壶天下</a><a class="transition_02">藏壶者</a><a class="transition_02">藏壶天下</a><a class="transition_02">藏壶者</a><a class="transition_02">藏壶天下</a><a class="transition_02">藏壶者</a>
						<a
						class="transition_02">藏壶天下</a><a class="transition_02">藏壶者</a><a class="transition_02">藏壶天下</a><a class="transition_02">藏壶者</a><a class="transition_02">藏壶天下</a></div>
					<div class="col-xs-6 text-right transition_02">
						<!--分页-->
						<script language="JavaScript">
							var pg_1 = new showPages('pg_1');
							pg_1.pageCount = "${pageCount}"; // 定义总页数(必要)
							pg_1.argName = 'p';  // 定义参数名(可选,默认为page)
							document.write();
							pg_1.printHtml(2);
						</script>
						<!--分页 end-->
					</div>
				</div>
			</div>
			<!--zyd-list-bottom-line end-->

			<!--zyd-footer srart-->
			<div class="zyd-footer">
				<div class="row">
					<!--footer left start-->
					<div class="col-xs-9">
						<div class="row text-center">
							<div class="col-xs-3">
								<h4><i class="fa fa-diamond"></i>品质保障</h4>
								<div class="divider"></div>
							</div>
							<div class="col-xs-3">
								<h4><i class="fa fa-heart-o"></i>7天无理由退货</h4>
								<div class="divider"></div>
							</div>
							<div class="col-xs-3">
								<h4><i class="fa fa-history"></i>15天免费换货</h4>
								<div class="divider"></div>
							</div>
							<div class="col-xs-3">
								<h4><i class="fa fa-gift"></i>满300元包邮</h4></div>
							<div class="divider_1"></div>
						</div>
						<div class="row">
							<ul class="col-xs-12">
								<li>
									<h5>帮助中心</h5>
									<ol>
										<li><a href="#">购物指南</a></li>
										<li><a href="#">支付方式</a></li>
										<li><a href="#">配送方式</a></li>
									</ol>
								</li>
								<li>
									<h5>服务支持</h5>
									<ol>
										<li><a href="#">售后政策</a></li>
										<li><a href="#">自助服务</a></li>
										<li><a href="#">相关下载</a></li>
									</ol>
								</li>
								<li>
									<h5>购物指南</h5>
									<ol>
										<li><a href="#">免费注册</a></li>
										<li><a href="#">发票保障</a></li>
										<li><a href="#">售后规则</a></li>
									</ol>
								</li>
								<li>
									<h5>帮助中心</h5>
									<ol>
										<li><a href="#">购物指南</a></li>
										<li><a href="#">支付方式</a></li>
										<li><a href="#">配送方式</a></li>
									</ol>
								</li>
								<li>
									<h5>帮助中心</h5>
									<ol>
										<li><a href="#">购物指南</a></li>
										<li><a href="#">支付方式</a></li>
										<li><a href="#">配送方式</a></li>
									</ol>
								</li>
							</ul>
						</div>
					</div>
					<!--footer left end-->
					<!--footer right start-->
					<div class="col-xs-3">
						<img src="/pic/images/QR code.svg">
						<span>QQ：123456789</span>
						<span>微信：紫玉之巅</span>
						<span><i class="fa fa-envelope-o"></i>YT_villain@icould.com</span>
						<div class="divider_2"></div>
					</div>
					<!--footer right end-->
					<!--footer bottom start-->
					<div class="col-xs-12">
						<div class="row">
							<div class="col-xs-7">
								<a href="#" class="transition_02">帮助中心</a>
								<a href="#" class="transition_02">开放平台</a>
								<a href="#" class="transition_02">联系我们</a>
								<a href="#" class="transition_02">网站合作</a>
								<a href="#" class="transition_02">法律声明</a>
								<a href="#" class="transition_02">规则意见征集</a>
							</div>
							<div class="col-xs-5 text-right">
								帮助中心Copyright© 紫玉颠 2007-2015 <span>All Rights Reserved</span>
							</div>
						</div>
					</div>
					<!--footer bottom end-->
				</div>
			</div>
			<!--zyd-footer end-->

		</main>
		<!--zyd-购物车/收藏/返回顶部 start-->
		<div id="zyd-shopping-cart"><a href="javascript:void(0)" class="transition_02"><i class="fa fa-cart-plus"></i><em class="transition_02">5</em><span class="transition_02">购物车</span></a></div>
		<a id="zyd-return-top" href="javascript:void(0)" class="transition_02"><i class="fa fa-chevron-up"></i><span class="transition_02">顶部</span></a>
		<div class="zyd-body-right-line"></div>
		<!--zyd-购物车/收藏/返回顶部 end-->

		<script src="/resource/js/jquery-1.8.3.min.js"></script>
		<!-- 图片懒加载 -->
		<script type="text/javascript" src="/resource/js/jquery.lazyload.min.js"></script>
		<script>
			// 购物车删除商品
			$('.zyd-buy-del').click(function() {
				$(this).parents('li').eq(0).remove();
			});
			// 返回顶部
			function b() {
				h = $(window).height(),
					t = $(document).scrollTop(),
					t > h ? $("#zyd-return-top").show() : $("#zyd-return-top").hide();
			}
			$(document).ready(function() {
				$('img.lazy').lazyload();
				$("#zyd-return-top").click(function() {
					$(document).scrollTop(0);
				});
			});
			function cParams(key){
				var args = location.search;
				var mod = "#s_rc";
				var reg = new RegExp('([,]?)' + key + ':([^,]*)', 'gi');
				var chk = args.match(reg);
				if (chk != null){
					args = args.replace(chk[0], "");
					location.href= args + mod;
				}
			}
			function sParams(key, value){
				var args = location.search;
				var mod = "#s_rc";
				args = clearPage(args);
				if (args == null || args == "" || args.indexOf("?") == -1){
					location.href = "?s=" + key + ":" + value + mod;
					return false;
				}
				var reg = new RegExp('s=([^&]*)', 'gi');
				var match1 = args.match(reg);
				if (match1 == null){
					location.href = args + "&s=" + key + ":" + value + mod;
					return false;
				}
				var sp = match1[0];
				var reg1 = new RegExp(key + ':([^,]*)', 'gi');
				var match2 = sp.match(reg1);
				if (match2 == null) {
					sp = sp + "," + key + ":" + value;
				} else {
					var sp1 = match2[0];
					var reg2 = new RegExp(':([^,]*)', 'gi');
					var match3 = sp1.match(reg2);
					var sp2 = match3[0];
					
					sp1 = sp1.replace(sp2, ":"+value);
					sp = sp.replace(match2[0], sp1);
				}
				args = args.replace(match1[0], sp);
				location.href= args + mod;
			}
			function sSort(value){
				var args = location.search;
				var mod = "#s_ft";
				args = clearPage(args);
				if (args == null || args.indexOf("?") == -1){
					location.href = "?sort=" + value + mod;
					return false;
				}
				var reg = new RegExp('sort=([^&]*)', 'gi');
				var match1 = args.match(reg);
				if (match1 == null){
					location.href = args + "&sort=" + value + mod;
					return false;
				}
				args = args.replace(match1[0], "sort=" + value);
				location.href= args + mod;
			}
			function clearPage(args){
				var preg = new RegExp('([\?&]?)p=([^&]*)', 'gi');
				var page = args.match(preg);
				if (page == null){
					return args;
				}
				args = args.replace(page[0], "");
				return args;
			}
			// 返回顶部 end 
			// 筛选点击显示更多 start
			$(function() {
				$("#zyd-screen-moreID").click(function() {
					$("#zyd-screen-contentID").toggleClass("zyd-screen-content");
					$("#zyd-screen-moreID").children("i").toggleClass("fa-angle-double-up");
					$("#zyd-screen-moreID").children("i").toggleClass("fa-angle-double-down");
					if($("#zyd-screen-contentID").hasClass("zyd-screen-content")) {
						var container = $("#s_container");
						if (container.outerHeight() < 35) {
							$("#zyd-screen-moreID").hide();
						} else if (container.outerHeight() < 100){
							$("#zyd-screen-contentID").css({height : container.outerHeight()});
						} else {
							container.css({height : 100});
						}
					} else {
						var shape = "${queryParam.shape}";
						var container = $("#s_container");
						if (shape != "") {
							var ex = $("#s_"+shape);
							container.scrollTop(
								ex.offset().top - container.offset().top + container.scrollTop()
							);
						}
						$("#zyd-screen-contentID").removeAttr("style");
						if (container.outerHeight() < 35) {
							$("#s_container").removeAttr("style");
						} else if (container.outerHeight() > 100){
							$("#s_container").css({height : 100});
						}
						
					}
				});
				$("#zyd-material-moreID").click(function() {
					$("#zyd-material-contentID").toggleClass("zyd-screen-content");
					$("#zyd-material-moreID").children("i").toggleClass("fa-angle-double-up");
					$("#zyd-material-moreID").children("i").toggleClass("fa-angle-double-down");
				});
				
			});
			// 筛选点击显示更多 end
			// 初始化更多图标
			function exmaterial(){
				var mat = "${queryParam.material}";
				if (mat != "") {
					$("#zyd-material-contentID").toggleClass("zyd-screen-content");
					$("#zyd-material-moreID").children("i").toggleClass("fa-angle-double-up");
					$("#zyd-material-moreID").children("i").toggleClass("fa-angle-double-down");
				}
			}
			function exshape(){
				var container = $("#s_container");
				if (container.outerHeight() < 35) {
					$("#zyd-screen-moreID").hide();
				}
				var shape = "${queryParam.shape}";
				if (shape != "") {
					$("#zyd-screen-contentID").toggleClass("zyd-screen-content");
					$("#zyd-screen-moreID").children("i").toggleClass("fa-angle-double-up");
					$("#zyd-screen-moreID").children("i").toggleClass("fa-angle-double-down");
					
					if (container.outerHeight() < 35) {
						$("#zyd-screen-moreID").hide();
						$("#zyd-screen-contentID").css ({height : 34});
					} else if (container.outerHeight() < 100){
						$("#zyd-screen-contentID").css({height : container.outerHeight()});
					} else {
						container.css({height : 100});
					}
					var ex = $("#s_"+shape);
					container.scrollTop(
						ex.offset().top - container.offset().top + container.scrollTop() - 5
					);
				}
			}
			exshape();
			exmaterial();
			// 初始化更多图标end
		</script>
	</body>

</html>