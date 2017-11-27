
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
<link rel="stylesheet" href="${xgq}/css/common.css">
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
var w,h,className;
function getSrceenWH(){
	w = $(window).width();
	h = $(window).height();
	$('#dialogBg').width(w).height(h);
}

window.onresize = function(){  
	getSrceenWH();
}  
$(window).resize();  

$(function(){
	getSrceenWH();
	
	
	
	//关闭弹窗
	$('.claseDialogBtn').click(function(){
		$('#dialogBg').fadeOut(300,function(){
			$('#dialog').addClass('bounceOutUp').fadeOut();
		});
	});
});

var number = "";
//显示弹框
function paymentone(numberId){
	number = numberId;
	className = $(this).attr('class');
	document.getElementById("orderNumber1").value =$.trim($("#orderNumber"+numberId).text());
	document.getElementById("movieName1").value =$.trim($("#movieName"+numberId).text());
	document.getElementById("memberId1").value =$.trim($("#memberId"+numberId).text());
	document.getElementById("date1").value =$.trim($("#date"+numberId).text());
	document.getElementById("languag1").value =$.trim($("#languag"+numberId).text());
	document.getElementById("placeNum1").value =$.trim($("#placeNum"+numberId).text());
	document.getElementById("memberPrice1").value =$.trim($("#memberPrice"+numberId).text());
	document.getElementById("orderNum1").value =$.trim($("#orderNum"+numberId).text());
	document.getElementById("total").value =$.trim($("#total"+numberId).text());
	$('#dialogBg').fadeIn(300);
	$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
};
</script>
	<script type="text/javascript">
   function payment(){
	   var id = number;
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
							电话：<span class="font8">027-85295363</span>
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
									<th><p>应付总额</p></th>
									<th><p>操作</p></th>
								</tr>

								<c:forEach items="${orderList}" var="item">
									<tr class="even">
										<td id="orderNumber${item['orderNumber']}">${item['orderNumber']}</td>
										<td id="memberId${item['orderNumber']}">${item['memberId']}</td>
										<td id="movieName${item['orderNumber']}">${item['movieName']}</td>
										<td id="date${item['orderNumber']}"><fmt:formatDate value="${item['date']}"
												pattern="HH:mm:ss " /></td>
										<td id="languag${item['orderNumber']}">${item['languag']}</td>
										<td id="placeNum${item['orderNumber']}">${item['placeNum']}</td>
										<td id="memberPrice${item['orderNumber']}">${item['memberPrice']}</td>
										<td id="orderNum${item['orderNumber']}">${item['orderNum']}</td>
										<td id="total${item['orderNumber']}">${item['orderNum']}*${item['memberPrice']}</td>
										<c:choose>
											<c:when test="${item['status'] == '1'}">
												<td>已付款</td>
											</c:when>
											<c:when test="${item['status'] == '2'}">
												<td>已失效</td>
											</c:when>
											<c:otherwise>
												<td class="film_a"><a href="javascript:void(0)"
													 onclick="paymentone(${item['orderNumber']})" target="_blank" style="color:red;">付款</a></td>
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
		
		<!-- 支付弹框 -->
		
		<div id="dialogBg"></div>
		<div id="dialog" class="animated" style="height: 500px;width: 300px;">
			<img class="dialogIco" width="50" height="50" src="${xgq}/images/ico.png" alt="" />
			<div class="dialogTop">
				<a href="javascript:;" class="claseDialogBtn">关闭</a>
			</div>
			<form action="" method="post" id="editForm" width="50" height="50">
				<ul class="editInfos">
					<li><label><font color="#ff0000">* </font>订单号：<input type="text" disabled="disabled name="orderNumber1" id="orderNumber1"  value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>电影名称<input type="text" disabled="disabled name="movieName1" id="movieName1" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>会员ID：<input type="text" disabled="disabled name="memberId1" id="memberId1"  required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>放映时间<input type="text" disabled="disabled name="date1"  id="date1" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>语种/制式：<input type="text" disabled="disabled name="languag1"  id="languag1" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>影厅：<input type="text" disabled="disabled name="placeNum1" id="placeNum1" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>价格：<input type="text" disabled="disabled name="memberPrice1" id="memberPrice1" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>订购张数：<input type="text" disabled="disabled name="orderNum1" id="orderNum1" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>总额：<input type="text" disabled="disabled name="total" id="total" required value="" class="ipt" /></label></li>
					
					<li><a type="submit" onclick="payment()" value="" class="submitBtn"  />确认付款</a></li>
				</ul>
			</form>
		</div>
</body>
</html>
<!--  fresh cache-->