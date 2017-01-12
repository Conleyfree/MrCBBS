package com.MrCBBS.DAO;

import java.util.List;

import com.MrCBBS.entities.Post;


public interface PostDAO
{
	//插入一个Post实例
	public void insertPost(Post post);
	
	//通过账号获取
	public List<Post> selectPostByUName(String UAccount);
	
	//通过PID获取
	public Post selectPostByPID(Integer PID);
	
	//通过PKnob获取
	public List<Post> selectPostByPKnob(Integer PKnob);

	public void update(Post post);
}
