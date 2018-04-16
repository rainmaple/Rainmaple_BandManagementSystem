<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Rainmaple乐队管理公司</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/amazeui.min.css" media="all">
	<link rel="stylesheet" type="text/css" href="css/main.css" media="all">
		<link href="css/main.css" rel="stylesheet" type="text/css">
		<link href="css/container.css" rel="stylesheet" type="text/css">
		<link href="css/reset.css" rel="stylesheet" type="text/css">
		<link href="css/screen.css" rel="stylesheet" type="text/css">
    <style>
     .am-topbar .am-text-ir {
  				display: block;
  				margin-right: 10px;
  				height: 50px;
  				width: 125px;
  				background: url(img/logo1.png) no-repeat left center;
 				 -webkit-background-size: 125px 24px;
 				 background-size: 125px 24px;
				}
     </style>                
  </head>
  
  <body>
  <%@include file="common_header.jsp" %>
    <!--轮播 -->
	<div id="fwslider" style="height: 554px;">
			<div class="slider_container">
				<div class="slide" style=" opacity: 1; z-index: 0; display: none;">
					<img id="img1" src="img/img1.jpg">
				</div>
				<div class="slide" style="opacity: 1; z-index: 1; display: block;">
					<img id="img2" src="img/img2.jpg">
				</div>
				<div class="slide" style="opacity: 1; z-index: 1; display: block;">
					<img id="img3" src="img/img3.jpg">
				</div>
				<div class="slide" style=" opacity: 1;z-index: 0; display: none;">
					<img id="img4" src="img/img4.jpg">
				</div>
				<div class="slide" style=" opacity: 1;z-index: 0; display: none;">
					<img id="img5" src="img/img5.jpg">
				</div>
				
				
				
			</div><!-- container-over -->
			<div class="timers" style="width: 180px;"></div>
				<div class="slidePrev" style="left: 0px; top: 252px;">
					<span></span>
				</div>
				<div class="slideNext" style="right: 0px; top: 252px; opacity: 0.5;">
					<span></span>
				</div>
	</div>
	<!--轮播 -->
	
	<!-- start main-->
		<div class="main_bg">
			<div class="business">
				业务领域 BUSINESS
			</div>
			<div class="wrap w_72">
				<div class="grids_1_of_3">
					<div class="grid_1_of_3  images_1_of_3">
						<img src="img/pic1.png" >

					</div>
					<div class="grid_1_of_3  images_1_of_3">
						<img src="img/pic2.png" >

					</div>
					<div class="grid_1_of_3  images_1_of_3">
						<img src="img/pic3.png" >

					</div>
					<div class="grid_1_of_3  images_1_of_3">
						<img src="img/pic4.png" >

					</div>
					<div class="grid_1_of_3  images_1_of_3"  style="background: none">
						<img src="img/pic5.png" >

					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
<!-- start  main-->
	<div class="address">
				Copyright 2017 Rainmaple乐队管理公司 All Rights.
				<br>
				<a href="http://www.tysoft.com">ty科技有限公司</a> 技术支持 
				<a href="<%=basePath%>/admin/login.jsp">后台</a>
				<br>
			</div>
		<div class="clear"></div>	
  </body>
  <script src="js/jquery.min.js"></script>
  <script src="js/amazeui.min.js"></script>
  <script src="js/jquery-ui.min.js"></script>
  <script src="js/fwslider.js"></script>
</html>
