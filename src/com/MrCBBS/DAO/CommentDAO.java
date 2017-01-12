package com.MrCBBS.DAO;

import java.util.List;

import com.MrCBBS.entities.Comment;

public interface CommentDAO
{
	public void insertComment(Comment comment);
	
	public List<Comment> selectByPID(Integer PID);

	List<Comment> selectByUAccount(Integer UAccount);
}
