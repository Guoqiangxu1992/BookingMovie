function setTab(name,cursel,n){
			for(i=1;i<=n;i++){
				var menu=document.getElementById(name+i);
				var con=document.getElementById("con_"+name+"_"+i);
				menu.className=i==cursel?"hover":"";
				con.style.display=i==cursel?"block":"none";
			}
		};
		
		
		
		/*
		 * 
		 * ImageScroller - a Image Horizental Scroll Viewer 
		 * Version 0.1
		 * @requires jQuery v1.2.1
		 * 
		 * Copyright (c) 2007 Luan
		 * Email verycss-ok@yahoo.com.cn 
		 * 
		 * Dual licensed under the MIT and GPL licenses:
		 * http://www.opensource.org/licenses/mit-license.php
		 * http://www.gnu.org/licenses/gpl.html
		 * 
		 * Example:
		 *   #viewer {height:100px; width:300px; clear:both; overflow:hidden; border:3px solid #e5e5e5;}
		 *   #viewerFrame {width:505px; clear:both; padding:0;}
		 *   #viewer img {width:90px; height:90px; margin:5px; display:inline; border:0;}
		 *   #viewer a {display:block; float:left; width:100px; height:100px;}
		 *   <script type="text/javascript">
		 *   $(function(){
		 *   	$("#viewer").imageScroller({
		 *   	next:"btn1",
		 *   	prev:"btn2",
		 *   	frame:"viewerFrame",
		 *   	width:100, 
		 *   	child:"a",
		 *   	auto:true
		 *   	});	 
		 *   });
		 *   </script>
		 *   <div id="viewer"><div id="viewerFrame">
		 *   <a href=""><img src="pre1.jpg"></a>
		 *   <a href=""><img src="pre2.jpg"></a>
		 *   <a href=""><img src="pre3.jpg"></a>
		 *   <a href=""><img src="pre4.jpg"></a>
		 *   <a href=""><img src="pre5.jpg"></a>
		 *   </div></div>
		 *   <span id="btn1">prev</span><br/><span id="btn2">next</span>   
		*/

		jQuery.fn.imageScroller = function(params){
			var p = params || {
				next:"right",
				prev:"left",
				frame:"viewerFrame",
				width:120,
				child:"img",
				auto:false
			}; 
			var _btnNext = $("#"+ p.next);
			var _btnPrev = $("#"+ p.prev);
			var _imgFrame = $("#"+ p.frame);
			var _width = p.width;
			var _child = p.child;
			var _auto = p.auto;
			var _itv;
			
			var turnLeft = function(){
				_btnPrev.unbind("click",turnLeft);
				if(_auto) autoStop();
				_imgFrame.animate( {marginLeft:-_width}, 'fast', '', function(){
					_imgFrame.find(_child+":first").appendTo( _imgFrame );
					_imgFrame.css("marginLeft",0);
					_btnPrev.bind("click",turnLeft);
					if(_auto) autoPlay();
				});
			};
			
			var turnRight = function(){
				_btnNext.unbind("click",turnRight);
				if(_auto) autoStop();
				_imgFrame.find(_child+":last").clone().show().prependTo( _imgFrame );
				_imgFrame.css("marginLeft",-_width);
				_imgFrame.animate( {marginLeft:0}, 'fast' ,'', function(){
					_imgFrame.find(_child+":last").remove();
					_btnNext.bind("click",turnRight);
					if(_auto) autoPlay(); 
				});
			};
			
			_btnNext.css("cursor","hand").click( turnRight );
			_btnPrev.css("cursor","hand").click( turnLeft );
			
			var autoPlay = function(){
			  _itv = window.setInterval(turnLeft, 3000);
			};
			var autoStop = function(){
				window.clearInterval(_itv);
			};
			if(_auto)	autoPlay();
		};
		var urlswf='http://city.hipiao.com/res';
		document.write('<div  id="show_video_640" class="fudong_640" style="display:none; ">'+
		  '<div class="fudong_title_640">'+
		     ' <div class="fudong_close_640"><img src="'+urlswf+'/images/fudong-close.jpg"  alt="关闭" onclick="hideDiv(\'show_video_640\',640,503)" style="cursor:pointer;" /></div>'+
		  '</div><div  class="fudong_video_640" id="resetdiv_640"></div></div>');
		var stop = 0;
		var sleft = 0;
		// point 弹出层起始位置（点击源） id 
		// alt     弹出层 id 
		function setWin(point,alt,w,h,url){
			//var winH = Math.max($(window).height(),$('body').height());
			var winW = Math.max($(window).width(),$('body').width());
			var winH = Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) +"px";
			//var winW = Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth) + "px";
			  $("<div id='mask' class='mask'></div>").width(winW)  
		                                  .height(winH)  
		                                  .appendTo("body").show()  ;
		    document.getElementById('resetdiv_'+w).innerHTML = '<div style="background-color:#000000" id=viswf_'+w+'></div>';                              
		    //alert($(window).height()+"==="+$('body').height());
		    var altH = ($(window).scrollTop()+($(window).height()-h)/2)+'px';
			stop = $(point).offset().top;
			sleft =$(point).offset().left;
			$('#'+alt).css({
				top:stop,
				left:sleft
			}).animate({
					width:w,
					height:h,
					left:(winW-w)/2,
					top:altH,
					opacity: 'show'
			},100,function(){
				var flashvars = {};
				flashvars.flvPath = url;
				//flashvars.imgPath = "http://movie.hipiao.com/style/wait.jpg";
				flashvars.stylepath = urlswf+"/flash/news/style/CBar/CBarSkin.swf";
				flashvars.configpath = urlswf+"/flash/news/config_"+w+".xml";

				//flashvars.autoPlay = "false";
				var params = {};
				params.allowfullscreen = "false";
				params.scale = "noscale";
				params.bgcolor = "#000000"; 
				params.salign = "tl";
				var attributes = {};
				attributes.id = "flvShow";
				swfobject.embedSWF(urlswf+"/flash/news/hipiao_new.swf", "viswf_"+w, "100%", "100%", "9.0.0", urlswf+"/flash/news/expressInstall.swf", flashvars, params, attributes);		
			});
		};

		var alertDiv=null;
		function setWinIndex(divId){
			//var winH = Math.max($(window).height(),$('body').height());
			//var winW = Math.max($(window).width(),$('body').width());
			var winH = Math.max(document.documentElement.scrollHeight, document.documentElement.clientHeight) +"px";
			var winW = Math.max(document.documentElement.scrollWidth, document.documentElement.clientWidth) + "px";
			if($("#mask").length <= 0){
				$("<div id='mask' class='mask'></div>").width(winW).height(winH).appendTo("body").show();
				//$("body").append("<div id = 'tsk_ts' class='tsk_ts'><span id = 'tsk_bj_r' class='tsk_bj_r change'><span id = 'tsk_bj_l' class='tsk_bj_l change'></span></span></div>");
			}
			//$("<div id='mask' class='mask'></div>").width(winW).height(winH).appendTo("body").show();  
			
			alertDiv=document.getElementById(divId);
			s=alertDiv.style;
			s.zIndex = 1000;
			s.display = "block";
			var dd= document.documentElement;

			var alertDivWidth = alertDiv.offsetWidth;
			var alertDivHeight = alertDiv.offsetHeight;
			//console.log(alertDivWidth);
			if(new RegExp('(chrome)|(Safari)','gi').test(navigator.userAgent)){
				s.left = document.body.scrollLeft + (dd.clientWidth - alertDivWidth) / 2+"px";
				s.top = document.body.scrollTop + (dd.clientHeight - alertDivHeight) / 2+"px";
			}else {
				s.left = dd.scrollLeft + (dd.clientWidth - alertDivWidth) / 2+"px";
				s.top = dd.scrollTop + (dd.clientHeight - alertDivHeight) / 2+"px";
			}
			$(alertDiv).show();
			dd=null;

			resizeAction=window.onresize;
			window.onresize=sizefreshnew;
			scrollAction=window.onscroll;
			window.onscroll=sizefreshnew;
			return true;
		};

		function sizefreshnew(){
			if(alertDiv){
				s=alertDiv.style;
				var dd= document.documentElement;

				var alertDivWidth = alertDiv.offsetWidth;
				var alertDivHeight = alertDiv.offsetHeight;
				if(new RegExp('(chrome)|(Safari)','gi').test(navigator.userAgent)){
					s.left = document.body.scrollLeft + (dd.clientWidth - alertDivWidth) / 2+"px";
					s.top = document.body.scrollTop + (dd.clientHeight - alertDivHeight) / 2+"px";
				}else {
					s.left = dd.scrollLeft + (dd.clientWidth - alertDivWidth) / 2+"px";
					s.top = dd.scrollTop + (dd.clientHeight - alertDivHeight) / 2+"px";
				}
				dd=null;
			}
		};

		 function hideDiv(alt,w,h) {
			 var winH = Math.max($(window).height(),$('body').height());
			 var winW = Math.max($(window).width(),$('body').width());
			 swfobject.removeSWF("flvShow"); 
			//alert($('#flvShow').attr('data',''));
			//$('#flvShow').attr('data','')
			//document.getElementById('resetdiv_'+w).innerHTML = '<div style="background-color:#000000" id=viswf_'+w+'></div>';
			$('#'+alt).css({
					left:(winW/2)-(w/2),
					top:(winH/2)-(h/2)
			}).animate({
					width:0,
					height:0,
					top:stop,
					left:sleft,
					opacity: 'hide'
			},70,function(){
				//swfobject.removeSWF("flvShow");
				$("#mask").remove(); 
			});
		}; 