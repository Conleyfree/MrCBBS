<%@ page language="java" import="java.util.*,com.MrCBBS.entities.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%	Post post = (Post)request.getAttribute("Post");
		List<Comment> comments = (List<Comment>)request.getAttribute("Comments");
		List<String> commentEditors = (List<String>)request.getAttribute("CommentEditors");
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("Post",post);
		User user = (User)request.getSession().getAttribute("User");
		Admin admin = (Admin)request.getSession().getAttribute("Admin");
		if(user == null && admin == null)	response.sendRedirect("../login.jsp");
	%>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/base.css"/>
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <link rel="stylesheet" type="text/css" href="/MrCBBS/Styles/formui.css"/>

	<script type="text/javascript" src="Scripts/jquery-1.7.2.js"></script>
	<script type="text/javascript" src="Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="Scripts/bootstrap.min.js"></script>
	<script type="text/javascript" src="Scripts/tb.js"></script>
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
		function modifyPost(){
			alert("修改成功");
		}
		function deletePost(){
			alert("删除成功");
		}
		function callPostEditor(){
			var content = window.parent.$('#messageContent').val();
			if(content != null && content.trim() != ""){
				parent.document.getElementById('errorMessage2').innerHTML = "";	// 清空错误信息
				window.parent.$('#messageModal').modal('hide');
				var adminName = '<%=admin==null ? "" :admin.getAname() %>';
				var uid = '<%=post.getUName() %>';
				var pid = '<%=post.getPID() %>';
				/* 发往后台 */
				$.ajax({
					url:'sendMessageAction',
					type:'post',
					async:false,//使代码按顺序执行
					data:{adminName:adminName,uid:uid,pid:pid,content:content},
					dataType:'json',
					success:function(data){
						var message = data.message;
						alert(message);
						parent.document.getElementById("errorMessage2").innerHTML = message;
					}
				});
			}else{
				parent.document.getElementById('errorMessage2').innerHTML = "发送给对方的消息不能为空！！";
			}
		}

		function showMyModal() {
			window.parent.$('#messageModal').modal('show');
		}
		/* 	 	模态框重置按钮	     */
		function reSet() {
			parent.document.getElementById('messageContent').value = "";
			parent.document.getElementById('errorMessage2').innerHTML = "";
		}
    </script>
  </head>
  
  <body>
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

        	<input class="btn btn-primary btn-lg" id="goodbutton" type="button" value="给个赞" onclick="onPostLike(<%=post.getPID() %>)"/>
        	<input class="btn" id="badbutton" type="button" value="踩一下" onclick="onPostHate(<%=post.getPID() %>)"/>
        	<%
				if(user != null){	//用户不是管理员
					if( Integer.parseInt(user.getuAccount()) == post.getUName()){//当前用户是帖子作者
					%>	<input class="btn" id="modifybutton" type="button" value="修改" onclick="modifyPost()"/>
						<input class="btn" id="deletebutton" type="button" value="删贴" onclick="deletePost()"/>
					<%
					}
				}else{	//管理员
					%>  <a  class="btn btn-primary btn-lg" data-toggle="modal" onclick="showMyModal()">告知贴主</a>
						<input class="btn" id="deletebutton" type="button" value="删贴" onclick="deletePost()"/>
						<!-- 管理员发送消息模态框 2017.1.25 -->
						<div id="messageModal" class="modal fade" role="dialog" style="display:none">
							<div class="modal-header" >
								<a class="close" data-dismiss="modal">×</a>
								<h3>发送消息给本贴贴主</h3>
							</div>
							<div class="modal-body" >
								<h4 style="text-align:center;color:red" id="errorMessage"></h4><br/>
								<h4 style="text-align:center">请输入消息内容：<input id="messageContent" type="text" style="width:40%;height:15%" ></h4><br/>
							</div>
							<div class="modal-footer" >
								<a href="#" class="btn btn-success" onclick="callPostEditor()">发送</a>
								<a href="#" class="btn bt" onclick="reSet()">重置</a>
							</div>
						</div>
					<%
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
