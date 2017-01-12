<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>登录 MrC BBS</title>   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!-- 导入UI相关文件 -->
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
                    location.href = 'index.jsp';
                }
            })
        })
        
        $(document).ready(function(){
			//先用警告框提醒用户登录
			var fm = $("#SM").val();
			if(fm != null && fm != ""){
				alert(fm);
			}
			
			$("input[type='button']").click(function(){
				var username = $("input[name='username']").val();
				var password = $("input[name='password']").val();
				if(username==""){
					alert("账号不能为空!");
				}else{
					if(password==""){
						alert("请输入密码!");
					}else{
						$("form").submit();
					}
				}
			});
		})
    </script>
  </head>
  
  <body>
  	<%	if(request.getAttribute("SM")!=null && !request.getAttribute("SM").equals("")){
  			System.out.println(request.getAttribute("SM"));
  	%>		
  		<input type="hidden" value=<%=request.getAttribute("SM")%> id="SM"/>
  	<% 	} 	
  	%>
  	
    <div id="clouds" class="stage"></div>
    <div class="loginmain"></div>	
	<div class="row-fluid">
		<h1>MrC BBS</h1>
		<!-- 表单 -->
		<form action="login.action" method="post" class="form">
	        <div class="namediv">
				<label>账&nbsp;号:
				<input type="text" name="username" id="namebox" style="height:10%"/>
				</label>
			</div>
			<div class="passdiv">
				<label>密&nbsp;码:
				<input type="password" name="password" id="passbox" style="height:10%"/>
				</label>
			</div>
			<div class="rankdiv">
				<label>
				<input type="radio" name="rank" value=2 checked="checked"/>
				普通用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="rank" value=1 />
				管理员</label>
			</div>
			<hr/>
	        <div class="buttondiv">
				<input class="btn1" type="submit" value="登&nbsp;录" style="width:20%"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input class="btn2" type="reset" value="重&nbsp;置" style="width:20%"/>
			</div>
		</form>
		<div>
			<label>没有帐号？<a href="/MrCBBS/regist.jsp" style="color: blue">注册一个吧！</a></label>
		</div>
    </div>
  </body>
</html>
