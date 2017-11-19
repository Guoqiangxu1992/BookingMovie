
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/system/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>全球风暴_电影_哈票网_电影排期、预告片及影讯查询</title>
<link rel="stylesheet" href="${xgq}/css/movieindex.css">
	<style type="text/css" rel="stylesheet">
.mask {
	z-index: 5;
	color: #C7EDCC;
	background-color: #000000;
	position: absolute;
	top: 0px;
	left: 0px;
	filter: Alpha(Opacity = 70);
	opacity: 0.7;
}

.bank_nav3 li {
	background: url(https://member.hipiao.com/res/images/film/btn_01-2.gif)
		no-repeat bottom;
}

.bank_nav3 li.hover {
	background: url(https://member.hipiao.com/res/images/film/btn_01-2.gif)
		no-repeat top;
}

element.style {
	margin-left: 430px;
}
</style>
	<script type="text/javascript">
   function payment(id){
	   //登录验证
	    $.ajax({
    	 type:'post',
    	 url: '${xgq}/index/isLogin.do',
         dataType: "json",
         success: function(data){
        	 if(data==0){
        		 alert("登录再购买！");
        		 return;
        	 }
			
         }
     });
	 
	    //下单
	    $.ajax({
	    	 type:'post',
	    	 url: '${xgq}/index/payment.do',
	         dataType: "json",
	         data: {id:id},
	         success: function(data){
	        	 if(data==1){
	        		 window.location = "${xgq}/index/getCustomerOrder.do";
	        	 }else{
	        		 alert("付款失败失败！！");
	        	 }
				
	         }
	     });
	    
	   
	
   }

</script>
</head>
<body>
	<!-- public start -->
	<!--useCache-->
	﻿
	<!--JQcookie文件-->
	<link href="http://city.hipiao.com/res/css/indexs/index.css"
		type="text/css" rel="stylesheet" />
	<script type="text/javascript">
		var tel = "400-603-5566";
	</script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/jquery-1.5.2.min.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/jquery.md5.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/jquery.cookie.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/index-head.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/indexs/jquery.jslides.js"></script>
	<div class="headH outside">
		<h1 class="logo">
			<img src="http://city.hipiao.com/res/images/indexs/logo.png" />
		</h1>
		<div class="nav">
			<ul>
				<li class="hover"><a href="${xgq}/index/getMovieIndex.do">首页</a></li>
				<li><a href="${xgq}/index/getMovieIndex.do">电影</a></li>

			</ul>
		</div>
		<div class="headRight">
			<!-- 判断是否登录  -->
			<c:choose>
				<c:when test="${SESSION_LOGIN_USER.loginName == null}">
					<div class="headLogin">
						<a href="${xgq}/member/login.do" class="hover">登录</a> | <a
							href="${xgq}/regist.jsp">注册</a>
					</div>
				</c:when>
				<c:otherwise>
						<p>欢迎！${SESSION_LOGIN_USER.loginName}登录。${isLogin}</p>
				</c:otherwise>
			</c:choose>
		</div>

	</div>


	</div>
	<div id="blackBg"></div>


	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/alertDiv.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/movie.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/swfobject-hp1.4.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/popupDiv_video.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/jquery.imageScroller.js"></script>
	<script type="text/javascript"
		src="http://city.hipiao.com/res/js/tab.js"></script>
	<!-- public end -->
	<div id="outside">
		<div class="l_w">

			<!--排期/购票 开始-->
			<div id="con_one_1" style="margin-left: 430px;">
				<div id="con_one_1">
					<dl class="film_c5">
						<dt>
							<a href="http://cinema.hipiao.com/dadi_szzlxs">湖北第二师范影院</a>
						</dt>
						<dd class="font3">地址：湖北第二师范学院食堂中心1楼</dd>
						<dd>
							电话：<span class="font8">0755-85295363</span>
						</dd>

					</dl>
					<div class="film_table">
						<table summary="这是影片放映信息表单">
							<tbody>
								<tr>
									<th><p>订单号</p></th>
									<th><p>会员id</p></th>
									<th><p>电影名称</p></th>
									<th><p>
											<a name="f44" id="f44"></a>放映时间
										</p></th>
									<th><p>语种/制式</p></th>
									<th><p>影厅</p></th>
									<th><p>价格</p></th>
									<th><p>订购张数</p></th>
									<th><p>操作</p></th>
								</tr>

								<c:forEach items="${orderList}" var="item">
									<tr class="even">
										<td>${item['orderNumber']}</td>
										<td>${item['memberId']}</td>
										<td>${item['movieName']}</td>
										<td><fmt:formatDate value="${item['date']}"
												pattern="HH:mm:ss " /></td>
										<td>${item['languag']}</td>
										<td>${item['placeNum']}</td>
										<td>${item['payment']}</td>
										<td>${item['orderNum']}</td>
										<c:choose>
											<c:when test="${item['status'] == '1'}">
												<td>已付款</td>
											</c:when>
											<c:otherwise>
												<td class="film_a"><a href="javascript:void(0)"
													onclick="payment(${item['orderNumber']})" target="_blank" style="color:red;">付款</a></td>
											</c:otherwise>
										</c:choose>

									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<!--具体排期区域 end-->
			</div>
		</div>
</body>
</html>
<!--  fresh cache-->