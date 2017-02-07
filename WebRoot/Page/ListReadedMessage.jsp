<%--
  Created by IntelliJ IDEA.
  User: HandsomeMrChen
  Date: 2017/2/7
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.MrCBBS.entities.Comment,com.MrCBBS.entities.User" pageEncoding="UTF-8"%>
<%@ page import="com.MrCBBS.entities.Message" %>
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
    <%	List<Message> messages = (List<Message>)request.getAttribute("messages");
        User user = (User)request.getSession().getAttribute("User");
        if(user == null)	response.sendRedirect("../login.jsp");
    %>
    <div class="alert alert-info">当前位置<b class="tip"></b>消息中心</div>
    <table class="tbform list">
        <thead>
        <tr class="tr">
            <th colspan="6">已读消息 <i class="tip-up"></i></th>
        </tr>
        </thead>
        <tbody>
        <%	if(messages.size()==0){	%>
        <tr>
            <td><a href="#">空空如也！QAQ</a></td>
        </tr>
        <%
        }else{
            for(int i = 0; i < messages.size(); i++){ %>
        <tr>
            <td>
                <%= messages.get(i).getSenddate() %>&nbsp;&nbsp;&nbsp;&nbsp;
                <a style="font-size: large;color: #0b9cd3" href="#">
                    来自 @<%=messages.get(i).getSenderid() %> 发来的消息
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

