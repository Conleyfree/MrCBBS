package com.MrCBBS.mapper;

import com.MrCBBS.entities.UserPersonal;

public interface UserPersonalMapper extends MyBatisSuperMapper
{
	//注册时插入新的userpersonal记录
	public void insertUP(UserPersonal userPersonal);
	
	public UserPersonal selectUPByUID(String UID);
	public void update(UserPersonal userPersonal);
}
