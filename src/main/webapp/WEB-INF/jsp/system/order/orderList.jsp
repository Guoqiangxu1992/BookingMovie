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



	
	

	
	function search() {
		var status = $('#status option:selected') .val();
		var param = {
				movieName: $('#name').val().trim(),
				status: status
		};
		COMMON_PAGINATION.initParam(param);//@
		var aj = $
				.ajax({
					url : '${xgq}/order/getOrderList.do',// 跳转到 action    
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
														+ value.id
														+ '</p></td>';
												html += '<td> <p class="long_txt">'
														+ value.memberId
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ value.customerName
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ value.phone
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ value.email
														+ '</p></td>';
												html += '<td><p class="long_txt">'
														+ value.payment
														+ '</p></td>';
												html += '<td><p class="long_txt">'
															+ formartDate(
																	"yyyy-MM-dd HH:mm:ss",
																	value.createDate.time)
															+ '</p></td>';		
												if (value.status == 0) {
													html += '<td><p class="long_txt" style="color:green;">'
															+ '待付款'
															+ '</p></td>';
												} else {
													html += '<td><p class="long_txt" style="color:red;">'
															+ '已付款'
															+ '</p></td>';
												}
												html += '<td><p class="long_txt">'
														+ value.orderNum
														+ '</p></td>';
												html += '<td><p class="long_txt">'
															+ value.originalPrice
															+ '</p></td>';
												html += '<td><p class="long_txt">'
																+ value.price
																+ '</p></td>';	
												html += '<td><p class="long_txt">'
																+ value.movieId
																+ '</p></td>';
												html += '<td><p class="long_txt">'
																	+ value.movieName
																	+ '</p></td>';
																
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
				<div class="panel-body" style="display: none;">
					<form id="myForm" role="form" class="form-inline" method="post">
						<input type="hidden" name="" value="" />
						<div class="form-group">
							<label for="title">电影名称</label> <input type="text"
								placeholder="电影名称" name="name" id="name"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="approvestatus">付款状态</label> <select name="status"
								id="status" class="form-control">
								<option value="">全部</option>
								<option value="0">未付</option>
								<option value="1">已付</option>
							</select>
						</div>

						
						<button style="margin-top: 23px;" class="btn btn-success"
							type="button" onclick="search()">查找</button>
						<button style="margin-top: 23px;" class="btn btn-default"
							type="button" onclick="reset()">重置</button>
					</form>
				</div>
				<table class="table table-striped table-advance table-hover">
					<thead>
						<tr>

							<th><i class="icon-bookmark"></i>订单ID</th>
							<th><i class="icon-bookmark"></i>会员ID</th>
							<th><i class="icon-bookmark"></i>会员姓名</th>
							<th><i class="icon-bookmark"></i>电话号码</th>
							<th><i class="icon-bookmark"></i>邮箱</th>
							<th><i class="icon-bookmark"></i>应付款</th>
							<th><i class="icon-bookmark"></i>下单日期</th>
							<th><i class="icon-bookmark"></i>下单状态</th>
							<th><i class="icon-bookmark"></i>下单数量</th>
							<th><i class="icon-bookmark"></i>原价</th>
							<th><i class="icon-bookmark"></i>会员价</th>
							<th><i class="icon-edit"></i>电影ID</th>
							<th><i class="icon-edit"></i>电影名称</th>
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