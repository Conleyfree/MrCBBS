<%--
  Created by IntelliJ IDEA.
  User: HandsomeMrChen
  Date: 2017/1/1
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.MrCBBS.entities.Comment,com.MrCBBS.entities.User" pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
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
    <%	List<Comment> myComments = (List<Comment>)request.getAttribute("myComments");
        List<String> postTitle = (List<String>)request.getAttribute("postTitle");
        User user = (User)request.getSession().getAttribute("User");
        if(user == null)	response.sendRedirect("../login.jsp");
    %>
    <div class="alert alert-info">当前位置<b class="tip"></b>我的评论</div>
    <table class="tbform list">
        <thead>
            <tr class="tr">
                <th colspan="6">全部评论 <i class="tip-up"></i></th>
            </tr>
        </thead>
        <tbody>
        <%	if(myComments.size()==0){	%>
            <tr>
                <td><a href="WritePo.jsp">你还没有发表过评论呢！快去发一个吧！</a></td>
            </tr>
        <%
            }else{
                for(int i = 0; i < myComments.size(); i++){ %>
            <tr>
                <td>
                    <%  String s = myComments.get(i).getCContent();
                        if(s.length() < 10){     %>
                    <%=s %>
                    <%  }else{     %>
                    <%=s.subSequence(0,10) %> . . . . . .
                    <%  }  %>
                    <a style="font-size: large;color: #0b9cd3" href="getPoAction.action?PID=<%=myComments.get(i).getPID() %>">
                        @<%=postTitle.get(i) %>
                    </a>
                </td>
            </tr>
            <%      }
                }
            %>
        </tbody>
    </table>

</body>

</html>
