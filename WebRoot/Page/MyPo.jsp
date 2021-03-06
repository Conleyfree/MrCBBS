<%@ page language="java" import="java.util.*,com.MrCBBS.entities.Post,com.MrCBBS.entities.User" pageEncoding="UTF-8"%>
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
            })
        })

    </script>
  </head>
  
  <body>
  	<%	List<Post> posts = (List<Post>)request.getAttribute("Posts");
  		User user = (User)request.getSession().getAttribute("User");
  		if(user == null)	response.sendRedirect("../login.jsp");
  	%>
    <div class="alert alert-info">当前位置<b class="tip"></b>我的帖子</div>
  	<table class="tbform list">
        <thead>
            <tr class="tr">
                <th colspan="6">全部帖子 <i class="tip-up"></i></th>
            </tr>
        </thead>
        <tbody>
        <%	if(posts.size() == 0){	%>
        	<tr>
                <td><a href="WritePo.jsp">你还没有发过贴子呢！快去发一个吧！</a></td>
            </tr>     
        <% 
        }else{ 
        	for(int i = 0; i < posts.size(); i++){ %>
        		<tr>
                	<td><a style="font-size: large;color: #0b9cd3" href="getPoAction.action?PID=<%=posts.get(i).getPID() %>"><%=posts.get(i).getPTitle() %></a></td>
                    <td>主题:<%=posts.get(i).getPTopic() %></td>
                    <td>赞:<%=posts.get(i).getLikeCount() %></td>
                    <td>踩:<%=posts.get(i).getHateCount() %></td>
            	</tr>

        <%  }      	
         }
        %>
               
        </tbody>
    </table>
  </body>
</html>
