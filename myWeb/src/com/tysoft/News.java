package com.tysoft;			

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 业务逻辑层
 * 
 * 
 */
public class News
{

    DBConnection DBConn = new DBConnection();
    Function Fun = new Function(); 
    
    public News()
    {
    	
    } 
   
   
     public String ListBandsFront(String sPage,String strPage)
     {			
 		try
     	{
 			
     		Connection Conn = DBConn.getConn();
 	    	Statement stmt = Conn.createStatement();
 	    	ResultSet rs = null;
     		StringBuffer sb = new StringBuffer();
     		
 			int i;
 			int intPage = 1; 			
 			int intPageSize = 5;
 			
 	    	String sSql = "select * from bandrelation order by bandId desc";
 	    	rs = stmt.executeQuery(sSql);
 	    	
     		
 			if (!rs.next())
 			{ 
 				sb.append("<tr height=\"25\" bgcolor=\"#d6dff7\"  class=\"info1\"><td colspan=\"5\">\r\n");
 				sb.append("<div align=\"center\"><b>没有记录!</b></div></td></tr>\r\n");
 			}
 			else 
 			{
 				
 				intPage = Fun.StrToInt(strPage);
 				sPage = Fun.CheckReplace(sPage);
 				if (intPage==0) intPage=1;	
 	
 				
 				rs.absolute((intPage-1) * intPageSize+1);
 				i = 0; 
 				while(i < intPageSize && !rs.isAfterLast())
 				{		
 					int bandId = rs.getInt("bandId");	
 					String leader = rs.getString("leader");
 					String bandName =rs.getString("bandName") ;
 					String slogan = rs.getString("slogan");
 					//String AdminName = rs.getString("AdminName");
 					
 					
 					sb.append("<tr>");
 					sb.append("<td>"+bandName+"</td>");
 					//sb.append("<td >"+AdminName+"</td>");
 					sb.append("<td >"+leader+"</td>");
 					sb.append("<td >"+slogan+"</td>");
 					sb.append("<td align=\"center\"><a style=\"margin-left:-18px;color:#3F862E\" target=\"_blank\" href=\"bandFrontDetail.jsp?bandId="+bandId+"\">详情</a></td></tr>");
 							
 							
 					
 					rs.next(); 
 					i++;
 				}
 				sb.append(Fun.PageFront(sPage,rs,intPage,intPageSize));
 			}
 			rs.close();
     		stmt.close();
     		Conn.close();
     		return sb.toString();	
     	}catch(Exception e)
         {
             return "No";
         }
     }
     
     
     
     //歌迷信息
     public String ListFansFront(String sPage,String strPage)
     {			
 		try
     	{
 			
     		Connection Conn = DBConn.getConn();
 	    	Statement stmt = Conn.createStatement();
 	    	ResultSet rs = null;
     		StringBuffer sb = new StringBuffer();
     		int i;
 			int intPage = 1; 			
 			int intPageSize = 5;
 			
 			
 	    	String sSql = "select * from fans join Member on fans.loveBand=Member.BandBelong and fans.loveMember=Member.MemberId join BandRelation on Member.BandBelong=BandRelation.bandId order by fansId desc";
 	    	rs = stmt.executeQuery(sSql);
 	    	
     		
 			if (!rs.next())
 			{ 
 				sb.append("<tr height=\"25\" bgcolor=\"#d6dff7\"  class=\"info1\"><td colspan=\"5\">\r\n");
 				sb.append("<div align=\"center\"><b>没有记录!</b></div></td></tr>\r\n");
 			}
 			else 
 			{
 				intPage = Fun.StrToInt(strPage);
 				sPage = Fun.CheckReplace(sPage);
 				if (intPage==0) intPage=1;	
 	
 				
 				rs.absolute((intPage-1) * intPageSize+1);
 				i = 0; 
 				while(i< intPageSize && !rs.isAfterLast())
 				{		
 					int fansId = rs.getInt("fansId");	
 					String fansName = rs.getString("fansName");
 					String sex =rs.getString("sex") ;
 					String loveBand =rs.getString("bandName");//多表连接查询结果，此处不遵循命名一致
 					String loveMember = rs.getString("MemberName");//多表连接查询结果，此处不遵循命名一致
 					//String AdminName = rs.getString("AdminName");
 					
 					
 					sb.append("<tr>");
 					sb.append("<td>"+fansName+"</td>");
 					//sb.append("<td >"+AdminName+"</td>");
 					sb.append("<td >"+sex+"</td>");
 					sb.append("<td >"+loveBand+"</td>");
 					//sb.append("<td ><a style=\"color:#3F862E\" target=\"_blank\" href=\"bandFrontDetail.jsp?bandId="+bandId+"\">详情</a></td></tr>");
 					sb.append("<td align=\"left\" style=\"padding-left:30px;\" >"+loveMember+"</td>");		
 							
 					
 					rs.next(); 
 					i++;
 					
 				}
 				sb.append(Fun.PageFront(sPage,rs,intPage,intPageSize));
 			}
 			rs.close();
     		stmt.close();
     		Conn.close();
     		return sb.toString();	
     	}catch(Exception e)
         {
             
     		e.printStackTrace();
     		return "No";
         }
     }
    
