package com.fjg.action;

public class HelloWordAction {
	private String msg;
	
	public String execute() {
		msg="我的第一个STRUTS应用";
		return "success" ;
	}

	public String getMsg() {
		return msg;
	}
}
