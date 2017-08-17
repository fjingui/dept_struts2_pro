package com.jdbc.bean;

import java.io.Serializable;

public class TestBean implements Serializable {
	
    private	int dept_id;
    private String dept_name;
    private int total_fen;
    private Float charge;
    private int month_id;
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public int getTotal_fen() {
		return total_fen;
	}
	public void setTotal_fen(int total_fen) {
		this.total_fen = total_fen;
	}
	public Float getCharge() {
		return charge;
	}
	public void setCharge(Float charge) {
		this.charge = charge;
	}
	public int getMonth_id() {
		return month_id;
	}
	public void setMonth_id(int month_id) {
		this.month_id = month_id;
	}
	

}
