package com.MrCBBS.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class CommonAction extends ActionSupport implements SessionAware,ServletRequestAware, ServletResponseAware{

	public HttpServletRequest request;
	public Map<String, Object> session;
	public HttpServletResponse response;

	public void setSession(Map<String, Object> arg0)
	{
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	public void setServletRequest(HttpServletRequest arg0)
	{
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0)
	{
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	
}
