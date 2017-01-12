package com.MrCBBS.mapper;

import com.MrCBBS.entities.Message;

public interface MessageMapper  extends MyBatisSuperMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}