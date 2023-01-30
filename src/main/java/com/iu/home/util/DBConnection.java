package com.iu.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	//getConnection
	public static Connection getConnection() throws Exception {
		//1. 연결정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.1.31:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		//2. driver를 메모리에 로딩
		Class.forName(driver);//문자열로 된것을 클래스로 만드는 작업
		
		//3. DB연결
		return DriverManager.getConnection(url, user, password);
		
	}
	
	public static void disConnection(ResultSet rs, PreparedStatement st, Connection con)throws Exception{
		rs.close();
		st.close();
		con.close();
		
	}
	public static void disConnection(PreparedStatement st, Connection con)throws Exception{
	
		st.close();
		con.close();
		
	}

	
	/*
	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection();
			System.out.println(con !=null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}*/
}
