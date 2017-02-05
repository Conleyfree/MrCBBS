package com.MrCBBS.Server.Impl;

import com.MrCBBS.DAO.MessageDAO;
import com.MrCBBS.Server.AdminService;
import com.MrCBBS.entities.Message;

/**
 * Created by HandsomeMrChen on 2017/2/4.
 */
public class AdminServiceImpl implements AdminService {

    MessageDAO messageDAO;

    public void setMessageDAO(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @Override
    public void sendMessage(String aname, String content, String uid, String pid) {
        Message message = new Message(aname, '1', content, uid, pid, '1');
        messageDAO.insert(message);
    }
}
