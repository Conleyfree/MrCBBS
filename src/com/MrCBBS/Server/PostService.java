package com.MrCBBS.Server;

import java.util.List;

import com.MrCBBS.entities.Post;
import com.MrCBBS.entities.User;

public interface PostService
{
	//插入Post实例
	public void insertPost(Post post);
	
	//通过账号获取
	public List<Post> selectPostByUName(String UAccount);
	
	//通过PID获取
	public Post selectPostByPID(Integer PID);
	
	//通过PKnob获取
	public List<Post> selectPostByPKnob(Integer PKnob);


	public void like(Post post,User operator);
	public void hate(Post post,User operator);
}
