<%@ page contentType="text/html; charset=utf-8" language="java" %>
<%@ page import="com.tysoft.*"%>
<%@ include file="Session.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	News bandMember=new News();
	Function fun =new Function();
	String [] sa=null;
	String MemberId =request.getParameter("MemberId");
	String Action =request.getParameter("Action");
	if(Action!=null&&Action.equals("Edit")){
		String IP =request.getRemoteAddr();
		String AdminName =(String)session.getAttribute("AdminName");
		String [] s=new String [3];
		s[0]=request.getParameter("upd_MemberName");
		s[1]=request.getParameter("upd_LeaveTime");
		s[2]=request.getParameter("upd_Workshare");
		String sOk =bandMember.EditBandMember(s, MemberId,AdminName,IP);
		System.out.println("jsp处的MemberId"+MemberId);
		if(sOk.equals("Yes")){
			out.println("<script>alert('修改乐队成员成功');location.href='adminUser.jsp'</script>");
			return;
		}
		else{
			out.println("<script>alert('修改乐队成员信息失败');location.href='adminUser.jsp'</script>");
			return;
		}
	}
%>