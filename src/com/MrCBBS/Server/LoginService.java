package com.MrCBBS.Server;

import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.entities.User;

public interface LoginService
{	
	//登录并返回一个User
	public User login(String username, String password);
}
