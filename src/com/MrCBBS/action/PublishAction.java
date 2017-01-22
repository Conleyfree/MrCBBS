package com.MrCBBS.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.MrCBBS.Server.CommentService;
import com.MrCBBS.Server.PostService;
import com.MrCBBS.Server.UserService;
import com.MrCBBS.entities.Comment;
import com.MrCBBS.entities.Post;
import com.MrCBBS.entities.User;
import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class PublishAction extends CommonAction
{
	private PostService postService;
	private CommentService commentService;
	private UserService userService;

	private int postId ;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public void setPostService(PostService postService)
	{
		this.postService = postService;
	}

	public void setCommentService(CommentService commentService)
	{
		this.commentService = commentService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public String publishPost() throws Exception{
		String title = request.getParameter("title");
		String topic = request.getParameter("topic");
		String content = request.getParameter("PostContent");
		String knob = request.getParameter("knob");
		
		if(title.equals("") || topic.equals("") || content.equals("") || knob.equals("")){
			return ERROR;
		}
		
		Post post = new Post(Integer.parseInt(knob), title, topic, content);
		
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("User");
		post.setUName(Integer.parseInt(user.getuAccount()));
		post.setPDate(new Date());
		post.setStatus("1");
		
		postService.insertPost(post);
		
		String SM = "成功发布帖子，快去社区看看吧！";
		request.setAttribute("SM", SM);
		return SUCCESS;
	}//end of publishPost
	
	public String showMyPoList() throws Exception{
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("User");
		if(user == null)	return ERROR;
		List<Post> posts = postService.selectPostByUName(user.getuAccount());
		request.setAttribute("Posts", posts);
		return SUCCESS;
	}//end of showMyPo
	
	public String getPo() throws Exception{
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("User");
		if(user == null)	return ERROR;
		String pid = request.getParameter("PID");
		Integer PID = Integer.parseInt(pid);
		Post post = postService.selectPostByPID(PID);
		request.setAttribute("Post", post);
		List<Comment> comments = commentService.selectByPID(PID);
		request.setAttribute("Comments", comments);

		List<String> commentEditors = new ArrayList<>();
		for(int i = 0; i < comments.size(); i++){
			User editor = userService.selectOneByUAccount(comments.get(i).getUName().toString());
			commentEditors.add(editor.getuNickName());
		}
		request.setAttribute("CommentEditors", commentEditors);
		return SUCCESS;
	}//end of getPo
	
	public String showPoListByPKnob() throws Exception{
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("User");
		if(user == null)	return ERROR;
		String pknob = request.getParameter("Pknob");
		Integer PKnob = Integer.parseInt(pknob);
		
		List<Post> posts = postService.selectPostByPKnob(PKnob);
		request.setAttribute("Posts", posts);
		request.setAttribute("Pknob", PKnob);
		return SUCCESS;
	}//end of showPoListByPKnob

	public String likePost() throws  Exception{
		ServletActionContext.getRequest().setAttribute("data", "success");
		Post post = postService.selectPostByPID(postId);
		if(post==null)	return ERROR;
		HttpSession httpSession = request.getSession();
		User operator = (User)httpSession.getAttribute("User");
		if(operator == null)	return ERROR;
		postService.like(post,operator);

		return SUCCESS;
	}

	public String hatePost() throws  Exception{
		ServletActionContext.getRequest().setAttribute("data", "success");
		Post post = postService.selectPostByPID(postId);
		if(post==null)return ERROR;
		HttpSession httpSession = request.getSession();
		User operator = (User)httpSession.getAttribute("User");
		if(operator == null)	return ERROR;
		postService.hate(post,operator);

		return SUCCESS;
	}
}
