package com.MrCBBS.DAO.Impl;

import java.util.List;

import com.MrCBBS.DAO.PostDAO;
import com.MrCBBS.entities.Post;
import com.MrCBBS.mapper.PostMapper;

public class PostDAOImpl implements PostDAO
{
	private PostMapper postMapper;
	
	public PostMapper getPostMapper()
	{
		return postMapper;
	}

	public void setPostMapper(PostMapper postMapper)
	{
		this.postMapper = postMapper;
	}

	public void insertPost(Post post)
	{
		// TODO Auto-generated method stub
		postMapper.insertPost(post);
	}

	public List<Post> selectPostByUName(String UAccount)
	{
		// TODO Auto-generated method stub
		return postMapper.selectPostByUName(UAccount);
	}

	public Post selectPostByPID(Integer PID)
	{
		// TODO Auto-generated method stub
		return postMapper.selectPostByPID(PID);
	}
	public void update(Post post){
		 postMapper.update(post);
	}
	//通过PKnob获取
	public List<Post> selectPostByPKnob(Integer PKnob){
		return postMapper.selectPostByPKnob(PKnob);
	}
}
