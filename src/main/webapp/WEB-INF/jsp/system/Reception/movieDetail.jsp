
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
	background: url(${xgq}/images/btn_01-2.gif)
		no-repeat bottom;
}

.bank_nav3 li.hover {
	background: url(${xgq}/images/btn_01-2.gif)
		no-repeat top;
}

element.style {
	margin-left: 430px;
}
</style>
	<script type="text/javascript">
   function orderMovie(movieId,id){
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
	    var orderNum = $.trim($("#orderNum"+id).text());
	    //下单
	    $.ajax({
	    	 type:'post',
	    	 url: '${xgq}/index/orderMovie.do',
	         dataType: "json",
	         data: {movieId:movieId,id:id,orderNum:orderNum},
	         success: function(data){
	        	 if(data==1){
	        		 window.location = "${xgq}/index/getCustomerOrder.do";
	        	 }else if(data==2){
	        		 alert("票数不足！");
	        	 }else{
	        		 alert("购买失败！！");
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
	
	<div class="headH outside">
		<div class="nav">
			<ul>
				<li class="hover"><a href="${xgq}/index/getMovieIndex.do">首页</a></li>
				<li><a href="${xgq}/index/getMovieIndex.do">电影</a></li>
				<li><a href="${xgq}/index/getCustomerOrder.do" class="hover">我的订单</a></li>

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
					
						<p style="color:red;">欢迎！${SESSION_LOGIN_USER.loginName}登录。${isLogin}</p>
						
				</c:otherwise>
			</c:choose>
		</div>

	</div>


	</div>
	<div id="blackBg"></div>

	<div class="clear"></div>
	<div class="secAdd">
		<div class="outside">
			<div class="adTurn2">
				<div class="adTurns2">
					<ul>
						<li><img
							src="http://city.hipiao.com/assist/campaign/newindex/dianying-ad2.jpg" /></li>
						<!--<li><img src="../images/ad2.jpg" /></li>
          <li><img src="../images/ad2.jpg" /></li>
          <li><img src="../images/ad2.jpg" /></li>
          <li><img src="../images/ad2.jpg" /></li>-->
					</ul>
				</div>
				<div class="adBtn2">
					<!--<ul>
          <li class="hover"></li>
          <li></li>
          <li></li>
          <li></li>
          <li></li>
        </ul>-->
				</div>
			</div>
		</div>
	</div>
	
	<!-- public end -->
	<div id="outside">
		<div class="l_w">
			<dl class="film_c1">
				<dt>
					<img src="${xgq}${movieInfo.mainUrl}" alt="海报" />
				</dt>
				<dd>
					<div class="film_c1_1">
						<strong>${movieInfo.name}</strong>
					</div>

					<p>
						<label>上映时间：</label>
						<fmt:formatDate value="${movieInfo.recommendDate}"
							pattern="yyyy-MM-dd " />
					</p>
					<p>
						<label>导&nbsp;&nbsp;&nbsp; 演：</label> ${movieInfo.director}
					</p>
					<p>
						<label>主要演员：</label>${movieInfo.tostar}
					</p>
					<p>
						<label>影片类型：</label> ${movieInfo.productType}
					</p>
					<p>
						<label>出 品 地：</label> 美国
					</p>
				</dd>
			</dl>
			<!--2014.02.12 修改为选项卡式显示 start-->
			<div class="l_c5">
				<div class="bank_nav3 bank_nav02" style="border-bottom: none;">
					<ul>
						<li onclick="setTab('one',3,3)" id="one3"
							style="margin-left: 12px;" class="hover">
							<p style="font-size: 12px;">影片/热评</p>
						</li>
						<li onclick="setTab('one',1,3)" id="one1" style="display: block">
							<p style="font-size: 12px;">排期/购票</p>
						</li>
						<li onclick="setTab('one',2,3)" id="one2" style="display: none">
							<p style="font-size: 12px;">排期/通兑券</p>
						</li>

					</ul>
				</div>
			</div>
			<!--排期/购票 开始-->
			<!--<div id="con_one_1" style="display:">-->
			<div id="con_one_1" style="display: none">
				<dl class="film_c5">
					<dt>
						<a href="">湖北第二师范影院</a>
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
								<th><p>
										<a name="f44" id="f44"></a>放映时间
									</p></th>
								<th><p>语种/制式</p></th>
								<th><p>影厅</p></th>
								<th><p>价格</p></th>
								<th><p>会员价</p></th>
								<th><p>总票数</p></th>
								<th><p>订购张数</p></th>
								<th><p>操作</p></th>
							</tr>

							<c:forEach items="${scheduleMovieList}" var="item">
								<tr class="even">
									<td><fmt:formatDate value="${item['date']}"
											pattern="HH:mm:ss " /></td>
									<td>${item['languag']}</td>
									<td>${item['placeNum']}</td>
									<td class="font7"><span
										style="text-decoration: line-through;">${item['marketPrice']}</span></td>
									<td class="font8"><span style="color: red;">${item['memberPrice']}</span></td>
									<td class="font8"><span style="color: red;">${item['number']}</span></td>
									<td class="font8" contentEditable="true"
										id="orderNum${item['id']}"><span style="color: red;">1</span></td>
									<td class="film_a" ><a href="javascript:void(0)"
										onclick="orderMovie(${item['movieId']},${item['id']})"
										target="_blank" style="color:red;">订 票</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<!--具体排期区域 end-->
		</div>
	</div>

	</div>
	<!--排期/购票 结束-->


	<!--影片摘要 end-->
	<!--电影剧照 start-->
	
	<div class="film_c7" style="margin-left: 6px;">
		<b class="tbg"></b>
		<div class="film_c7_bor">
			<!--影片/热评 开始-->

			<div class="film_zhu">
				<!--影片摘要 start-->
				<div style="padding: 6px;">
					<dl class="film_c6" style="margin: 0;">
						<dt>
							<a id="f1" name="f1"></a>影片摘要：
						</dt>
						<dd>
							<p>${movieInfo.introduce}</p>
						</dd>
					</dl>
				</div>
			</div>
			<div class="film_tt2 dis1">
		<a name="f3" id="f3"></a><span>共 4 张</span>剧照：
	</div>
			<div id="viewer">
				<div id="viewerFrame">
					<c:forEach items="${movieInfo.urlList}" var="item">
						<div>
							<img id='img1' src="${xgq}${item}" alt="" />
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="clear"></div>
			<div class="film_but1">
				<img 
					alt="上一张" id="right" /> <img
					
					id="left" />
			</div>
		</div>
		<b class="bbg"></b>
	</div>
	<script type="text/javascript">
						//var j = jQuery.noConflict();
						$("#viewer").imageScroller({
							next : "right",
							prev : "left",
							frame : "viewerFrame",
							width : 153,
							child : "div",
							auto : false
						});
					</script>
	<!--电影剧照 end-->
	</div>
	
	</div>
	<!--影片/热评 结束-->
	<!--2014.02.12 修改为选项卡式显示 end-->


	</div>
	<div class="r_w">
		<div class="r_c1" style="margin-bottom: 10px;">
			<div class="r_c1_tt">
				<img 
					alt="影片热售" />
			</div>
			<div class="r_c1_bor" style="overflow-y: hidden; height: 538px;">
				<c:forEach items="${newMovielist}" var="item">
					<dl class="r_c1_1" style="height: auto;">
						<dt>
							<a
								href="${xgq}/index/getMovieDetailIndex.do?movieId=${item['ID']}">
								<img src="${xgq}${item['mainUrl']}" alt="海报" />
							</a>
						</dt>
						<dd>
							<h3>
								<a>${item['name']}</a>
							</h3>
							<p>${item['introduce']}</p>
						</dd>
					</dl>
				</c:forEach>
			</div>
		</div>
		<script language="javascript" type="text/ecmascript">
				$(document).ready(function(e) {//右侧悬停广告所需脚本	
					t = $('.fixed').offset().top;
					mh = $('.l_w').height();
					fh = $('.fixed').height();
					$(window).scroll(function(e) {
						s = $(document).scrollTop();
						if (s > t - 10) {
							$('.fixed').css('position', 'fixed');
							if (s + fh > mh) {
								$('.fixed').css('top', mh - s - fh + 'px');
							}
						} else {
							$('.fixed').css('position', '');
						}
					})
				});
			</script>


		
		<input type="hidden" id="pnum" value="4" /> <input type="hidden"
			id="pcur" value="" />
</body>
</html>
<!--  fresh cache-->