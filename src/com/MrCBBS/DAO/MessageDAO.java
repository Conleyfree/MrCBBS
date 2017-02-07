package com.MrCBBS.DAO;

import com.MrCBBS.entities.Message;

import java.util.List;

/**
 * Created by HandsomeMrChen on 2017/2/4.
 */
public interface MessageDAO {

    //插入一条message记录
    void insert(Message record);

    /* 获取未读消息 */
    List<Message> getUnreadedMsg(String uAccount);

    /* 获取已读消息 */
    List<Message> getReadedMsg(String uAccount);
}
