package com.MrCBBS.action;

import com.MrCBBS.Server.UserService;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by HandsomeMrChen on 2017/2/8.
 */
public class MarkMsgAction extends CommonAction {
    private String mid;
    private String message;
    private String statusCode;

    private UserService userService;

    public void setMid(String mid) {
        this.mid = mid;
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
        Boolean result = userService.markMsg(mid);
        if(result){
            message = "标记成功！！";
            statusCode = "200";
        }
        else{
            message = "标记不存在的消息记录是非法操作！";
            statusCode = "404";
        }
        return SUCCESS;
    }
}
