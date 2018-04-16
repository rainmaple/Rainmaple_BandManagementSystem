<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path;
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, maximum-scale=1">
		<title>Rainmaple乐队管理公司</title>
		
		<link rel="stylesheet" type="text/css" href="css/amazeui.min.css" media="all">
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
		<script src="js/jquery.min.js"></script>
		<script src="js/amazeui.min.js"></script>
		<script src="js/tab.js"></script>
	</head>

	<body>
		
		 <%@ include file="common_header.jsp" %>  
		 
		<!--banner-->
		<div class="second_banner">
			<img src="img/companyback.png" alt="">
		</div>
		<!--//banner-->
		<!--企业简介-->
		<div class="container">

			<div class="left">
				<div class="menu">
					<div class="menu_title">
						企业简介
						<br>
						<span>Company profiles</span>
					</div>
					<ul id="tab">
						<li class="active" onclick="changeValue(this)">
							<a href="javascript:void(0)">企业概况</a>
						</li>
						<li onclick="changeValue(this)">
							<a href="javascript:void(0)">企业代言</a>
						</li>
						
					</ul>
				</div>
			</div>

			<div class="right">
				<div class="location">
					<span>当前位置：<a
						href="#">企业简介</a>
					</span>
					<div class="brief" id="b">
						企业概况
					</div>
					
				</div>
				<div style="font-size: 14px; margin-top: 53px; line-height: 36px;">
					<div id="tab_con">
						<div id="tab_con_1" class="active">
							<br>
							<p>
								公司全称
							</p>
							<p>
								江苏省Rainmaple乐队管理有限公司
							</p>
							<br>
							<p>
								创立时间
							</p>
							<p>
								江苏省Rainmaple乐队管理有限公司创建成立于 2017 年 12 月
							</p>
							<br>
							<p>
								企业定位
							</p>
							<p>
								江苏省Rainmaple乐队管理有限公司是一家经营乐队为核心的企业。
							</p>
							<br>
							<p>
								企业宗旨
							</p>
							
							<p>
								Rainmaple秉承诚信，创新的企业精神，一直致力于为用户提供完美的音乐盛宴。
							</p>
							<br>
							<p>
								企业近况
							</p>
							<p>
								经过不断努力，江苏省Rainmaple乐队管理有限公司旗下乐队在全国举办多场演出，反响热烈。
							</p>
							<br>
							
			
							
						</div>
						<div id="tab_con_2" class="dis-n" style="text-align: center;">
							<img src="img/Jzhou.jpg" alt="" style="margin: 2% 0;">
						</div>

					</div>
				</div>
			</div>
		</div>
		<!--//企业简介-->
		<!--底部-->
		<div class="bottom">
			<div class="footer">
				<div class="gulid">
					<p>
						Copyright 2017 Rainmaple乐队管理有限公司 All Rights.
					</p>
					<p>
						<a href="#">Ty科技</a> 技术支持
					</p>
					<p>
						苏ICP备  66666666号-2  苏公网安备6666666666666号
					</p>
				</div>
			</div>
		</div>

	</body>

	
	
	<!--//底部-->
	<script>
tabs("#tab", "active", "#tab_con");
</script>
	
</script>

</html>
