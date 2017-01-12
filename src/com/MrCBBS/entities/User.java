package com.MrCBBS.entities;

@SuppressWarnings("serial")
public class User implements java.io.Serializable{
	private String uid;			//ID
	private String uAccount;	//帐号
	private String uPassWD;		//密码
	private Integer uTag;		//标签
	private String uNickName;	//昵称
	private String uEmail;		//申请邮箱
	private UserPersonal userPersonal;
	
	public UserPersonal getUserPersonal()
	{
		return userPersonal;
	}

	public void setUserPersonal(UserPersonal userPersonal)
	{
		this.userPersonal = userPersonal;
	}

	public User(){
		
	}
	
	//构造函数
	public User(String uid, String uNickName,String uPassWD,String uEmail){	//注册时用
		this.uid = uid;
		this.uNickName = uNickName;
		this.uPassWD = uPassWD;
		this.uEmail = uEmail;
	}
	
	//方法
//	public UserPersonal getUserPersonal()
//	{
//		return userPersonal;
//	}
//	public void setUserPersonal(UserPersonal userPersonal)
//	{
//		this.userPersonal = userPersonal;
//	}
	public String getUid()
	{
		return uid;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getuAccount()
	{
		return uAccount;
	}
	public void setuAccount(String uAccount)
	{
		this.uAccount = uAccount;
	}
	public String getuNickName()
	{
		return uNickName;
	}
	public void setuNickName(String uNickName)
	{
		this.uNickName = uNickName;
	}
	public String getuPassWD()
	{
		return uPassWD;
	}
	public void setuPassWD(String uPassWD)
	{
		this.uPassWD = uPassWD;
	}
	public Integer getuTag()
	{
		return uTag;
	}
	public void setuTag(Integer uTag)
	{
		this.uTag = uTag;
	}
	public String getuEmail()
	{
		return uEmail;
	}
	public void setuEmail(String uEmail)
	{
		this.uEmail = uEmail;
	}
	
}