    public String ListBands(String sPage,String strPage)
    {			
		try
    	{
			
    		Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
	    	ResultSet rs = null;
    		StringBuffer sb = new StringBuffer();
    		
			int i;
			int intPage = 1; 			
			int intPageSize = 5;
			
	    	String sSql = "select * from bandrelation order by bandId desc";
	    	rs = stmt.executeQuery(sSql);
	    	
    		
	    	
			if (!rs.next())
			{ 
				sb.append("<tr height=\"25\" bgcolor=\"#d6dff7\"  class=\"info1\"><td colspan=\"4\">\r\n");
				sb.append("<div align=\"center\"><b>没有记录!</b></div></td></tr>\r\n");
			}
			else 
			{
				
				intPage = Fun.StrToInt(strPage);
				sPage = Fun.CheckReplace(sPage);
				if (intPage==0) intPage=1;	
	
				
				rs.absolute((intPage-1) * intPageSize+1);
				i = 0; 
				while(i < intPageSize && !rs.isAfterLast())
				{							
					int bandId = rs.getInt("bandId");	
 					String leader = rs.getString("leader");
 					String bandName =rs.getString("bandName") ;
 					String slogan = rs.getString("slogan");
 					//String AdminName = rs.getString("AdminName");
					
					
					sb.append("<tr>");
					sb.append("<td class=\"table-id\">"+bandId+"</td>");
					
					sb.append("<td>"+leader+"</td>");
					sb.append("<td class=\"table-title\">"+bandName+"</td>");
					sb.append("<td class=\"table-title\">"+slogan+"</td>");
					sb.append("<td><div class=\"am-btn-toolbar\">");
					sb.append("<div class=\"am-btn-group am-btn-group-xs\">");
					sb.append("<input type=\"hidden\" value=\""+bandId+"\">");
					sb.append("<input type=\"hidden\" value=\""+slogan+"\">");
					sb.append("<input type=\"hidden\" value=\""+bandName+"\">");
					sb.append("<a onclick=\"edit(this);\"");
					sb.append("class=\"am-btn am-btn-primary am-btn-xs \"");		
					sb.append("href=\"javascript:void(0);\"> <span></span> 修改 <a> ");			
					sb.append("<a rel=\""+bandId+"\" onclick=\"del(this);\" class=\"am-btn am-btn-danger am-btn-xs \" href=\"javascript:void(0);\"> " +
							"<span></span>删除<a>");			
					sb.append("</div></div></td></tr>");		
							
					
					rs.next(); 
					i++;
				}
				sb.append(Fun.Page(sPage,rs,intPage,intPageSize));
			}
			rs.close();
    		stmt.close();
    		Conn.close();
    		return sb.toString();	
    	}catch(Exception e)
        {
            return "No";
        }
    }
    
    
   /**添加乐队**/ 
  
