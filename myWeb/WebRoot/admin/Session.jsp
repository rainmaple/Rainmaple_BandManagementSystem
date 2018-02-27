<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.tysoft.*"%>
<%
	Function Function1 = new Function(); 
	boolean isLogin = Function1.StringToBoolean((String)session.getAttribute("Login"));
	if(!isLogin) 
	{
	
		out.print("<script>alert('请重新登录!');location.href='login.jsp';</script>");
		
	}
%>