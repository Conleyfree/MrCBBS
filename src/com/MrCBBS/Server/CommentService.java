package com.MrCBBS.Server;

import java.util.List;

import com.MrCBBS.entities.Comment;

public interface CommentService
{
	public void insertComment(Comment comment);

	//根据帖子id获取评论
	public List<Comment> selectByPID(Integer PID);

	//根据用户获取评论
	List<Comment> selectByUAccount(int UAccount);
}
