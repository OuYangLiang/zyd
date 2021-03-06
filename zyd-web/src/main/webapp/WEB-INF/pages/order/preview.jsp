<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="utf-8">
<title>订单预览</title>
<link rel="stylesheet" href="/resource/css/public.css" />
<link rel="stylesheet" href="/resource/css/font-awesome.min.css" />
<link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resource/css/beyond.min.css" />
<link rel="stylesheet" href="/resource/css/custom.css" />
<script type="text/javascript" src="/resource/js/template.js"></script>
</head>
<body>
	<!--zyd-top start-->
	<div class="zyd-top">
		<div class="zyd-top-nav">
			<div class="row">
				<div class="col-xs-4">欢迎您来到紫玉巅紫砂艺术网</div>
				<ul>
					<li><c:choose>
							<c:when test="${empty USER_SESSION_KEY}">
								<a href="<c:url value='/login' />">登录</a>
							</c:when>
							<c:otherwise>
								<a
									href="javascript:document.getElementById('logoutForm').submit();">退出</a>
							</c:otherwise>
						</c:choose></li>
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
					<a href="<c:url value='/' />"><img
						src="/resource/images/logo.png"></a>
				</div>
			</div>
			<div class="col-xs-offset-3 col-xs-6">
				<div class="zyd-search">
					<div class="input-group input-group-lg">
						<input type="text" class="form-control" placeholder="高级紫砂壶">
						<span class="input-group-btn">
							<button class="btn btn-danger" type="button">搜&nbsp;索</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--zyd-logo end-->

	<main>
	<div class="widget flat">
		<div class="widget-header">
			<span class="widget-caption font-150">配送信息<a href="收货地址.html"
				class="font-70 danger margin-left-10">地址管理</a></span>
			<!--Widget Buttons-->
			<a class="add_even" onClick="doAct(this);"></a>
		</div>

		<div class="widget-body">
			<div class="row no-margin padding-top-30 cont3" id="add_cont">
				<div class="col-xs-3">
					<div class="new-address transition_02" data-toggle="modal"
						data-target=".bs-example-modal-sm">
						<i class="fa fa-plus"></i><span>添加新地址</span>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="addres transition_02">
						<i class="edit fa fa-pencil transition_02" data-toggle="modal"
							data-target=".bs-example-modal-sm"></i>
						<h6 class=" danger">
							<i class="fa fa-home font-120 margin-right-10"></i>默认地址
						</h6>
						<h5>
							葛见奎<strong class="font-90 margin-left-10 danger">18351887866</strong>
						</h5>
						<div class="provinces">
							<span>江苏省</span><span>南京市</span><span>雨花台区</span>
						</div>
						<div class="margin-top-5 darkgray">软件大道123号 江苏吹牛皮股份有限公司</div>
						<em></em><i></i>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="addres transition_02 addres-selected">
						<i class="default fa fa-home transition_02"></i> <i
							class="edit fa fa-pencil transition_02" data-toggle="modal"
							data-target=".bs-example-modal-sm"></i> <i
							class="delete fa fa-trash-o transition_02"></i>
						<h5>
							葛见奎<strong class="font-90 margin-left-10 danger">18351887866</strong>
						</h5>
						<div class="provinces">
							<span>江苏省</span><span>南京市</span><span>雨花台区</span>
						</div>
						<div class="margin-top-5 darkgray">软件大道123号 江苏吹牛皮股份有限公司</div>
						<em></em><i></i>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="addres transition_02">
						<i class="default fa fa-home transition_02"></i> <i
							class="edit fa fa-pencil transition_02" data-toggle="modal"
							data-target=".bs-example-modal-sm"></i> <i
							class="delete fa fa-trash-o transition_02"></i>
						<h5>
							杨晓东<strong class="font-90 margin-left-10 danger">18351887866</strong>
						</h5>
						<div class="provinces">
							<span>江苏省</span><span>南京市</span><span>雨花台区</span>
						</div>
						<div class="margin-top-5 darkgray">软件大道123号 江苏吹牛皮股份有限公司</div>
						<em></em><i></i>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="addres transition_02">
						<i class="default fa fa-home transition_02"></i> <i
							class="edit fa fa-pencil transition_02" data-toggle="modal"
							data-target=".bs-example-modal-sm"></i> <i
							class="delete fa fa-trash-o transition_02"></i>
						<h5>
							葛见奎<strong class="font-90 margin-left-10 danger">18351887866</strong>
						</h5>
						<div class="provinces">
							<span>江苏省</span><span>南京市</span><span>雨花台区</span>
						</div>
						<div class="margin-top-5 darkgray">软件大道123号 江苏吹牛皮股份有限公司</div>
						<em></em><i></i>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="addres transition_02">
						<i class="default fa fa-home transition_02"></i> <i
							class="edit fa fa-pencil transition_02" data-toggle="modal"
							data-target=".bs-example-modal-sm"></i> <i
							class="delete fa fa-trash-o transition_02"></i>
						<h5>
							杨晓东<strong class="font-90 margin-left-10 danger">18351887866</strong>
						</h5>
						<div class="provinces">
							<span>江苏省</span><span>南京市</span><span>雨花台区</span>
						</div>
						<div class="margin-top-5 darkgray">软件大道123号 江苏吹牛皮股份有限公司</div>
						<em></em>
					</div>
				</div>
			</div>
		</div>

		<!--支付方式-->
		<div class="widget-header margin-top-10">
			<span class="widget-caption font-150">支付方式</span>
			<!--Widget Buttons-->
		</div>

		<div class="widget-body">
			<div class="row no-margin padding-top-20 padding-bottom-20">
				<div class="col-xs-12 payment-method">
					<div class="row">
						<span class="barter danger return">在线支付</span> <span
							class="barter default">货到付款</span>
					</div>
					<div
						class="form-horizontal confirmation padding-top-20  bordered-top-1 bordered-ivory"
						style="display: block;">

						<div class="zyd-detail-gift">
							<div class="sys_item_specpara" data-sid="1">
								<ul class="zyd-gift-item pay">
									<li><a href="javascript:;" title="支付宝"><img
											src="/pic/images/支付宝logo.png"></a><i></i></li>
									<li><a href="javascript:;" title="工商网银"><img
											src="/pic/images/工商logo.png"></a><i></i></li>
									<li><a href="javascript:;" title="银联网银"><img
											src="/pic/images/银联logo.png"></a><i></i></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!--商品信息-->
		<div class="widget-header margin-top-10">
			<span class="widget-caption font-150">商品信息</span>
			<!--Widget Buttons-->
		</div>

		<div class="widget-body  padding-20">
			<!--订单头部-->
			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="title col-xs-7">商品名称详情</th>
						<th class="title col-xs-2 text-align-center">单价</th>
						<th class="title col-xs-1 text-align-center">数量</th>
						<th class="title col-xs-2 text-align-center ">小计</th>
					</tr>
				</thead>
			</table>
			<!--订单头部 end-->
			<c:forEach var="item" items="${orderItems }" varStatus="status">
			<!--订单列表-->
			<table class="table table-bordered  margin-top-20" style="font-size: 13px">
				<tbody>
					<tr>
						<td class="col-xs-7  form-bordered">
							<div class="row form-group">
								<div class="col-xs-2" onClick="window.location.href='<c:url value="/teapot/${item.cmmdty.cmmdtyId }/view" />'"
									style="cursor: pointer;">
									<img src="/pic/${item.cmmdty.defaultImageAddrs }">
								</div>
								<div class="col-xs-7" onClick="window.location.href='<c:url value="/teapot/${item.cmmdty.cmmdtyId }/view" />'"
									style="cursor: pointer;">
									<a href="javascript:;">${item.cmmdty.cmmdtyName }</a>
								</div>
							</div>
							<c:if test="${!empty item.cmmdty.gifts}">
								<c:forEach var="gift" items="${item.cmmdty.gifts }" varStatus="status">
								<div class="row form-group">
									<div class="col-xs-2" onClick="window.location.href='<c:url value="/teapot/${gift.cmmdtyId }/view" />'"
										style="cursor: pointer;">
										<img src="/pic/${gift.defaultImageAddrs }" width="100%">
									</div>
									<div class="col-xs-7" onClick="window.location.href='<c:url value="/teapot/${gift.cmmdtyId }/view" />'"
										style="cursor: pointer;">${gift.cmmdtyName }</div>
								</div>
								</c:forEach>
							</c:if>
						</td>
						<td class="col-xs-2 text-align-center"><span class="danger">￥<fmt:formatNumber value="${item.cmmdty.currentPrice }" pattern="0.00"/></span>
						</td>
						<td class="col-xs-1 text-align-center"><span class="danger">${item.qtyToBuy }</span>
						</td>
						<td class="col-xs-2 text-align-center"><b>￥<fmt:formatNumber value="${item.cmmdty.currentPrice * 100 * item.qtyToBuy / 100 }" pattern="0.00"/></b></td>
					</tr>
				</tbody>
			</table>
			</c:forEach>
			<!--订单列表 end-->
			<div
				class="orders-footer padding-top-10 padding-bottom-10 margin-top-20 bg-ivory">
				<div class="row">
					<div class="col-xs-4">
						<form class="form-horizontal" role="form">
							<label class="col-xs-3 control-label no-padding-right">买家留言:</label>
							<div class="col-xs-9">
								<input type="text" class="form-control" placeholder="请输入您要说的话">
							</div>
						</form>
					</div>
					<div class="col-xs-5">
						<form class="form-horizontal" role="form">
							<label class="col-xs-2 control-label no-padding-right">发票:</label>
							<div class="radio col-xs-5">
								<label class="no-padding"> <input
									name="form-field-radio" type="radio" class="colored-danger">
									<span class="text"> 普通发票</span>
								</label> <label class="no-padding fr"> <input
									name="form-field-radio" type="radio" class="colored-danger">
									<span class="text"> 电子发票</span>
								</label>
							</div>
							<div class="col-xs-5">
								<input type="text" class="form-control" placeholder="请输入发票抬头">
							</div>
						</form>
					</div>
					<div class="col-xs-3 text-align-center">
						<div class="item-price">
							<span>合计：</span> <span>¥</span> <strong
								style="line-height: 34px;">${order.orderTotalPrice }</strong>
								<span> + 运费：</span><span>¥${order.logisticsAmt }</span>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="settlement">
		<p>
			<span>${order.totalCount }</span>件商品合计：<span>¥</span><em>${order.orderShouldPayment }</em>
		</p>
		<p>
			收货地址：<b>江苏省南京市雨花台区软件大道12345号大数据挖掘园</b>
		</p>
		<p>
			收货人：<b>欧阳亮</b>
		</p>
		<p>
			发票抬头：<b>(普通发票)欧阳亮</b>
		</p>
		<p>
			<button class="btn btn-danger">
				<strong class="font-160">提交订单</strong>
			</button>
		</p>
	</div>
	<!--zyd-footer srart-->
	<div class="zyd-footer">
		<div class="row">
			<!--footer bottom start-->
			<div class="col-xs-12">
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
		</div>
	</div>
	<!--zyd-footer end--> </main>

	<!--弹窗  dialog start-->
	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="mySmallModalLabel">增加新地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label class="col-xs-3 control-label no-padding-right">*收货人</label>
							<div class="col-xs-6">
								<input type="text" class="form-control" placeholder="收货人">
							</div>
							<p>姓名不能为空</p>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label no-padding-right">*地址</label>
							<div class="col-xs-6">
								<div class="m-form">
									<div class="item">
										<dl class="m-select" id="AreaSelector2">
											<dt></dt>
											<dd class="region" style="height: 250px;">
												<input type="hidden" name="" value="">
												<ul class="tab"></ul>
												<div class="tab-con clearfix"></div>
											</dd>
										</dl>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label no-padding-right"></label>
							<div class="col-xs-6">
								<input type="text" class="form-control" placeholder="街道名称或小区名称">
							</div>
							<p>地址不能为空</p>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label no-padding-right">*手机</label>
							<div class="col-xs-6">
								<input type="text" class="form-control" placeholder="必须真实有效">
							</div>
							<p>手机不能为空</p>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label no-padding-right">固定电话</label>
							<div class="col-xs-6">
								<input type="text" class="form-control" placeholder="选填">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<div class="checkbox">
									<label> <input type="checkbox"> <span
										class="text">设为默认收货地址</span>
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-6">
								<button type="submit" class="btn btn-danger">保存</button>
								<button type="submit" class="btn btn-default">取消</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!--弹窗  dialog end-->
	<script src="/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resource/js/beyond.min.js"></script>
	<!--地址联动-->
	<script type="text/javascript" src="/resource/js/Selector.js"></script>
	<script>
			//		全部地址
			function doAct(s) {
				var t = document.getElementById('add_cont'),
					c = s.className;
				//有more属性
				if (c != null && c.indexOf('more') > -1) {
					s.className = c.replace('more', '');
					t.className = t.className.replace('Large', 'cont3');
				} else {
					s.className = c + ' more';
					t.className = t.className.replace('cont3', 'Large');
					//t.className = t.className + ' Large';
				}
			}
			//支付方式切换
			$(".barter").click(function() {
				if ($(this).hasClass('danger')) return;
				$('.barter').each(function() {
					$(this).hasClass('default') ?
						($(this).removeClass('default').addClass('danger'), $(".confirmation").hide()) :
						($(this).removeClass('danger').addClass('default'), $(".confirmation").show())
				});
			});
			
			//在线支付选择
			$(function() {
				$(".zyd-detail-gift .sys_item_specpara").each(function() {
					var i = $(this);
					var p = i.find("ul>li");
					p.click(function() {
						if (!!$(this).hasClass("selected")) {
							$(this).removeClass("selected");
							i.removeAttr("data-attrval");
						} else {
							$(this).addClass("selected").siblings("li").removeClass("selected");
							i.attr("data-attrval", $(this).attr("data-aid"))
						}
					});
				});
				$(".addres").click(function() {
					$(".addres").removeClass("addres-selected");
					$(this).addClass("addres-selected");
				});
					//获取对应属性
				function getattrprice() {
					var defaultstats = true;
					var _val = '';
					var _resp = {
							mktprice: ".sys_item_mktprice"
					}; //输出对应的class
					$(".zyd-detail-gift .sys_item_specpara").each(function() {
						var i = $(this);
						var v = i.attr("data-attrval");
						if (!v) {
							defaultstats = false;
						} else {
							_val += _val != "" ? "_" : "";
							_val += v;
						}
					});
				}
			});
				//在线支付选择 end
				//地区联动 三级
			new SelectorJS.area.init('#AreaSelector2', '101180109', true);
		</script>

</body>

</html>