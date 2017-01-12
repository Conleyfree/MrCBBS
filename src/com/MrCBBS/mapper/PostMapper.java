package com.MrCBBS.mapper;

import com.MrCBBS.entities.Post;
import java.util.List;

public interface PostMapper extends MyBatisSuperMapper
{
	//插入Post实例
	public Integer insertPost(Post post);
	
	//通过账号获取
	public List<Post> selectPostByUName(String UAccount);
	
	//通过PID获取
	public Post selectPostByPID(Integer PID);
	
	//通过PKnob获取
	public List<Post> selectPostByPKnob(Integer PKnob);

	void update(Post post);
}
