package com.MrCBBS.DAO.Impl;

import com.MrCBBS.DAO.MessageDAO;
import com.MrCBBS.entities.Message;
import com.MrCBBS.mapper.MessageMapper;

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
}
