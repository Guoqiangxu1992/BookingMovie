
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/system/common.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="wb:webmaster" content="ae6109b9469c859a" />
<title>哈票网 - 登录</title>
<link rel="stylesheet" href="${xgq}/css/login.css">
</head>
<body>

<div class="headH outside">
  <h1 class="logo">
  <img src="${xgq}/images/logo.png" />  
  </h1>
  <div class="nav">
    <ul>
      
    
    </ul>
  </div>
  <div class="headRight">
       
        <div class="myHp">
      <h3>我的哈票</h3>
      
    </div>
  </div>
<script type="text/javascript">
function valChanges(user){		
	$(user).val('');	
}
function valChangesUser(user){
	if ($(user).val()=='请输入用户名/手机号'){
		$(user).val('');
	}
}
function valChangesPwd(user){
	if($(user).val()=='请输入您的用户密码'){
		$(user).val('');
	}
}

function Login(){
	var name = $("#username").val();
	var password = $("#password").val();
     $.ajax({
    	 type:'post',
    	 url: '${xgq}/login/ReceptionloginAjax.do',
         data: {username:name,password:password},
         dataType: "json",
         success: function(data){
        	 if(data==1){
        		 window.location = "${xgq}/index/getMovieIndex.do";
        	 }else
        		 {
        		 alert("用户名错误或者密码错误！");
        		 }
			
         }
     });
}

</script>
    <div class="mainbj login">
       
        <div class="login_l"  style="margin-top:20px; height:auto;" >
        	<!-- 哈票登陆 begin -->
       		<div id="con_one_1">
        		    <div class="table_c1">
			           <form id="login_form" action="javascript:void(0);" >
				            <ul>
				                <li>
				                    <span>用户名：</span>
				                    <input  onpaste="return false" oncopy="return false" onselectstart="return false" ondragstart="return false" oncontextmenu='return false' id="username" name="username" onfocus="valChanges(username)" onblur="valrecover(username,'请输入用户名/手机号');" type="text" class="k_250" value="请输入用户名/手机号" />
				                <li>
				                    <span>密码：</span>
				                  <input  onpaste="return false" oncopy="return false" onselectstart="return false" ondragstart="return false" oncontextmenu='return false' id="password" name="password" onfocus="valChanges(password)" onblur="valrecover(password,'请输入您的用户密码')" type="password" class="k_250" value="请输入您的用户密码" />
				                </li>
				                <li>
				                    <span>&nbsp;</span>
				                    <a href="javascript:void(0)" id="submitId"  onclick="Login()" class="menu_login" title="立即登录">立即登录</a>
				                  
				                </li>
				            </ul>
			            </form>
		            </div>
		      </div>
		      <!-- 哈票登陆 end -->
        </div>
    </div>
	
	<!-- public end -->
	
</div>

</body>
