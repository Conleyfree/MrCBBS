package com.MrCBBS.action;

import javax.servlet.http.HttpSession;

import com.MrCBBS.Server.LoginService;
import com.MrCBBS.entities.User;

@SuppressWarnings("serial")
public class LoginAction extends CommonAction{

	private String username;
	private String password;
	private LoginService loginService;
	
	public LoginService getLoginService()
	{
		return loginService;
	}

	public void setLoginService(LoginService loginService)
	{
		this.loginService = loginService;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String execute() throws Exception
	{
		// TODO Auto-generated method stub
		username = request.getParameter("username");
		password = request.getParameter("password");
		User user = loginService.login(username, password);
		if(user == null){
			String EM = "输入的用户名或密码有误";
			request.setAttribute("SM", EM);			
			return ERROR;
		}
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("User", user);
		request.setAttribute("User", user);
		return SUCCESS;
	}
}
