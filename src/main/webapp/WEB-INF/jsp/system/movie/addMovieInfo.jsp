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
		var url = " ${xgq}/movie/saveMovieInfo.do";
		common.submitForm2Path('carInfoform', url);
		return;
	}

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
					<span class="label label-success label-mini"><b>新增电影</b></span>
				</header>
				<div class="panel-body">
					<form class="form-horizontal tasi-form" role="form"
						id="carInfoform">
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>电影种类</b></label>
							<div class="col-sm-10">
								<input type="text" id="productType" name="productType"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>电影名称</b></label>
							<div class="col-sm-10">
								<input type="text" id="name" name="name"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>导演</b></label>
							<div class="col-sm-10">
								<input type="text" id="director" name="director"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>主演</b></label>
							<div class="col-sm-10">
								<input type="text" id="tostar" name="tostar"
									class="form-control">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>备注</b></label>
							<div class="col-sm-10">
								<input type="text" id="remark" name="remark"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>官方价</b></label>
							<div class="col-sm-10">
								<input type="text" id="marketPrice" name="marketPrice" class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>会员价</b></label>
							<div class="col-sm-10">
								<input type="text" id="membersPrice" name="membersPrice"
									class="form-control" maxlength="50">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>是否推荐</b></label>
							<div class="col-sm-10">
								<select type="text" id="recommend" name="recommend"
									class="form-control">
									<option value="1">推荐</option>
									<option value="2">不推荐</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 col-sm-2 control-label"><b>内容</b></label>
							<div class="col-sm-10">
								<script id="editor_content" type="text/plain"
									style="width: 90%; height: 300px;">
											</script>
							</div>
						</div>
						<div class="form-group text-center">
							<input type="hidden" id="id" name="id" value="0" /> <input
								type="hidden" name="statement" value="${statement }" /> <input
								type="hidden" name="tourl" value="${tourl }" />
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