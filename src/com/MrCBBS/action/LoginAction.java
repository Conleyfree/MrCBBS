package com.MrCBBS.action;

import javax.servlet.http.HttpSession;

import com.MrCBBS.Server.LoginService;
import com.MrCBBS.entities.Admin;
import com.MrCBBS.entities.User;

@SuppressWarnings("serial")
public class LoginAction extends CommonAction{

	private String username;
	private String password;
	private String rank;

	private LoginService loginService;

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
		rank = request.getParameter("rank");

		if(Integer.parseInt(rank) == 1){	//管理员用户登录
			Admin admin = loginService.Alogin(username, password);
			if(admin == null){
				String EM = "输入的用户名或密码有误";
				request.setAttribute("SM", EM);
				return ERROR;
			}
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("Admin", admin);
			request.setAttribute("Admin", admin);
			return "1";
		}else{
			User user = loginService.Ulogin(username, password);
			if(user == null){
				String EM = "输入的用户名或密码有误";
				request.setAttribute("SM", EM);
				return ERROR;
			}
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("User", user);
			request.setAttribute("User", user);
			return "2";
		}

	}
}
