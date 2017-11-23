<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>新增汽车信息</title>
<%@ include file="/WEB-INF/common/common.jsp"%>
<script type="text/javascript" charset="utf-8"
	src="${xgq }/common/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${xgq }/common/ueditor/ueditor.all.js">
</script>
<link rel="stylesheet" type="text/css"
	href="${xgq }/common/system/assets/bootstrap-fileupload/bootstrap-fileupload.css" />
<script type="text/javascript"
	src="${xgq }/common/system/assets/bootstrap-fileupload/bootstrap-fileupload.js"></script>
<script type="text/javascript"
	src="${xgq }/common/system/assets/fuelux/js/spinner.min.js"></script>
<script type='text/javascript' src="${xgq }/js/myCommon.js"></script>
<script type="text/javascript">
	function submitform() {
		var d = $("#carInfoform").serialize();
		var url = " ${xgq}/user/updateUser.do";
		common.submitForm2Path('carInfoform', url);
		return;
	}
	
	var password = com.ycx.manager.ClassUtil.convertMD5(SESSION_LOGIN_USER.password); 
	 document.gerElementById('password').value=password;
	function goBack() {
		var base = ' ${xgq }/movie/getMovieInformation.do';
		var param = {
		//carId:carId
		}
		common.loadPage(base, param);
	}
</script>

</head>
<body>
	<!-- 主体内容开始 -->
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<span class="label label-success label-mini"><b>修改个人信息</b></span>
				</header>
				<div class="panel-body">
				
					<form class="form-horizontal tasi-form" role="form"
						id="carInfoform">
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>登录名</b></label>
							<div class="col-sm-10">
								<input type="text" id="loginName" name="loginName" value="${SESSION_LOGIN_USER.loginName}" style="
    width: 259.66666px;
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>真实姓名</b></label>
							<div class="col-sm-10">
								<input type="text" id="name" name="name" value="${SESSION_LOGIN_USER.name}" style="
    width: 259.66666px;
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>电话</b></label>
							<div class="col-sm-10">
								<input type="text" id="phone" name="phone" value="${SESSION_LOGIN_USER.phone}" style="
    width: 259.66666px;
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>邮箱</b></label>
							<div class="col-sm-10">
								<input type="text" id="email" name="email" value="${SESSION_LOGIN_USER.email}" style="
    width: 259.66666px;
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>修改后密码</b></label>
							<div class="col-sm-10">
								<input type="text" id="password" name="password" value="${SESSION_LOGIN_USER.password}" style="
    width: 259.66666px;
									class="form-control">
							</div>
						</div>
						
							<div class="form-group text-center">
							<input  type="hidden"id="userId" name="userId" value="${SESSION_LOGIN_USER.userId}" />
							<button type="button" class="btn btn-info"
								onclick="submitform();">
								<i class="icon-ok"></i><b>&nbsp;提 交</b>
							</button>
							<button type="button" class="btn btn-info" onclick="goBack();">
								<i class="icon-reply"></i><b>&nbsp;返 回</b>
							</button>
						</div>

					</form>
				</div>
			</section>
		</div>
	</div>
	<!-- 主体内容结束 -->

	<script type="text/javascript">
		var ue = UE.getEditor('editor_content');
	</script>
</body>
</html>