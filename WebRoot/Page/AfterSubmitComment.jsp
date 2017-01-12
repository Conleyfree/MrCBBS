<%--
  Created by IntelliJ IDEA.
  User: HandsomeMrChen
  Date: 2016/12/31
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.MrCBBS.entities.Post,com.MrCBBS.entities.User" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>
<body>
    <%	Post post = (Post)request.getSession().getAttribute("Post");
  		User user = (User)request.getSession().getAttribute("User");
  		if(user == null)	response.sendRedirect("../login.jsp");
  	%>

    <div id="content">
        <a href="getPoAction.action?PID=<%=post.getPID() %>" > ^_^ 评论提交成功，点击查看！！</a>
    </div>

</body>
</html>