    public String AddBand(String [] s,String s1,String s2)
    {			
		try
    	{
    		Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
    		
	    	ResultSet rs = null;
	    	String sSql = "select * from BandRelation order by bandId desc";   
	    	rs = stmt.executeQuery(sSql);
	    	int z=0;
	    	int bandNum=0;
	    	if (!rs.next())
			{ 
	    		bandNum=1;
			}else{
				while(z <1  && !rs.isAfterLast())
				{		
				    int bandId = rs.getInt("bandId");
				    bandNum=bandId+1;
					break;
				}
			}
	    	
	    	for(int i=0;i<s.length;i++)
	    	{
	    		if(i!=1) s[i] = Fun.getStrCN(Fun.CheckReplace(s[i]));
	    		else s[i] = Fun.getStrCN(s[i]);
	    	}
	    	
	    	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    	String createTime =  format1.format(new Date());

		    	StringBuffer sql= new StringBuffer();
		    	sql.append("insert into bandRelation (bandId,leader,bandName,slogan,createTime) values (" +
		    			" '"+bandNum+"',"+
		    			" '"+s[0]+"',"+
		    			" '"+s[1]+"'," +
		    			" '"+s[2]+"'," +
		    			" '"+createTime+"')");
		    	
				System.out.println(sql);
				
				try{
					
					Conn.setAutoCommit(false);
					stmt.execute(sql.toString());
					Conn.commit();
					Conn.setAutoCommit(true);
					stmt.close();
					Conn.close();
					
			    	return "Yes";
			    }catch (Exception e) {
						Conn.rollback();			
						e.printStackTrace();
						Conn.close();
						return "添加成功!";
						}  
	    }catch(Exception e)
        {
            e.printStackTrace();
            return "添加失败";
        }
     }
    /**添加乐队over**/ 
    
    /**修改乐队**/ 
    
