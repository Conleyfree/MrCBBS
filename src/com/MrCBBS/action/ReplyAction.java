package com.MrCBBS.action;

import com.MrCBBS.Server.UserService;

/**
 * Created by HandsomeMrChen on 2017/2/9.
 */
public class ReplyAction extends CommonAction {
    private String sender;
    private String receiver;
    private String pid;
    private String content;

    private String message;
    private String statusCode;

    private UserService userService;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getMessage() {
        return message;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String execute() throws Exception{
        if(sender.equals("")){
            statusCode = "401";
            message = "未授权访问！";
        }else {
            userService.sendMessage(sender, content, receiver, pid);
            statusCode = "200";
            message = "信息已发送！";
        }
        return SUCCESS;
    }
}
