
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta property="wb:webmaster" content="ae6109b9469c859a" />
<title>哈票网 - 登录</title>
<link href="https://member.hipiao.com/res/css/hipiao.css" type="text/css" rel="stylesheet" />
<link href="https://member.hipiao.com/res/css/basic.css" type="text/css" rel="stylesheet" />
<link href="https://member.hipiao.com/res/css/login.css" type="text/css" rel="stylesheet" />
<link href="https://member.hipiao.com/res/css/float.css" type="text/css" rel="stylesheet" />
<link href="https://member.hipiao.com/res/css/register.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="https://member.hipiao.com/res/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="https://member.hipiao.com/res/js/mLogin20131218.js?v=20141104"></script>
<script type="text/javascript" src="/JS/cinemaLogin0718.js?v=20141104"></script>
<script src="https://member.hipiao.com/res/js/alertDiv.js" type="text/javascript"></script>
<script type="text/javascript" src="/JS/zpyhy.js"></script>
</head>
<body>
<!-- public start -->
 ﻿<!--JQcookie文件-->
<link href="https://member.hipiao.com/res/css/indexs/index.css" type="text/css" rel="stylesheet" />
<script type="text/javascript">var tel="400-603-5566";</script>
<script type="text/javascript" src="https://member.hipiao.com/res/js/jquery-1.5.2.min.js"></script>
<script type="text/javascript" src="https://member.hipiao.com/res/js/jquery.md5.js"></script>
<script type="text/javascript" src="https://member.hipiao.com/res/js/jquery.cookie.js"></script>
<script type="text/javascript" src="https://member.hipiao.com/res/js/index-head.js"></script>
<script type="text/javascript" src="https://member.hipiao.com/res/js/indexs/jquery.jslides.js"></script>
<div class="headH outside">
  <h1 class="logo">
  <img src="https://member.hipiao.com/res/images/indexs/logo.png" />  
  </h1>
  <div class="nav">
    <ul>
      <li class="hover"><a href="http://www.hipiao.com/">首页</a></li>
      
    </ul>
  </div>
  <div class="headRight">
       
        <div class="myHp">
      <h3>我的哈票</h3>
      <ul>
        <li><a href="https://member.hipiao.com/myhipiao/order.php">我的订单</a></li>

      </ul>
    </div>
  </div>

<script type="text/javascript" src="https://member.hipiao.com/res/js/tab.js"></script>
<script type="text/javascript" src="/JS/getCinemaOfCity.js?v=20141104"></script>
    <div class="mainbj login">
       
        <div class="login_l"  style="margin-top:20px; height:auto;" >
        	<!-- 哈票登陆 begin -->
       		<div id="con_one_1">
        		    <div class="table_c1">
			           <form id="login_form" action="javascript:void(0);" >
				            <ul>
				                <li>
				                    <span>用户名：</span>
				                    <input onkeydown="fncKeyStop(event)" onpaste="return false" oncopy="return false" onselectstart="return false" ondragstart="return false" oncontextmenu='return false' id="user" name="user" onfocus="valChanges(user)" onblur="valrecover(user,'请输入用户名/手机号');" type="text" class="k_250" value="请输入用户名/手机号" />
				                
				                <li>
				                    <span>密码：</span>
				                  <input onkeydown="fncKeyStop(event)" onpaste="return false" oncopy="return false" onselectstart="return false" ondragstart="return false" oncontextmenu='return false' id="logPwd" name="logPwd" onfocus="valChanges(logPwd)" onblur="valrecover(logPwd,'请输入您的用户密码')" type="password" class="k_250" value="请输入您的用户密码" />
				                    
				                </li>
				                <li>
									<span>验证码:&nbsp;</span>
								<input name="vcodeItem" id="vcodeItem" class="input k_220" style="width: 80px;" maxlength="4" onpaste="return false" oncopy="return false;" type="text" />
								<img src="https://member.hipiao.com/vcode.php" alt="验证码" class="img_yzm" id="vcodeImg"/><a href="javascript:void(0)" onclick="javascript:document.getElementById('vcodeImg').src='https://member.hipiao.com/vcode.php?rand='+Math.random();return false;" id="zs" class="change_yzm">看不清楚，换一张</a><b id="vcode_Msg" style="font-weight: 400;"></b>
								<p class="reg_tips" style="margin-flort:left;margin-left:150px;"><b id="vcodeMsg"></b></p>
				                </li>
				                <!--li>
				                    <span>&nbsp;</span>
				                    <input name="remeber" id="remeber" type="checkbox" value="1" class="rem_me" />在这台电脑上记住我(一个月之内不用再登录)
				                </li-->
				                <li>
				                    <span>&nbsp;</span>
				                    <a href="javascript:void(0)" id="submitId"  onclick="Login.exec('user','logPwd');return false;" class="menu_login" title="立即登录">立即登录</a>
				                  
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


<div class="float_w buy_ts" style="display:none;position:absolute;" id="showCinemaTurnInfo" height="176" width="362" >
	<div class="login_kup">
    	<span>提示</span>
        <!--<a href="https://member.hipiao.com" title="关闭" style="cursor:pointer;">关闭</a>-->
    </div>
    <div class="float_bor">
    	<ul>
        	<li class="first_h">系统已经检测到您的影院卡已经绑定哈票网会员，系统将跳转到哈票会员管理页面！</li>
        </ul>
        <div class="btn_tsk"><a href="https://member.hipiao.com/myhipiao/memberInfo.php" class="but1"><span>确定</span></a></div>
    </div>
</div>
<div class="float_w buy_ts" style="display:none;position:absolute;" id="div_cinemacardlogin" height="176" width="362" >
	<div class="login_kup">
    	<span>提示</span>
        <!--<a href="https://member.hipiao.com" title="关闭" style="cursor:pointer;">关闭</a>-->
    </div>
    <div class="float_bor">
    	<ul>
        	<li class="first_h">正在请求登录，请稍等！</li>
        </ul>
        <div class="btn_tsk"></div>
    </div>
</div>
</body>
