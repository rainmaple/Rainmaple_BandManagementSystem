<%@ page contentType="text/html; charset=UTF-8" language="java" buffer="32kb"%>
<%@ page import="com.tysoft.*"%>
<meta http-equiv="Content-Language" content="zh-cn">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	request.setCharacterEncoding("UTF-8");
	News News1=new News();
	Function fun =new Function();
	String IP =request.getRemoteAddr();
	String AdminName =(String)session.getAttribute("AdminName");
	String bandId =request.getParameter("bandId");
	if(News1.DelBand(bandId, AdminName, IP)){
		out.println("<script>alert('删除乐队成功');location.href='BandIndex.jsp'</script>");
		}
		else{
			out.print("<script>alert('删除乐队失败');location.href='BandIndex.jsp'</script>");
		}
%>
