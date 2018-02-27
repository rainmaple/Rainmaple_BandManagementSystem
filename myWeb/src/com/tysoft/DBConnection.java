package com.tysoft;			//指定类所在的包

import java.sql.*;						//导入数据库操作的类
import java.util.*;
import java.io.*;

import com.tysoft.Function;

public class DBConnection					
{

    private String FileName;			//配置文件名
    private int DBType;					//数据库类型
    private Connection conn;			//连接对象
    private String MySqlDriver;			//MYSQL Server驱动程序
    private String MySqlURL; //MYSQL Server连接字符串
    String user="root";
    String password="123456";
   
    public DBConnection()
    {
    	conn = null;
    }

	public  Connection getConn()
	{

	
		return(getConnToMySql());
			
	
	}
	
	//读取数据库配置文件
	public String getPara(String ParaName) 
	{
		FileName="../DBConfig.property";
		Properties prop= new Properties();
		try
		{
			InputStream is=getClass().getResourceAsStream(FileName);
			prop.load(is);
			if(is!=null) is.close();
		}
		catch(Exception e) {
			return "Error!";
		}
		return prop.getProperty(ParaName);
	}
	
	
	
    public Connection getConnToMySql()
    {
		try{
	 		
	    	Class.forName("com.mysql.jdbc.Driver");
	    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webDB?useUnicode=true&characterEncoding=UTF-8",this.user,this.password);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	  
			return conn;
			
    }       
    
}
