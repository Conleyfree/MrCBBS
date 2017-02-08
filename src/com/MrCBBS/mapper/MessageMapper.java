package com.MrCBBS.mapper;

import com.MrCBBS.entities.Message;

import java.util.List;

public interface MessageMapper  extends MyBatisSuperMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectMsgByUAccount_isRead(String UAccount, char isRead);

}