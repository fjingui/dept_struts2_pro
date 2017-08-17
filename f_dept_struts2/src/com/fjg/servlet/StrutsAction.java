package com.fjg.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.jdbc.bean.TestBean;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ActionContext;

public class StrutsAction {	
	String months="";
	String dept="";
	List<TestBean> list=new ArrayList();
	List<TestBean> querylist=new ArrayList();
	ActionContext acx=ActionContext.getContext();
//	HttpServletRequest hsre=ServletActionContext.getRequest();
//	HttpServletResponse hsreponse= ServletActionContext.getResponse();

	private String param;
	
	public void connMonth() throws Exception {
		String sql;
		Connection conn=MySqlConn.getConnection();
		sql="select distinct month_id from tb_b_ft_dept_kpi_esmti";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			months+="<option>"+rs.getInt(1)+"</option>";
		}
		acx.getSession().put("months", months);
		MySqlConn.realseConn(conn,rs,st);
	//	return "months";
	}
	public void connDeptname() throws Exception {
		String sql;
		
		Connection conn=MySqlConn.getConnection();
		sql="select distinct dept_name from tb_b_ft_dept_kpi_esmti";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			dept+="<option>"+rs.getString(1)+"</option>";
		}
		acx.getSession().put("dept", dept);
		MySqlConn.realseConn(conn,rs,st);
	 //   return "dept";
	}
	public void connTable() throws Exception {
		String sql;
	    
		Connection conn=MySqlConn.getConnection();
		sql="select * from tb_b_ft_dept_kpi_esmti";
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next()) {
			TestBean tablebean=	new TestBean();
			BeanUtils.setProperty(tablebean, "month_id", rs.getInt("month_id"));
			BeanUtils.setProperty(tablebean, "dept_id", rs.getInt("dept_id"));
			BeanUtils.setProperty(tablebean, "dept_name", rs.getString("dept_name"));
			BeanUtils.setProperty(tablebean, "total_fen", rs.getInt("total_fen"));
			BeanUtils.setProperty(tablebean, "charge", rs.getFloat("charge"));
			
			list.add(tablebean);
		}
		
		acx.getSession().put("list", list);
		MySqlConn.realseConn(conn,rs,st);
		// return "table";
	}
	
	public String execute() throws Exception {
		connMonth();
		connDeptname();
		connTable();
		return "success";
	}

}
