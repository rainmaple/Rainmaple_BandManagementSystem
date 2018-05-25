package com.tysoft;
/***工具类***/
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Function {
	DBConnection DBConn = new DBConnection();
	public static int AdminID = 0;
	public static int AdminType = 0;
/**核对登陆状态**/	
	public boolean CheckLogin(Connection conn, String s1, String s2) throws SQLException {
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
		boolean OK = true;
		
		String AdminPwd = "";
		String User = CheckReplace(s1);
		String Pwd = CheckReplace(s2);
		String Sql = "select * from Admin where AdminName='" + User + "'";
		rs = stmt.executeQuery(Sql);
		if (!rs.next()) {
			OK = false;//未找到用户
		} else {
			AdminPwd = rs.getString("AdminPwd");
			if (Pwd.equals(AdminPwd)) {

				AdminID = rs.getInt("AdminID");
				AdminType = rs.getInt("AdminType");
			
				OK = true;
			} else {
				OK = false;
			}
		}
		return OK;

	}
/*对变量进行翻译，翻译成网页字符***/
	public String CheckReplace(String s) {
		try {
			if ((s == null) || (s.equals("")))
				return "";

			StringBuffer stringbuffer = new StringBuffer();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch (c) {
				case '"':
					stringbuffer.append("&quot;");
					break;
				case '\'':
					stringbuffer.append("&#039;");
					break;
				case '|':
					stringbuffer.append("");
					break;
				case '&':
					stringbuffer.append("&amp;");
					break;
				case '<':
					stringbuffer.append("&lt;");
					break;
				case '>':
					stringbuffer.append("&gt;");
					break;
				default:
					stringbuffer.append(c);
				}
			}

			return stringbuffer.toString().trim();
		} catch (Exception e) {
		}
		return "";
	}

	public String CheckDate(String[] s1, String[] s2) {
		boolean OK = true;
		StringBuffer sb = new StringBuffer();
		try {
			for (int i = 0; i < s1.length; i++) {
				if ((s1[i] == null) || (s1[i].equals(""))
						|| (s1[i].equals(" "))) {
					sb.append("<li> [ " + s2[i] + " ] 不能为空!");
					OK = false;
				}
			}
			if (OK)
				return "Yes";
			return sb.toString().trim();
		} catch (Exception e) {
		}
		return "操作失败！";
	}

	public String getStrCN(String s) {
		
		return s;
	}
/*String 转 int**/
	public int StrToInt(String s) {
		try {
			return Integer.parseInt(CheckReplace(s));
		} catch (Exception e) {
		}
		return 0;
	}

	public boolean StringToBoolean(String s) {
		if ((s != null) && (s.equals("Yes")))
			return true;
		return false;
	}
/**分页逻辑**/
	public String Page(String sPage, ResultSet rs, int intPage, int intPageSize) {
		StringBuffer sb = new StringBuffer();
		String s = null;

		int i = 0;
		try {
			rs.last();

			int intRowCount = rs.getRow();
			int intPageCount;
			if (intRowCount % intPageSize == 0)
				intPageCount = intRowCount / intPageSize;
			else
				intPageCount = (int) Math.floor(intRowCount / intPageSize) + 1;
			if (intPageCount == 0)
				intPageCount = 1;

			if (intPage < 1)
				intPage = 1;
			if (intPage > intPageCount)
				intPage = intPageCount;

			if (intRowCount > intPageSize) {
				s = "<table class=\"am-table am-table-striped\" width=\"90%\"  border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"0\"><tr>";
				s = s+ "<td width=\"80%\" height=\"30\" class=\"chinese\"><span class=\"chinese\">";
				s = s + "当前第" + intPage + "页/共" + intPageCount
						+ "页,&nbsp;&nbsp;&nbsp;&nbsp;共" + intRowCount
						+ "条记录,&nbsp;&nbsp;&nbsp;&nbsp;" + intPageSize + "条/页";

				int showye = intPageCount;
				if (showye > 10)
					showye = 10;
				for (i = 1; i <= showye; i++)
					;
				s = s + "</span></td>";
				s = s + "<td width=\"20%\">";
				s = s + "<table width=\"100%\" border=\"0\">";
				s = s + "<tr><td><div align=\"right\"><span class=\"chinese\">";
				s = s+ "<select id=\"ipage\" name=\"ipage\" class=\"chinese\" onChange=\"jumpMenu('self',this,0)\">";
				s = s + "<option value=\"\" selected>请选择</option>";

				for (i = 1; i <= intPageCount; i++) {
					String sSelect = i == intPage ? "SELECTED" : "";
					s = s + "<option value=\"" + sPage + "intPage=" + i + "\""
							+ sSelect + ">第" + i + "页</option>";
				}

				s = s + "</select></span></div>";
				s = s + "</td></tr></table>";
				return s + "</td></tr></table>";
			}

			return "";
		} catch (Exception e) {
		}
		return "分页出错!";
	}

	public String PageFront(String sPage, ResultSet rs, int intPage,
			int intPageSize) {
		StringBuffer sb = new StringBuffer();
		String s = null;

		int i = 0;
		try {
			rs.last();

			int intRowCount = rs.getRow();
			int intPageCount;
			if (intRowCount % intPageSize == 0)
				intPageCount = intRowCount / intPageSize;
			else
				intPageCount = (int) Math.floor(intRowCount / intPageSize) + 1;
			if (intPageCount == 0)
				intPageCount = 1;

			if (intPage < 1)
				intPage = 1;
			if (intPage > intPageCount)
				intPage = intPageCount;

			if (intRowCount > intPageSize) {
				s = "<table  width=\"90%\"  border=\"0\" align=\"left\" cellpadding=\"2\" cellspacing=\"0\"><tr>";
				s = s+ "<td style=\"text-align:left\" width=\"80%\" height=\"30\" class=\"chinese\"><span class=\"chinese\">";
				s = s + "当前第" + intPage + "页/共" + intPageCount
						+ "页,&nbsp;&nbsp;&nbsp;&nbsp;共" + intRowCount
						+ "条记录,&nbsp;&nbsp;&nbsp;&nbsp;" + intPageSize
						+ "条/页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";

				int showye = intPageCount;
				if (showye > 10)
					showye = 10;
				for (i = 1; i <= showye; i++) {
					if (i == intPage)
						s = s + " " + i + " ";
					else {
						s = s + "&nbsp; <a style=\"color:#3F862E\" href=\""
								+ sPage + "intPage=" + i + "\">" + i + "</a> ";
					}
				}
				s = s + "</span></td>";

				return s + "</tr></table>";
			}

			return "";
		} catch (Exception e) {
		}
		return "分页出错!";
	}