    public String EditBand(String [] s,String s0,String s1,String s2)
    {			
		try
    	{

    		Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
    		
	    	for(int i=0;i<s.length;i++)
	    	{
	    		s[i] = Fun.getStrCN(Fun.CheckReplace(s[i]));
	    	}
	    	
	    	int bandId = Fun.StrToInt(s0);
	    			
	    	StringBuffer sql = new StringBuffer();
	    	sql.append("update BandRelation set leader='"+s[0]+"'" +
	    			   " ,BandName='"+s[1]+"'" +
	    			   " ,slogan='"+s[2]+"'" +
	    			   " where bandId='"+bandId+"'");
			System.out.println(sql);
			stmt.executeUpdate(sql.toString());
			stmt.close();
			Conn.close();

			return "Yes";
		    
	    }catch(Exception e)
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return "编辑错误!";
        }
     }
    
    
    //删除乐队
    public boolean DelBand(String s0,String s1,String s2)
    {
    	
    	try{
	    	Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
	    	int bandId = Fun.StrToInt(s0);
	    	if (bandId==0)
	    		return false;
	    	else
	    	{
			  try{
			    	String sql = "delete from BandRelation where bandId=" + bandId;
			    	
			    	Conn.setAutoCommit(false);
			    	stmt.executeUpdate(sql);
		
			    	Conn.commit();
			    	Conn.setAutoCommit(true);
			    	
					stmt.close();
					Conn.close();
			    	return true;
		    	}catch (Exception e) {
						Conn.rollback();		
						//e.printStackTrace();
						Conn.close();
						return false;
						}  
		    }
    	}catch(Exception e){
    		//e.printStackTrace();
    		//System.out.print(e.getMessage());
    		
    		return false;
    	}
	
	}
    //后台显示乐队成员（队长查看）
    
    public String ListMember(String sPage,String strPage,String LeaderUser)
    {			
		try
    	{
			//select * from fans join Member on fans.loveBand=Member.BandBelong and fans.loveMember=Member.MemberId join BandRelation on Member.BandBelong=BandRelation.bandId order by fansId desc";	
    		Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
	    	ResultSet rs = null;
    		StringBuffer sb = new StringBuffer();
    		
			int i;
			int intPage = 1; 			
			int intPageSize = 5;
			//队长的身份id即为团队id作为查询依据
	    	String sSql = "select * from member join BandRelation on member.BandBelong=BandRelation.bandId where BandRelation.bandid="+LeaderUser+"";
	    	rs = stmt.executeQuery(sSql);
	    	
    		
	    	
			if (!rs.next())
			{ 
				sb.append("<tr height=\"25\" bgcolor=\"#d6dff7\"  class=\"info1\"><td colspan=\"4\">\r\n");
				sb.append("<div align=\"center\"><b>没有记录!</b></div></td></tr>\r\n");
			}
			else 
			{
				
				intPage = Fun.StrToInt(strPage);
				sPage = Fun.CheckReplace(sPage);
				if (intPage==0) intPage=1;	
	
				
				rs.absolute((intPage-1) * intPageSize+1);
				i = 0; 
				while(i < intPageSize && !rs.isAfterLast())
				{		

					int MemberId = rs.getInt("MemberId");	
 					//String leader = rs.getString("leader");
 					String MemberName =rs.getString("MemberName") ;
 					//String JoinTime =rs.getString("JoinTime");
 					String LeaveTime =rs.getString("LeaveTime") ;
 					String Workshare = rs.getString("Workshare");
 					//String AdminName = rs.getString("AdminName");
 					
					
					
					sb.append("<tr>");
					sb.append("<td class=\"table-id\">"+MemberId+"</td>");
					
					sb.append("<td>"+MemberName+"</td>");
					
					sb.append("<td class=\"table-title\">"+Workshare+"</td>");
					sb.append("<td class=\"table-title\">"+LeaveTime+"</td>");
					
					sb.append("<td><div class=\"am-btn-toolbar\">");
					sb.append("<div class=\"am-btn-group am-btn-group-xs\">");
					sb.append("<input type=\"hidden\" value=\""+MemberId+"\">");
					sb.append("<input type=\"hidden\" value=\""+Workshare+"\">");
					sb.append("<input type=\"hidden\" value=\""+LeaveTime+"\">");
					sb.append("<a onclick=\"edit(this);\"");
					sb.append("class=\"am-btn am-btn-primary am-btn-xs \"");		
					sb.append("href=\"javascript:void(0);\"> <span></span> 修改 <a> ");			
					sb.append("<a rel=\""+MemberId+"\" onclick=\"del(this);\" class=\"am-btn am-btn-danger am-btn-xs \" href=\"javascript:void(0);\"> " +
							"<span></span>删除<a>");			
					sb.append("</div></div></td></tr>");		
							
					
					rs.next(); 
					i++;
				}
				sb.append(Fun.Page(sPage,rs,intPage,intPageSize));
			}
			rs.close();
    		stmt.close();
    		Conn.close();
    		return sb.toString();	
    	}catch(Exception e)
        {
    		e.printStackTrace();
            return "No";
        }
    }
    //修改乐队成员
    public String EditBandMember(String [] s,String s0,String s1,String s2)
    {			
		try
    	{

    		Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
    		
	    	for(int i=0;i<s.length;i++)
	    	{
	    		s[i] = Fun.getStrCN(Fun.CheckReplace(s[i]));
	    	}
	    	
	    	int MemberId = Fun.StrToInt(s0);
	    			
	    	StringBuffer sql = new StringBuffer();
	    	sql.append("update Member set MemberName='"+s[0]+"'" +
	    			   " ,LeaveTime='"+s[1]+"'" +
	    			   " ,Workshare='"+s[2]+"'" +
	    			   " where MemberId='"+MemberId+"'");
			System.out.println(sql);
			stmt.executeUpdate(sql.toString());
			stmt.close();
			Conn.close();

			return "Yes";
		    
	    }catch(Exception e)
        {
            e.printStackTrace();
            System.out.print(e.getMessage());
            return "编辑错误!";
        }
     }
    
  //删除乐队成员
    public boolean DelBandMember(String s0,String s1,String s2)
    {
    	
    	try{
	    	Connection Conn = DBConn.getConn();
	    	Statement stmt = Conn.createStatement();
	    	int MemberId = Fun.StrToInt(s0);
	    	if (MemberId==0)
	    		return false;
	    	else
	    	{
			  try{
			    	String sql = "delete from Member where MemberId=" + MemberId;
			    	
			    	Conn.setAutoCommit(false);
			    	stmt.executeUpdate(sql);
		
			    	Conn.commit();
			    	Conn.setAutoCommit(true);
			    	
					stmt.close();
					Conn.close();
			    	return true;
		    	}catch (Exception e) {
						Conn.rollback();		
						//e.printStackTrace();
						Conn.close();
						return false;
						}  
		    }
    	}catch(Exception e){
    		//e.printStackTrace();
    		//System.out.print(e.getMessage());
    		
    		return false;
    	}
	
	}
    
    
    
   //乐队详情
    public String FrontNewsDetail(String s0)
    {	
    	try{
	    	Connection Conn = DBConn.getConn();
	    	Statement stmt= Conn.createStatement();
	    	ResultSet rs=null;
	    
			
	    	
	    	int bandId = Fun.StrToInt(s0);
	    	if (bandId==0)
	    		return "No";
	    	
	    	else
	    	{
				try{
					
			    	String sql = "select  * from member where BandBelong=" + bandId;
			    	
			    
			    	int i=0;
			    	rs=stmt.executeQuery(sql);
			    	while(!rs.next()){
			    		i++;
			    		
			    		
			    	}
			    	
			    	StringBuffer sb= new StringBuffer();
			    	
			    	int count=0;
					
					while (count<i+2&&!rs.isAfterLast()) {
						//rs.next();
						String imageUrl =rs.getString("memberPicture");
						String flag="在职";
						
						String Workshare =rs.getString("Workshare");
						String MemberName = rs.getString("MemberName");
						String JoinTime = rs.getString("JoinTime");
						String LeaveTime = rs.getString("LeaveTime");
						
						String [] Worksharecontent=Workshare.split("#");
						sb.append("<image style=\"height:160px;width:120px; margin-top:30px;\" src=\""+ imageUrl+ "\"></image>");
						sb.append("<span style=\"font-size:28px;margin-left:35%;margin-top:-60px;\">"+ MemberName+ "</span>");
						sb.append("<br><h2 style=\"font-size:18px;float:right;margin-left:30%\">入职时间："+ JoinTime+ "</h2>");
						if(LeaveTime!=null){
							
							sb.append("<br><h2 style=\"font-size:18px;float:right;margin-left:30%\">已经离职——离职时间为"+ LeaveTime+ "</h2>");
							
						}
						
						sb.append("<br><h2 style=\"font-size:18px;\">分工：</h2>");
						for(int j=0;j<Worksharecontent.length;j++){
							sb.append("<p style=\"text-align:center\">"+Worksharecontent[j]+"</p>");
						}
						sb.append("<br><h2 style=\"font-size:18px;float:right;margin-top:30px;\"></h2><br>");
						count++;
						rs.next();
					}
			    			
					rs.close();
		     		stmt.close();
		     		Conn.close();
			    	return sb.toString();
					
		    	}catch (Exception e) {
		    		e.printStackTrace();
						Conn.rollback();		//JDBC回滚
						Conn.close();
						return "No";
						}  
		    }
    	}catch(Exception e){
    		
    		return "No";
    	}
	
	}



