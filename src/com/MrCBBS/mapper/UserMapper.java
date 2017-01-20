package com.MrCBBS.mapper;

import com.MrCBBS.entities.User;

public interface UserMapper	extends MyBatisSuperMapper
{
	//根据UID获取User实例
	User selectOneByUID(String UID);
	
	//根据UNickName获取User是否存在
	Integer selectOneByUNickName(String uNickName);
	User selectOneByUAccount(String uAccount);

	//根据UNickName获取UID
	String selectUIDByUNickName(String uNickName);
	
	//插入一条User记录
	void insertUser(User user);

	//更新一条User记录的密码
	void updateUserPassWD(User user);
}
