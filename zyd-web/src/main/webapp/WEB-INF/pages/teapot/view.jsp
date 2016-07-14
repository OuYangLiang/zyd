<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>zyd—产品详情</title>
		<link rel="stylesheet" href="/resource/css/public.css" />
		<link rel="stylesheet" href="/resource/css/custom.css" />
		<link rel="stylesheet" href="/resource/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/resource/css/beyond.min.css" />
		<!--分页-->
		<script type="text/javascript" src="/resource/js/page_ajax.js"></script>
		<script>
			//tip srart
			function createCookie(n, t, i) {
				var r, u;
				i ? (r = new Date, r.setTime(r.getTime() + i * 864e5), u = "; expires=" + r.toGMTString()) : u = "";
				document.cookie = n + "=" + t + u + "; path=/";
			}

			function readCookie(n) {
				for (var t, r = n + "=", u = document.cookie.split(";"), i = 0; i < u.length; i++) {
					for (t = u[i]; t.charAt(0) == " ";) t = t.substring(1, t.length);
					if (t.indexOf(r) == 0) return t.substring(r.length, t.length);
				}
				return null;
			}

			function eraseCookie(n) {
				createCookie(n, "", -1);
			}
		</script>
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
						<li>
							<a href="<c:url value='/teapot/list' />">紫砂壶</a>
						</li>
						<li class="active">产品详情</li>
					</ul>
				</div>
			</div>
			<!--zyd-page-breadcrumbs end-->

			<!--zyd-product-details start-->
			<div class="zyd-product-details">
				<div class="row">
					<div class="col-xs-12">
						<!--放大镜区域 start-->
						<div class="zyd-product-master-plan">
							<div class="zyd-booth zyd-pic zyd-s500">
								<a href="/pic/images/01.jpg"><span></span><img src="/pic/images/002.jpg" alt="葛见奎对象在此" rel="/pic/images/002.jpg" class="jqzoom" /></a>
							</div>
							<ul class="zyd-thumb" id="thumblist">
								<li class="zyd-selected">
									<div class="zyd-pic zyd-s75">
										<a href="#"><span></span><img src="/pic/images/002.jpg" mid="/pic/images/002.jpg" big="/pic/images/002.jpg"></a>
									</div>
								</li>
								<li>
									<div class="zyd-pic zyd-s75">
										<a href="#"><span></span><img src="/pic/images/003.jpg" mid="/pic/images/003.jpg" big="/pic/images/003.jpg"></a>
									</div>
								</li>
								<li>
									<div class="zyd-pic zyd-s75">
										<a href="#"><span></span><img src="/pic/images/004.jpg" mid="/pic/images/004.jpg" big="/pic/images/004.jpg"></a>
									</div>
								</li>
								<li>
									<div class="zyd-pic zyd-s75">
										<a href="#"><span></span><img src="/pic/images/005.jpg" mid="/pic/images/005.jpg" big="/pic/images/005.jpg"></a>
									</div>
								</li>
								<li>
									<div class="zyd-pic zyd-s75">
										<a href="#"><span></span><img src="/pic/images/02.jpg" mid="/pic/images/02.jpg" big="/pic/images/02_small.jpg"></a>
									</div>
								</li>
							</ul>
						</div>
						<!--放大镜区域 end-->
						<!--价格区域 start-->
						<div class="zyd-product-detail-information">
							<div class="row">
								<div class="col-xs-12">
									<strong class="no-padding-top">${teapot.cmmdtyName } ${teapot.cmmdtyDesc }</strong>
									<div class="price">
										<div class="row"><span class="original"><em>原价:</em><i>¥</i>${teapot.proposedPrice }</span><span class="present"><em>活动价:</em><i>¥</i>${teapot.currentPrice }</span></div>
										<div class="right"><span>累计评论:<em>${teapot.numEvaluated }</em></span><span>累计销量:<em>${teapot.numSales }</em></span></div>
										<hr />
									</div>
									<div class="field">
										<div class="row">
											<div class="col-xs-12"><span>作者:</span><em>${teapot.producer }</em></div>
											<div class="col-xs-12"><span>泥料:</span><em>${teapot.material.desc }</em></div>
											<div class="col-xs-12"><span>编号:</span><em>${teapot.cmmdtyNum }</em></div>
											<div class="col-xs-12"><span>容量:</span><em>${teapot.size }cc</em></div>
											<div class="col-xs-12"><span>库存:</span><em>${teapot.numStored }件</em></div>
											<div class="col-xs-12">
												<span>数量:</span>
												<div class="spinner spinner-right">
                                                    <input type="text" class="spinner-input form-control" maxlength="2">
                                                    <div class="spinner-buttons	btn-group btn-group-vertical">
                                                        <button type="button" class="btn spinner-up maroon">
                                                            <i class="fa fa-angle-up"></i>
                                                        </button>
                                                        <button type="button" class="btn spinner-down magenta">
                                                            <i class="fa fa-angle-down"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
							                <c:if test="${!empty gifts}">
	                                            <div class="col-xs-12"><span>赠品:</span>
	                                            	<div class="zyd-detail-gift">
													<div data-sid="1">
														<ul class="zyd-gift-item">
															<c:forEach var="gift" items="${gifts }" varStatus="status">
																<li data-toggle="tooltip" data-placement="top" data-original-title="${gift.cmmdtyName }">
																	<a href="javascript:;" title="${gift.defaultImageAddrs }"><img src="/pic${gift.defaultImageAddrs }"></a><i></i></li>
															</c:forEach>
														</ul>
													</div>
													</div>
	                                            </div>
							                </c:if>
										</div>
									</div>
									<div class="button">
					                    <button class="btn btn-magenta" <c:if test="${!teapot.effective}">disabled="disabled"</c:if> id="add_cart" ><i class="fa fa-cart-plus"></i>加入购物车</button>
										<button class="btn btn-danger" <c:if test="${!teapot.effective}">disabled="disabled"</c:if> onclick="window.location.href='结算.html'" ><i class="fa fa-heart"></i>立即购买</button>
									</div>
									
								</div>
							</div>
						</div>
						<!--价格区域 end-->
						<!--分割线-->
						<div class="zyd-product-line"></div>
						<!--分割线 end-->
					</div>
				</div>
			</div>
			<!--zyd-product-details end-->
			<c:if test="${!empty recommends}">
			<!--zyd-details-recommendation start-->
			<div class="zyd-detail-recommend">
				<fieldset>
					<legend>猜您喜欢</legend>
					<div class="row">
						<ul>
							<c:forEach var="recommend" items="${recommends }" varStatus="status">
							<li>
								<a href="<c:url value='/teapot/${recommend.cmmdtyId}/view' />" class="transition_02"><img src="/pic/${recommend.defaultImageAddrs }" /><b>${recommend.cmmdtyName }</b><span>作者:${recommend.producer }</span><em>￥${recommend.currentPrice  }</em></a>
							</li>
							</c:forEach>
						</ul>
					</div>
				</fieldset>
			</div>
			<!--zyd-details-recommendation end-->
			</c:if>
			<!--zyd-product-list start-->
			<div id="zyd-details-tab">
				<div class="menu">
					<ul>
						<li id="one1" onclick="setTab('one',1,3)" class="off">产品描述</li>
						<li id="one2" onclick="setTab('one',2,3)">壶友评论(${teapot.numEvaluated })</li>
						<li id="one3" onclick="setTab('one',3,3)">咨询(${teapot.numEnquired })</li>
					</ul>
					<input type="hidden" id="hid_one_2" value="${teapot.numEvaluated }"/>
					<input type="hidden" id="hid_one_3" value="${teapot.numEnquired }"/>
					<input type="hidden" id="hid_three_1" value="${teapot.numEnquired }"/>
				</div>
				<div class="menudiv">
					<div id="con_one_1" class="menu-content">
						<c:if test="${!empty recommends}">
						<div class="zyd-menu-content-title">
							<div class="row">
								<c:forEach var="prop" items="${properties }" varStatus="status">
									<div class="col-xs-3"><span>${prop.propName }:<em>${prop.propVal }</em></span></div>
								</c:forEach>
							</div>
						</div>
						<div class="row">
							<div class="lined"></div>
						</div>
						</c:if>
						<c:if test="${!empty detailImages}">
						<div class="zyd-menu-content-image">
							<c:forEach var="img" items="${detailImages }" varStatus="status">
								<img class="lazy" src="/resource/images/grey.gif" data-original="/pic/${img.imageAddrs }" />
							</c:forEach>
						</div>
						</c:if>
					</div>
					<div id="con_one_2" style="display:none;" class="menu-content">
					</div>
					<!--pages-->
					<div class="row" id="eva_con_one_2" style="display:none;" >
						<div class="col-xs-6 col-xs-offset-6 text-right transition_02">
							<div id="eva_page_container"></div>
						</div>
					</div>
					<!--pages-->
					<div id="con_one_3" style="display:none;" class="menu-content">
					</div>
					<!--pages-->
					<div class="row" id="enq_con_one_3" style="display:none;" >
						<div class="col-xs-6 col-xs-offset-6 text-right transition_02">
							<div id="enq_page_container"></div>
						</div>
					</div>
					<!--pages-->
				</div>
			</div>
			<!--zyd-product-list end-->

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
						<span>微信：紫玉巅</span>
						<span><i class="fa fa-envelope-o"></i>admin@ziyudian.com</span>
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
								帮助中心Copyright© 紫玉巅 2007-2015 <span>All Rights Reserved</span>
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

		<!--弹窗  dialog start-->
		<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 450px">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h4 class="modal-title" id="mySmallModalLabel">商品添加成功</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-4 w100">
								<img src="/pic/${teapot.defaultImageAddrs}">
							</div>
							<div class="col-xs-6">
								<h4>${teapot.cmmdtyName }</h4>
								<p>
									<span>作者:</span>
									<b>${teapot.producer }</b>
								</p>
								<p class="item-time">
									<span>售价:</span>
									<b>${teapot.currentPrice }</b>
								</p>
								<p>
									<span>数量:</span>
									<b><span id="saleQty"></span>件</b>
								</p>
								<p>
									<button class="btn btn-danger" onClick="window.location.href='<c:url value="/party/cart/index" />'">去购物车结算</button>
									<button class="btn btn-default" data-dismiss="modal" >继续购物</button>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--弹窗  dialog end-->
		
		<script src="/resource/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
		<!-- 图片懒加载 -->
		<script type="text/javascript" src="/resource/js/jquery.lazyload.min.js"></script>
		<!--放大图片展示-->
		<script type="text/javascript" src="/resource/js/jquery.imagezoom.min.js"></script>
		<!--数量-->
		<script type="text/javascript" src="/resource/js/fuelux.spinner.min.js"></script>
		<script id="eval_ty" type="text/html">
		{{ each evals }}   
			<div class="row no-margin"> 
    		<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div class="col-xs-2 zyd-face-icon" id="{{dname }}_{{cursel }}_{{$value.evalId }}" lazyload="{{$value.partyId }}" eval="{{$value.evalId }}" imaged="{{if $value.containsImage }}true{{/if}}" addedEval="{{if $value.containsAddedEval }}true{{/if}}">
					<img src="/resource/images/grey.gif" />
					<b></b>
					<span></span>
				</div>
				<div class="col-xs-10">
					<div class="row">
						<div class="col-xs-10 no-padding padding-bottom-10 padding-top-10 bordered-bottom-1 bordered-seashell">
							{{if $value.numOfStars == 1}}
							<i class="fa fa-star orange"></i><i class="fa fa-star-o"></i><i class="fa fa-star-o"></i><i class="fa fa-star-o"></i><i class="fa fa-star-o"></i>
							{{/if}}
							{{if $value.numOfStars == 2}}
							<i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star-o"></i><i class="fa fa-star-o"></i><i class="fa fa-star-o"></i>
							{{/if}}
							{{if $value.numOfStars == 3}}
							<i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star-o"></i><i class="fa fa-star-o"></i>
							{{/if}}
							{{if $value.numOfStars == 4}}
							<i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star-o"></i>
							{{/if}}
							{{if $value.numOfStars == 5}}
							<i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star orange"></i><i class="fa fa-star orange"></i>
							{{/if}}
						</div>
					</div>
					<div class="row">
						<div class="col-xs-10 no-padding padding-top-10 ">
							{{$value.evalContent }}
						</div>
					</div>
					<div class="row" id="img_{{dname }}_{{cursel }}_{{$value.evalId }}">
					</div>
					<div class="row" id="zoom_img_{{dname }}_{{cursel }}_{{$value.evalId }}">
					</div>
					<div class="row" id="added_{{dname }}_{{cursel }}_{{$value.evalId }}">
					</div>
					<div class="row gray  margin-top-10">{{$value.eventTs | dateFormat:'yyyy-MM-dd hh:mm:ss' }}</div>
				</div>
			</div>
			</div>
		{{ /each }}
	</script>
		<script>
			//购物车删除商品
			$('.zyd-buy-del').click(function(){
			   $(this).parents('li').eq(0).remove();
			});
			//--Fuelux Spinner--
        	$('.spinner').spinner({max:'${teapot.numStored }'});

			$('#add_cart').click(function(){
				$.ajax({
		            url:'<c:url value='/party/async/cart/add' />?cmmdtyId=' + '${teapot.cmmdtyId }' + '&qty=' + $('.spinner-input').val(),
		            dataType: 'json',
		            success: function(resp) {
		            	if(resp.status == "2"){
		            		location.href = '<c:url value='/login' />?curl=' + encodeURIComponent(location.href);
		            	} else if(resp.status){
		            		$('#saleQty').html($('.spinner-input').val());
		            		$('.bs-example-modal-sm').modal('show');
		            	}
		            },error: function(XMLHttpRequest, textStatus, errorThrown) {
		            	 alert(XMLHttpRequest.status);
		            	 alert(XMLHttpRequest.readyState);
		            	 alert(textStatus);
            	   	}
		        });
			});
			 //		返回顶部
			function b() {
				h = $(window).height(),
					t = $(document).scrollTop(),
					t > h ? $("#zyd-return-top").show() : $("#zyd-return-top").hide()
			}
			$(document).ready(function() {
				$("#zyd-return-top").click(function() {
					$(document).scrollTop(0);
				});
			});
			 //		 返回顶部 end 
			 //		 产品主图放大镜 start
			$(document).ready(function() {
				$(".jqzoom").imagezoom();
				$('img.lazy').lazyload();
				$("#thumblist li a").hover(function() {
					$(this).parents("li").addClass("zyd-selected").siblings().removeClass("zyd-selected");
					$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
					$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
				});
			});
			 //		 产品主图放大镜 end
			
			 //	详情tab切换
			function setTab(name, cursel, links_len) {
				for (var i = 1; i <= links_len; i++) {
					var menu = document.getElementById(name + i);
					var menudiv = document.getElementById("con_" + name + "_" + i);
					if (i == cursel) {
						menu.className = "off";
						menudiv.style.display = "block";
					} else {
						menu.className = "";
						menudiv.style.display = "none";
					}
				}
				if (name == 'one' && cursel == 1){
					$("#eva_con_one_2").hide();
					$("#enq_con_one_3").hide();
				}
				if (name == 'one' && cursel == 2){
					$("#eva_con_one_2").show();
					$("#enq_con_one_3").hide();
					
					if ($("#con_one_2").attr("tab") == 'sel'){
						return;
					}
					pg_1.tabName = 'two';
					pg_1.cursel = 1;
					$.ajax({
			            url:'<c:url value='/teapot/async/${teapot.cmmdtyId }/evaluations/num' />',
			            dataType: 'html',
			            success: function(res) {
			            	$("#con_" + name + "_2").html(res);
			            	$.ajax({
					            url:'<c:url value='/teapot/async/${teapot.cmmdtyId }/evaluations' />',
					            dataType: 'json',
					            success: function(resp) {
					            	if(resp.evals && resp.evals.length > 0){
					            		resp.dname = 'two';
					            		resp.cursel = '1';
						            	var evalInfoHtml = template('eval_ty', resp);
						            	$("#con_two_1").html(evalInfoHtml);
						            	$("#con_" + name + "_2").attr("tab", "sel");
						            	$("#con_two_1").attr("tab", "sel");
					            	} else {
					            		$("#con_two_1").html("暂无评价");
						            	$("#con_two_1").css('text-align', 'center');
						            	$("#con_two_" + cursel).css('padding-top', '15px');
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
				callBack(name, cursel, 1, false);
			}
			//标签选择
			function callBack(name, cursel, page, chg){
				if (name == 'two'){
					if ($("#con_two_" + cursel).attr("tab") == 'sel' && !chg){
						repagefooter(name, cursel, page);
						return;
					}
					pg_1.tabName = name;
					pg_1.cursel = cursel;
	            	$.ajax({
			            url:'<c:url value='/teapot/async/${teapot.cmmdtyId }/evaluations' />?m=' + cursel + '&p=' + page,
			            dataType: 'json',
			            success: function(resp) {
			            	if(resp.evals && resp.evals.length > 0){
			            		resp.dname = name;
			            		resp.cursel = cursel;
				            	var evalInfoHtml = template('eval_ty', resp);
				            	$("#con_two_" + cursel).html(evalInfoHtml);
				            	if (chg) {
					            	$("div[id^=con_two_]").removeAttr("tab");
				            	} else {
				            		$("#con_two_" + cursel).attr("tab", "sel");
				            	}
			            	} else {
			            		$("#con_two_" + cursel).html("暂无评价");
				            	$("#con_two_" + cursel).css('text-align', 'center');
				            	$("#con_two_" + cursel).css('padding-top', '15px');
			            	}
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
	            	   	}
					});
				}
				if (name == 'three' && cursel == 2){
					$("#con_three_2").attr("tab", 'sel');
					$("#con_three_1").removeAttr("tab");
					$("#enq_con_one_3").hide();
					$("#eva_con_one_2").hide();
				}
				if (name == 'three' && cursel == 1){
					$("#con_three_1").attr("tab", 'sel');
					$("#con_three_2").removeAttr("tab");
					$("#enq_con_one_3").show();
				}
				if ((name == 'one' && cursel == 3) || (name == 'three' && cursel == 1)){
					if ($("#con_three_2").attr("tab") == 'sel'){
						$("#enq_con_one_3").hide();
						$("#eva_con_one_2").hide();
					} else {
						$("#enq_con_one_3").show();
						$("#eva_con_one_2").hide();
					}
					if ($("#con_one_3").attr("tab") == 'sel' && !chg){
						return;
					}
					pg_2.tabName = name;
					pg_2.cursel = cursel;
	            	$.ajax({
			            url:'<c:url value='/teapot/async/${teapot.cmmdtyId }/enquirings' />?p=' + page,
			            dataType: 'html',
			            success: function(resp) {
			            	$("#con_one_3").html(resp);
		            		$("#con_one_3").attr("tab", "sel");
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
	            	   	}
					});
				}
				
            	repagefooter(name, cursel, page);
			}
			function repagefooter(name, cursel, page){
				var count = $("#hid_" + name + "_" + cursel).val();
				if ((name == 'one' && cursel == 3) || (name == 'three' && cursel == 1)) {
					pg_2.pageCount = count % 1 == 0 ? count / 1 : count / 1 + 1;
					pg_2.page = page;
					pg_2.printHtml(2);
				} else if (name == 'two' || (name == 'one' && cursel == 2)) {
					pg_1.pageCount = count % 1 == 0 ? count / 1 : count / 1 + 1;
					pg_1.page = page;
					pg_1.printHtml(2);
				}
				
				$("html,body").animate({scrollTop:$("#zyd-details-tab").offset().top - 1}, 300);
				$("html,body").animate({scrollTop:$("#zyd-details-tab").offset().top});
			}
		</script>
		<!--分页-->
		<script language="JavaScript">
			var pg_1 = new showPages('pg_1', 'eva_page_container', callBack);
			pg_1.pageCount = 20; // 定义总页数(必要)
			 //pg.argName = 'p';  // 定义参数名(可选,默认为page)
			document.write();
			pg_1.printHtml(2);
			
			var pg_2 = new showPages('pg_2', 'enq_page_container', callBack);
			pg_2.pageCount = 20; // 定义总页数(必要)
			 //pg.argName = 'p';  // 定义参数名(可选,默认为page)
			document.write();
			pg_2.printHtml(2);
		</script>
		<!--分页 end-->
	</body>

</html>