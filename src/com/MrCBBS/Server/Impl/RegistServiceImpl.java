package com.MrCBBS.Server.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.Server.RegistService;
import com.MrCBBS.entities.User;
import com.MrCBBS.entities.UserPersonal;

public class RegistServiceImpl implements RegistService
{
	public UserDAO userDAO;
	
	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	public boolean registNewUser(User user)
	{
		// TODO Auto-generated method stub
		//同时生成用户信息记录
		UserPersonal userPersonal = new UserPersonal();
		userPersonal.setUid(user.getUid());	//设置UID
		//获取系统时间
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		userPersonal.setuRegistDate(sdFormatter.format(new Date(System.currentTimeMillis())));
		userPersonal.setuLRestrictDate(null);	//最近被封号时间，初始值为空
		userPersonal.setuRepTimes(0);	//被举报次数
		userPersonal.setuScore(0);		//积分
		userPersonal.setuRank(0);		//等级
		userPersonal.setuPubNum(0);		//发表帖子数
		userPersonal.setuGoodNum(0);	//被赞数
		userPersonal.setuBadNum(0);		//被踩数
		userPersonal.setuComNum(0);		//被评论数
		//调用更新
		userDAO.insertUser(user, userPersonal);
		return true;
	}//end of registNewUser
	
	//判断UID是否易经存在
	public boolean isExistByUID(String UID)
	{
		// TODO Auto-generated method stub
		return userDAO.isExistByUID(UID);
	}
	
	//判断UNickName是否易经存在
	public boolean isExistByUNickName(String uNickName)
	{
		// TODO Auto-generated method stub
		return userDAO.isExistByUNickName(uNickName);
	}

}
