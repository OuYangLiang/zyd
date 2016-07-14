<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>产品详情-咨询</title>
		
	</head>

	<body>
	<div class="row zyd-evaluation-title no-margin">
		<div class="col-xs-6"><span  class="off" id="three1" onclick="setTab('three',1,2)">全部咨询</span></div>
		<div class="col-xs-6"><span id="three2" onclick="setTab('three',2,2)">如有疑问,请发表咨询</span></div>
	</div>
	<div id="con_three_1">
		<c:choose>
        	<c:when test="${empty enquirings }">
        		<div class="row margin-top-20 padding-bottom-20 margin-left-50 margin-right-50 bordered-bottom bordered-seashell bordered-bottom-1">
					<div align="center">暂无咨询</div>
				</div>
			</c:when>
			<c:otherwise>
				<c:forEach var="enq" items="${enquirings }" varStatus="status">
				<div class="row margin-top-20 padding-bottom-20 margin-left-50 margin-right-50 bordered-bottom bordered-seashell bordered-bottom-1">
					<div class="row">
						<div class="col-xs-2 margin-top-10 margin-bottom-10"><i class="fa fa-comments-o blue margin-right-10"></i>${fn:substring(enq.acntVal, 0, 3) }****${fn:substring(enq.acntVal, 7, 11) }</div>
						<div class="col-xs-8 margin-top-10 margin-bottom-10">${enq.enquiringContent }</div>
						<div class="col-xs-2 text-align-right gray  margin-top-10 margin-bottom-10"><fmt:formatDate value="${enq.eventTs }" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></div>
					</div>
					<div class="row">
						<div class="col-xs-2  margin-top-10 margin-bottom-10 storm-cloud "><i class="fa fa-group green margin-right-10"></i>${enq.answerer }</div>
						<div class="col-xs-8  margin-top-10 margin-bottom-10 storm-cloud">${enq.answer }</div>
					</div>
				</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
			
	</div>
	<div id="con_three_2" style="display:none;">
		<div class="row margin-top-20 padding-bottom-20 margin-left-50 margin-right-50 bordered-bottom bordered-seashell bordered-bottom-1">
			<form role="form">
               <div class="row">
                   <div class="col-sm-6">
                       <div class="form-group">
                       	<label for=" ">问题归类</label>
                       	<select class="form-control" name="country" data-bv-field="country">
                           <option value="">蛋疼问题</option>
                           <option value="FR">妇科问题</option>
                           <option value="DE">牙科问题</option>
                           <option value="IT">国际问题</option>
                           <option value="JP">本拉登走了，心情不好怎么办？</option>
                       </select>
                       </div>
                   </div>
                   <div class="col-sm-6">
                       <div class="form-group">
                           <label for="exampleInputName2">姓名</label>
                           <span class="input-icon icon-right">
                               <input type="text" class="form-control" id="exampleInputName2" placeholder="称呼">
                               <i class="fa fa-user palegreen"></i>
                           </span>
                       </div>
                   </div>
               </div>
               <div class="row">
                   <div class="col-sm-12">
                       <div class="form-group">
                           <label for="exampleInputEmail2">留言</label>
                           <span class="input-icon icon-right">
                               <textarea class="form-control" rows="10"></textarea>
                               <i class="fa fa-envelope darkorange"></i>
                           </span>
                           <p class="help-block">请在文本区域输入您的留言.</p>
                       </div>

                   </div>
               </div>
               <button type="submit" class="btn btn-danger">提交</button>
           </form>
		</div>
	</div>
</body>
</html>