<%--
  Created by IntelliJ IDEA.
  User: HandsomeMrChen
  Date: 2017/2/7
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*,com.MrCBBS.entities.User" pageEncoding="UTF-8"%>
<%@ page import="com.MrCBBS.entities.Message" %>
<%@ page import="com.MrCBBS.entities.Admin" %>
<html>
<head>
    <%	List<Message> messages = (List<Message>)request.getAttribute("messages");
        List<String> postTitles = (List<String>)request.getAttribute("postTitle");
        List<String> sendernames = (List<String>)request.getAttribute("sendername");
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
    <script type="text/javascript">
        var p = -1;
        var message = "";
        var statusCode = "";

        /* 标记为已读 */
        function markRead(){
            if(p != -1){
                var mid = document.getElementById('mid'+p).value;
                $.ajax({
                    url:'markMsgAction',
                    type:'post',
                    async:false,//使代码按顺序执行
                    data:{mid:mid},
                    dataType:'json',
                    success:function(data){
                        message = data.message;
                        statusCode = data.statusCode;
                        alert(message);
                    }
                });
                document.getElementById('mark').style.color = "#b3b3b3";
                document.getElementById('mark').innerHTML = "已读";
                document.getElementById('isRead'+p).value = 1;
            }else{
                alert("发生错误！非法操作！");
            }
            window.parent.$('#msgContentModal').modal('hide');
        }

        var sender = "";
        var date = "";
        var content = "";

        /* 显示消息内容 */
        function showMsgContent(num){
            window.parent.$('#msgContentModal').modal('show');
            sender = document.getElementById('sender'+num).value;
            date = document.getElementById('date'+num).value;
            content = document.getElementById('content'+num).value;
            var list = content.split("//////");
            parent.document.getElementById('sender').innerHTML = "发信人：" + document.getElementById('sendername'+num).value;
            parent.document.getElementById('time').innerHTML = date;
            parent.document.getElementById('pre_content').innerHTML = list.length==1?"": list[0];
            parent.document.getElementById('content').innerHTML = list.length==1?list[0]: list[1];
            var from = parent.document.getElementById('from');
            from.href = "getPoAction.action?PID=" + document.getElementById('pid'+num).value;
            from.innerHTML = "@ 贴子：" + document.getElementById('pTitle'+num).value;
            from.target = "Conframe";

            p = num;
            if(document.getElementById('isRead'+num).value == 1)        //已读消息不提供“标记已读”按钮
                parent.document.getElementById('markReaded').style.display = "none";
            else
                parent.document.getElementById('markReaded').style.display = "block";
        }

        /* 显示回复输入框 */
        function reply(){
            parent.document.getElementById('replyContent').style.display = "block";
            parent.document.getElementById('msgInput').style.display = "block";
        }

        /* 提交回复 */
        function submitReply() {
            var replyContent = parent.document.getElementById('replyInput').value;
            var list = content.split("//////");
            var allContent = "";
            if(list.length==2){
                allContent = list[0] + "</br>" + date + "&nbsp;" + sender + ": " + list[1];
            }else{
                allContent = date + "&nbsp;" + sender + ": " + list[0];
            }
            allContent += "//////" + replyContent;
            var uid = document.getElementById('receiver'+p).value;
            var pid = document.getElementById('pid'+p).value;
            //alert(allContent);
            $.ajax({
                url:'replyAction',
                type:'post',
                async:false,//使代码按顺序执行
                data:{sender:uid,receiver:sender,pid:pid,content:allContent},
                dataType:'json',
                success:function(data){
                    message = data.message;
                    statusCode = data.statusCode;
                    alert(message);
                }
            });
            window.parent.$('#msgContentModal').modal('hide');
        }

        /* 重置 */
        function reset() {
            parent.document.getElementById('replyInput').value = "";
        }
    </script>
</head>
<body>
    <div class="alert alert-info">当前位置<b class="tip"></b>消息中心</div>
    <table class="tbform list">
        <thead>
            <tr class="tr">
                <th colspan="6">未读消息 <i class="tip-up"></i></th>
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
                    <a><%= messages.get(i).getSenddate() %>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    <img src="/MrCBBS/img/myimg/message_closed.png"  alt="点击查看消息内容" width="30" height="20" onclick="showMsgContent(<%=i%>)"/>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a style="font-size: large;color: #0b9cd3" href="#">
                        来自 @<%=sendernames.get(i) %> 发来的消息
                    </a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a id="mark" style="color:red">未读</a>
                    <input id="mid<%=i%>" type="hidden" value="<%=messages.get(i).getMid()%>" />
                    <input id="sender<%=i%>" type="hidden" value="<%=messages.get(i).getSenderid()%>" />
                    <input id="sendername<%=i%>" type="hidden" value="<%=sendernames.get(i) %>"/>
                    <input id="date<%=i%>" type="hidden" value="<%=messages.get(i).getSenddate()%>" />
                    <input id="content<%=i%>" type="hidden" value="<%=messages.get(i).getContent()%>" />
                    <input id="isRead<%=i%>" type="hidden" value=0 />
                    <input id="pid<%=i%>" type="hidden" value="<%=messages.get(i).getRptobjectid()%>">
                    <input id="pTitle<%=i%>" type="hidden" value="<%=postTitles.get(i).trim()%>">
                    <input id="receiver<%=i%>" type="hidden" value="<%=messages.get(i).getReceiverid()%>">
                </td>
             </tr>
            <%      }
            }
            %>
        </tr>
        </tbody>
    </table>
</body>

</html>
