package com.fjg.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.jdbc.bean.TestBean;
import com.mysql.conn.MySqlConn;

public class QueryData {
	private String mons;
//	HttpServletRequest req=ServletActionContext.getRequest();
	private List<TestBean> querylist=new ArrayList();
	private String querydata;
	
	public String queryData() throws Exception {
        String sql;
       int param =  Integer.parseInt(ServletActionContext.getRequest().getParameter("mons"));
		Connection conn=MySqlConn.getConnection();
		sql="select * from tb_b_ft_dept_kpi_esmti where month_id=?";
		PreparedStatement prest = conn.prepareStatement(sql);
		prest.setInt(1, param);
		ResultSet rs=prest.executeQuery();
		while(rs.next()) {
			TestBean tablebean=	new TestBean();
			tablebean.setDept_id(rs.getInt("dept_id"));
			tablebean.setCharge(rs.getFloat("charge"));
			tablebean.setDept_name(rs.getString("dept_name"));
			tablebean.setMonth_id(rs.getInt("month_id"));
			tablebean.setTotal_fen(rs.getInt("total_fen"));

			querylist.add(tablebean);
		}

		
	//	JSONObject jsonobj = JSONObject.fromObject(querylist);
		JSONArray jarry = JSONArray.fromObject(querylist);	
		querydata=jarry.toString();
		MySqlConn.realseConn(conn,rs,prest);
		return "success";
		
	}

	public String getMons() {
		return mons;
	}


	public void setMons(String mons) {
		this.mons = mons;
	}

	public String getQuerydata() {
		return querydata;
	}

	public void setQuerydata(String querydata) {
		this.querydata = querydata;
	}

}
