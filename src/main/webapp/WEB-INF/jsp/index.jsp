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
<style>
	.cinameBtn a{background:url(${xgq}/images/btnBuy.gif) no-repeat;display:block;width:100px;height:34px;margin:0px auto;}
.headH h1.logo{background:url(${xgq}/images/indexLogoBg.png) no-repeat;width:101px;height:70px;padding-top:6px;padding-left:27px;position:absolute;left:0px;top:0px;z-index:10;}
.leftBtn a, .rightBtn a{display:block;width:29px;height:76px;background:url(${xgq}/images/filmsBtn.gif) no-repeat top;}
.conList dt{background:url(${xgq}/images/dtBg.png) no-repeat left top;height:210px;padding:6px 0px 0px 11px;margin-bottom:7px;overflow:hidden;}


</style>
<html>
<body>
	<div class="headH outside">
		<h1 class="logo">
			<img src="${xgq}/images/logo.png" />
		</h1>
		<div class="nav">
			<ul>
				<li class="hover"><a >首页</a></li>
				<li class="hover"><a href="${xgq}/index/getCustomerOrder.do" class="hover">我的订单</a></li>

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
					<p>欢迎！${SESSION_LOGIN_USER.loginName}登录。</p>
					
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<!-- big turn img -->
	<div class="bigOutBor">
		<div id="bigImg">
			<ul id="slides">
				<li
					style="background: url(${xgq}/images/index2.jpg) no-repeat center top"><a
					target="_blank"> </a></li>
				<li
					style="background: url(${xgq}/images/index1.jpg) no-repeat center top"><a
					target="_blank"> </a></li>
				<li
					style="background: url(${xgq}/images/index1.jpg) no-repeat center top"><a
					target="_blank"> </a></li>
				<li
					style="background: url(${xgq}/images/index2.jpg) no-repeat center top"><a
					target="_blank"> </a></li>
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

						<c:forEach items="${list}" var="item">

							<%-- <tr>
									<td align="center" valign="middle">${item["domain"]==null?"&nbsp;":item["domain"]}</td>
									<td align="center" valign="middle"><fmt:formatDate
											value="${item['bind_date']}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td align="center" valign="middle"><c:if
											test="${item['domain']!=null}">
											<a href="javascript:;" id="${item['domain']}" class="del">&nbsp;</a>
										</c:if></td>
								</tr>
								
								 --%>
							<dl>
								<dt>
									<a target="_blank"
										href="${xgq}/index/getMovieDetailIndex.do?movieId=${item['ID']}">
										<img src="${xgq}${item['mainUrl']}">
									</a> <span></span>
								</dt>
								<dd>
									<p class="cinameName1">${item['name']}</p>
									<p class="cinameBtn">
										<a target="_blank" href="${xgq}/index/getMovieDetailIndex.do?movieId=${item['ID']}"></a>
									</p>
									<p class="cinameYg">
										<a target="_blank">预告片(0)</a>&nbsp;&nbsp; <a
											target="_blank">剧照(${item['picturetotal']})</a>
									</p>
								</dd>
							</dl>
						</c:forEach>


					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript">

</script>
</html>