/***登陆日志****/
	public boolean AddLog(String[] s) {
		try {
			Connection Conn = this.DBConn.getConn();
			Statement stmt = Conn.createStatement(1004, 1007);
			ResultSet rs = null;
			for (int i = 0; i < s.length; i++) {
				s[i] = getStrCN(CheckReplace(s[i]));
			}
			String sql = "insert into Log (User,LogType,LogTime,IP,Result) values (";
			sql = sql + "'" + s[0] + "',";
			sql = sql + "'" + s[1] + "',";
			sql = sql + "'" + s[2] + "',";
			sql = sql + "'" + s[3] + "',";
			sql = sql + "'" + s[4] + "')";
			stmt.executeUpdate(sql);
			stmt.close();
			Conn.close();
			return true;
		} catch (SQLException e) {
		}finally{
		        stmt.close();
			Conn.close();
		}
		return false;
	}

	public String OutError(String s) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<br><br><table width=\"60%\"  border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
			sb.append("<tr><td align=\"center\" valign=\"top\">\r\n");
			sb.append("<table width=\"90%\"  border=\"1\" align=\"center\" cellpadding=\"6\" cellspacing=\"1\">\r\n");
			sb.append("<tr class=\"chinese\" height=\"25\"><td height=\"27\" background=\"images/bg.gif\" class=\"info\">\r\n");
			sb.append("<div align=\"center\" class=\"title\">错误页面</div></td></tr>\r\n");
			sb.append("<tr class=\"chinese\" height=\"25\"><td><table cellspacing=\"4\" cellpadding=\"1\">\r\n");
			sb.append("<tr><td width=\"511\" height=\"80\" align=\"middle\" valign=\"top\">\r\n");
			sb.append("<p align=\"left\"><span class=\"info1\">操作出错：</span></p><div align=\"left\" class=\"info1\">");
			sb.append(s + "</div></td></tr></table></td></tr>\r\n");
			sb.append("<tr><td background=\"images/bg.gif\" height=\"20\" valign=\"middle\"><div align=\"center\" class=\"chinese\">\r\n");
			sb.append("<a href=\"#\" onClick=\"javascript:history.go(-1)\">返回</a></div></td></tr></table></td></tr></table><br><br>\r\n");
			return sb.toString();
		} catch (Exception e) {
		}
		return "操作出错!";
	}

	public String OutWarn(String s) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("<br><br><form name=\"form1\" method=\"post\" action=\"\">\r\n");
			sb.append("<table border=\"1\" align=\"center\" cellpadding=\"1\" cellspacing=\"2\">\r\n");
			sb.append("<tr><td width=\"400\" height=\"80\" align=\"middle\" valign=\"top\">\r\n");
			sb.append("<div align=\"left\" class=\"info1\">系统警告：<br><br>\r\n");
			sb.append("&nbsp;&nbsp;&nbsp;&nbsp;");
			sb.append(s);
			sb.append("</div></td></tr>\r\n");
			sb.append("<tr><td height=\"20\" align=\"middle\" valign=\"top\"><div align=\"center\">\r\n");
			sb.append("<input name=\"Submit\" type=\"button\" class=\"button\" value=\"取消\" onClick=\"javascript:history.go(-1);\">&nbsp;&nbsp;\r\n");
			sb.append("<input name=\"OK\" type=\"hidden\" id=\"OK\" value=\"Yes\">\r\n");
			sb.append("<input name=\"Submit2\" type=\"submit\" class=\"button\" value=\"确定\">\r\n");
			sb.append("</div></td>\r\n");
			sb.append("</tr></table></form>\r\n");
			return sb.toString();
		} catch (Exception e) {
		}
		return "操作出错!";
	}

}
