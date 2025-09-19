package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnect {

	public static Connection  get_connect() {
		Connection conn =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodProject","root","sam@55");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	

}
