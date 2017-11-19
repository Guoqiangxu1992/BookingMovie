<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/system/common.jsp"%>
<!DOCTYPE html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="qc:admins" content="2451043703601011763757" />
<meta property="wb:webmaster" content="ae6109b9469c859a" />
<title>春雪网_国内领先的专业电影票在线购买网站 优先选座 不用排队</title>
<link rel="stylesheet" href="${xgq}/css/movieindex.css">
</head>
<html>
<body>
	<div class="headH outside">
		<h1 class="logo">
			<img src="http://city.hipiao.com/res/images/indexs/logo.png" />
		</h1>
		<div class="nav">
			<ul>
				<li class="hover"><a href="http://city.hipiao.com/">首页</a></li>
				<li><a href="http://movie.hipiao.com/">电影</a></li>
				<li><a href="http://cinema.hipiao.com/">电影院</a></li>
				<li><a href="https://member.hipiao.com/score/score.php">积分换礼</a></li>
			</ul>
		</div>
		<div class="headRight">
			<!-- 判断是否登录-->
			<div class="headLogin">
				<a href="https://member.hipiao.com" class="hover">登录</a> | <a
					href="https://member.hipiao.com/reg/">注册</a>
			</div>
		</div>
	</div>
	<!-- big turn img -->
	<div class="bigOutBor">
		<div id="bigImg">
			<ul id="slides">
				<li
					style="background: url(${xgq}/images/index2.jpg) no-repeat center top"><a
					href="http://movie.hipiao.com/film.php?pixnumber=英伦对决"
					target="_blank"> </a></li>
				<li
					style="background: url(${xgq}/images/index1.jpg) no-repeat center top"><a
					href="http://city.hipiao.com/" target="_blank"> </a></li>
				<li
					style="background: url(${xgq}/images/index1.jpg) no-repeat center top"><a
					href="http://movie.hipiao.com/film.php?pixnumber=昆塔：反转星球"
					target="_blank"> </a></li>
				<li
					style="background: url(${xgq}/images/index2.jpg) no-repeat center top"><a
					href="http://city.hipiao.com/" target="_blank"> </a></li>
			</ul>
		</div>
	</div>
	<!-- hot and being -->
	<div class="outside">
		<div class="hotBeNav">
			<ul>
				<li class="hover">正在热映</li>
				<li>即将上映</li>
			</ul>
		</div>
		<div class="cinameImg">
			<div>
				<div id="leftPBtn" class="leftBtn noLeft">
					<a href="javascript:;"></a>
				</div>
				<div id="rightPBtn" class="rightBtn">
					<a href="javascript:;"></a>
				</div>
				<div class="cimates">
					<div class="conList" id="photo_list">
						<!--statr正在热映-->
						<dl>
							<dt>
								<a target="_blank"
									href="http://movie.hipiao.com/film.php?pixnumber=%E5%85%A8%E7%90%83%E9%A3%8E%E6%9A%B4">
									<img
									onerror="this.src=http://city.hipiao.com/res/images/indexs/morenImg.gif;this.onerror=null;"
									src="http://img.hipiao.com/hipiao15/film/201710/145761306059edbcde50c3c.jpg">
								</a> <span></span>
							</dt>
							<dd>
								<p class="cinameName1">全球风暴</p>
								<p class="cinameBtn">
									<a target="_blank"
										href=""></a>
								</p>
								<p class="cinameYg">
									<a target="_blank"
										href="">预告片(0)</a>&nbsp;&nbsp;
									<a target="_blank"
										href="">剧照(4)</a>
								</p>
							</dd>
						</dl>
						
</body>
<script type="text/javascript">
$(function() {
	search();

});
</script>
</html>