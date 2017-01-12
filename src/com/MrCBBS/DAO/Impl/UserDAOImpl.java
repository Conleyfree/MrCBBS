package com.MrCBBS.DAO.Impl;

import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.entities.User;
import com.MrCBBS.entities.UserPersonal;
import com.MrCBBS.mapper.UserMapper;
import com.MrCBBS.mapper.UserPersonalMapper;

public class UserDAOImpl implements UserDAO
{
	private UserMapper userMapper;
	private UserPersonalMapper userPersonalMapper;
		
	public UserMapper getUserMapper()
	{
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper)
	{
		this.userMapper = userMapper;
	}

	public UserPersonalMapper getUserPersonalMapper()
	{
		return userPersonalMapper;
	}

	public void setUserPersonalMapper(UserPersonalMapper userPersonalMapper)
	{
		this.userPersonalMapper = userPersonalMapper;
	}
	public User selectOneByUAccount(String uAccount){

			return userMapper.selectOneByUAccount(uAccount);
	}

	public void insertUser(User user, UserPersonal userPersonal)
	{
		// TODO Auto-generated method stub
		userMapper.insertUser(user);
		userPersonalMapper.insertUP(userPersonal);
	}

	public void updateUser(User user)
	{
		// TODO Auto-generated method stub

	}
	
	//登录
	public User loginUser(String uNickName, String password)
	{
		// TODO Auto-generated method stub
		String UID = userMapper.selectUIDByUNickName(uNickName);
		System.out.println(UID);

		if(UID != null){
			User user = userMapper.selectOneByUID(UID);
			System.out.println(user);

			user.setUserPersonal(selectUPByUID(user.getUid()));
			return user;
		}
		return null;
	}
	
	public UserPersonal selectUPByUID(String UID){
		return userPersonalMapper.selectUPByUID(UID);
	}

	//判断UID是否易经存在
	public boolean isExistByUID(String UID){
		User user = (User)userMapper.selectOneByUID(UID);
		if(user == null)	return false;
		else {
			return true;
		}
	}
	
	//判断UNickName是否已经存在
	public boolean isExistByUNickName(String uNickName)
	{
		// TODO Auto-generated method stub
		Integer user = userMapper.selectOneByUNickName(uNickName);
		if(user == 0)	return false;
		else {
			return true;
		}
	}

	//更新用户主要信息（昵称、密码）
	public void updateUserPersonal(UserPersonal userPersonal){
		userPersonalMapper.update(userPersonal);
	}

}
