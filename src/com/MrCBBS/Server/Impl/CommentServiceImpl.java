package com.MrCBBS.Server.Impl;

import java.util.List;

import com.MrCBBS.DAO.CommentDAO;
import com.MrCBBS.Server.CommentService;
import com.MrCBBS.entities.Comment;

public class CommentServiceImpl implements CommentService
{
	private CommentDAO commentDAO;

	public CommentDAO getCommentDAO()
	{
		return commentDAO;
	}

	public void setCommentDAO(CommentDAO commentDAO)
	{
		this.commentDAO = commentDAO;
	}

	public List<Comment> selectByPID(Integer PID)
	{
		// TODO Auto-generated method stub
		return commentDAO.selectByPID(PID);
	}

	public void insertComment(Comment comment)
	{
		// TODO Auto-generated method stub
		commentDAO.insertComment(comment);
	}

	public List<Comment> selectByUAccount(int UAccount){
		return commentDAO.selectByUAccount(UAccount);
	}

}
