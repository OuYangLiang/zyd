<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>我的购物车</title>
<link rel="stylesheet" href="/resource/css/public.css" />
<link rel="stylesheet" href="/resource/css/custom.css" />
<link rel="stylesheet" href="/resource/css/font-awesome.min.css" />
<link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
<link rel="stylesheet" href="/resource/css/beyond.min.css" />
<script type="text/javascript" src="/resource/js/template.js"></script>
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
	<div class="widget flat w990" style="margin: 0 auto">
		<div class="widget-header bordered-bottom-2 bordered-danger">
			<span class="widget-caption font-150"><i
				class="fa fa-cart-plus margin-right-10"></i>购物车</span>
			<!--Widget Buttons-->
		</div>
		<!--Widget Header-->
		<div class="widget-body">
			<div class="widget transparent padding-20" id="cart_b">
				<div class="align_center">
					<img src="/pic/images/loading_16.gif" />&nbsp;&nbsp;正在努力刷您的购物车，马上就出来了~
				</div>
			</div>
		</div>
		<!--Widget Body-->

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
	<!--==========-->
	<div class="nav-wrapper-fixed" id="navFixed" style="display: none;">
		<div class="orders-footer padding-10" id="nav">
			<div class="row">
				<div class="col-xs-1">
					<strong> <label> <input type="checkbox" onClick="chooseAllGoods(this)"
							class="colored-danger" id="chooseAll" style="position: relative;"> <span
							class="text"></span>
					</label>
					</strong>
				</div>
				<div class="col-xs-2">
	                <a href="javascript:;" onClick="batchDelCmmdty()">删除选中商品</a>
	            </div>
	            <div class="col-xs-2">
	                <a href="javascript:;" onClick="clearCart()">清空购物车</a>
	            </div>
				<div class="col-xs-2 text-align-right">
					<span>已选商品<span id="totalCount">0</span>件</span>
				</div>
				<div class="col-xs-3 text-align-right font-130">
					<div class="item-price">
						<b>商品应付金额</b> <strong>¥</strong> <strong id="totalCost">0.00</strong>
					</div>
				</div>
				<div class="col-xs-2 text-align-right">
					<button class="btn btn-danger"
						onClick="toPreview(this);" style="cursor: pointer;">
						<strong class="font-160">去结算</strong>
					</button>
				</div>
			</div>
		</div>
	</div>
	<form action="<c:url value='/logout' />" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
	<!--===================-->
	<script src="/resource/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/resource/js/fuelux.spinner.min.js"></script>
	<script type="text/javascript" src="/resource/js/utils.js"></script>
	<script type="text/javascript" src="/resource/js/bootbox.js"></script>
	<script type="text/javascript" src="/resource/js/dialog.js"></script>
	<script id="cart_items" type="text/html">
    <div class="orders-container">
        <div class="orders-header">
            <div class="row text-align-center">
                <div class="col-xs-1">
                    <label> <input type="checkbox" id="chooseAll" onClick="chooseAllGoods(this)" class="colored-danger"> <span class="text"></span>
                    </label>
                </div>
                <div class="col-xs-4 text-align-left">
                    <strong>商品名称</strong>
                </div>
                <div class="col-xs-2">
                    <strong>操作</strong>
                </div>
                <div class="col-xs-1">
                    <strong>购买类型</strong>
                </div>
                <div class="col-xs-1">
                    <strong>单价</strong>
                </div>
                <div class="col-xs-1">
                    <strong>数量</strong>
                </div>
                <div class="col-xs-2">
                    <strong>小计(元)</strong>
                </div>
            </div>
        </div>
        <ul class="orders-list">
            {{ each items }}
            <li class="order-item" id="li_{{$index}}">
                <div class="row text-align-center">
                    <div class="col-xs-1">
                        <label>
							{{if $value.cmmdty.effective}}
								<input type="checkbox" cid="{{$value.cmmdtyId}}" index="{{$index}}" id="item_c_{{$index}}" onClick="chooseGoods(this, {{$index}})" class="item_choose colored-danger"> <span class="text"></span>
							{{else}}
								<span style="color:#999;background-color:#dedede">失效</span>
							{{/if}}
                        </label>
                    </div>
                    <div class="col-xs-4 text-align-left">
                        <div class="row">
                            <div class="col-xs-4"
                                onClick="window.location.href='<c:url value="/teapot/{{$value.cmmdtyId}}/view" />'"
                                style="cursor: pointer;">
                                <img src="/pic/{{$value.cmmdty.defaultImageAddrs}}" width="100%">
                            </div>
                            <div class="col-xs-8"
                                onClick="window.location.href='<c:url value="/teapot/{{$value.cmmdtyId}}/view" />'"
                                style="cursor: pointer;">
                                <div class="font-120">{{$value.cmmdty.cmmdtyName}}</div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-2">
                        <div class="item-price" onClick="delCmmdty({{$value.cmmdtyId}}, {{$index}})">
                            <a>删除</a>
                        </div>
                    </div>
                    <div class="col-xs-1">现货</div>
                    <div class="col-xs-1">
                        <div class="item-price">
                            <span>¥</span> <span id="price_{{$index}}">{{$value.cmmdty.currentPrice.toFixed(2)}}</span>
                        </div>
                    </div>
                    <div class="col-xs-1">
						{{if $value.cmmdty.effective}}
						<div class="spinner spinner-right" cid="{{$value.cmmdtyId}}" id="spinner_{{$index}}" index="{{$index}}" max="{{$value.cmmdty.numStored}}" dcount="{{$value.qtyToBuy}}">
                            <input type="text" class="spinner-input form-control"
                                maxlength="2" id="spininput_{{$index}}" oldnum="{{$value.qtyToBuy}}">
                            <div class="spinner-buttons btn-group btn-group-vertical">
                                <button type="button" class="btn spinner-up maroon">
                                    <i class="fa fa-angle-up"></i>
                                </button>
                                <button type="button" class="btn spinner-down magenta">
                                    <i class="fa fa-angle-down"></i>
                                </button>
                            </div>
                        </div>
						{{else}}
							{{$value.qtyToBuy}}
						{{/if}}
                    </div>
                    <div class="col-xs-2">
                        <div class="item-price">
                            <span>¥</span> <span id="subtotal_{{$index}}" index="{{$index}}">{{($value.cmmdty.currentPrice * 100 * $value.qtyToBuy / 100).toFixed(2) }}</span>
                        </div>
                    </div>
                </div>
            </li>
            {{ /each }}
        </ul>
        <div class="orders-footer margin-top-20">
            <div class="row text-align-center">
                <div class="col-xs-5 text-align-left">
                    <strong>因为专业，所以放心</strong>
                </div>
                <div class="col-xs-5 text-align-right">运费（以结算页为准）</div>
                <div class="col-xs-2">
                    <div class="item-price">
                        <span>¥</span> <span>8.00</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="orders-footer padding-10" id="nav">
        <div class="row">
            <div class="col-xs-1">
                <strong> <label> <input type="checkbox" onClick="chooseAllGoods(this)"
                        class="colored-danger" id="chooseAll" style="position: relative;"> <span
                        class="text"></span>
                </label>
                </strong>
            </div>
            <div class="col-xs-2">
                <a href="javascript:;" onClick="batchDelCmmdty()">删除选中商品</a>
            </div>
            <div class="col-xs-2">
                <a href="javascript:;" onClick="clearCart()">清空购物车</a>
            </div>
            <div class="col-xs-2 text-align-right">
                <span>已选商品<span id="totalCount">0</span>件</span>
            </div>
            <div class="col-xs-3 text-align-right font-130">
                <div class="item-price">
                    <b>商品应付金额</b> <strong>¥</strong> <strong id="totalCost">0.00</strong>
                </div>
            </div>
            <div class="col-xs-2 text-align-right">
                <button class="btn btn-danger"
                    onClick="toPreview(this);"
                    style="cursor: pointer;">
                    <strong class="font-160">去结算</strong>
                </button>
            </div>
        </div>
    </div>
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			if ('${msg}' != null && '${msg}' != ""){
				utils.dialog({
        	        type: 'tip',
        	        value: '<b>${msg}</b>'
        	    });
			}
			obtainCart();
			operatebtn();
			window.onscroll = function() {
				operatebtn();
			};
			$(".spinner").each(function(){
				var dcount = $(this).attr("dcount");
				var max = $(this).attr("max");
				$(this).spinner({value: parseInt(dcount), max: parseInt(max)});
				$(this).on('change', function(){
					var index = $(this).attr("index");
					var cid = $(this).attr("cid");
					var price = parseFloat($("#price_" + index).text());
					var count = parseFloat($("#spininput_" + index).val());
					if (isNaN(count) || count < 1) {
						$("#spininput_" + index).val(1);
						count = 1;
					}
					$.ajax({
			            url:'<c:url value='/party/async/cart/change' />?cmmdtyId=' + cid + "&qty=" + count,
			            dataType: 'json',
			            cache : false,
			            async : false,
			            success: function(resp) {
			            	if(resp.status == "2"){
			            		location.href = '<c:url value='/login' />?curl=' + encodeURIComponent(location.href);
			            	} else if(resp.status){
			            		var oldnum = parseFloat($("#spininput_" + index).attr("oldnum"));
			            		var subtotal = price * 100 * count / 100;
								$("#subtotal_" + index).text(subtotal.toFixed(2));
								$("#spininput_" + index).attr("oldnum", count);
								if ($("#item_c_" + index).attr("checked") == "checked") {
									var total = (parseFloat($("#totalCost").text()) * 100 + (count - oldnum) * 100 * price ) /100;
									var totalCount = parseInt($("#totalCount").text()) + (count - oldnum);
									$("strong[id=totalCost]").text(total.toFixed(2));
									$("span[id=totalCount]").text(totalCount);
								}
			            	} else {
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>' + resp.errors + '</b>'
			            	    });
			            	}
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
		           	   	}
			        });
				});
			});
		});
		function toPreview(_this){
			$(_this).attr("disabled","disabled");
			var cmmdtyIds = new Array();
        	$(".item_choose").each(function(){
				if ($(this).attr("checked") == "checked") {
					cmmdtyIds.push($(this).attr("cid"));
				}
			});
        	if (cmmdtyIds.length == 0){
        		utils.dialog({
        	        type: 'tip',
        	        value: '<b>别逗了，根本就没选好不好~</b>'
        	    });
        		$(_this).removeAttr("disabled");
        		return false;
        	}
        	location.href = '<c:url value='/order/preview' />?cIds=' + encodeURIComponent(cmmdtyIds);
		}
		function operatebtn(){
			var nav = $('#nav');
			var navFixed = $('#navFixed');
			var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
			if (scrollTop + window.innerHeight > nav.offset().top + nav.outerHeight()) {
				navFixed.hide();
			} else if (scrollTop + window.innerHeight < nav.offset().top + nav.outerHeight()) {
				navFixed.show();
			}
		}
		function obtainCart(){
           	$.ajax({
	            url:'<c:url value='/party/async/cart/list' />',
	            dataType: 'json',
	            cache : false,
	            async : false,
	            success: function(resp) {
	            	if(resp.status == "2"){
	            		location.href = '<c:url value='/login' />?curl=' + encodeURIComponent(location.href);
	            	} else if(resp && resp.items.length > 0) {
		            	var cartInfoHtml = template('cart_items', resp);
		            	$("#cart_b").html(cartInfoHtml);
	            	} else {
	            		$("#cart_b").html("<div class='align_center'>醉了，您的购物车里啥玩意木有~去加点吧~<div>");
	            	}
	            },error: function(XMLHttpRequest, textStatus, errorThrown) {
	            	 alert(XMLHttpRequest.status);
	            	 alert(XMLHttpRequest.readyState);
	            	 alert(textStatus);
           	   	}
	        });
		}
		function chooseAllGoods(_this) {
			if ($(_this).attr("checked") == "checked") {
				$(".item_choose").each(function(){
					$(this).attr("checked", "checked");
				});
				$("input[id=chooseAll]:checkbox").attr("checked", "checked");
				
				var total = 0;
				var count = 0;
				$("span[id^=subtotal]").each(function(){
					var index = $(this).attr("index");
					if ($("#item_c_" + index).attr("checked") == "checked"){
						total += parseFloat($(this).text());
						count += parseInt($("#spininput_" + index).attr("oldnum"));
					}
				});
				$("strong[id=totalCost]").text(total.toFixed(2));
				$("span[id=totalCount]").text(count);
			} else {
				$(".item_choose").each(function(){
					$(this).removeAttr("checked");
				});
				$("input[id=chooseAll]:checkbox").removeAttr("checked");
				$("strong[id=totalCost]").text("0.00");
				$("span[id=totalCount]").text(0);
			}
		}
		function chooseGoods(_this,_index) {
			var subtotal = parseFloat($("#subtotal_" + _index).text());
			var subcount = parseInt($("#spininput_" + _index).attr("oldnum"));
			var totalCost = parseFloat($("#totalCost").text());
			var totalCount = parseInt($("#totalCount").text());
			if ($(_this).attr("checked") == "checked") {
				var total = totalCost + subtotal;
				var count = totalCount + subcount;
				total = total.toFixed(2);
				$("strong[id=totalCost]").text(total);
				$("span[id=totalCount]").text(count);
				
				var isAll = true;
				$(".item_choose").each(function(){
					if ($(this).attr("checked") != "checked") {
						isAll = false;
						return false;
					}
				});
				if (isAll) {
					$("input[id=chooseAll]:checkbox").attr("checked", "checked");
				}
			} else {
				$(_this).removeAttr("checked");
				var count = totalCount - subcount;
				var total = totalCost - subtotal;
				total = total.toFixed(2);
				$("strong[id=totalCost]").text(total);
				$("span[id=totalCount]").text(count);
				
				$("input[id=chooseAll]:checkbox").removeAttr("checked");
			}
		}
		function delCmmdty(_cmmdtyId, _index){
			utils.dialog({
		        type: 'confirm',
		        title: '购物车',
		        value: '确定要删了我吗？',
		        confirmFunc: function() {
		        	$.ajax({
			            url:'<c:url value='/party/async/cart/delCmmdty' />?cmmdtyId=' + _cmmdtyId,
			            dataType: 'json',
			            success: function(resp) {
			            	if(resp.status == "2"){
			            		location.href = '<c:url value='/login' />?curl=' + encodeURIComponent(location.href);
			            	} else if(resp.status){
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>官人，人家被你删掉了~</b>'
			            	    });
			            		if ($("#item_c_" + _index).attr("checked") == "checked") {
			            			var subtotal = parseFloat($("#subtotal_" + _index).text());
			            			var subcount = parseInt($("#spininput_" + _index).attr("oldnum"));
			        				var totalCost = parseFloat($("#totalCost").text());
			        				var totalCount = parseInt($("#totalCount").text());
			        				var total = totalCost - subtotal;
			        				var count = totalCount - subcount;
			        				total = total.toFixed(2);
			        				$("strong[id=totalCost]").text(total);
			        				$("span[id=totalCount]").text(count);
			        			}
				            	$("#li_" + _index).remove();
			            	} else {
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>' + resp.errors + '</b>'
			            	    });
			            	}
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
		           	   	}
			        });
		        }
		    });
		}
		function batchDelCmmdty(){
			var cmmdtyIds = new Array();
        	$(".item_choose").each(function(){
				if ($(this).attr("checked") == "checked") {
					cmmdtyIds.push($(this).attr("cid"));
				}
			});
        	if (cmmdtyIds.length == 0){
        		utils.dialog({
        	        type: 'tip',
        	        value: '<b>别逗了，根本就没选好不好~</b>'
        	    });
        		return false;
        	}
			utils.dialog({
		        type: 'confirm',
		        title: '购物车',
		        value: '确定要删了我和兄弟们吗？',
		        confirmFunc: function() {
		        	$.ajax({
			            url:'<c:url value='/party/async/cart/batchDel' />?cmmdtyIds=' + cmmdtyIds,
			            dataType: 'json',
			            success: function(resp) {
			            	if(resp.status == "2"){
			            		location.href = '<c:url value='/login' />?curl=' + encodeURIComponent(location.href);
			            	} else if(resp.status){
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>官人，人家被你删掉了啦~</b>'
			            	    });
			            		$(".item_choose").each(function(){
			        				if ($(this).attr("checked") == "checked") {
			        					var _index = $(this).attr("index");
						            	$("#li_" + _index).remove();
			        				}
			        			});
		        				$("strong[id=totalCost]").text("0.00");
		        				$("span[id=totalCount]").text(0);
		        				$("input[id=chooseAll]:checkbox").removeAttr("checked");
			            	} else {
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>' + resp.errors + '</b>'
			            	    });
			            	}
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
		           	   	}
			        });
		        }
		    });
		}
		function clearCart(){
			utils.dialog({
		        type: 'confirm',
		        title: '购物车',
		        value: '真的要做的这么绝吗？',
		        confirmFunc: function() {
		        	$.ajax({
			            url:'<c:url value='/party/async/cart/clear' />',
			            dataType: 'json',
			            success: function(resp) {
			            	if(resp.status == "2"){
			            		location.href = '<c:url value='/login' />?curl=' + encodeURIComponent(location.href);
			            	} else if(resp.status){
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>完了，没了，啥都没了~</b>'
			            	    });
				            	$("li[id^=li_").remove();
		        				$("strong[id=totalCost]").text("0.00");
		        				$("span[id=totalCount]").text(0);
		        				$("input[id=chooseAll]:checkbox").removeAttr("checked");
			            	} else {
			            		utils.dialog({
			            	        type: 'tip',
			            	        value: '<b>' + resp.errors + '</b>'
			            	    });
			            	}
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
		           	   	}
			        });
		        }
		    });
		}
	</script>
</body>

</html>