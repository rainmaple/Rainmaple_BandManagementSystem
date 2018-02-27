<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="javax.imageio.*"%>
<%@ page import="com.tysoft.*"%>

<!DOCTYPE html>
<html>
	<head lang="en">
		<meta charset="UTF-8">
		<title>Rainmaple乐队运营后台</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
<script src="js/Stats.min.js"></script>
<script src="js/TweenMax.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>

$().ready(function() {
// 在键盘按下并释放及提交后验证提交表单
  $("#signupForm").validate({
	    rules: {
	        username: {
	        required: true,
	        minlength: 2
	      },
	     password: {
	        required: true,
	        minlength: 5
	      }   
	      
	    },
	    messages: {
	      username: {
	        required: "请输入用户名",
	        minlength: "用户名至少由两个字母组成"
	      },
	      password: {
	        required: "请输入密码",
	        minlength: "密码长度不能小于 5 个字母"
	      }
	    }
	});
});
</script>


<link rel="stylesheet" href="css/amazeui.min.css" />
<style>

.header {
	text-align: center;
}

.header h1 {
	font-size: 200%;
	color: #333;
	margin-top: 30px;
}

.header p {
	font-size: 14px;
}
.error{
	color:red;
}
</style>
</head>
	<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires", 0);
	request.setCharacterEncoding("utf-8");						     //设置编码方式为utf-8
	//处理表单，并进行异常处理
	String Action = request.getParameter("Action");
	
	if(Action!=null && Action.equals("Login"))
	{
		String Page1  = (String)request.getHeader("Referer");		//得到页面地址来源
		String Page2  = request.getRequestURL().toString();			//得到当前页面地址
		
		String method = request.getMethod();
		
		if (method.equals("POST") && Page2.equals(Page1))
		{
			try{
				Function Fun = new Function();
				Login login = new Login();
				String IP = request.getRemoteAddr();						//得到客户端Ip地址
				String User = request.getParameter("username");     	        //得到登录用户名
				String Pwd = request.getParameter("password");                   //得到登录密码
				
				
				if (login.LoginCheck(User,Pwd))
				{
					session.setAttribute("Login","Yes");
					session.setAttribute("AdminID",Integer.toString(Fun.AdminID));
					session.setAttribute("AdminType",Integer.toString(Fun.AdminType));
					session.setAttribute("AdminName",User);
					if(Fun.AdminType==1){
						out.println("<SCRIPT LANGUAGE='JavaScript'>alert('登录成功！您的身份为队长');location.href='adminUser.jsp';</SCRIPT>");	
					
					}else if(Fun.AdminType==0){
						out.println("<SCRIPT LANGUAGE='JavaScript'>alert('登录成功！您的身份为超管');location.href='BandIndex.jsp';</SCRIPT>");
					}else if(Fun.AdminType==2){
						out.println("<SCRIPT LANGUAGE='JavaScript'>alert('登录成功！您的身份为粉丝');location.href='fansown.jsp';</SCRIPT>");
					}
					return;
				}
				else 
				{
					out.println("<SCRIPT LANGUAGE='JavaScript'>alert('用户名或密码不正确！');location.href='login.jsp';</SCRIPT>");
					
					return;
				}
			}catch(Exception e){
				out.println("<SCRIPT LANGUAGE='JavaScript'>alert('服务器异常！!');location.href='login.jsp';</SCRIPT>");
					return;
					}
		}
		else
		{
			response.sendError(403,"禁止访问");
			return;
		}
	}
%>

	<body>
		<div class="header">
			<div class="am-g">
				<h1>
					Rainmaple乐队运营后台
				</h1>
			</div>
			<hr />
		</div>
		
		
	




		
		<div class="am-g">
			<div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
				<form action="login.jsp" method="post" id="signupForm" class="am-form login-form" onSubmit="return LoginCheck()">
					<label for="name">
						用户名:
					</label>
					<input type="text" name="username" id="username"  value="">
					<br>
					<label for="ps">
						密码:
					</label>
					<input type="password" name="password"  id="password"  value="">
					<br>

					<br />
					<div class="am-cf">
					
					<input name="Action" type="hidden" value="Login">
					
					
					<input type="submit" value="登 录" id="save"	class="am-btn am-btn-primary am-btn-sm am-fl">

					</div>
				</form>
				
			</div>
		</div>

	</body>


	<script src="js/amazeui.min.js"></script>
<script>
function LoginCheck() 
{   

    var LoginCheck = false;
    if($("#username").val()==="" || $("#password").val()===""){
		alert("用户名或密码不能为空!");
        return false;
	}
    
    return true;
}
</script>
	<!--<![endif]-->
</html>