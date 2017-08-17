package com.mysql.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConn {

	 static Connection conn=null;

	public static Connection getConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dept_duty_dab?useSSL=true&serverTimezone=GMT","root","root");
		return conn;
	}
	public static void realseConn(Connection con,ResultSet rs,Statement st) throws SQLException {
		con.close();
		rs.close();
		st.close();
	}
}
