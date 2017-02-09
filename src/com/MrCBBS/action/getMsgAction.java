package com.MrCBBS.action;

import com.MrCBBS.Server.PostService;
import com.MrCBBS.Server.UserService;
import com.MrCBBS.entities.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HandsomeMrChen on 2017/2/7.
 */
public class getMsgAction extends CommonAction {
    private String UName;
    private UserService userService;
    private PostService postService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public void setUName(String UName) {
        this.UName = UName;
    }
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public String getUnreadedMsg() throws Exception{
        List<Message> messages = userService.getUnreadedMsg(UName);
        List<String> postnames = new ArrayList();
        for(Message msg: messages){
            postnames.add(postService.selectPostByPID(Integer.parseInt(msg.getRptobjectid())).getPTitle());
        }
        request.setAttribute("messages", messages);
        request.setAttribute("postTitle", postnames);
        return SUCCESS;
    }

    public String getReadedMsg() throws Exception{
        List<Message> messages = userService.getReadedMsg(UName);
        List<String> postnames = new ArrayList();
        for(Message msg: messages){
            postnames.add(postService.selectPostByPID(Integer.parseInt(msg.getRptobjectid())).getPTitle());
        }
        request.setAttribute("messages", messages);
        request.setAttribute("postTitle", postnames);
        return SUCCESS;
    }

}
