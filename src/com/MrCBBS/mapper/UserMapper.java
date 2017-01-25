package com.MrCBBS.mapper;

import com.MrCBBS.entities.User;

public interface UserMapper	extends MyBatisSuperMapper
{
	//根据UID获取User实例
	public User selectOneByUID(String UID);
	
	//根据UNickName获取User是否存在
	public Integer selectOneByUNickName(String uNickName);
	public User selectOneByUAccount(String uAccount);

	//根据UNickName获取UID
	public String selectUIDByUNickName(String uNickName);
	
	//插入一条User记录
	public void insertUser(User user);

	//更新一条User记录的密码
	public void updateUserPassWD(User user);
}
