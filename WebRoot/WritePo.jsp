<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script src="/MrCBBS/HtmlBox/js/jquery-1.3.2.min.js"></script>  
    <script type="text/javascript" src="/MrCBBS/HtmlBox/js/htmlbox.colors.js"></script>  
    <script type="text/javascript" src="/MrCBBS/HtmlBox/js/htmlbox.styles.js"></script>  
    <script type="text/javascript" src="/MrCBBS/HtmlBox/js/htmlbox.syntax.js"></script>  
    <script type="text/javascript" src="/MrCBBS/HtmlBox/js/htmlbox.undoredomanager.js"></script>  
    <script type="text/javascript" src="/MrCBBS/HtmlBox/js/htmlbox.min.js"></script>
    
    <script type="text/javascript">
    	$(document).ready(function(){
			/*先用警告框提醒用户登录
			var fm = $("#SM").val();
			if(fm != null && fm != ""){
				alert(fm);
			}*/
			
			if(<%=request.getParameter("SM")%> != null){
				alert(<%=request.getParameter("SM")%>);
			}
			
			$("input[type='submit']").click(function(){
				var title = $("input[name='title']").val();
				var topic = $("input[name='topic']").val();
				var PostContent = $("input[name='PostContent']").val();
				if(title==""){
					alert("贴子题目不能为空!");
				}else{
					if(topic==""){
						alert("贴子主题不能为空!");
					}else{
						if(PostContent==""){
							alert("贴子内容不能为空!");
						}else{
							$("form").submit();
						}						
					}
				}
			});
		})
    
    	function onClickSave(){
			//alert("提交成功!");
    		document.getElementById("PostContent").value = $('#htmlbox_icon_set_green').val();
    	}  
    	
    </script> 
  </head>
  
  <body>
  	<br/>
  	<form action="publishPostAction.action" method="post">
  		<!-- 帖子题目 -->
  		题目 ：<input type="text" id="title" name="title"><br/><hr/>
  		<!-- 帖子主题 -->
  		主题 ：<input type="text" id="topic" name="topic"><br/><hr/>
	    <!-- 文本编辑 -->
	   	正文：<input type="hidden" id="PostContent" name="PostContent"><br/><br/>
	    <textarea id="htmlbox_icon_set_green" class="text_area2" cols="100" rows="200" name="content"></textarea>  
	        <script language="Javascript" type="text/javascript">  
			var hb_icon_set_green = $('#htmlbox_icon_set_green').css("height","800").css("width","600").css("position","center").htmlbox({  
		    	toolbars:[  
		         			["separator","cut","copy","paste",
		         			 "separator","bold","italic","underline","strike","sub","sup",
		         			 "separator","undo","redo",
		         			 "separator","left","center","right","justify",
		         			 "separator","ol","ul","indent","outdent",
		         			 "separator","link","image","unlink"],
			         		["separator","code","removeformat","paragraph","striptags",
			         		 "separator","quote","hr",
			         		 "separator",  
			             	 {icon:"new.png",tooltip:"New",command:function(){hb_icon_set_green.set_text("<p></p>");}},  
			             	 {icon:"open.png",tooltip:"Open",command:function(){alert('Open')}},  
			             	 {icon:"save.png",tooltip:"Save",command:function(){alert('Save')}}]  
		    	],  
	    		icons:"silk",  
	    		skin:"blue"  
			});  
		</script>  
		<!-- 文本编辑完 --> 
		<br/><input type="button" value="内容提交" onclick="onClickSave();"><br/>   	
    	<!-- 选择发布社区 -->
    	要把本文发布在那个社区：
    	<div class="rankdiv">	                        
			<label>
				<input type="radio" name="knob" value=1 checked="checked" />
				移动开发版块&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=2 />
				.NET技术版块&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=3 />
				数据库开发版块&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=4 />
				云计算版块&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=5 />
				Web开发版块&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				<input type="radio" name="knob" value=6 />
				硬件/嵌入式开发版块&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=7 />
				Java技术版块&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=8 />
				开发语言/框架&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=9 />
				Linux/Unix社区&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="knob" value=10 />
				其他&nbsp;&nbsp;&nbsp;&nbsp;<br/>
				<input type="radio" name="knob" value=11 />
				生活日常讨论版块&nbsp;&nbsp;&nbsp;&nbsp;
			</label>
		</div>
		<br/><input type="submit" value="提交"><br/><hr/>
	</form>
  </body>
</html>
