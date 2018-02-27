<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.tysoft.*"%>
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
		
		<script src="js/jquery.min.js">
</script>
 <script src="js/amazeui.min.js"></script>
		<script src="js/tab.js">
</script>
	</head>

	<body>
		<%@ include file="common_header.jsp"%>

		<!--banner-->
		<div class="second_banner">
			<img src="img/bandback1.png" alt="">
		</div>
		<!--//banner-->
		<!--核心竞争力-->
		<div class="container">
			<div class="left">
        <div class="menu_plan">
            <div class="menu_title">乐队粉丝<br><span>list of fans</span></div>
			 <ul id="tab">
                <li ><a href="#">上榜粉丝</a></li>
            </ul>
        </div>
     </div>
     <div class="right">
            <div class="location">
                <span>当前位置：<a href="javascript:void(0)" id="a"><a href="#">粉丝专区</a></a></span>
                <div class="brief" id="b"><a href="#">粉丝一览</a></div>
            </div>
            <div style=" font-size:14px; margin-top:53px; line-height:36px;">
               <div id="tab_con" style="margin-left:-36px;">
                    <div id="tab_con_2" class="dis-n" style="display: none;">
							<table style="margin-top:70px；">
								<tbody>
									<tr class="tt_bg">
										
										<td>
											粉丝名
										</td>
										<td>
											性别
										</td>
										<td>
											喜欢乐队
										</td>
										<td align="left" style="padding-left:10px;">
											最喜欢成员
										</td>
										
									</tr>
									
									<%
										request.setCharacterEncoding("UTF-8"); 
										News news = new News();
										String strPage = request.getParameter("intPage");
										String sPage = request.getContextPath() + request.getServletPath()+ "?";
										String sOK = news.ListFansFront(sPage, strPage);
										if (sOK.equals("No")) {
											out.println("数据服务器出现错误！");
										} else {
											out.println(sOK);
										}
									%>
							</tbody>
							</table>
						</div>
                    
				</div>
            </div>

    </div>
		</div>
		<!--//核心竞争力-->
		<!--底部-->
		<%@ include file="common_footer.jsp"%>
		
	</body>

	<!--//底部-->
	<script>
tabs("#tab", "active", "#tab_con");
</script>


	
</script>

</html>
