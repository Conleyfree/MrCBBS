package com.MrCBBS.entities;

import java.util.Date;

public class Post
{
	public Long PID;
	public Integer PKnob;
	public String PTitle;
	public String PTopic; 
	public String PContent; 
	public Integer UName; 
	public Date PDate;
	public Date PCloseDate; 
	public String Status;
	public int likeCount;
	public int hateCount;

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getHateCount() {
		return hateCount;
	}

	public void setHateCount(int hateCount) {
		this.hateCount = hateCount;
	}

	//为mybatis提供无参数构造函数
	public Post(){
		
	}
	
	public Post(Integer PKnob, String PTitle, String PTopic, String PContent){
		this.PKnob = PKnob;
		this.PTitle = PTitle;
		this.PTopic = PTopic;
		this.PContent = PContent;
	}
	
	public Long getPID()
	{
		return PID;
	}
	public void setPID(Long pID)
	{
		PID = pID;
	}
	public Integer getPKnob()
	{
		return PKnob;
	}
	public void setPKnob(Integer pKnob)
	{
		PKnob = pKnob;
	}
	public String getPTitle()
	{
		return PTitle;
	}
	public void setPTitle(String pTitle)
	{
		PTitle = pTitle;
	}
	public String getPTopic()
	{
		return PTopic;
	}
	public void setPTopic(String pTopic)
	{
		PTopic = pTopic;
	}
	public String getPContent()
	{
		return PContent;
	}
	public void setPContent(String pContent)
	{
		PContent = pContent;
	}
	public Integer getUName()
	{
		return UName;
	}
	public void setUName(Integer uName)
	{
		UName = uName;
	}
	public Date getPDate()
	{
		return PDate;
	}
	public void setPDate(Date pDate)
	{
		PDate = pDate;
	}
	public Date getPCloseDate()
	{
		return PCloseDate;
	}
	public void setPCloseDate(Date pCloseDate)
	{
		PCloseDate = pCloseDate;
	}
	public String getStatus()
	{
		return Status;
	}
	public void setStatus(String status)
	{
		Status = status;
	}

}
