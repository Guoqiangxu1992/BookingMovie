<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

<title>电影列表</title>
<%@ include file="/WEB-INF/common/common.jsp"%>
<script type="text/javascript"
	src="${xgq }/common/bootstrap/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script type="text/javascript"
	src="${xgq }/common/bootstrap/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
<script type="text/javascript"
	src="${xgq}/common/bootstrap/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type='text/javascript'
	src="${xgq }/js/paginate/jquery.myPagination.js"></script>
<script type='text/javascript'
	src="${xgq }/js/paginate/commonPagination.js"></script>
<%-- <script type='text/javascript' src="${xgq }/js/myCommon.js"></script> --%>
<script type='text/javascript' src="${xgq }/js/car/carEdit.js"></script>

<script type="text/javascript">
	$(function() {
		// 调用分页控件初始化函数
		COMMON_PAGINATION.init("pagination", 10, search);
		search();

	});
	$(function() {
		$(".form_date").datepicker({
			format : "yyyy-mm-dd",
			showMeridian : true,
			autoclose : true,
			todayBtn : true,
			startDate : "2015-02-14 ",
		});

	});

	function undercarriage(movieId) {
		var base = ' ${xgq }/movie/undercarriage.do';
		var param = {
			movieId : movieId
		}
		common.loadPage(base, param);
	}
	function search() {
		//COMMON_PAGINATION.reset();
		// var loginName = $('#carName').val().trim();
		//var roleId = $('#variableBox option:selected') .val();
		//var startTime = $('#startTime').val();
		//var endTime = $('#endTime').val();
		var param = {
		// 'carInfoDto.carName': carName,
		//'carInfoDto.variableBox' : variableBox
		};
		COMMON_PAGINATION.initParam(param);//@
		var aj = $
				.ajax({
					url : '${xgq}/movie/getMovieHasPublishInformation.do',// 跳转到 action    
					type : 'POST',
					dataType : 'json',
					data : param,
					success : function(data) {
						var str = eval(data);
						if (str != '') {
							$("#taskResult").empty();
							$
									.each(
											str.rows,
											function(n, value) {
												html = "";
												html += '<tr>';
												html += '<td><p class="long_txt">'
														+ value.ID
														+ '</p></td>';
												html += '<td> <p class="long_txt">'
														+ getProductType(value.productType)
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ value.name
														+ '</p></td>';
												
												html += '<td><p class="long_txt">'
														+ value.marketPrice
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ value.membersPrice
														+ '</p></td>';
												if (value.recommed == 0) {
													html += '<td><p class="long_txt">'
															+ '不推荐'
															+ '</p></td>';
												} else {
													html += '<td><p class="long_txt">'
															+ '推荐'
															+ '</p></td>';
												}

												if (value.status == 0) {
													html += '<td><p class="long_txt" style="color:green;">'
															+ '待发布'
															+ '</p></td>';
												} else {
													html += '<td><p class="long_txt" style="color:red;">'
															+ '已发布'
															+ '</p></td>';
												}

												html += '<td><p class="long_txt">'
														+ value.remark
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ formartDate(
																"yyyy-MM-dd HH:mm:ss",
																value.recommendDate.time)
														+ '</p></td>';
														html += '</td><td><button class="btn btn-primary btn-xs"onclick="undercarriage('+ value.ID+ ');"><i class="icon-edit" title="下架">下架</i></button></td>';
												html += '</tr>';
												$("#taskResult").append(html);
											});
							COMMON_PAGINATION.refresh(data);
						}
					}
				});
	}
</script>
<link rel="stylesheet" type="text/css"
	href="${xgq }/js/paginate/myPagination.css" />
</head>
<body>
	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<span class="tools pull-left"> <a class="icon-search"
						style="padding: 10px;" href="javascript:void(0);"
						onclick="goUp(this);">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</span>
				</header>
				


				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>

							<th><i class="icon-bookmark"></i>电影编号</th>
							<th><i class="icon-bookmark"></i>电影种类</th>
							<th><i class="icon-bookmark"></i>电影名称</th>
							<th><i class="icon-bookmark"></i>官方价</th>
							<th><i class="icon-bookmark"></i>会员价</th>
							<th><i class="icon-bookmark"></i>是否推荐</th>
							<th><i class="icon-bookmark"></i>发布状态</th>
							<th><i class="icon-bookmark"></i>备注</th>
							<th><i class="icon-bookmark"></i>推荐时间</th>
							<th><i class="icon-bookmark"></i>操作</th>

						</tr>
					</thead>
					<tbody class="taskResult" name="taskResult" id="taskResult">

					</tbody>
				</table>
			</section>
		</div>
	</div>
	<div class="table_handle page_box clearfix" style="float: right">
		<div class="page-model clearfix financial-record-page fr">
			<div class="yhdbk-page clearfix">
				<div id="pagination" class="pg_right"></div>
			</div>
		</div>
	</div>

	<!-- 主体内容结束 -->
	<!-- 分页 -->
	<input type="hidden" value="searchMenuForm" id="currentFormId" />
</body>
<script type="text/javascript">
	$(document).ready(function() {
		// 调用分页控件初始化函数
		COMMON_PAGINATION.init("pagination", 10, search);
	});

	function getProductType(type) {
		if (type == 1) {
			return '战争片';
		} else if (type == 2) {
			return '爱情片';
		} else if (type == 3) {
			return '喜剧片';
		} else {
			return '喜剧';
		}
	}
</script>
</html>