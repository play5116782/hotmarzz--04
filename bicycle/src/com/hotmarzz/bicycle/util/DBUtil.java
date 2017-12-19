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
	//�������ݿ�����
	public static Connection getConn(){
		Connection conn = null;
		try {
			//����������
			Class.forName("com.mysql.jdbc.Driver");
			//���ݿ����Ӳ��� url jdbc:mysql://localhost:3306/demo root password
			//localhost ��������ip��ַi
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
	
	//�ر����ݿ�����
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
