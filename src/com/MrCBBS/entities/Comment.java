package com.MrCBBS.entities;

import java.util.Date;

public class Comment
{
	private Long CID;
	private Long PID;
	private Integer UName;	//评价人
	private String CContent;
	private Date CDate;
	private Integer Status;
	
	public Comment(){
		
	}
	public Long getCID()
	{
		return CID;
	}
	public void setCID(Long CID)
	{
		this.CID = CID;
	}
	public Long getPID()
	{
		return PID;
	}
	public void setPID(Long PID)
	{
		this.PID = PID;
	}
	public Integer getUName()
	{
		return UName;
	}
	public void setUName(Integer uName)
	{
		UName = uName;
	}
	public String getCContent()
	{
		return CContent;
	}
	public void setCContent(String cContent)
	{
		CContent = cContent;
	}
	
	public Date getCDate()
	{
		return CDate;
	}
	public void setCDate(Date cDate)
	{
		CDate = cDate;
	}
	public Integer getStatus()
	{
		return Status;
	}
	public void setStatus(Integer status)
	{
		Status = status;
	}	

}