/**列表粉丝信息****/
public String Listfans(String sPage,String strPage,String fansId)
{			
	try
	{
		
		Connection Conn = DBConn.getConn();
    	Statement stmt = Conn.createStatement();
    	ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		
		int i;
		int intPage = 1; 			
		int intPageSize = 5;
		
    	String sSql = "select * from fans join Member on fans.loveMember=Member.MemberId join BandRelation on fans.loveBand=BandRelation.BandId where fansId="+fansId+" ";
    	rs = stmt.executeQuery(sSql);
    	
		
    	
		if (!rs.next())
		{ 
			sb.append("<tr height=\"25\" bgcolor=\"#d6dff7\"  class=\"info1\"><td colspan=\"4\">\r\n");
			sb.append("<div align=\"center\"><b>没有记录!</b></div></td></tr>\r\n");
		}
		else 
		{
			
			intPage = Fun.StrToInt(strPage);
			sPage = Fun.CheckReplace(sPage);
			if (intPage==0) intPage=1;	

			
			rs.absolute((intPage-1) * intPageSize+1);
			i = 0; 
			while(i < intPageSize && !rs.isAfterLast())
			{							
				int fansId1 = rs.getInt("fansId");	
					String loveBandName = rs.getString("BandName");
					String fansName =rs.getString("fansName") ;
					String loveMemberName = rs.getString("MemberName");
				
				
				sb.append("<tr>");
				sb.append("<td class=\"table-id\">"+fansId1+"</td>");
				
				sb.append("<td>"+fansName+"</td>");
				sb.append("<td class=\"table-title\">"+loveBandName+"</td>");
				sb.append("<td class=\"table-title\">"+loveMemberName+"</td>");
				sb.append("<td><div class=\"am-btn-toolbar\">");
				sb.append("<div class=\"am-btn-group am-btn-group-xs\">");
				sb.append("<input type=\"hidden\" value=\""+fansId1+"\">");
				sb.append("<input type=\"hidden\" value=\""+loveMemberName+"\">");
				sb.append("<input type=\"hidden\" value=\""+loveBandName+"\">");
				sb.append("<a onclick=\"edit(this);\"");
				sb.append("class=\"am-btn am-btn-primary am-btn-xs \"");		
				sb.append("href=\"javascript:void(0);\"> <span></span> 修改 <a> ");			
				//sb.append("<a rel=\""+fansId+"\" onclick=\"del(this);\" class=\"am-btn am-btn-danger am-btn-xs \" href=\"javascript:void(0);\"> " +
				//		"<span></span>删除<a>");			
				sb.append("</div></div></td></tr>");		
						
				
				rs.next(); 
				i++;
			}
			sb.append(Fun.Page(sPage,rs,intPage,intPageSize));
		}
		rs.close();
		stmt.close();
		Conn.close();
		return sb.toString();	
	}catch(Exception e)
    {
		e.printStackTrace();
        return "No";
    }
}
/**添加乐队成员**/ 

