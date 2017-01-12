package com.MrCBBS.mapper;

import java.util.List;

import com.MrCBBS.entities.Comment;

public interface CommentMapper extends MyBatisSuperMapper
{
	public void insertComment(Comment comment);
	
	public List<Comment> selectByPID(Integer PID);

	List<Comment> selectByUAccount(int UAccount);
}
