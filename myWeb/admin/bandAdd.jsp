<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.tysoft.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	News News1=new News();
	Function fun =new Function();
	String AdminName =(String)session.getAttribute("AdminName");
	String Action =request.getParameter("Action");
	if(Action!=null&&Action.equals("Add")){
		String IP =request.getRemoteAddr();
		String [] s=new String [3];
		s[0]=request.getParameter("leader");//newtitle
		s[1]=request.getParameter("bandName");
		s[2]=request.getParameter("slogan");
		String sNews =News1.AddBand(s, AdminName, IP);
		if(sNews.equals("Yes")){
			out.println("<script>alert('添加乐队成功');location.href='BandIndex.jsp'</script>");
			return;
		}
		else{
			out.println("<script>alert('添加乐队失败');location.href='BandIndex.jsp'</script>");
			return;
		}
			
	}

%>