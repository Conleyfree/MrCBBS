package com.MrCBBS.Server;

import com.MrCBBS.entities.User;

public interface RegistService
{
	public boolean registNewUser(User user);
	
	//判断UID是否易经存在
	public boolean isExistByUID(String UID);
	
	//判断UNickName是否易经存在
	public boolean isExistByUNickName(String uNickName);
}
