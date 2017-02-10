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
        List<String> sendernames = new ArrayList();
        for(Message msg: messages){
            postnames.add(postService.selectPostByPID(Integer.parseInt(msg.getRptobjectid())).getPTitle());
            if(msg.getSendertype()=='1'){
                sendernames.add(msg.getSenderid());     //由管理员发送的消息的senderid与管理员名字相同
            }else if(msg.getSendertype()=='0'){
                sendernames.add(userService.selectOneByUAccount(msg.getSenderid()).getuNickName());
            }else {
                sendernames.add("BBS系统");
            }
        }
        request.setAttribute("messages", messages);
        request.setAttribute("postTitle", postnames);
        request.setAttribute("sendername", sendernames);
        return SUCCESS;
    }

    public String getReadedMsg() throws Exception{
        List<Message> messages = userService.getReadedMsg(UName);
        List<String> postnames = new ArrayList();
        List<String> sendernames = new ArrayList();
        for(Message msg: messages){
            postnames.add(postService.selectPostByPID(Integer.parseInt(msg.getRptobjectid())).getPTitle());
            if(msg.getSendertype()=='1'){
                sendernames.add(msg.getSenderid());     //由管理员发送的消息的senderid与管理员名字相同
            }else if(msg.getSendertype()=='0'){
                sendernames.add(userService.selectOneByUAccount(msg.getSenderid()).getuNickName());
            }else {
                sendernames.add("BBS系统");
            }
        }
        request.setAttribute("messages", messages);
        request.setAttribute("postTitle", postnames);
        request.setAttribute("sendername", sendernames);
        return SUCCESS;
    }

}
