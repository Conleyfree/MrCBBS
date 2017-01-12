package com.MrCBBS.entities;

import java.util.Date;

@SuppressWarnings("serial")
public class UserPersonal implements java.io.Serializable{
	private String uid;
	private String uRegistDate;		//注册时间，非空
	private String uLRestrictDate;	//最近被封号时间，可以为空
	private int uRepTimes;			//实际被举报次数，非空
	private int uScore;				//：用户积分，非空
	private int uRank;				//：等级，非空
	private int uPubNum;			//: 发表帖子数，非空
	private int uComNum;			//：评论数，非空
	private int uGoodNum;			//：被赞数，非空
	private int uBadNum;			//：被踩数，非空
	
	public UserPersonal(){
		
	}
	public int getuGoodNum()
	{
		return uGoodNum;
	}
	public void setuGoodNum(int uGoodNum)
	{
		this.uGoodNum = uGoodNum;
	}
	public int getuBadNum()
	{
		return uBadNum;
	}
	public void setuBadNum(int uBadNum)
	{
		this.uBadNum = uBadNum;
	}
	public String getUid()
	{
		return uid;
	}
	public void setUid(String uid)
	{
		this.uid = uid;
	}
	public String getuRegistDate()
	{
		return uRegistDate;
	}
	public void setuRegistDate(String uRegistDate)
	{
		this.uRegistDate = uRegistDate;
	}
	public String getuLRestrictDate()
	{
		return uLRestrictDate;
	}
	public void setuLRestrictDate(String uLRestrictDate)
	{
		this.uLRestrictDate = uLRestrictDate;
	}
	public int getuRepTimes()
	{
		return uRepTimes;
	}
	public void setuRepTimes(int uRepTimes)
	{
		this.uRepTimes = uRepTimes;
	}
	public int getuScore()
	{
		return uScore;
	}
	public void setuScore(int uScore)
	{
		this.uScore = uScore;
	}
	public int getuRank()
	{
		return uRank;
	}
	public void setuRank(int uRank)
	{
		this.uRank = uRank;
	}
	public int getuPubNum()
	{
		return uPubNum;
	}
	public void setuPubNum(int uPubNum)
	{
		this.uPubNum = uPubNum;
	}
	public int getuComNum()
	{
		return uComNum;
	}
	public void setuComNum(int uComNum)
	{
		this.uComNum = uComNum;
	}

}
