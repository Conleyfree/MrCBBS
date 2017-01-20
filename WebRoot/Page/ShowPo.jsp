<%@ page language="java" import="java.util.*,com.MrCBBS.entities.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/base.css"/>
    <script type="text/javascript" src="/MrCBBS/Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="/MrCBBS/Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/formui.css"/>
    <script type="text/javascript" src="/MrCBBS/Scripts/tb.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".datepicker").datepicker();

            $('#list').hide();
            $('#find').click(function () {
                $('#list').show();
            });
        });
        function  onPostLike(postId) {
			$.post("likePost.action",{postId:postId},function(data,status){
				console.log("DlikePost ,Data: " + data + "nStatus: " + status);
			});

		}
		function onPostHate(postId){
			$.post("hatePost.action",{postId:postId},function(data,status){
				console.log("hatePost Data: " + data + "nStatus: " + status);
			});

		}
        function submitComment(){
        	document.getElementById("comment").value = $('#htmlbox_icon_set_green').val();
        	$("form").submit();
        }

    </script>
  </head>
  
  <body>
	    <%	Post post = (Post)request.getAttribute("Post");
	    	List<Comment> comments = (List<Comment>)request.getAttribute("Comments");
			List<String> commentEditors = (List<String>)request.getAttribute("CommentEditors");
	    	HttpSession httpsession = request.getSession();
	    	httpsession.setAttribute("Post",post);
	  		User user = (User)request.getSession().getAttribute("User");
	  		if(user == null)	response.sendRedirect("../login.jsp");
	  	%>
	    <div class="alert alert-info">当前位置<b class="tip"></b>我的帖子<b class="tip"></b>查看帖子</div>
	  	<table class="tbform list">
	        <thead>
	            <tr class="tr">
	                <th colspan="6">帖子全文 <i class="tip-up"></i></th>
	            </tr>
	        </thead>
	    </table>
    	<%	if(Integer.parseInt(post.getStatus()) == -1){	%>
        	<h6>该帖子已经被删！</h6>
        <% 
        }else{ 
        %>
        <font size="6"><a href="#"><%=post.getPTitle() %></a></font><br/>
        <table class="tbform list">
	        <thead>
	            <tr class="tr">
	                <th colspan="6">帖子主题<i class="tip-up"></i></th>
	            </tr>
	        </thead>
	        <tbody>
	        	<tr>
	                <td><a href="WritePo.jsp"><font size="2"><%=post.getPTopic() %></font></a></td>
	            </tr>     
	        </tbody>
        </table>
        
        <!-- 正文区 -->
        <div class="alert alert-info">
        	<font size="4"><%=post.getPContent() %></font><br/>

        	<input class="btn" id="goodbutton" type="button" value="给个赞" onclick="onPostLike(<%=post.getPID() %>)"/>
        	<input class="btn" id="badbutton" type="button" value="踩一下" onclick="onPostHate(<%=post.getPID() %>)"/>
        	<%
        	if( Integer.parseInt(user.getuAccount()) == post.getUName()){//当前用户是帖子作者       		
        	%>	<input class="btn" id="goodbutton" type="button" value="修改" onclick=""/>
            	<input class="btn" id="badbutton" type="button" value="删帖" onclick=""/><% 
        	}
        	%>
        </div><br/>
        
        <!-- 评论区 -->
        <table class="tbform list">
	        <thead>
	            <tr class="tr">
	                <th colspan="6">评论区<i class="tip-up"></i></th>
	            </tr>
	        </thead>
	        <tbody>
	        <!-- 放入评论信息 -->
	        <%
	        	if(comments==null || comments.size()==0){
	        %>
	        	<tr>
	                <td><a href="WritePo.jsp"><font size="2">目前没有人评论</font></a></td>
	            </tr>
	        <% 	
	        	}else{
	        		for(int i = 0; i < comments.size(); i++){
	        %>
	     	        <tr>
	     	        	<th>
	     	        		<font size="2"><%=commentEditors.get(i) %>:</font><br/>
	     	            	<font size="3"><%=comments.get(i).getCContent() %></font>
	     	            </th>
	     	        </tr>
	     	 <% 				
	        		}
	        	}
	        %>	       
	        </tbody>
        </table>
        <!-- 评论编辑区 -->
        <textarea id="htmlbox_icon_set_green" class="text_area2" cols="200" rows="25" name="content"></textarea><br>
        <input class="btn" id="goodbutton" type="button" value="提交评论" onclick="submitComment();"/>
        <form action="publishComment.action" method="post" class="form">
        	<input type="hidden" id="comment" name="comment"/>
        </form>
        <%        	
         }
        %>
  </body>
</html>
