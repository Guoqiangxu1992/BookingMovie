<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

<title>电影列表</title>
<%@ include file="/WEB-INF/common/common.jsp"%>
<script type="text/javascript" src="${xgq}/js/echart/echarts.min.js"></script>
<script src="${xgq}/js/echart/esl.js"></script>
<script src="${xgq}/js/echart/zrender.js"></script>
<script type="text/javascript" src="${xgq}/js/jquery-1.7.2.min.js"></script>

<script type="text/javascript">
	$(function() {
		show();
	});

</script>
<link rel="stylesheet" type="text/css"
	href="${xgq }/js/paginate/myPagination.css" />
</head>
<body>
	<div style="display: inline">
		<div id="main" style="float: left; width: 1200px; height: 400px;"></div>
		<div id="show" name="show"
			style="float: left; width: 1200px; height: 400px;"></div>
	</div>

	<!-- 主体内容结束 -->
</body>
<script type="text/javascript">
/**
商品销售额数据报表
*/
      var arr1 = [];
	  var arr2 = [];
	  s = [];
       function show() {
       	
           $.ajax({
           	
               type : "post",
               datatype:"json",
               url : '${xgq }/order/getOrderPlanList.do',
               success : function(data) {
            	   var str = eval(eval(data));
            	   for(var i = 0;i<str.length;i++){
            		     arr1.push(str[i].dateStr);
						 arr2.push(parseInt(str[i].number));
						 s.push({value:parseInt(str[i].number),name:str[i].name});
	                     
            	   }
            	   drewChart();
					
                    
               },
               error : function(data) {
                   myChart.hideLoading();
               }
               
           })
           
           
           
            $.ajax({
           	
               type : "post",
               datatype:"json",
               url : '${xgq }/order/getOrderPlanList1.do',
               success : function(data) {
            	   var str = eval(eval(data));
            	   for(var i = 0;i<str.length;i++){
						 s.push({value:parseInt(str[i].movieNum),name:str[i].movieName});
	                     
            	   }
            	   drewChart1();
			
                    
               },
               error : function(data) {
                   myChart.hideLoading();
               }
               
           })
        
        
   
       function drewChart(){
      
               // 基于准备好的dom，初始化echarts图表
               var myChart = echarts.init(document.getElementById('main')); 
              
               var options = {
                       title : {
                           text: '每日销售数量',
                           x:'center'
                       },
                       tooltip : {},
                       xAxis :
                           {
                       	     data:arr1
                            //   //data : '['+arr1+']',
                           } ,
                       yAxis :
                           {
                               type : 'value',
                           },
                       series : [
                           {
                               name:'每日销售数量',
                               type:'bar',
                               data:arr2
                               //data:'['+arr1+']'
                            
                           }]
                   };
               myChart.setOption(options);                
           } ;
           
           
           function drewChart1(){
               
               // 基于准备好的dom，初始化echarts图表
               var myChart1 = echarts.init(document.getElementById('show')); 
              
               option = {
               	    title : {
               	        text: '销售数量占比',
               	        subtext: '',
               	        x:'center'
               	    },
               	    tooltip : {
               	        trigger: 'item',
               	        formatter: "{a} <br/>{b} : {c} ({d}%)"
               	    },
               	    legend: {
               	        orient : 'vertical',
               	        x : 'left',
               	        data:arr1
               	    },
               	    toolbox: {
               	        show : true,
               	        feature : {
               	            mark : {show: true},
               	            dataView : {show: true, readOnly: false},
               	            magicType : {
               	                show: true, 
               	                type: ['pie', 'funnel'],
               	                option: {
               	                    funnel: {
               	                        x: '25%',
               	                        width: '50%',
               	                        funnelAlign: 'left',
               	                        max: 1548
               	                    }
               	                }
               	            },
               	            restore : {show: true},
               	            saveAsImage : {show: true}
               	        }
               	    },
               	    calculable : true,
               	    series : [
               	        {
               	            name:'访问来源',
               	            type:'pie',
               	            radius : '55%',
               	            center: ['50%', '60%'],
               	            data:s
               	        }
               	    ]
               	};
               myChart1.setOption(option);                
           } ; 
       };
</script>
</html>