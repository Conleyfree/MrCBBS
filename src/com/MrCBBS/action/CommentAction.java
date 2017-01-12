package com.MrCBBS.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.MrCBBS.Server.CommentService;
import com.MrCBBS.Server.PostService;
import com.MrCBBS.entities.Comment;
import com.MrCBBS.entities.Post;
import com.MrCBBS.entities.User;

@SuppressWarnings("serial")
public class CommentAction extends CommonAction
{
	private CommentService commentService;
	private PostService postService;

	//提供给Struts2使用
	public void setCommentService(CommentService commentService)
	{
		this.commentService = commentService;
	}
	public void setPostService(PostService postService) {this.postService = postService; }

	// 发表评论
	public String publishComment() throws Exception{
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("User");
		Post post = (Post)httpSession.getAttribute("Post");
		Comment comment = new Comment();
		comment.setUName(Integer.parseInt(user.getuAccount()));
		comment.setPID(post.getPID());
		comment.setCContent(request.getParameter("comment"));
		comment.setCDate(new Date());
		comment.setStatus(1);
		commentService.insertComment(comment);

		return SUCCESS;
	}

	//查找评论
	public String getCommentFromMe() throws Exception{
		String userAccount = request.getParameter("UName");
		List<Comment> comments = commentService.selectByUAccount(Integer.parseInt(userAccount));
		request.setAttribute("myComments", comments);

		List<String> title = new ArrayList<>();
		for(int i = 0; i < comments.size(); i++){		//获取评论对应的帖子题目
			Post post = postService.selectPostByPID(Integer.parseInt(String.valueOf(comments.get(i).getPID())));
			title.add(post.getPTitle());
		}
		request.setAttribute("postTitle", title);
		return SUCCESS;
	}

	public String getCommentToMe() throws Exception{
		HttpSession httpSession = request.getSession();
		User user = (User)httpSession.getAttribute("User");
		String userAccount = user.getuAccount();
		List<Post> posts = postService.selectPostByUName(userAccount);
		List<Comment> comments = new ArrayList<>();
		for(int i = 0; i < posts.size(); i++){
			comments.addAll(commentService.selectByPID(Integer.parseInt(String.valueOf(posts.get(i).getPID()))));
		}

		List<String> title = new ArrayList<>();
		for(int i = 0; i < comments.size(); i++){		//获取评论对应的帖子题目
			if(comments.get(i).getUName().toString().equals(userAccount)){
				comments.remove(i);		//把自己的回复拿掉
				i--;
				continue;
			}
			Post post = postService.selectPostByPID(Integer.parseInt(String.valueOf(comments.get(i).getPID())));
			title.add(post.getPTitle());
		}
		request.setAttribute("commentToMe", comments);
		request.setAttribute("postTitle", title);

		return SUCCESS;
	}
}
