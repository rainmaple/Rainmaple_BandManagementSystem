<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="com.tysoft.*"%>
<%@ include file="Session.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	News fans=new News();
	Function fun =new Function();
	String [] sa=null;
	String fansId =request.getParameter("fansId");
	String Action =request.getParameter("Action");
	if(Action!=null&&Action.equals("Edit")){
		String IP =request.getRemoteAddr();
		String AdminName =(String)session.getAttribute("AdminName");
		String [] s=new String [3];
		s[0]=request.getParameter("upd_fansName");
		s[1]=request.getParameter("upd_loveBand");
		s[2]=request.getParameter("upd_loveMember");
		String sOk =fans.Editfans(s, fansId,AdminName,IP);
		System.out.println("jsp处的fansId" + fansId);
		if (sOk.equals("Yes")) {
			out.println("<script>alert('修改个人信息成功');location.href='fansown.jsp'</script>");
			return;
		} else {
			out.println("<script>alert('修改个人信息失败');location.href='fansown.jsp'</script>");
			return;
		}
	}
%>
