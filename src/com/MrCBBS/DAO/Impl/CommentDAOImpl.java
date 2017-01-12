package com.MrCBBS.DAO.Impl;

import java.util.List;

import com.MrCBBS.DAO.CommentDAO;
import com.MrCBBS.entities.Comment;
import com.MrCBBS.mapper.CommentMapper;

public class CommentDAOImpl implements CommentDAO
{
	private CommentMapper commentMapper;

	public CommentMapper getCommentMapper()
	{
		return commentMapper;
	}

	public void setCommentMapper(CommentMapper commentMapper)
	{
		this.commentMapper = commentMapper;
	}
	
	public void insertComment(Comment comment)
	{
		// TODO Auto-generated method stub
		commentMapper.insertComment(comment);
	}

	public List<Comment> selectByPID(Integer PID)
	{
		// TODO Auto-generated method stub
		return commentMapper.selectByPID(PID);
	}

	public List<Comment> selectByUAccount(Integer UAccount){
		return commentMapper.selectByUAccount(UAccount);
	}

}
