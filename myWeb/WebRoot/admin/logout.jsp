<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%
	session.setAttribute("Login","");
	session.setAttribute("AdminID","");
	session.setAttribute("AdminType","");
	session.setAttribute("AdminName","");
	out.println("<SCRIPT LANGUAGE='JavaScript'>alert('成功退出系统!');location.href='login.jsp';</SCRIPT>");
	//response.sendRedirect("index.jsp");
%>
