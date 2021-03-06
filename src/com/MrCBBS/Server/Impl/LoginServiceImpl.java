package com.MrCBBS.Server.Impl;

import com.MrCBBS.DAO.AdminDAO;
import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.Server.LoginService;
import com.MrCBBS.entities.Admin;
import com.MrCBBS.entities.User;

public class LoginServiceImpl implements LoginService
{
	private UserDAO userDAO;
	private AdminDAO adminDAO;

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public User Ulogin(String username, String password) {
		// TODO Auto-generated method stub
		User user = userDAO.loginUser(username, password);
		//检验用户与密码
		if(user != null){	//获得同样昵称的用户记录
			if(password.endsWith(user.getuPassWD())){	//密码相同，登录成功，返回实例
				return user;
			}
		}
		//否则返回空
		return null;
	}

	@Override
	public Admin Alogin(String adminname, String password) {
		Admin admin = adminDAO.selectAdminByAName(adminname);
		if(admin != null){
			if(password.endsWith(admin.getApasswd())){	//密码相同，登录成功，返回实例
				return admin;
			}
		}
		return null;
	}

}
