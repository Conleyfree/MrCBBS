package com.MrCBBS.DAO;

import com.MrCBBS.entities.User;
import com.MrCBBS.entities.UserPersonal;

public interface UserDAO
{
	//根据昵称查找(登陆用)
	public User loginUser(String username, String password);
	
	//登陆时根据UID获取UserPersonal
	public UserPersonal selectUPByUID(String UID);
	//登陆时根据UID获取UserPersonal
	public User selectOneByUAccount(String uAccount);
	//用户注册时使用的增加用户记录方法
	public void insertUser(User user, UserPersonal userPersonal);
	
	//更新用户主要信息（昵称、密码）
	public void updateUser(User user);
	//更新用户主要信息（昵称、密码）
	public void updateUserPersonal(UserPersonal userPersonal);
	//判断UID是否易经存在
	public boolean isExistByUID(String UID);
	
	//判断UNickName是否易经存在
	public boolean isExistByUNickName(String uNickName);
}
