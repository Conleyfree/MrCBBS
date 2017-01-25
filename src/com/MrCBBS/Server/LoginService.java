package com.MrCBBS.Server;

import com.MrCBBS.entities.Admin;
import com.MrCBBS.entities.User;

public interface LoginService
{	
	//登录并返回一个User
	User Ulogin(String username, String password);

	//登录并返回一个Admin
	Admin Alogin(String adminname, String password);
}
