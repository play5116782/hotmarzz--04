package com.hotmarzz.bicyle.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class SqlUtil {
	
	//���ݿ�����
	public static Connection getConn(){
		Connection conn =null;
		
			//����������
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//���ݿ����Ӳ��� url jdbc://localhost:3306/demo root password
			try {
				//loca
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","123456");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return conn;
	}
	//�ر����ݿ�����
	public static void close(Connection conn,PreparedStatement ps, ResultSet rs){
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

