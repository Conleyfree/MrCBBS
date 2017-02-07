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
    <script type="text/javascript" src="Scripts/bootstrap.min.js"></script>

    <!-- js -->
    <script type="text/javascript">
        /*  2017.1.20   17：26
            修改密码
         */
        function modifyPassWD() {
            var oldPassword = $("#oldPassWD").val();
            var newPassword = $("#newPassWD").val();
            var rePassword = $("#rePassWD").val();
            var message = "";
            var statusCode = "";
            $.ajax({
                url:'modifyPasswordAction',
                type:'post',
                async:false,//使代码按顺序执行
                data:{oldPassword:oldPassword,newPassword:newPassword,rePassword:rePassword},
                dataType:'json',
                success:function(data){
                    message = data.message;
                    statusCode = data.statusCode;
                    alert(message);
                    document.getElementById("errorMessage").innerHTML = message;
                }
            });
            if(statusCode == "200")     return true;
            if(statusCode == "300")     return false;

            return false;
        }

        /*  2017.1.21
            修改密码模态框重置按钮
         */
        function reSet() {
            document.getElementById("oldPassWD").value = "";
            document.getElementById("newPassWD").value = "";
            document.getElementById("rePassWD").value = "";
            document.getElementById("errorMessage").innerHTML = "";
        }
    </script>

  </head>
  
  <body>
  
    <div class="warp">
    	<% User user = (User)request.getAttribute("User");
           session.setAttribute("User", user);
            UserPersonal up;
    	   if(user == null){
               RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
               requestDispatcher.forward(request,response);
               //response.sendRedirect("login.jsp");
    	   }else{
              up = user.getUserPersonal();
    	%>
    	<!--头部开始-->
        <div class="top_c">
            <div class="top-menu">
                <ul class="top-menu-nav">
                    <li><a href="#">首页</a></li>
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
                            <li><b class="tip"></b><a target="Conframe" href="getUnreadedMsgAction.action?UName=<%=user.getuAccount()%>">未读信息</a></li>
                            <li><b class="tip"></b><a target="Conframe" href="getReadedMsgAction.action?UName=<%=user.getuAccount()%>">已读信息</a></li>
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
	                        <li><b class="tip"></b><a data-toggle="modal" href="#modifyPassWD">修改密码</a></li>
	                        <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">申请成为版主</a></li>
	                        <li><b class="tip"></b><a target="_parent" href="logout.action">安全退出</a></li>
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
                    	<li><b class="tip"></b><a target="Conframe" href="getUnreadedMsgAction.action?UName=<%=user.getuAccount()%>">未读信息</a></li>
                        <li><b class="tip"></b><a target="Conframe" href="getReadedMsgAction.action?UName=<%=user.getuAccount()%>">已读信息</a></li>
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
                        <li><b class="tip"></b><a data-toggle="modal" href="#modifyPassWD">修改密码</a></li>
	                    <li><b class="tip"></b><a target="Conframe" href="Page/UnFinishPage.jsp">申请成为版主</a></li>
                    	<li><b class="tip"></b><a target="_parent" href="logout.action">安全退出</a></li>
                    </ul>
                </div>

                <!-- 模态框 start 2017.1.20 -->
                <div id="modifyPassWD" class="modal hide fade in" style="display:none">
                    <div class="modal-header" >
                        <a class="close" data-dismiss="modal">×</a>
                        <h3>修改用户密码</h3>
                    </div>
                    <div class="modal-body" >
                         <h4 style="text-align:center;color:red" id="errorMessage"></h4><br/>
                         <h4 style="text-align:center" >原密码：<input id="oldPassWD" type="password" style="width:40%;height:15%" ></h4><br/>
                         <h4 style="text-align:center">新密码：<input id="newPassWD" type="password" style="width:40%;height:15%" ></h4><br/>
                         <h4 style="text-align:center">确认输入：<input id="rePassWD" type="password" style="width:40%;height:15%" ></h4><br/>
                    </div>
                    <div class="modal-footer" >
                        <a href="#" class="btn btn-success" onclick="modifyPassWD()">修改</a>
                        <a href="#" class="btn bt" onclick="reSet()">重置</a>
                    </div>
                </div>
                <!-- 模态框 end 2017.1.20 -->

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

       <% } %>

    </div>
    
  </body>
  
</html>
