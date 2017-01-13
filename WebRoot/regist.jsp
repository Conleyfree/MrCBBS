<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>MrC BBS帐号注册页面</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="Styles/base.css" />
    <link rel="stylesheet" type="text/css" href="Styles/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="Styles/bootstrap.min.css" />
    <script type="text/javascript" src="Scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="Scripts/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="Scripts/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="Styles/login.css" />
    <script type="text/javascript">
        $(function () {
            $('#clouds').pan({ fps: 20, speed: 0.7, dir: 'right', depth: 10 });
            $('.login').click(function () {
                if ($('#uid').val() == "" || $('#pwd').val() == "" || $('#code').val() == "") { $('.tip').html('用户名或密码不可为空！') }
                else {
                    location.href = 'index.html';
                }
            })
        })
        
        $(document).ready(function(){
			//先用警告框提醒用户登录，以后添加提醒界面 czc 2015-8-5
			var fm = $("#EM").val();
			if(fm != null && fm != ""){
				alert(fm);
			}
			
			$("input[type='button']").click(function(){
				var username = $("input[name='nickName']").val();
				var password = $("input[name='passWD']").val();
				var repassword = $("input[name='rePassWD']").val();
				var email = $("input[name='email']").val();
				if(password=="")	alert("密码不能为空!");
				else{
					if(repassword=="")	alert("请输入确认密码!");
					else{
						if(email=="")	alert("注册邮箱不能为空!");
						$("form").submit();
					}
				}								
			});
		})
    </script>
  </head>
  
  <body>
  	<%	if(request.getAttribute("EM")!=null && !request.getAttribute("EM").equals("")){
  			System.out.println(request.getAttribute("EM"));
  	%>		
  		<input type="hidden" value=<%=request.getAttribute("EM")%> id="EM"/>
  	<% 	} 	
  	%>
  	
    <div id="clouds" class="stage"></div>
    <div class="loginmain"></div>	
	<div class="row-fluid">
	<!-- 表单 -->
	<form action="regist.action" method="post" class="form">
	        <h1>MrC BBS</h1>
	        <div class="namediv">
				<label>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:
				<input type="text" name="nickName" id="namebox" style="height:10%"/>
				</label>
			</div>
			<div class="passdiv">
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
				<input type="password" name="passWD" id="passbox" style="height:10%"/>
				</label>
			</div>
			<div class="repassdiv">
				<label>确认密码:
				<input type="password" name="rePassWD" id="repassbox" style="height:10%"/>
				</label>
			</div>
			<div class="emaildiv">
				<label>注册邮箱:
				<input type="text" name="email" id="emailbox" style="height:10%"/>
				</label>
			</div>
			<hr/>
	        <div class="buttondiv">
				<input class="btn1" type="button" value="注&nbsp;册" style="width:20%;center"/>
			</div>
		</form>
    </div>
  </body>
</html>
