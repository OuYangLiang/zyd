<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
    <head>
        <meta charset="utf-8">
        <title>注册</title>
        <link rel="stylesheet" href="/resource/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/resource/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/resource/css/beyond.min.css" />
		<link rel="stylesheet" href="/resource/css/public.css" />
		<link rel="stylesheet" href="/resource/css/custom.css" />
    </head>

    <body>
        <div class="login-header">
            <!--zyd-logo start-->
            <div class="row">
                <div class="col-xs-8">
                    <div class="login-logo">
                        <a href="index.html"><img src="/resource/images/person-logo.png"></a>
                    </div>
                </div>
            </div>
        </div>
        <p class="text-align-right w990">我已经注册，马上<a href="<c:url value='/login' />" class="blue">登录></a>.</p>
        <!--zyd-logo end-->
        <div class="person">
            <div class="row">
                <div class="col-xs-12">
                    <div id="simplewizard" class="wizard" data-target="#simplewizard-steps">
                        <ul class="steps">
                            <li data-target="#simplewizardstep1" class="active"><span class="step">1</span>设置登录名<span class="chevron"></span></li>
                            <li data-target="#simplewizardstep2"><span class="step">2</span>设置登录密码<span class="chevron"></span></li>
                            <li data-target="#simplewizardstep3"><span class="step">3</span>注册成功<span class="chevron"></span></li>
                        </ul>
                    </div>
                    <div class="step-content col-xs-6 col-sm-offset-3" id="simplewizard-steps">
                        <div class="step-pane active" id="simplewizardstep1">
                            <div class="form-group">
                                <div class="input-group input-group-lg margin-top-30">
                                    <span class="input-group-addon bg-gray bordered-gray"><i class="fa fa-mobile-phone font-150"></i></span>
                                    <input type="text" id="acnt" class="form-control" placeholder="请输入手机号码">
                                </div>
                                <!--<p class="help-block danger">请输入正确格式</p>-->
                            </div>
                            <div class="input-group input-group-lg margin-top-30">
                                <input type="text" id="vcode" class="form-control" placeholder="请输入手机验证码">
                                <span class="input-group-btn" >
                                    <button class="btn btn-default" type="button">获取验证码</button>
                                </span>
                            </div>
                            <p id="err1" class="help-block danger"></p>
                        </div>
                        
                        <div class="step-pane" id="simplewizardstep2">
                            <div class="form-group">
                                <div class="input-group input-group-lg margin-top-30">
                                    <span class="input-group-addon bg-gray bordered-gray"><i class="fa fa-lock font-150"></i></span>
                                    <input id="p1" type="password" class="form-control" placeholder="请设置登录密码">
                                </div>
                                <!--<p class="help-block danger">请输入正确格式</p>-->
                            </div>
                            <div class="input-group input-group-lg margin-top-30">
                                <span class="input-group-addon bg-gray bordered-gray"><i class="fa fa-lock font-150"></i></span>
                                <input id="p2" type="password" class="form-control" placeholder="请重复登录密码">
                            </div>
                            <p id="err2" class="help-block danger"></p>
                        </div>
                        
                        <div class="step-pane" id="simplewizardstep3">
                            <div class="col-xs-12 text-align-center margin-top-30 margin-bottom-20 ">
                                <i class="fa fa-check finished"></i>
                                <div class="databox-cell">
									<h2 class="databox-text sonic-silver">注册成功</h2>
									<h5 class="databox-number lightcarbon">下次请使用手机号码登录</h5>
                                </div>
                            </div>
                        </div>
                        
                    <div class="margin-top-30" id="simplewizard-actions">
                        <button type="button" class="btn btn-default btn-next btn-block btn-danger font-150 h40" data-last="注册完成">下一步</button>
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
        <script src="/resource/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="/resource/js/wizard-custom.js"></script>
        <script>
            $(document).ready(function(){
            	$('#simplewizard').wizard().on('change', function(e, data) {
            		
            		if (1 == data.step) {
            			var acnt = $("#acnt").val();
            			var vcode= $("#vcode").val();
            			
            			$.ajax({
                            cache: false,
                            url: '<c:url value="/register/async/account/verify" />',
                            type: "GET",
                            data: {"acnt" : acnt, "vcode" : vcode},
                            async: false,
                            success: function(data) {
                                if (!data.status) {
                                	$("#err1").html(data.errors);
                                	e.preventDefault();
                                }
                            },
                            error: function( xhr, status, errorThrown ) {
                            	$("#err1").html("系统出错，请稍后重试");
                            }
                        });
            		} else if (2 == data.step) {
            			var acnt = $("#acnt").val();
                        var vcode= $("#vcode").val();
                        var p1   = $("#p1").val();
                        var p2   = $("#p2").val();
                        
                        if (p1 != p2) {
                        	$("#err2").html("两次输入密码不相同");
                        	e.preventDefault();
                        	return;
                        }
                        
                        $.ajax({
                            cache: false,
                            url: '<c:url value="/register/save" />',
                            type: "POST",
                            data: {"acnt" : acnt, "vcode" : vcode, "pwd" : p1, "${_csrf.parameterName}" : "${_csrf.token}"},
                            async: false,
                            success: function(data) {
                                if (!data.status) {
                                    $("#err2").html(data.errors);
                                    e.preventDefault();
                                }
                            },
                            error: function( xhr, status, errorThrown ) {
                                $("#err2").html("系统出错，请稍后重试");
                            }
                        });
            		} else if (3 == data.step) {
            			alert("hehe");
            		}
            		
            	});
            });
        </script>
    </body>

</html>
