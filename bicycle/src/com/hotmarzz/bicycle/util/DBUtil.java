package com.hotmarzz.bicycle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	//创建数据库连接
	public static Connection getConn(){
		Connection conn = null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			//数据库连接参数 url jdbc:mysql://localhost:3306/demo root password
			//localhost 代表本机的ip地址i
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bicycle", "root", "123456");
		} 
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭数据库连接
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs){
			try {
				if(conn!=null)
					conn.close();
				if(ps!=null)
					ps.close();
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
