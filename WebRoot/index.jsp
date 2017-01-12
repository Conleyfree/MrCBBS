<%@ page language="java" import="java.util.*,com.MrCBBS.entities.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>MrC BBS首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 导入UI相关文件 -->
	<link rel="stylesheet" type="text/css" href="Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="Styles/base.css" />
    <link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="Styles/ui-lightness/jquery-ui-1.8.22.custom.css" />
    <script type="text/javascript" src="Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="Scripts/jquery-ui-1.8.22.custom.min.js"></script>
    <script type="text/javascript" src="Scripts/index.js"></script>
  </head>
  
  <body>
  
    <div class="warp">
    	<% User user = (User)request.getAttribute("User"); 
    	   if(user == null){
 		   		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
 	   	   		requestDispatcher.forward(request,response);
    	   }
    	   UserPersonal up = user.getUserPersonal();
    	
    	%>
    	<!--头部开始-->
        <div class="top_c">
            <div class="top-menu">
                <ul class="top-menu-nav">
                    <li><a href="index.jsp">首页</a></li>
                    <li><a href="#">我的帖子<i class="tip-up"></i></a>
                     	<ul class="kidc">
                            <li><b class="tip"></b><a target="Conframe" href="findMyPoAction.action">查看帖子</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="WritePo.jsp">发表帖子</a></li>
                        </ul>
                    </li>
                    <li><a href="#">我的评论<i class="tip-up"></i></a>
                    	<ul class="kidc">
                    		<li><b class="tip"></b><a target="Conframe" href="getCommentFromMe.action?UName=<%=user.getuAccount()%>">我的评论</a></li>
                        	<li><b class="tip"></b><a target="Conframe" href="getCommentToMe.action">评论我的</a></li>
                    	</ul>
                    </li>
                    <li><a href="#">我的消息<i class="tip-up"></i></a>
                        <ul class="kidc">
                            <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">未读信息</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">已读信息</a></li>
                        </ul>
                    </li>
                    <li><a href="#">逛逛社区<i class="tip-up"></i></a>
                        <ul class="kidc">
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=1">移动开发版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=2">.NET技术版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=3">数据库开发版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=4">云计算版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=5">Web开发版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=6">硬件/嵌入式开发版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=7">Java技术版块</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=8">开发语言/框架</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=9">Linux/Unix社区</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=10">其他</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=11">生活日常讨论版块</a></li>
                    	</ul>
                    </li>
                    <li><a href="#">辅助功能<i class="tip-up"></i></a>
                        <ul class="kidc">
	                        <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">修改密码</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">申请成为版主</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="login.jsp">安全退出</a></li>
                    	</ul>
                    </li>
                </ul>
            </div>        
            <div class="top-nav" style="width:400">欢迎您，<%=user.getuNickName() %>！&nbsp;&nbsp;我的积分：<%=up.getuScore() %>&nbsp;&nbsp;|我的等级：<%=up.getuRank() %>&nbsp;&nbsp;|<br/>发帖数：<%=up.getuPubNum() %>&nbsp;&nbsp;|评论数：<%=up.getuComNum() %>&nbsp;&nbsp;|被赞数：<%=up.getuGoodNum() %>&nbsp;&nbsp;|被踩数：<%=up.getuBadNum() %><br/></div>
        </div>
        <!--头部结束-->
        
        <!--左边菜单开始-->
        <div class="left_c left">
            <h1>系统操作菜单</h1>
            <div class="acc">
                <div>
                    <a class="one">我的帖子</a>
                    <ul class="kid">
                    	<li><b class="tip"></b><a target="Conframe" href="findMyPoAction.action">查看帖子</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="WritePo.jsp">发表帖子</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">查看评论</a>
                    <ul class="kid">  
                    	<li><b class="tip"></b><a target="Conframe" href="getCommentFromMe.action?UName=<%=user.getuAccount()%>">我的评论</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="getCommentToMe.action">评论我的</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">我的消息</a>
                    <ul class="kid">
                    	<li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">未读信息</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">已读信息</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">逛逛社区</a>
                    <ul class="kid">
                    	<li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=1">移动开发版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=2">.NET技术版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=3">数据库开发版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=4">云计算版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=5">Web开发版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=6">硬件/嵌入式开发版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=7">Java技术版块</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=8">开发语言/框架</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=9">Linux/Unix社区</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=10">其他</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="findPoAction.action?Pknob=11">生活日常讨论版块</a></li>
                    </ul>
                </div>
                <div>
                    <a class="one">辅助功能</a>
                    <ul class="kid">
                        <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">修改密码</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">申请成为版主</a></li>
                    	<li><b class="tip"></b><a target="Conframe" href="login.jsp">安全退出</a></li>
                    </ul>
                </div>
                <div id="datepicker"></div>
            </div>
        </div>
        <!--左边菜单结束-->
        
        <!--右边框架开始-->
        <div class="right_c">
            <div class="nav-tip" onclick="javascript:void(0)">&nbsp;</div>

        </div>
        <div class="Conframe">
            <iframe name="Conframe" id="Conframe"></iframe>
        </div>
        <!--右边框架结束-->
        <!-- -->
        <!--底部开始-->
        <div class="bottom_c">Copyright &copy;3113006216 陈泽川   13级软件工程1班</div>
        <!--底部结束-->
        
    </div>
    
  </body>
  
</html>
