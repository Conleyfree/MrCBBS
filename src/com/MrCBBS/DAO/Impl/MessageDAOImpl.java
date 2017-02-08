package com.MrCBBS.DAO.Impl;

import com.MrCBBS.DAO.MessageDAO;
import com.MrCBBS.entities.Message;
import com.MrCBBS.mapper.MessageMapper;

import java.util.List;

/**
 * Created by HandsomeMrChen on 2017/2/4.
 */
public class MessageDAOImpl implements MessageDAO {

    MessageMapper messageMapper;

    public void setMessageMapper(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public void insert(Message record) {
        messageMapper.insert(record);
    }

    @Override
    public List<Message> getUnreadedMsg(String uAccount) {
        return messageMapper.selectMsgByUAccount_isRead(uAccount, '0');
    }

    @Override
    public List<Message> getReadedMsg(String uAccount) {
        return messageMapper.selectMsgByUAccount_isRead(uAccount, '1');
    }

    @Override
    public Boolean markMsg(String mid) {
        Message message = messageMapper.selectByPrimaryKey(Integer.parseInt(mid));
        if(message == null)     return false;
        message.setIsread('1');
        messageMapper.updateByPrimaryKey(message);
        return true;
    }
}
