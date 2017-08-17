package com.sqlconn.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.conn.MySqlConn;


@WebServlet("/sqlConnTest")
public class sqlConnTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResultSet rs;
       
    public sqlConnTest() {
    }


	public void init(ServletConfig config) throws ServletException {
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		 HttpServletRequest hsr= (HttpServletRequest) request;
		 String str1=hsr.getContextPath();
		String str2= hsr.getServletPath();
		
		System.out.println("str1"+str1+","+str2);
			try {
				Statement stmt=MySqlConn.getConnection().createStatement();
			  rs = stmt.executeQuery("select * from tb_b_ft_dept_kpi_esmti");
			  System.out.println("breakpoint2");
			while (rs.next()){
				response.getWriter().write(rs.getInt("dept_id")+","+rs.getString("dept_name")+","+rs.getInt("total_fen")+","+rs.getFloat("charge")+"<br>");
			}
			rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
