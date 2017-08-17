package com.fjg.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	private FilterConfig filterconfig;
	private String sessionkey;
	private String redirectUri ;
	private String redirectUrl;
	private Set<String> notCheckList=new HashSet<String>();
	private HttpSession session;
	
	public void destroy() {
		// TODO Auto-generated method stub
		filterconfig=null;
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request= (HttpServletRequest) arg0;
		HttpServletResponse response= (HttpServletResponse) arg1;
		session=request.getSession();
		String passUrl =request.getServletPath();
		if (passUrl.startsWith("/css")||passUrl.startsWith("/js")||passUrl.startsWith("/img")
				||passUrl.startsWith("fonts")) {
			arg2.doFilter(arg0, arg1);
			return;
		}
		if(!checkRequestUrLInNotCheckList(request)&&session.getAttribute("sessionkey")==null){
			response.sendRedirect(request.getScheme()+":"+"//"+request.getServerName()+":"+request.getServerPort()+
					"/f_dept_stuts2"+redirectUri);
			return;
		}
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.filterconfig=arg0;
		sessionkey=arg0.getInitParameter("sessionCheckKey");
		redirectUri=arg0.getInitParameter("redirectUri");
		String notCheckListstr=arg0.getInitParameter("notCheckList");
		if(notCheckListstr!=null) {
			String[] params=notCheckListstr.split(",");
			for(int i=0;i<params.length;i++) {
				notCheckList.add(params[i]);
			}
		}

	}
	public boolean checkRequestUrLInNotCheckList(HttpServletRequest request) {
		String url=request.getServletPath();
		
		return notCheckList.contains(url);
	}

}
