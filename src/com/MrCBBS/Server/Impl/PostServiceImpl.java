package com.MrCBBS.Server.Impl;

import java.util.List;

import com.MrCBBS.DAO.Appraise4postDAO;
import com.MrCBBS.DAO.PostDAO;
import com.MrCBBS.DAO.UserDAO;
import com.MrCBBS.Server.PostService;
import com.MrCBBS.entities.Appraise4post;
import com.MrCBBS.entities.Post;
import com.MrCBBS.entities.User;
import com.MrCBBS.entities.UserPersonal;

public class PostServiceImpl implements PostService
{
	public void like(Post post,User operator){
		//点赞
		Appraise4post appraise4post=new Appraise4post();
		appraise4post.setUid(operator.getUid());
		appraise4post.setPid(post.getPID());
		//此次点赞
		appraise4postDAO.like(appraise4post);

		UserPersonal owner=userDAO.selectUPByUID(userDAO.selectOneByUAccount(Integer.toString(post.getUName())).getUid());
		//懒得处理，暴力聚合
		owner.setuBadNum(appraise4postDAO.countUserValue(new Appraise4post(null,(short)-1,userDAO.selectOneByUAccount(Integer.toString(post.getUName())).getUid())));
		owner.setuGoodNum(appraise4postDAO.countUserValue(new Appraise4post(null,(short)1,userDAO.selectOneByUAccount(Integer.toString(post.getUName())).getUid())));


		post.setHateCount(appraise4postDAO.countPostValue(new Appraise4post(post.getPID(),(short)-1,null)));
		post.setLikeCount(appraise4postDAO.countPostValue(new Appraise4post(post.getPID(),(short)1,null)));

		userDAO.updateUserPersonal(owner);
		postDAO.update(post);
	}
	public void hate(Post post,User operator){
		//点赞
		Appraise4post appraise4post=new Appraise4post();
		appraise4post.setUid(operator.getUid());
		appraise4post.setPid(post.getPID());
		//此次点赞
		appraise4postDAO.hate(appraise4post);
		UserPersonal owner=userDAO.selectUPByUID(userDAO.selectOneByUAccount(Integer.toString(post.getUName())).getUid());
		//懒得处理，暴力聚合
		owner.setuBadNum(appraise4postDAO.countUserValue(new Appraise4post(null,(short)-1,userDAO.selectOneByUAccount(Integer.toString(post.getUName())).getUid())));
		owner.setuGoodNum(appraise4postDAO.countUserValue(new Appraise4post(null,(short)1,userDAO.selectOneByUAccount(Integer.toString(post.getUName())).getUid())));


		post.setHateCount(appraise4postDAO.countPostValue(new Appraise4post(post.getPID(),(short)-1,null)));
		post.setLikeCount(appraise4postDAO.countPostValue(new Appraise4post(post.getPID(),(short)1,null)));

		userDAO.updateUserPersonal(owner);
		postDAO.update(post);
	}
	private PostDAO postDAO;
	private Appraise4postDAO appraise4postDAO;
	private UserDAO userDAO;

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public Appraise4postDAO getAppraise4postDAO() {
		return appraise4postDAO;
	}

	public void setAppraise4postDAO(Appraise4postDAO appraise4postDAO) {
		this.appraise4postDAO = appraise4postDAO;
	}

	public PostDAO getPostDAO()
	{
		return postDAO;
	}

	public void setPostDAO(PostDAO postDAO)
	{
		this.postDAO = postDAO;
	}

	public void insertPost(Post post)
	{
		// TODO Auto-generated method stub
		postDAO.insertPost(post);
	}

	public List<Post> selectPostByUName(String UAccount)
	{
		// TODO Auto-generated method stub
		return postDAO.selectPostByUName(UAccount);
	}

	public Post selectPostByPID(Integer PID)
	{
		// TODO Auto-generated method stub
		return postDAO.selectPostByPID(PID);
	}
	
	//ͨ��PKnob��ȡ
	public List<Post> selectPostByPKnob(Integer PKnob){
		return postDAO.selectPostByPKnob(PKnob);
	}

}
