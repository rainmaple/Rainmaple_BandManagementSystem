<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.tysoft.*"%>

<%
	request.setCharacterEncoding("UTF-8");
	News Member=new News();
	Function fun =new Function();
	String AdminName =(String)session.getAttribute("AdminName");
	String AdminID =(String)session.getAttribute("AdminID");

	String Action =request.getParameter("Action");
	if(Action!=null&&Action.equals("Add")){
		String IP =request.getRemoteAddr();
		String [] s=new String [3];
		s[0]=request.getParameter("MemberName");//newtitle
		s[1]=request.getParameter("sex");
		s[2]=request.getParameter("Workshare");
		String sNews =Member.AddMember(s, AdminName, IP,AdminID);
		if(sNews.equals("Yes")){
			out.println("<script>alert('添加乐队成员成功');location.href='adminUser.jsp'</script>");
			return;
		}
		else{
			out.println("<script>alert('添加乐队成员失败');location.href='adminUser.jsp'</script>");
			return;
		}
			
	}

%>