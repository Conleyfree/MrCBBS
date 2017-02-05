package com.MrCBBS.Server;

/**
 * Created by HandsomeMrChen on 2017/1/25.
 */
public interface AdminService {

    //发送信息给贴子主人
    void sendMessage(String aname, String content, String uid, String pid);

}
