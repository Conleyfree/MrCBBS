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
		//ͬʱ�����û���Ϣ��¼
		UserPersonal userPersonal = new UserPersonal();
		userPersonal.setUid(user.getUid());	//����UID
		//��ȡϵͳʱ��
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd");
		userPersonal.setuRegistDate(sdFormatter.format(new Date(System.currentTimeMillis())));
		userPersonal.setuLRestrictDate(null);	//��������ʱ�䣬��ʼֵΪ��
		userPersonal.setuRepTimes(0);	//���ٱ�����
		userPersonal.setuScore(0);		//����
		userPersonal.setuRank(0);		//�ȼ�
		userPersonal.setuPubNum(0);		//����������
		userPersonal.setuGoodNum(0);	//������
		userPersonal.setuBadNum(0);		//������
		userPersonal.setuComNum(0);		//��������
		//���ø���
		userDAO.insertUser(user, userPersonal);
		return true;
	}//end of registNewUser
	
	//�ж�UID�Ƿ��׾�����
	public boolean isExistByUID(String UID)
	{
		// TODO Auto-generated method stub
		return userDAO.isExistByUID(UID);
	}
	
	//�ж�UNickName�Ƿ��׾�����
	public boolean isExistByUNickName(String uNickName)
	{
		// TODO Auto-generated method stub
		return userDAO.isExistByUNickName(uNickName);
	}

}