public String AddMember(String [] s,String s1,String s2,String BandBelong)
{			
	try
	{
		Connection Conn = DBConn.getConn();
    	Statement stmt = Conn.createStatement();
		
    	ResultSet rs = null;
    	String sSql = "select * from Member order by MemberId desc";   
    	rs = stmt.executeQuery(sSql);
    	int z=0;
    	int MemberNum=0;
    	if (!rs.next())
		{ 
    		MemberNum=1;
		}else{
			while(z <1  && !rs.isAfterLast())
			{		
			    int bandId = rs.getInt("MemberId");
			    MemberNum=bandId+1;
				break;
			}
		}
    	
    	for(int i=0;i<s.length;i++)
    	{
    		if(i!=1) s[i] = Fun.getStrCN(Fun.CheckReplace(s[i]));
    		else s[i] = Fun.getStrCN(s[i]);
    	}
    	
    	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    	String createTime =  format1.format(new Date());

	    	StringBuffer sql= new StringBuffer();
	    	sql.append("insert into Member (MemberId,BandBelong,MemberName,sex,Workshare,JoinTime) values (" +
	    			" '"+MemberNum+"',"+
	    			" '"+BandBelong+"',"+
	    			" '"+s[0]+"',"+
	    			" '"+s[1]+"'," +
	    			" '"+s[2]+"'," +
	    			" '"+createTime+"')");
	    	
			System.out.println(sql);
			
			try{
				
				Conn.setAutoCommit(false);
				stmt.execute(sql.toString());
				Conn.commit();
				Conn.setAutoCommit(true);
				stmt.close();
				Conn.close();
				
		    	return "Yes";
		    }catch (Exception e) {
					Conn.rollback();			
					e.printStackTrace();
					Conn.close();
					return "添加成功!";
					}  
    }catch(Exception e)
    {
        e.printStackTrace();
        return "添加失败";
    }
 }
/**添加乐队over**/ 
//修改乐队成员
public String Editfans(String [] s,String s0,String s1,String s2)
{			
	try
	{

		Connection Conn = DBConn.getConn();
    	Statement stmt = Conn.createStatement();
		
    	for(int i=0;i<s.length;i++)
    	{
    		s[i] = Fun.getStrCN(Fun.CheckReplace(s[i]));
    	}
    	
    	int fansId = Fun.StrToInt(s0);
    			
    	StringBuffer sql = new StringBuffer();
    	sql.append("update fans set fansName='"+s[0]+"'" +
    			   " ,loveBand=(select BandId from BandRelation where BandName='"+s[1]+"')" +
    			   " ,loveMember=(select MemberId from Member where MemberName='"+s[2]+"')" +
    			   " where fansId='"+fansId+"'");
		System.out.println(sql);
		stmt.executeUpdate(sql.toString());
		stmt.close();
		Conn.close();

		return "Yes";
	    
    }catch(Exception e)
    {
        e.printStackTrace();
        System.out.print(e.getMessage());
        return "编辑错误!";
    }
 }

}
     