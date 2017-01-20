package com.MrCBBS.DAO;

import com.MrCBBS.entities.User;
import com.MrCBBS.entities.UserPersonal;

public interface UserDAO
{
	//根据昵称查找(登陆用)
	User loginUser(String username, String password);

	User selectOneByUID(String UID);
	
	//登陆时根据UID获取UserPersonal
	UserPersonal selectUPByUID(String UID);
	//登陆时根据UAccount(账号)获取User
	User selectOneByUAccount(String uAccount);

	//用户注册时使用的增加用户记录方法
	void insertUser(User user, UserPersonal userPersonal);
	
	//更新用户主要信息（昵称、密码）
	void updateUser(User user);
	//更新用户主要信息（昵称、密码）
	void updateUserPersonal(UserPersonal userPersonal);

	//更改用户密码
	void updateUserPassWD(User user);

	//判断UID是否易经存在
	boolean isExistByUID(String UID);
	
	//判断UNickName是否易经存在
	boolean isExistByUNickName(String uNickName);
}
