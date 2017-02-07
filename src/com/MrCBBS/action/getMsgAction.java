package com.MrCBBS.action;

import com.MrCBBS.Server.UserService;
import com.MrCBBS.entities.Message;
import java.util.List;

/**
 * Created by HandsomeMrChen on 2017/2/7.
 */
public class getMsgAction extends CommonAction {
    private String UName;
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUnreadedMsg() throws Exception{
        List<Message> messages = userService.getUnreadedMsg(UName);
        request.setAttribute("messages", messages);
        return SUCCESS;
    }

    public String getReadedMsg() throws Exception{
        List<Message> messages = userService.getReadedMsg(UName);
        request.setAttribute("messages", messages);
        return SUCCESS;
    }

}
