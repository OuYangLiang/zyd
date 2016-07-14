<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>产品详情-评价</title>
		
		<script type="text/javascript" src="/resource/js/template.js"></script>
	
	</head>

	<body>
	<c:if test="${!empty evalLabels}">
	<!--标签区域-->
	<div class="row no-margin bordered-1 bordered-gray padding-top-10 margin-bottom-30 margin-top-10 bg-snow">
		<div class="col-xs-2 no-padding">
			<h3 class="danger text-align-center">大家印象：</h3>
		</div>
		<div class="col-xs-10 no-padding">
			<div class="buttons-preview">
				<c:forEach var="label" items="${evalLabels }" varStatus="status">
	            	<a href="javascript:void(0);" class="btn btn-default danger">${label.label}(${label.hitTimes})</a>
	            </c:forEach>
	        </div>
		</div>
	</div>
	<!--标签区域  end-->
	</c:if>
	<div class="row zyd-evaluation-title no-margin">
		<div class="col-xs-2"><span class="off" id="two1" onclick="setTab('two',1,6)">全部(${gCount + mCount + pCount })</span></div>
		<div class="col-xs-2"><span id="two2" onclick="setTab('two',2,6)">有图(${imagedCount })</span></div>
		<div class="col-xs-2"><span id="two3" onclick="setTab('two',3,6)">好评(${gCount })</span></div>
		<div class="col-xs-2"><span id="two4" onclick="setTab('two',4,6)">中评(${mCount })</span></div>
		<div class="col-xs-2"><span id="two5" onclick="setTab('two',5,6)">差评(${pCount })</span></div>
		<div class="col-xs-2"><span id="two6" onclick="setTab('two',6,6)">追评(${addedCount })</span></div>
		<input type="hidden" id="hid_two_1" value="${gCount + mCount + pCount }"/>
		<input type="hidden" id="hid_two_2" value="${imagedCount }"/>
		<input type="hidden" id="hid_two_3" value="${gCount }"/>
		<input type="hidden" id="hid_two_4" value="${mCount }"/>
		<input type="hidden" id="hid_two_5" value="${pCount }"/>
		<input type="hidden" id="hid_two_6" value="${addedCount }"/>
	</div>
	<div id="con_two_1">
		<div class="row no-margin">
			<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div align="center">
					<img src="/resource/images/loading_16.gif" />
				</div>
			</div>
		</div>
	</div>
	<div id="con_two_2" style="display:none;">
		<div class="row no-margin">
			<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div align="center">
					<img src="/resource/images/loading_16.gif" />
				</div>
			</div>
		</div>
	</div>
	<div id="con_two_3" style="display:none;">
		<div class="row no-margin">
			<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div align="center">
					<img src="/resource/images/loading_16.gif" />
				</div>
			</div>
		</div>
	</div>
	<div id="con_two_4" style="display:none;">
		<div class="row no-margin">
			<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div align="center">
					<img src="/resource/images/loading_16.gif" />
				</div>
			</div>
		</div>
	</div>
	<div id="con_two_5" style="display:none;">
		<div class="row no-margin">
			<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div align="center">
					<img src="/resource/images/loading_16.gif" />
				</div>
			</div>
		</div>
	</div>
	<div id="con_two_6" style="display:none;">
		<div class="row no-margin">
			<div class="col-xs-12 padding-top-40 padding-bottom-30 bordered-bottom-1 bordered-gray">
				<div align="center">
					<img src="/resource/images/loading_16.gif" />
				</div>
			</div>
		</div>
	</div>
	
	</body>
	<script id="party_info" type="text/html">  
		<img src="/pic/images/04.jpg" />
		<b>{{acntVal }}</b>
		<span>{{level}}</span>
	</script>
	<script id="eval_img" type="text/html">  
    	{{ each evalImgs }}  
        	<div class="zoombox margin-top-10">
				<span class="photoBox">
				<img src="/pic{{$value.imageAddrs }}" class="zoom" onclick="zoom_image('/pic{{$value.imageAddrs }}',{{$value.evalId }},$(this).parent());" />
				</span>
			</div> 
    	{{ /each }}
	</script>
	<script id="eval_img_zoom" type="text/html">  
    	<div class="photoArea  margin-bottom-10" id="area_{{evalId }}" style="display:none;">
			<p class="toolBar">
				<span class="view"><a href="/pic{{imageAddrs }}" target="_blank"><i class="fa fa-search-plus"></i>查看原图</a></span>
				<em>|</em>
				<span class="view"><a href="javascript:void(0)" onclick="zoom_image_close();"><i class="fa fa-upload"></i>收起</a></span>
			</p>
			<p><img src="/pic{{imageAddrs }}" class="minifier" onclick="zoom_image_close()"></p>
		</div>
	</script>
	<script id="added_eval" type="text/html">
		{{ each addedEvals }}    
    		<div class="col-xs-12 no-padding padding-top-10 margin-bottom-10">
				{{if $value.addedEvalType == 'A3150010'}}
				<span class="bg-seashell margin-top-10 margin-bottom-10 padding-10"><span class="orange margin-right-5">[追评]</span>{{$value.addedEvalContent }}</span>
				{{else}}
				<span class="bg-seashell margin-top-10 margin-bottom-10 padding-10"><span class="blue margin-right-5">[官方回复]</span>{{$value.addedEvalContent }}</span>
				{{/if}}
			</div>
			<br/>
		{{ /each }}
	</script>
	
	
	<script type="text/javascript">
	//有图评价
	function zoom_image(img,ed,obj) {
		$('.photoBox').removeClass('cur');
		obj.addClass('cur');
		//obj.hide();
		if($("#area_"+ed).is(':hidden')){
			$(".photoArea img").attr('src',img);
			$(".photoArea").hide();
			$("#area_"+ed).show();
		}
		else{
			$(".photoArea img").attr('src',img);
			$(".photoArea").hide();
			$("#area_"+ed).show();
		}
		
	}
	function zoom_image_close(){
		$(".photoArea").hide();
	}

	$(document).ready(function() {
		$(window).bind("scroll", function(event){
			$(".zyd-face-icon").each(function(){
	            var winHeight = parseInt(window.screen.availHeight); //屏幕高度
	            var docScrollTop = parseInt(document.body.scrollTop); //页面翻过去的距离 
                var thisTop = parseInt($(this).offset().top);  //元素距离顶部的距离
                //alert((thisTop - docScrollTop) + "---" + winHeight);
                if ((thisTop - docScrollTop < winHeight) && (thisTop - docScrollTop > 0) && $(this).attr("lazyload") != $(this).attr("gir")) {
                   	$(this).attr("gir", $(this).attr("lazyload")); 
                   	var id = $(this).attr("id");
                   	$("#" + id).html("");
                   	$.ajax({
			            url:'<c:url value='/teapot/async/evaluations' />?partyId=' + $(this).attr("lazyload") + '&evalId=' + $(this).attr("eval") + '&imaged=' + $(this).attr("imaged") + '&addedEval=' + $(this).attr("addedEval"),
			            dataType: 'json',
			            success: function(resp) {
			            	var partyInfoHtml = template('party_info', resp.partyAccount);
			            	$("#" + id).html(partyInfoHtml);
			            	if (resp.evalImgs && resp.evalImgs.length > 0) {
				            	var imgHtml = template('eval_img', resp);
				            	$("#img_" + id).html(imgHtml);
				            	var zoomHtml = template('eval_img_zoom', resp.evalImgs[0]);
				            	$("#zoom_img_" + id).html(zoomHtml);
			            	}
			            	if (resp.addedEvals && resp.addedEvals.length > 0) {
				            	var addedHtml = template('added_eval', resp);
				            	$("#added_" + id).html(addedHtml);
			            	}
			            },error: function(XMLHttpRequest, textStatus, errorThrown) {
			            	 alert(XMLHttpRequest.status);
			            	 alert(XMLHttpRequest.readyState);
			            	 alert(textStatus);
	            	   	}
			        });
                }
			});

		});
	});
	template.helper('dateFormat', function (date, format) {
	    if (typeof date === "string") {
	        var mts = date.match(/(\/Date\((\d+)\)\/)/);
	        if (mts && mts.length >= 3) {
	            date = parseInt(mts[2]);
	        }
	    }
	    date = new Date(date);
	    if (!date || date.toUTCString() == "Invalid Date") {
	        return "";
	    }
	    var map = {
	        "M": date.getMonth() + 1, //月份 
	        "d": date.getDate(), //日 
	        "h": date.getHours(), //小时 
	        "m": date.getMinutes(), //分 
	        "s": date.getSeconds(), //秒 
	        "q": Math.floor((date.getMonth() + 3) / 3), //季度 
	        "S": date.getMilliseconds() //毫秒 
	    };
	    
	    format = format.replace(/([yMdhmsqS])+/g, function(all, t){
	        var v = map[t];
	        if(v !== undefined){
	            if(all.length > 1){
	                v = '0' + v;
	                v = v.substr(v.length-2);
	            }
	            return v;
	        }
	        else if(t === 'y'){
	            return (date.getFullYear() + '').substr(4 - all.length);
	        }
	        return all;
	    });
	    return format;
	});
	</script>
</html>