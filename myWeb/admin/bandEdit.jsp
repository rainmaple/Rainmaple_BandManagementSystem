<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="com.tysoft.*"%>
<%@ include file="Session.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	News News1=new News();
	Function fun =new Function();
	String [] sa=null;
	String bandId =request.getParameter("bandId");
	String Action =request.getParameter("Action");
	if(Action!=null&&Action.equals("Edit")){
		String IP =request.getRemoteAddr();
		String AdminName =(String)session.getAttribute("AdminName");
		String [] s=new String [3];
		s[0]=request.getParameter("upd_leader");
		s[1]=request.getParameter("upd_bandName");
		s[2]=request.getParameter("upd_slogan");
		String sOk =News1.EditBand(s, bandId,AdminName,IP);
		System.out.println("jsp处的bandId"+bandId);
		if(sOk.equals("Yes")){
			out.println("<script>alert('修改乐队成功');location.href='BandIndex.jsp'</script>");
			return;
		}
		else{
			out.println("<script>alert('修改乐队失败');location.href='BandIndex.jsp'</script>");
			return;
		}
	}
%>
